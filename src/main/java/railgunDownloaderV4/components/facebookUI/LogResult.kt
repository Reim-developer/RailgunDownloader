/*
 * RAILGUN DOWNLOADER - VERSION 4.0.0
 * LogResult.kt
 */
package railgunDownloaderV4.components.facebookUI

import java.awt.Color
import java.awt.Dimension
import java.awt.Font
import java.awt.Point
import javax.swing.JFrame
import javax.swing.JScrollPane
import javax.swing.JTextArea

class LogResult {
    fun setLogResult(app: JFrame, logResultArea: JTextArea) {
        logResultArea.apply {
            isEditable = false
            background = Color(69, 69, 69)
            foreground = Color.WHITE
            font = Font("Consolas", Font.PLAIN, 12)
        }

        val scrollPanel = JScrollPane(logResultArea).apply {
            size = Dimension(400, 300)
            location = Point(100, 20)
            border = null
        }
        app.add(scrollPanel)
    }
}