/*
 * RAILGUN DOWNLOADER - VERSION 4.0.0
 * File: LogResult.kt
 * This project is licensed GPL-3.0 License.
 * LICENSE: https://www.gnu.org/licenses/gpl-3.0.html
 * Contribution: Reim
 */
package railgunDownloaderV4.components.nhentaiUI

import java.awt.Color
import java.awt.Font
import javax.swing.JFrame
import javax.swing.JScrollPane
import javax.swing.JTextArea

class LogResult {
    fun setLogResult(app: JFrame, logArea: JTextArea) {
        logArea.background = Color(69, 69, 69)
        logArea.foreground = Color.WHITE
        logArea.isEditable = false
        logArea.font = Font("Consolas", Font.PLAIN, 12)
        logArea.toolTipText = "Your download result will be displayed here"

        val logScrollPane = JScrollPane(logArea)
        logScrollPane.setSize(400, 250)
        logScrollPane.verticalScrollBarPolicy = JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED
        logScrollPane.horizontalScrollBarPolicy = JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED
        logScrollPane.border = null
        logScrollPane.setLocation(100, 40)

        app.add(logScrollPane)
    }
}