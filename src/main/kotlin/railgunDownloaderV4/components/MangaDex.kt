/*
 * RAILGUN DOWNLOADER - VERSION 4.0.0
 * File: MangaDex.kt
 * This project is licensed GPL-3.0 License.
 * LICENSE: https://www.gnu.org/licenses/gpl-3.0.html
 * Contribution: Reim
 */
package railgunDownloaderV4.components

import railgunDownloaderV4.Application
import railgunDownloaderV4.components.mangadexUI.MangaDexUI
import railgunDownloaderV4.components.mangadexUI.events.LoadUI
import railgunDownloaderV4.components.ulti.SetIconButton
import java.awt.Dimension
import java.awt.Point
import javax.swing.JButton

class MangaDex (private val appScene: Application){

    private val setIconButton: SetIconButton by lazy { SetIconButton() }
    private val loadUI: LoadUI by lazy { LoadUI(appScene) }
    private val mangaDexUI: MangaDexUI by lazy { MangaDexUI(appScene) }

    fun setMangaDex(mangaDexButton: JButton) {
        mangaDexButton.apply {
            size = Dimension(50, 50)
            isFocusPainted = false
            isBorderPainted = false
            border = null
            isContentAreaFilled = false
            location = Point(210, 7)
            toolTipText = "Download from MangaDex"
        }
        setIconButton.setIcon(
            mangaDexButton, "/MangaDex.png",
            50, 50
        )
        loadUI.setLoadUI(mangaDexButton, mangaDexUI::setMangaDexUI)

        appScene.app.add(mangaDexButton)
    }
}