/*
 * RAILGUN DOWNLOADER - VERSION 4.0.0
 * File: Hitomi.kt
 * This project is licensed GPL-3.0 License.
 * LICENSE: https://www.gnu.org/licenses/gpl-3.0.html
 * Contribution: Reim
 */
package railgunDownloaderV4.components

import railgunDownloaderV4.Application
import railgunDownloaderV4.components.global.ButtonUI
import railgunDownloaderV4.components.global.events.LoadUI
import railgunDownloaderV4.components.hitomiUI.HitomiUI
import java.awt.Dimension
import java.awt.Point
import javax.swing.JButton

class Hitomi(private val appScene: Application) {

    private val buttonUI: ButtonUI by lazy { ButtonUI() }
    private val hitomiUI: HitomiUI by lazy { HitomiUI(appScene) }
    private val loadUI: LoadUI by lazy { LoadUI(appScene) }

    fun setHitomiButton(hitomiButton: JButton) {
        buttonUI.setButtonUI(
            appScene.app, hitomiButton, Dimension(50, 50),
            Point(290, 10), "/Hitomi.png",
            "Download from Hitomi.la"
        )
        loadUI.setLoadUI(hitomiButton, hitomiUI::setHitomiUI)
    }
}