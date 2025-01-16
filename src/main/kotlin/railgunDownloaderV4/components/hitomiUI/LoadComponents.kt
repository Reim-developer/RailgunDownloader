/*
 * RAILGUN DOWNLOADER - VERSION 4.0.0
 * File: LoadComponents.kt
 * This project is licensed GPL-3.0 License.
 * LICENSE: https://www.gnu.org/licenses/gpl-3.0.html
 * Contribution: Reim
 */

package railgunDownloaderV4.components.hitomiUI

import railgunDownloaderV4.components.global.ButtonUI
import railgunDownloaderV4.components.global.LogResult
import railgunDownloaderV4.components.global.TextField
import railgunDownloaderV4.components.hitomiUI.events.HitomiDownload
import railgunDownloaderV4.components.ulti.PathDialog
import java.awt.Dimension
import java.awt.Point
import javax.swing.JButton
import javax.swing.JFrame
import javax.swing.JTextArea
import javax.swing.JTextField

class LoadComponents {

    private val textField: TextField by lazy { TextField() }
    private val buttonUI: ButtonUI by lazy { ButtonUI() }
    private val pathDialog: PathDialog by lazy { PathDialog() }
    private val hitomiDownload: HitomiDownload by lazy { HitomiDownload(urlField, pathField, logArea) }
    private val logResult: LogResult by lazy { LogResult() }

    private val urlField: JTextField by lazy { JTextField() }
    private val pathField: JTextField by lazy { JTextField() }
    private val downloadButton: JButton by lazy { JButton() }
    private val saveDirButton: JButton by lazy { JButton() }
    private val logArea: JTextArea by lazy { JTextArea() }

    fun setLoadComponents(appTarget: JFrame ){
        textField.setTextField(
            appTarget, urlField, Dimension(400, 30),
            Point(100, 400), true,
            "Input your Hitomi.la doujinshi URL here"
        )
        textField.setTextField(
            appTarget, pathField, Dimension(400, 30),
            Point(100, 350), false,
            "Your chose save path directory will be displayed here"
        )

        buttonUI.setButtonUI(
            appTarget, downloadButton, Dimension(50, 50),
            Point(100, 450), "/Download.png",
            "Download doujinshi from Hitomi.la"
        )
        hitomiDownload.setHitomiDownload(downloadButton)

        buttonUI.setButtonUI(
            appTarget, saveDirButton, Dimension(50, 50),
            Point(200, 450), "/FolderPath.png",
            "Choose save directory path"
        )
        pathDialog.setShowDialog(
            saveDirButton, "Choose save directory",
            pathField
        )

        logResult.setLogResult(
            appTarget, logArea, Dimension(400, 250),
            Point(100, 50), "Your download result will be displayed here"
        )
    }
}