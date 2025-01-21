/*
 * RAILGUN DOWNLOADER - VERSION 4.0.0
 * File: LogResult.kt
 * This project is licensed GPL-3.0 License.
 * LICENSE: https://www.gnu.org/licenses/gpl-3.0.html
 * Contribution: Reim
 */
package railgunDownloaderV4.components.mangadexUI

import java.awt.Color
import java.awt.Dimension
import java.awt.Font
import java.awt.Point
import javax.swing.JFrame
import javax.swing.JScrollPane
import javax.swing.JTextArea

class LogResult {
    fun setLogResult(app: JFrame, logResultArea: JTextArea) {
        logResultArea.background = Color(69, 69, 69)
        logResultArea.foreground = Color.WHITE
        logResultArea.font = Font("Consolas", Font.PLAIN, 12)
        logResultArea.toolTipText = "Your download process will be displayed here"
        logResultArea.lineWrap = true

        val scrollPanel = JScrollPane(logResultArea)
        scrollPanel.verticalScrollBarPolicy = JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED
        scrollPanel.horizontalScrollBarPolicy = JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED
        scrollPanel.border = null
        scrollPanel.size = Dimension(400, 340)
        scrollPanel.location = Point(100, 30)

        app.add(scrollPanel)
    }
}