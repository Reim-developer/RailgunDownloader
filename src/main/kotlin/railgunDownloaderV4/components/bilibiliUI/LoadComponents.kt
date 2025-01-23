/*
* RAILGUN DOWNLOADER - VERSION 4.0.0
* File: LoadComponents.kt
* This project is licensed under GPL-3.0 License.
* LICENSE: https://www.gnu.org/licenses/gpl-3.0.html
* Contribution: Reim
*/
package railgunDownloaderV4.components.bilibiliUI

import railgunDownloaderV4.components.bilibiliUI.events.Download
import railgunDownloaderV4.components.global.LogResult
import railgunDownloaderV4.components.global.TextField
import railgunDownloaderV4.components.global.ButtonUI
import railgunDownloaderV4.components.global.QualityBox
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
    private val setButtonUI: ButtonUI by lazy { ButtonUI() }
    private val pathDialog: PathDialog by lazy { PathDialog() }
    private val qualityBox: QualityBox by lazy { QualityBox() }
    private val download: Download by lazy { Download(urlField, pathField, resultLog, qualityList) }

    private val urlField: JTextField by lazy { JTextField() }
    private val pathField: JTextField by lazy { JTextField() }
    private val resultLog: JTextArea by lazy { JTextArea() }
    private val qualityList: JList<String> by lazy { JList<String>() }
    private val downloadButton: JButton by lazy { JButton() }
    private val saveDirButton: JButton by lazy { JButton() }

    fun setLoadComponents(appTarget: JFrame) {
        textField.setTextField(
            appTarget, urlField,
            Dimension(400, 30), Point(100, 450),
            true, "Input your Bilibili video URL here"
        )
        textField.setTextField(
            appTarget, pathField,
            Dimension(400, 30), Point(100, 400),
            false, "Your save directory path will be displayed here"
        )
        logResult.setLogResult(
            appTarget, resultLog,
            Dimension(400, 300), Point(100, 50),
            "Your result log will be displayed here"
        )
        setButtonUI.setButtonUI(
            appTarget, downloadButton,
            Dimension(50, 50), Point(100, 490),
            "/Download.png", "Download video from Bilibili"
        )
        download.setDownload(downloadButton)
        setButtonUI.setButtonUI(
            appTarget, saveDirButton,
            Dimension(50, 50), Point(160, 490),
            "/FolderPath.png", "Choose your save directory path"
        )
        pathDialog.setShowDialog(
            saveDirButton, "Download from Bilibili",
            pathField
        )

        qualityBox.setQualityBox(
            appTarget, qualityList,
            Point(20, 390), Dimension(70, 150)
        )
    }
}