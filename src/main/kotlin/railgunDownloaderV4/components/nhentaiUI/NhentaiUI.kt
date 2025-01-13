/*
 * RAILGUN DOWNLOADER - VERSION 4.0.0
 * NhentaiUI.kt
 */
package railgunDownloaderV4.components.nhentaiUI

import railgunDownloaderV4.Application
import railgunDownloaderV4.components.ulti.SetIcon
import java.awt.Color
import java.awt.Dimension
import java.awt.event.WindowAdapter
import java.awt.event.WindowEvent
import javax.swing.JButton
import javax.swing.JFrame
import javax.swing.JTextArea
import javax.swing.JTextField
import javax.swing.SwingUtilities
import javax.swing.WindowConstants

class NhentaiUI (private val appScene: Application){
    private val setIconComponent: SetIcon by lazy { SetIcon() }
    private val urlFieldComponent: URLField by lazy { URLField() }
    private val pathFieldComponent: PathField by lazy { PathField() }
    private val choosePathComponent: ChoosePath by lazy { ChoosePath(this) }
    private val downloadButtonComponent: DownloadButton by lazy { DownloadButton(urlField, pathField, logArea) }
    private val logResultComponent: LogResult by lazy { LogResult() }
    private val findByCodeComponent: FindByCode by lazy { FindByCode(urlField, pathField, logArea) }

    private val urlField: JTextField by lazy { JTextField() }
    val pathField: JTextField by lazy { JTextField() }
    private val logArea: JTextArea by lazy { JTextArea() }
    private val choosePathButton: JButton by lazy { JButton() }
    private val downloadButton: JButton by lazy { JButton() }
    private val findByCodeButton: JButton by lazy { JButton() }

    fun showNhentaiUI(visible: Boolean = false) {
        val nhentaiUI = JFrame()
        SwingUtilities.invokeLater {
            nhentaiUI.title = "Download from Nhentai.net"
            nhentaiUI.setSize(600, 600)
            nhentaiUI.defaultCloseOperation = WindowConstants.DISPOSE_ON_CLOSE
            nhentaiUI.setLocationRelativeTo(null)
            nhentaiUI.isResizable = false
            nhentaiUI.maximumSize = Dimension(600, 600)
            nhentaiUI.contentPane.background = Color(21, 21, 21)
            nhentaiUI.iconImage = setIconComponent.setAppIcon()
            nhentaiUI.layout = null
            nhentaiUI.isVisible = visible


            findByCodeComponent.setFindByCode(nhentaiUI, findByCodeButton)
            urlFieldComponent.setURLField(nhentaiUI, urlField)
            pathFieldComponent.setPathField(nhentaiUI, pathField)
            choosePathComponent.setChoosePath(nhentaiUI, choosePathButton)
            downloadButtonComponent.setDownloadButton(nhentaiUI, downloadButton)
            logResultComponent.setLogResult(nhentaiUI, logArea)
        }
        closingWindow(nhentaiUI = nhentaiUI)
    }

    private fun closingWindow(nhentaiUI: JFrame) {
        nhentaiUI.addWindowListener(object: WindowAdapter() {
            override fun windowClosing(e: WindowEvent?) {
                appScene.app.isVisible = true
            }
        })
    }
}