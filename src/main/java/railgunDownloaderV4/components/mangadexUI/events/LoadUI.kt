/*
 * RAILGUN DOWNLOADER - VERSION 4.0.0
 * LoadUI.kt
 */
package railgunDownloaderV4.components.mangadexUI.events

import railgunDownloaderV4.Application
import javax.swing.JButton


class LoadUI (private val appScene: Application){
    fun setLoadUI(app: JButton, action: (Boolean) -> Unit) {
        app.addActionListener {
            action(true)
            appScene.App.isVisible = false
        }
    }
}