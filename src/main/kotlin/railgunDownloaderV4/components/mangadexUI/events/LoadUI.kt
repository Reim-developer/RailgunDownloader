/*
 * RAILGUN DOWNLOADER - VERSION 4.0.0
 * File: LoadUI.kt
 * This project is licensed GPL-3.0 License.
 * LICENSE: https://www.gnu.org/licenses/gpl-3.0.html
 * Contribution: Reim
 */
package railgunDownloaderV4.components.mangadexUI.events

import railgunDownloaderV4.Application
import javax.swing.JButton


class LoadUI (private val appScene: Application){
    fun setLoadUI(app: JButton, action: (Boolean) -> Unit) {
        app.addActionListener {
            action(true)
            appScene.app.isVisible = false
        }
    }
}