/*
 * RAILGUN DOWNLOADER - VERSION 4.0.0
 * DownloadButton.kt
 */
package railgunDownloaderV4.components.nhentaiUI

import railgunDownloaderV4.components.nhentaiUI.helper.NhentaiDownloadHelper
import railgunDownloaderV4.components.ulti.DirExists
import railgunDownloaderV4.components.ulti.MatchURL
import java.awt.Image
import java.awt.Toolkit
import javax.swing.ImageIcon
import javax.swing.JButton
import javax.swing.JFrame
import javax.swing.JOptionPane
import javax.swing.JTextArea
import javax.swing.JTextField

class DownloadButton(
    private val urlField: JTextField,
    private val savePathField: JTextField,
    private val logResultArea: JTextArea
    ) {
    private val matchURL: MatchURL by lazy { MatchURL() }
    private val dirExists: DirExists by lazy { DirExists() }
    private val downloadHelper: NhentaiDownloadHelper by lazy { NhentaiDownloadHelper() }

    fun setDownloadButton(app: JFrame, downloadButton: JButton) {
        downloadButton.setSize(50, 50)
        downloadButton.isBorderPainted = false
        downloadButton.isFocusPainted = false

        val buttonIcon = Toolkit.getDefaultToolkit()
            .getImage(this::class.java.getResource("/Download.png"))

        downloadButton.icon = ImageIcon(
            buttonIcon.getScaledInstance(50, 50, Image.SCALE_FAST)
        )
        downloadButton.isContentAreaFilled = false
        downloadButton.setLocation(170, 450)
        downloadButton.toolTipText = "Download doujinshi"

        downloadAction(downloadButton)

        app.add(downloadButton)
    }

    private fun downloadAction(downloadButton: JButton) {
        downloadButton.addActionListener {
            val inputURL = urlField.text
            val savePathDir = savePathField.text

            if(!matchURL.matchURL(inputURL)) {
                JOptionPane.showMessageDialog(
                    null,
                    "Please input valid URL",
                    "Notification",
                    JOptionPane.INFORMATION_MESSAGE
                )
                return@addActionListener
            }

            if(!dirExists.checkDirExists(savePathDir)) {
                JOptionPane.showMessageDialog(
                    null,
                    "Please choose exists save directory path",
                    "Notification",
                    JOptionPane.INFORMATION_MESSAGE
                )
                return@addActionListener
            }

            downloadHelper.startDownload(
                logResultArea,
                savePathDir,
                inputURL
            )
        }
    }
}