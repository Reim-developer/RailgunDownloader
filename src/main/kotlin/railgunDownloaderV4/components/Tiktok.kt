/*
 * RAILGUN DOWNLOADER - VERSION 4.0.0
 * File: Tiktok.kt
 * This project is licensed GPL-3.0 License.
 * LICENSE: https://www.gnu.org/licenses/gpl-3.0.html
 * Contribution: Reim
 */

package railgunDownloaderV4.components

import railgunDownloaderV4.Application
import railgunDownloaderV4.components.global.ButtonUI
import railgunDownloaderV4.components.global.events.LoadUI
import railgunDownloaderV4.components.tiktokUI.TiktokUI
import java.awt.Dimension
import java.awt.Point
import javax.swing.JButton

class Tiktok (private val appScene: Application){

    private val buttonUI: ButtonUI by lazy { ButtonUI() }
    private val loadUI: LoadUI by lazy { LoadUI(appScene) }
    private val tiktokUI: TiktokUI by lazy { TiktokUI(appScene) }

    fun setTiktok(buttonTarget: JButton) {
        buttonUI.setButtonUI(
            appScene.app, buttonTarget,
            Dimension(50, 50), Point(520, 10),
            "/Tiktok.png", "Download video from Tiktok"
        )
        loadUI.setLoadUI(buttonTarget, tiktokUI::setTiktokUI)
    }
}