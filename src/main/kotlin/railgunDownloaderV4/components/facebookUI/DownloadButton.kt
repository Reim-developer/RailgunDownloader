/*
 * RAILGUN DOWNLOADER - VERSION 4.0.0
 * File: DownloadButton.kt
 * This project is licensed GPL-3.0 License.
 * LICENSE: https://www.gnu.org/licenses/gpl-3.0.html
 * Contribution: Reim
 */
package railgunDownloaderV4.components.facebookUI

import railgunDownloaderV4.components.facebookUI.events.Download
import railgunDownloaderV4.components.ulti.SetIconButton
import java.awt.Dimension
import java.awt.Point
import javax.swing.JButton
import javax.swing.JFrame

class DownloadButton (facebookUI: FacebookUI){

    private val setIconButton: SetIconButton by lazy { SetIconButton() }
    private val download: Download by lazy { Download(facebookUI) }

    fun setDownloadButton(app: JFrame, downloadButton: JButton) {
        downloadButton.apply {
            size = Dimension(50, 50)
            isContentAreaFilled = false
            border = null
            isFocusPainted = false
            isBorderPainted = false
            location = Point(170, 440)
            toolTipText = "Download Facebook video"
        }

        setIconButton.setIcon(
            downloadButton, "/Download.png",
            50, 50
        )

        download.setDownload(downloadButton)
        app.add(downloadButton)
    }
}