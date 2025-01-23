/*
 * RAILGUN DOWNLOADER - VERSION 4.0.0
 * File: FacebookUI.kt
 * This project is licensed GPL-3.0 License.
 * LICENSE: https://www.gnu.org/licenses/gpl-3.0.html
 * Contribution: Reim
 */
package railgunDownloaderV4.components.facebookUI

import railgunDownloaderV4.Application
import railgunDownloaderV4.components.global.events.GoHome
import railgunDownloaderV4.components.ulti.SetIcon
import java.awt.Color
import java.awt.Dimension
import javax.swing.*

class FacebookUI (private val appScene: Application){

    private val setIcon: SetIcon by lazy { SetIcon() }
    private val goHome: GoHome by lazy { GoHome(appScene) }
    private val loadComponents: LoadComponents by lazy { LoadComponents() }

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

                loadComponents.setLoadComponents(app)
                goHome.setGoHome(app)
            }
        }
    }
}