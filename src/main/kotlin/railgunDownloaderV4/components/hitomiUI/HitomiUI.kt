/*
 * RAILGUN DOWNLOADER - VERSION 4.0.0
 * File: HitomiUI.kt
 * This project is licensed GPL-3.0 License.
 * LICENSE: https://www.gnu.org/licenses/gpl-3.0.html
 * Contribution: Reim
 */

package railgunDownloaderV4.components.hitomiUI

import railgunDownloaderV4.Application
import railgunDownloaderV4.components.global.events.GoHome
import railgunDownloaderV4.components.ulti.SetIcon
import java.awt.Color
import java.awt.Dimension
import javax.swing.JFrame
import javax.swing.WindowConstants

class HitomiUI (private val appScene: Application){

    private val goHome: GoHome by lazy { GoHome(appScene) }
    private val setIcon: SetIcon by lazy {  SetIcon() }
    private val loadComponents: LoadComponents by lazy { LoadComponents() }

    fun setHitomiUI(visible: Boolean) {
        val app = JFrame("Download from Hitomi.la")
        app.size = Dimension(600, 600)
        app.isResizable = false
        app.maximumSize = Dimension(600, 600)
        app.contentPane.background = Color(21, 21, 21)
        app.defaultCloseOperation = WindowConstants.DISPOSE_ON_CLOSE
        app.setLocationRelativeTo(null)
        app.layout = null
        app.iconImage = setIcon.setAppIcon()
        loadComponents.setLoadComponents(app)
        app.isVisible = visible

        goHome.setGoHome(app)
    }
}