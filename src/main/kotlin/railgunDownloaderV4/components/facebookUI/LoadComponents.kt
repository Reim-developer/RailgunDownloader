/*
 * RAILGUN DOWNLOADER - VERSION 4.0.0
 * File: LoadComponents.kt
 * This project is licensed GPL-3.0 License.
 * LICENSE: https://www.gnu.org/licenses/gpl-3.0.html
 * Contribution: Reim
 */

package railgunDownloaderV4.components.facebookUI

import railgunDownloaderV4.components.facebookUI.events.Download
import railgunDownloaderV4.components.global.ButtonUI
import railgunDownloaderV4.components.global.LogResult
import railgunDownloaderV4.components.global.QualityBox
import railgunDownloaderV4.components.global.TextField
import railgunDownloaderV4.components.ulti.PathDialog
import java.awt.Dimension
import java.awt.Point
import javax.swing.JButton
import javax.swing.JFrame
import javax.swing.JList
import javax.swing.JTextArea
import javax.swing.JTextField

class LoadComponents {
    private val qualityBox: QualityBox by lazy { QualityBox() }
    private val textField: TextField by lazy { TextField() }
    private val logResult: LogResult by lazy { LogResult() }
    private val buttonUI: ButtonUI by lazy { ButtonUI() }
    private val pathDialog: PathDialog by lazy { PathDialog() }
    private val download: Download by lazy { Download(urlField, pathField, logArea, qualityList) }

    private val qualityList: JList<String> by lazy { JList<String>() }
    private val urlField: JTextField by lazy { JTextField() }
    private val pathField: JTextField by lazy { JTextField() }
    private val logArea: JTextArea by lazy { JTextArea() }
    private val downloadButton: JButton by lazy { JButton() }
    private val savePathButton: JButton by lazy { JButton() }

    fun setLoadComponents(app: JFrame) {
        qualityBox.setQualityBox(
            app, qualityList,
            Point(320, 440),
            Dimension(70, 150)
        )
        textField.setTextField(
            app, urlField,
            Dimension(400, 30), Point(100, 400),
            true, "Input your Facebook video URL here"
        )
        textField.setTextField(
            app, pathField,
            Dimension(400, 30), Point(100, 350),
            false, "Your chosen directory path will be displayed here"
        )

        buttonUI.setButtonUI(
            app, downloadButton,
            Dimension(50, 50), Point(170, 440),
            "/Download.png", "Download video from Facebook"
        )
        download.setDownload(downloadButton)

        buttonUI.setButtonUI(
            app, savePathButton,
            Dimension(50, 50), Point(100, 440),
            "/FolderPath.png", "Choose save directory path"
        )
        pathDialog.setShowDialog(savePathButton, "Choose save directory", pathField)

        logResult.setLogResult(
            app, logArea,
            Dimension(400, 300), Point(100, 20),
            "Your download result will be displayed here"
        )
    }
}