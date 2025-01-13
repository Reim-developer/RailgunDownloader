/*
 * RAILGUN DOWNLOADER - VERSION 4.0.0
 * File: InputURL.kt
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
import javax.swing.JTextField

class InputURL {
    fun setInputURL(app: JFrame, urlInput: JTextField) {
        urlInput.size = Dimension(400, 30)
        urlInput.border = null
        urlInput.background = Color(69, 69, 69)
        urlInput.foreground = Color.WHITE
        urlInput.font = Font("Consolas", Font.PLAIN, 15)
        urlInput.location = Point(100, 370)
        urlInput.toolTipText = "Input your Youtube URL here."

        app.add(urlInput)
    }
}
