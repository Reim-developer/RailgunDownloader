/*
 * RAILGUN DOWNLOADER - VERSION 4.0.0
 * File: InputURL.kt
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
import javax.swing.JTextField

class InputURL {
    fun setURL(app: JFrame, inputURLField: JTextField) {
        inputURLField.apply {
            size = Dimension(400, 30)
            location = Point(100, 400)
            font = Font("Consolas", Font.PLAIN, 12)
            background = Color(69, 69, 69)
            foreground = Color.WHITE
            border = null
            toolTipText = "Input your URL here"
        }

        app.add(inputURLField)
    }
}