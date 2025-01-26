/*
 * RAILGUN DOWNLOADER - VERSION 4.0.0
 * File: YoutubeUI.kt
 * This project is licensed GPL-3.0 License.
 * LICENSE: https://www.gnu.org/licenses/gpl-3.0.html
 * Contribution: Reim
 */
package railgunDownloaderV4.components.youtubeUI

import railgunDownloaderV4.Application
import railgunDownloaderV4.components.global.events.GoHome
import railgunDownloaderV4.components.ulti.SetIcon
import java.awt.Color
import java.awt.Dimension
import javax.swing.*

class YoutubeUI(val appScene: Application) {
    private val setIcon: SetIcon by lazy { SetIcon() }
    private val goHome: GoHome by lazy { GoHome(this.appScene) }
    private val loadComponents: LoadComponents by lazy { LoadComponents() }

    val urlField: JTextField by lazy { JTextField() }
    val pathField: JTextField by lazy { JTextField() }

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

        loadComponents.setLoadComponents(app)
        goHome.setGoHome(app)
    }
}
