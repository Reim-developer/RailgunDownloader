/*
 * RAILGUN DOWNLOADER - VERSION 4.0.0
 * File: Facebook.kt
 * This project is licensed GPL-3.0 License.
 * LICENSE: https://www.gnu.org/licenses/gpl-3.0.html
 * Contribution: Reim
 */
package railgunDownloaderV4.components

import railgunDownloaderV4.Application
import railgunDownloaderV4.components.facebookUI.FacebookUI
import railgunDownloaderV4.components.global.ButtonUI
import railgunDownloaderV4.components.global.events.LoadUI
import java.awt.Dimension
import java.awt.Point
import javax.swing.JButton

class Facebook (private val appScene: Application){
    private val facebookUI: FacebookUI by lazy { FacebookUI(appScene) }
    private val buttonUI: ButtonUI by lazy { ButtonUI() }
    private val loadUI: LoadUI by lazy { LoadUI(appScene) }

    fun setFacebookButton(facebookButton: JButton) {
        buttonUI.setButtonUI(
            appScene.app, facebookButton,
            Dimension(50, 50), Point(135, 0),
            "/Facebook.png", "Download video from Facebook"
        )

       loadUI.setLoadUI(facebookButton, facebookUI::showFacebookUI)
       appScene.app.add(facebookButton)
    }
}