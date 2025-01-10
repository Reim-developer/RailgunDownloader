/*
 * RAILGUN DOWNLOADER - VERSION 4.0.0
 * ClosingWindow.kt
 */
package railgunDownloaderV4.components.facebookUI.events

import railgunDownloaderV4.Application
import java.awt.event.WindowAdapter
import java.awt.event.WindowEvent
import javax.swing.JFrame

class ClosingWindow (private val appScene: Application){
    fun returnHome(app: JFrame) {
        app.addWindowListener(object: WindowAdapter() {
            override fun windowClosing(e: WindowEvent?) {
                appScene.App.isVisible = true
            }
        })
    }
}