/*
 * RAILGUN DOWNLOADER - VERSION 4.0.0
 * File: GoHome.kt
 * This project is licensed GPL-3.0 License.
 * LICENSE: https://www.gnu.org/licenses/gpl-3.0.html
 * Contribution: Reim
 */

package railgunDownloaderV4.components.global.events

import railgunDownloaderV4.Application
import java.awt.event.WindowAdapter
import java.awt.event.WindowEvent
import javax.swing.JFrame

class GoHome(private val appScene: Application){
    fun setGoHome(targetApp: JFrame) {
        targetApp.addWindowListener(object : WindowAdapter(){
            override fun windowClosing(e: WindowEvent?) {
                appScene.app.isVisible = true
            }
        })
    }
}