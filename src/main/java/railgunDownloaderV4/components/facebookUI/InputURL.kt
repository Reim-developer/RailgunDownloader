/*
 * RAILGUN DOWNLOADER - VERSION 4.0.0
 * InputURL.kt
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
        }

        app.add(inputURLField)
    }
}