/*
 * RAILGUN DOWNLOADER - VERSION 4.0.0
 * File: WindowClosing.kt
 * This project is licensed GPL-3.0 License.
 * LICENSE: https://www.gnu.org/licenses/gpl-3.0.html
 * Contribution: Reim
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
                appScene.app.isVisible = true
            }
        })
    }
}