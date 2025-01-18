/*
 * RAILGUN DOWNLOADER - VERSION 4.0.0
 * File: LogResult.kt
 * This project is licensed GPL-3.0 License.
 * LICENSE: https://www.gnu.org/licenses/gpl-3.0.html
 * Contribution: Reim
 */

package railgunDownloaderV4.components.global

import java.awt.Color
import java.awt.Dimension
import java.awt.Font
import java.awt.Point
import javax.swing.JFrame
import javax.swing.JScrollPane
import javax.swing.JTextArea

class LogResult {
    fun setLogResult(
        app: JFrame,
        logArea: JTextArea,
        size: Dimension,
        location: Point,
        toolTipText: String
    ) {
        logArea.background = Color(69, 69, 69)
        logArea.foreground = Color.WHITE
        logArea.font = Font("Consolas", Font.PLAIN, 12)
        logArea.isEditable = false
        logArea.lineWrap = true
        logArea.toolTipText = toolTipText

        val scrollPanel = JScrollPane(logArea)
        scrollPanel.size = size
        scrollPanel.location = location
        scrollPanel.border = null
        scrollPanel.verticalScrollBarPolicy = JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED
        scrollPanel.horizontalScrollBarPolicy = JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED

        app.add(scrollPanel)
    }
}