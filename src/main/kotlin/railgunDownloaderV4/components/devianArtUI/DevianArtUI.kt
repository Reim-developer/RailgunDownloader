/*
 * RAILGUN DOWNLOADER - VERSION 4.0.0
 * File: DevianArtUI.kt
 * This project is licensed GPL-3.0 License.
 * LICENSE: https://www.gnu.org/licenses/gpl-3.0.html
 * Contribution: Reim
 */
package railgunDownloaderV4.components.devianArtUI

import railgunDownloaderV4.Application
import railgunDownloaderV4.components.global.events.GoHome
import railgunDownloaderV4.components.ulti.SetIcon
import java.awt.Color
import java.awt.Dimension
import javax.swing.JFrame

class DevianArtUI (appScene: Application){

    private val goHome: GoHome by lazy { GoHome(appScene) }
    private val setIcon: SetIcon by lazy { SetIcon() }
    private val loadComponents: LoadComponents by lazy { LoadComponents() }

    fun setDevianArtUI(visible: Boolean = true) {
        val app = JFrame("Download image from DevianArt")
        app.size = Dimension(600, 600)
        app.isResizable = false
        app.maximumSize = Dimension(600, 600)
        app.setLocationRelativeTo(null)
        app.layout = null
        app.iconImage = setIcon.setAppIcon()
        app.contentPane.background = Color(21, 21, 21)
        app.foreground = Color.WHITE
        app.isVisible = visible

        loadComponents.setLoadComponents(app)
        goHome.setGoHome(app)
    }
}