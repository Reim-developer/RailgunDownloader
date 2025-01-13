/*
 * RAILGUN DOWNLOADER - VERSION 4.0.0
 * File: LogResult.kt
 * This project is licensed GPL-3.0 License.
 * LICENSE: https://www.gnu.org/licenses/gpl-3.0.html
 * Contribution: Reim
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
            toolTipText = "Your download result will be displayed here"
        }

            val scrollPanel = JScrollPane(logResultArea)
            scrollPanel.size = Dimension(400, 300)
            scrollPanel.border = null
            scrollPanel.verticalScrollBarPolicy = JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED
            scrollPanel.horizontalScrollBarPolicy = JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED
            scrollPanel.location = Point(100, 20)

        app.add(scrollPanel)
    }
}