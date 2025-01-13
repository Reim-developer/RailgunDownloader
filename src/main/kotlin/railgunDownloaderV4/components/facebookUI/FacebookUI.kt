/*
 * RAILGUN DOWNLOADER - VERSION 4.0.0
 * File: FacebookUI.kt
 * This project is licensed GPL-3.0 License.
 * LICENSE: https://www.gnu.org/licenses/gpl-3.0.html
 * Contribution: Reim
 */
package railgunDownloaderV4.components.facebookUI

import railgunDownloaderV4.Application
import railgunDownloaderV4.components.facebookUI.events.ClosingWindow
import railgunDownloaderV4.components.ulti.SetIcon
import java.awt.Color
import java.awt.Dimension
import javax.swing.*

class FacebookUI (private val appScene: Application){

    private val setIcon: SetIcon by lazy { SetIcon() }
    private val closingWindow: ClosingWindow by lazy { ClosingWindow(appScene) }
    private val inputURL: InputURL by lazy { InputURL() }
    private val inputPath: InputPath by lazy { InputPath() }
    private val openPath: OpenPath by lazy { OpenPath(this) }
    private val logResult: LogResult by lazy { LogResult() }
    private val downloadButton: DownloadButton by lazy { DownloadButton(this) }
    private val qualityList: QualityList by lazy { QualityList() }

    val inputURLField: JTextField by lazy { JTextField() }
    val inputPathField: JTextField by lazy { JTextField() }
    val logResultArea: JTextArea by lazy { JTextArea() }
    val qualityListBox: JList<String> by lazy { JList() }
    private val openPathButton: JButton by lazy { JButton() }
    private val buttonDownload: JButton by lazy { JButton() }



    fun showFacebookUI(visible: Boolean = false) {
        val app = JFrame()
        SwingUtilities.invokeLater {
            app.apply {
                title = "Download video from Facebook"
                size = Dimension(600, 600)
                isResizable = false
                maximumSize = Dimension(600, 600)
                contentPane.background = Color(21, 21, 21)
                setLocationRelativeTo(null)
                layout = null
                iconImage = setIcon.setAppIcon()
                isVisible = visible

                inputURL.setURL(app, inputURLField)
                inputPath.setInputPath(app, inputPathField)
                openPath.setOpenPath(app, openPathButton)
                logResult.setLogResult(app, logResultArea)
                downloadButton.setDownloadButton(app, buttonDownload)
                qualityList.setQualityList(app, qualityListBox)

                closingWindow.returnHome(app)
            }
        }
    }
}