/*
 * RAILGUN DOWNLOADER - VERSION 4.0.0
 * File: Instagram.kt
 * This project is licensed GPL-3.0 License.
 * LICENSE: https://www.gnu.org/licenses/gpl-3.0.html
 * Contribution: Reim
 */

package railgunDownloaderV4.components
import railgunDownloaderV4.Application
import railgunDownloaderV4.components.global.ButtonUI
import railgunDownloaderV4.components.global.events.LoadUI
import railgunDownloaderV4.components.instagramUI.InstagramUI
import railgunDownloaderV4.components.instagramUI.LoadComponents
import java.awt.Dimension
import java.awt.Point
import javax.swing.JButton

class Instagram (private val appScene: Application){

    private val buttonUI: ButtonUI by lazy { ButtonUI() }
    private val instagramUI: InstagramUI by lazy { InstagramUI(appScene) }
    private val loadUI: LoadUI by lazy { LoadUI(appScene) }

    fun setInstagram(buttonTarget: JButton) {
        buttonUI.setButtonUI(
            appScene.app, buttonTarget,
            Dimension(50, 50), Point(450, 10),
            "/Instagram.png", "Download video from Instagram"
        )

        loadUI.setLoadUI(buttonTarget, instagramUI::setInstagramUI)
    }
}