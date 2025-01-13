/*
 * RAILGUN DOWNLOADER - VERSION 4.0.0
 * File: Resultlog.kt
 * This project is licensed GPL-3.0 License.
 * LICENSE: https://www.gnu.org/licenses/gpl-3.0.html
 * Contribution: Reim
 */
package railgunDownloaderV4.components.youtubeUI

import java.awt.Color
import java.awt.Dimension
import java.awt.Font
import java.awt.Point
import javax.swing.JFrame
import javax.swing.JScrollPane
import javax.swing.JTextArea

class Resultlog {
    fun setResultlog(app: JFrame, resultArea: JTextArea) {
        resultArea.font = Font("Consolas", Font.PLAIN, 10)
        resultArea.isEditable = false
        resultArea.wrapStyleWord = true
        resultArea.lineWrap = true
        resultArea.background = Color(69, 69, 69)
        resultArea.foreground = Color.WHITE
        resultArea.toolTipText = "Your download result will be displayed here"

        val scrollPanel = JScrollPane(resultArea)
        scrollPanel.verticalScrollBarPolicy = JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED
        scrollPanel.horizontalScrollBarPolicy = JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED
        scrollPanel.size = Dimension(400, 200)
        scrollPanel.location = Point(100, 50)
        scrollPanel.border = null

        app.add(scrollPanel)
    }
}
