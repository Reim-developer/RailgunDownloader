/*
 * RAILGUN DOWNLOADER - VERSION 4.0.0
 * File: InstagramUI.kt
 * This project is licensed GPL-3.0 License.
 * LICENSE: https://www.gnu.org/licenses/gpl-3.0.html
 * Contribution: Reim
 */

package railgunDownloaderV4.components.instagramUI

import railgunDownloaderV4.Application
import railgunDownloaderV4.components.global.events.GoHome
import railgunDownloaderV4.components.ulti.SetIcon
import java.awt.Color
import java.awt.Dimension
import javax.swing.JFrame
import javax.swing.WindowConstants

class InstagramUI(appScene: Application) {

    private val setIcon: SetIcon by lazy { SetIcon() }
    private val goHome: GoHome by lazy { GoHome(appScene) }
    private val loadComponents: LoadComponents by lazy { LoadComponents() }

    fun setInstagramUI(visible: Boolean = false) {
        val app = JFrame("Download from Instagram")
        app.size = Dimension(600, 600)
        app.isResizable = false
        app.iconImage = setIcon.setAppIcon()
        app.defaultCloseOperation = WindowConstants.DISPOSE_ON_CLOSE
        app.setLocationRelativeTo(null)
        app.contentPane.background = Color(21, 21, 21)
        app.layout = null
        app.maximumSize = Dimension(600, 600)
        app.isVisible = visible

        loadComponents.setLoadComponent(app)
        goHome.setGoHome(app)
    }
}