/*
 * RAILGUN DOWNLOADER - VERSION 4.0.0
 * File: LoadComponents.kt
 * This project is licensed GPL-3.0 License.
 * LICENSE: https://www.gnu.org/licenses/gpl-3.0.html
 * Contribution: Reim
 */

package railgunDownloaderV4.components.devianArtUI

import railgunDownloaderV4.components.devianArtUI.events.Download
import railgunDownloaderV4.components.global.ButtonUI
import railgunDownloaderV4.components.global.LogResult
import railgunDownloaderV4.components.global.TextField
import railgunDownloaderV4.components.ulti.PathDialog
import java.awt.Dimension
import java.awt.Point
import javax.swing.JButton
import javax.swing.JFrame
import javax.swing.JTextArea
import javax.swing.JTextField

class LoadComponents {

    private val textField: TextField by lazy { TextField() }
    private val logResult: LogResult by lazy { LogResult() }
    private val buttonUI: ButtonUI by lazy { ButtonUI() }
    private val pathDialog: PathDialog by lazy { PathDialog() }
    private val download: Download by lazy { Download(urlField, pathField, logArea) }

    private val urlField: JTextField by lazy { JTextField() }
    private val pathField: JTextField by lazy { JTextField() }
    private val logArea: JTextArea by lazy { JTextArea() }
    private val downloadButton: JButton by lazy { JButton() }
    private val saveDirButton: JButton by lazy { JButton() }

    fun setLoadComponents(appTarget: JFrame) {
        textField.setTextField(
            appTarget, urlField,
            Dimension(400, 30), Point(100, 450),
            true, "Input your DevianArt image URL here"
        )
        textField.setTextField(
            appTarget, pathField,
            Dimension(400, 30), Point(100, 400),
            false, "Your save directory path will be displayed here"
        )
        logResult.setLogResult(
            appTarget, logArea,
            Dimension(400, 300), Point(100, 30),
            "Your download result will be displayed here"
        )
        buttonUI.setButtonUI(
            appTarget, downloadButton,
            Dimension(50, 50), Point(100, 490),
            "/Download.png", "Download image from DevianArt"
        )
        download.setDownload(downloadButton)

        buttonUI.setButtonUI(
            appTarget, saveDirButton,
            Dimension(50, 50), Point(180, 490),
            "/FolderPath.png", "Choose save directory path"
        )
        pathDialog.setShowDialog(
            saveDirButton, "Choose save directory path",
            pathField
        )
    }
}