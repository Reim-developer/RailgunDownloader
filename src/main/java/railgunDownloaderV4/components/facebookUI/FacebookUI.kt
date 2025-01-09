/*
 * RAILGUN DOWNLOADER - VERSION 4.0.0
 * FacebookUI.kt
 */
package railgunDownloaderV4.components.facebookUI

import railgunDownloaderV4.Application
import railgunDownloaderV4.components.ulti.SetIcon
import java.awt.Color
import java.awt.Dimension
import java.awt.event.WindowAdapter
import java.awt.event.WindowEvent
import javax.swing.JFrame
import javax.swing.SwingUtilities

class FacebookUI (private val appScene: Application){

    private val setIcon: SetIcon by lazy { SetIcon() }

    fun showFacebookUI(visible: Boolean = false) {
        SwingUtilities.invokeLater {
            val app = JFrame("Download video from Facebook")
            app.apply {
                size = Dimension(600, 600)
                isResizable = false
                maximumSize = Dimension(600, 600)
                contentPane.background = Color(21, 21, 21)
                setLocationRelativeTo(null)
                layout = null
                iconImage = setIcon.AppIcon()
                isVisible = visible

                closingWindow(app)
            }
        }
    }

    private fun closingWindow(app: JFrame) {
        app.addWindowListener(object: WindowAdapter() {
            override fun windowClosing(e: WindowEvent?) {
                appScene.App.isVisible = true
            }
        })
    }
}