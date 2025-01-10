/*
 * RAILGUN DOWNLOADER - VERSION 4.0.0
 * LoadUI.kt
 */
package railgunDownloaderV4.components.facebookUI.events

import railgunDownloaderV4.Application
import javax.swing.JButton

class LoadUI (private val appScene: Application){
    fun setLoadUI(loadUIButton: JButton, action: (Boolean) -> Unit) {
        loadUIButton.addActionListener {
            action(true)
            appScene.App.isVisible = false
        }
    }
}