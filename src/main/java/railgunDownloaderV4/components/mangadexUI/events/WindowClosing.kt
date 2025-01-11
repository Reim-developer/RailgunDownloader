/*
 * RAILGUN DOWNLOADER - VERSION 4.0.0
 * WindowClosing.kt
 */
package railgunDownloaderV4.components.mangadexUI.events

import railgunDownloaderV4.Application
import java.awt.event.WindowAdapter
import java.awt.event.WindowEvent
import javax.swing.JFrame

class WindowClosing (private val appScene: Application){
    fun setWindowClosing(app: JFrame) {
        app.addWindowListener(object : WindowAdapter() {
            override fun windowClosing(e: WindowEvent?) {
                appScene.App.isVisible = true
            }
        })
    }
}