/*
 * RAILGUN DOWNLOADER - VERSION 4.0.0
 * File: InputPath.kt
 * This project is licensed GPL-3.0 License.
 * LICENSE: https://www.gnu.org/licenses/gpl-3.0.html
 * Contribution: Reim
 */
package railgunDownloaderV4.components.facebookUI

import java.awt.Color
import java.awt.Dimension
import java.awt.Point
import javax.swing.JFrame
import javax.swing.JTextField

class InputPath {
    fun setInputPath(app: JFrame, inputPathField: JTextField) {
        inputPathField.apply {
            size = Dimension(400, 30)
            location = Point(100, 350)
            isEditable = false
            border = null
            background = Color(69, 69, 69)
            foreground = Color.WHITE
            toolTipText = "Your chosen path will be displayed here"
        }

        app.add(inputPathField)
    }
}