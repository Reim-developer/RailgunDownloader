/*
 * RAILGUN DOWNLOADER - VERSION 4.0.0
 * File: LoadComponents.kt
 * This project is licensed GPL-3.0 License.
 * LICENSE: https://www.gnu.org/licenses/gpl-3.0.html
 * Contribution: Reim
 */

package railgunDownloaderV4.components.youtubeUI

import railgunDownloaderV4.components.global.ButtonUI
import railgunDownloaderV4.components.global.LogResult
import railgunDownloaderV4.components.global.QualityBox
import railgunDownloaderV4.components.global.TextField
import railgunDownloaderV4.components.ulti.PathDialog
import railgunDownloaderV4.components.youtubeUI.events.Download
import java.awt.Dimension
import java.awt.Point
import javax.swing.JButton
import javax.swing.JFrame
import javax.swing.JList
import javax.swing.JTextArea
import javax.swing.JTextField

class LoadComponents {
    private val textField: TextField by lazy { TextField() }
    private val buttonUI: ButtonUI by lazy { ButtonUI() }
    private val logResult: LogResult by lazy { LogResult() }
    private val qualityBox: QualityBox by lazy { QualityBox() }
    private val pathDialog: PathDialog by lazy { PathDialog() }
    private val download: Download by lazy { Download(urlField, pathField, logArea, qualityList) }

    private val urlField: JTextField by lazy { JTextField() }
    private val pathField: JTextField by lazy { JTextField() }
    private val logArea: JTextArea by lazy { JTextArea() }
    private val downloadButton: JButton by lazy { JButton() }
    private val saveDirButton: JButton by lazy { JButton() }
    private val qualityList: JList<String> by lazy { JList<String>() }

    fun setLoadComponents(appTarget: JFrame) {
        textField.setTextField(
            appTarget, urlField,
            Dimension(400, 30), Point(100, 370),
            true, "Input your YouTube video/playlist here"
        )
        textField.setTextField(
            appTarget, pathField,
            Dimension(400, 30), Point(100, 300),
            false, "Your chosen directory will be displayed here"
        )
        logResult.setLogResult(
            appTarget, logArea,
            Dimension(400, 200), Point(100, 30),
            "Your download result will be displayed here"
        )

        qualityBox.setQualityBox(
            appTarget, qualityList,
            Point(400, 430), Dimension(100, 100)
        )

        buttonUI.setButtonUI(
            appTarget, downloadButton, Dimension(50, 50),
            Point(175, 420), "/Download.png", "Download YouTube video/playlist"
        )
        buttonUI.setButtonUI(
            appTarget, saveDirButton,
            Dimension(50, 50), Point(100, 420),
            "/FolderPath.png", "Choose save directory path"
        )
        pathDialog.setShowDialog(
            saveDirButton, "Choose save directory",
            pathField
        )

        download.setDownload(downloadButton)
    }
}