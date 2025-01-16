/*
 * RAILGUN DOWNLOADER - VERSION 4.0.0
 * File: Bilibili.kt
 * This project is licensed GPL-3.0 License.
 * LICENSE: https://www.gnu.org/licenses/gpl-3.0.html
 * Contribution: Reim
 */

package railgunDownloaderV4.components

import railgunDownloaderV4.Application
import railgunDownloaderV4.components.bilibiliUI.BilibiliUI
import railgunDownloaderV4.components.global.ButtonUI
import railgunDownloaderV4.components.global.events.LoadUI
import javax.swing.JButton
import java.awt.Dimension
import java.awt.Point

class Bilibili(private val appScene: Application){

    private val buttonUI: ButtonUI by lazy { ButtonUI() }
    private val loadUI: LoadUI by lazy { LoadUI(appScene) }
    private val bilibiliUI: BilibiliUI by lazy { BilibiliUI(appScene) }

    fun setBilibili(targetButton: JButton) {
        buttonUI.setButtonUI(
            appScene.app, targetButton,
            Dimension(70, 60), Point(360, 0),
            "/Bilibili.png", "Download from Bilibili"
        )

        loadUI.setLoadUI(targetButton, bilibiliUI::setBilibiliUI)
    }
}