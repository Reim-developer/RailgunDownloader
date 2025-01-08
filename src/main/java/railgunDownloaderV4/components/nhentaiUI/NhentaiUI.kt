package railgunDownloaderV4.components.nhentaiUI

import railgunDownloaderV4.Application
import railgunDownloaderV4.components.ulti.SetIcon
import java.awt.Color
import java.awt.Dimension
import java.awt.event.WindowAdapter
import java.awt.event.WindowEvent
import javax.swing.JFrame
import javax.swing.JTextField
import javax.swing.SwingUtilities
import javax.swing.WindowConstants

class NhentaiUI (private val appScene: Application){
    private val setIconComponent: SetIcon by lazy { SetIcon() }
    private val urlFieldComponent: URLField by lazy { URLField() }

    private val urlField: JTextField by lazy { JTextField() }

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
            nhentaiUI.iconImage = setIconComponent.AppIcon()
            nhentaiUI.layout = null
            nhentaiUI.isVisible = visible

            urlFieldComponent.setURLField(nhentaiUI, urlField)
        }
        closingWindow(nhentaiUI = nhentaiUI)
    }

    private fun closingWindow(nhentaiUI: JFrame) {
        nhentaiUI.addWindowListener(object: WindowAdapter() {
            override fun windowClosing(e: WindowEvent?) {
                appScene.App.isVisible = true
            }
        })
    }
}