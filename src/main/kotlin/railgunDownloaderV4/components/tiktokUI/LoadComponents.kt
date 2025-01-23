/*
 * RAILGUN DOWNLOADER - VERSION 4.0.0
 * File: LoadComponents.kt
 * This project is licensed GPL-3.0 License.
 * LICENSE: https://www.gnu.org/licenses/gpl-3.0.html
 * Contribution: Reim
 */
package railgunDownloaderV4.components.tiktokUI

import railgunDownloaderV4.components.global.ButtonUI
import railgunDownloaderV4.components.global.LogResult
import railgunDownloaderV4.components.global.QualityBox
import railgunDownloaderV4.components.global.TextField
import railgunDownloaderV4.components.tiktokUI.events.Download
import railgunDownloaderV4.components.ulti.PathDialog
import java.awt.Dimension
import java.awt.Point
import javax.swing.JButton
import javax.swing.JFrame
import javax.swing.JList
import javax.swing.JTextArea
import javax.swing.JTextField

class LoadComponents {

    private val textField: TextField by lazy { TextField() }
    private val logResult: LogResult by lazy { LogResult() }
    private val buttonUI: ButtonUI by lazy { ButtonUI() }
    private val pathDialog: PathDialog by lazy { PathDialog() }
    private val download: Download by lazy { Download(urlField, pathField, logArea, qualityList) }
    private val qualityBox: QualityBox by lazy { QualityBox() }

    private val urlField: JTextField by lazy { JTextField() }
    private val pathField: JTextField by lazy { JTextField() }
    private val logArea: JTextArea by lazy { JTextArea() }
    private val qualityList: JList<String> by lazy { JList<String>() }
    private val downloadButton: JButton by lazy { JButton() }
    private val saveDirButton: JButton by lazy { JButton() }

    fun setLoadComponents(appTarget: JFrame) {
        textField.setTextField(
            appTarget, urlField, Dimension(400, 30),
            Point(100, 450), true,
            "Input your Tiktok URL here"
        )
        textField.setTextField(
            appTarget, pathField, Dimension(400, 30),
            Point(100, 380), false,
            "Your chosen save directory path will be displayed here"
        )

        logResult.setLogResult(
            appTarget, logArea, Dimension(400, 300),
            Point(100, 30), "Your download result will be displayed here"
        )

        buttonUI.setButtonUI(
            appTarget, downloadButton,
            Dimension(50, 50), Point(100, 485),
            "/Download.png", "Download video from Tiktok"
        )
        download.setDownload(downloadButton)

        buttonUI.setButtonUI(
            appTarget, saveDirButton,
            Dimension(50, 50), Point(170, 485),
            "/FolderPath.png", "Choose your save directory path"
        )
        pathDialog.setShowDialog(
            saveDirButton, "Choose your save directory path",
            pathField
        )

        qualityBox.setQualityBox(
            appTarget, qualityList,
            Point(20, 380),
            Dimension(70, 150)
        )
    }
}