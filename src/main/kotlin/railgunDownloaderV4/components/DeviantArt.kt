/*
 * RAILGUN DOWNLOADER - VERSION 4.0.0
 * File: DevianArt.kt
 * This project is licensed GPL-3.0 License.
 * LICENSE: https://www.gnu.org/licenses/gpl-3.0.html
 * Contribution: Reim
 */
package railgunDownloaderV4.components

import railgunDownloaderV4.Application
import railgunDownloaderV4.components.devianArtUI.DevianArtUI
import railgunDownloaderV4.components.global.ButtonUI
import railgunDownloaderV4.components.global.events.LoadUI
import java.awt.Dimension
import java.awt.Point
import javax.swing.JButton

class DeviantArt (private val appScene: Application){

    private val buttonUI: ButtonUI by lazy { ButtonUI() }
    private val loadUI: LoadUI by lazy { LoadUI(appScene) }
    private val devianArtUI: DevianArtUI by lazy { DevianArtUI(appScene) }

    fun setDevianArt(buttonTarget: JButton) {
        buttonUI.setButtonUI(
            appScene.app, buttonTarget,
            Dimension(50, 50), Point(0, 50),
            "/DevianArt.png", "Download image from DevianArt"
        )

        loadUI.setLoadUI(buttonTarget, devianArtUI::setDevianArtUI)
    }
}