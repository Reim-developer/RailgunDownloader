/*
 * RAILGUN DOWNLOADER - VERSION 4.0.0
 * File: YoutubeUI.kt
 * This project is licensed GPL-3.0 License.
 * LICENSE: https://www.gnu.org/licenses/gpl-3.0.html
 * Contribution: Reim
 */
package railgunDownloaderV4.components.youtubeUI

import railgunDownloaderV4.Application
import railgunDownloaderV4.components.global.LogResult
import railgunDownloaderV4.components.ulti.SetIcon
import java.awt.Color
import java.awt.Dimension
import java.awt.Point
import java.awt.event.WindowAdapter
import java.awt.event.WindowEvent
import javax.swing.*

class YoutubeUI(val appScene: Application) {
    private val inputURLField: InputURL by lazy { InputURL() }
    private val showPathField: ShowPath by lazy { ShowPath() }
    private val choosePath: ChoosePath by lazy { ChoosePath(this) }
    private val downloadButton = DownloadButton(this)
    private val logResult: LogResult by lazy { LogResult() }
    private val listQuality: QualityList by lazy { QualityList() }
    private val setIcon: SetIcon by lazy { SetIcon() }
    private val cancelDownload: CancelDownload by lazy { CancelDownload() }

    val urlField: JTextField by lazy { JTextField() }
    val pathField: JTextField by lazy { JTextField() }
    private val choosePathButton: JButton by lazy { JButton() }
    private val buttonDownload: JButton by lazy { JButton() }
    val resultLog: JTextArea by lazy { JTextArea() }
    val qualityBox: JList<String> by lazy { JList() }
    private val cancelDownloadButton by lazy { JButton() }

    fun showYoutubeUI(visible: Boolean) {
        val app = JFrame()
        app.title = "Download from Youtube"
        app.iconImage = setIcon.setAppIcon()
        app.size = Dimension(600, 650)
        app.defaultCloseOperation = WindowConstants.DISPOSE_ON_CLOSE
        app.setLocationRelativeTo(null)
        app.layout = null
        app.isResizable = false
        app.maximumSize = Dimension(600, 650)
        app.contentPane.background = Color(21, 21, 21)
        app.isVisible = visible

        inputURLField.setInputURL(app, urlField)
        showPathField.setShowPath(app, pathField)
        choosePath.setChoosePath(app, choosePathButton)
        downloadButton.setDownloadButton(app, buttonDownload)
        logResult.setLogResult(
            app, resultLog,
            Dimension(400, 200), Point(100, 50),
            "Your download result will be displayed here"
        )
        listQuality.setQuality(app, qualityBox)
        cancelDownload.setCancelDownload(app, cancelDownloadButton)

        onClosing(app)
    }

    private fun onClosing(appTarget: JFrame) {
        appTarget.addWindowListener(object : WindowAdapter() {
            override fun windowClosing(e: WindowEvent) {
                appScene.app.isVisible = true
            }
        })
    }
}
