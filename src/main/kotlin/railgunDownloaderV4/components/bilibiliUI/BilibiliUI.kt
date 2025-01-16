/*
* RAILGUN DOWNLOADER - VERSION 4.0.0
* File: BilibiliUI.kt
* This project is licensed under GPL-3.0 License.
* LICENSE: https://www.gnu.org/licenses/gpl-3.0.html
* Contribution: Reim
*/
package railgunDownloaderV4.components.bilibiliUI

import railgunDownloaderV4.Application
import railgunDownloaderV4.components.global.events.GoHome
import railgunDownloaderV4.components.ulti.SetIcon
import java.awt.Color
import javax.swing.JFrame
import java.awt.Dimension
import javax.swing.WindowConstants

class BilibiliUI (appScene: Application){

    private val goHome: GoHome by lazy { GoHome(appScene) }
    private val setIcon: SetIcon by lazy { SetIcon() }
    private val loadComponents: LoadComponents by lazy { LoadComponents() }

    fun setBilibiliUI(visible: Boolean = false) {
        val app = JFrame("Download from Bilibili")
        app.size = Dimension(600, 600)
        app.layout = null
        app.defaultCloseOperation = WindowConstants.DISPOSE_ON_CLOSE
        app.isResizable = false
        app.maximumSize = Dimension(600, 600)
        app.contentPane.background = Color(21, 21, 21)
        app.setLocationRelativeTo(null)
        app.iconImage = setIcon.setAppIcon()
        app.isVisible = visible

        goHome.setGoHome(app)
        loadComponents.setLoadComponents(app)
    }

}