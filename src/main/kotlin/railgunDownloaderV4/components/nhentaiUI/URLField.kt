/*
 * RAILGUN DOWNLOADER - VERSION 4.0.0
 * File: URLField.kt
 * This project is licensed GPL-3.0 License.
 * LICENSE: https://www.gnu.org/licenses/gpl-3.0.html
 * Contribution: Reim
 */
package railgunDownloaderV4.components.nhentaiUI

import java.awt.Font
import javax.swing.JFrame
import javax.swing.JTextField
import java.awt.Color
import java.awt.Point

class URLField {
    fun setURLField(app: JFrame, urlField: JTextField) {
        urlField.setSize(400, 30)
        urlField.border = null
        urlField.font = Font("Consolas", Font.PLAIN, 12)
        urlField.background = Color(69, 69, 69)
        urlField.foreground = Color.WHITE
        urlField.location = Point(100, 400)
        urlField.toolTipText = "Input your doujinshi URL or code"

        app.add(urlField)
    }
}