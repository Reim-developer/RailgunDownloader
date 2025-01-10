/*
 * RAILGUN DOWNLOADER - VERSION 4.0.0
 * FacebookUI.kt
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

    val inputURLField: JTextField by lazy { JTextField() }
    val inputPathField: JTextField by lazy { JTextField() }
    private val openPathButton: JButton by lazy { JButton() }
    private val logResultArea: JTextArea by lazy { JTextArea() }
    private val buttonDownload: JButton by lazy { JButton() }
    private val app: JFrame by lazy { JFrame() }

    fun showFacebookUI(visible: Boolean = false) {
        SwingUtilities.invokeLater {
            app.apply {
                title = "Download video from Facebook"
                size = Dimension(600, 600)
                isResizable = false
                maximumSize = Dimension(600, 600)
                contentPane.background = Color(21, 21, 21)
                setLocationRelativeTo(null)
                layout = null
                iconImage = setIcon.AppIcon()
                isVisible = visible

                inputURL.setURL(app, inputURLField)
                inputPath.setInputPath(app, inputPathField)
                openPath.setOpenPath(app, openPathButton)
                logResult.setLogResult(app, logResultArea)
                downloadButton.setDownloadButton(app, buttonDownload)

                closingWindow.returnHome(app)
            }
        }
    }
}