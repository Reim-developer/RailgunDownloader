/*
* RAILGUN DOWNLOADER - VERSION 4.0.0
* File: Application.kt
* This project is licensed under GPL-3.0 License.
* LICENSE: https://www.gnu.org/licenses/gpl-3.0.html
* Contribution: Reim
*/
package railgunDownloaderV4.components.global

import java.awt.Color
import java.awt.Dimension
import java.awt.Font
import java.awt.Point
import javax.swing.JFrame
import javax.swing.JTextField

class TextField {
    fun setTextField(
        app: JFrame,
        textField: JTextField,
        size: Dimension,
        location: Point,
        canEditable: Boolean,
        toolTipText: String
    ) {
        textField.size = size
        textField.location = location
        textField.toolTipText = toolTipText
        textField.border = null
        textField.isEditable = canEditable
        textField.background = Color(69, 69, 69)
        textField.foreground = Color.WHITE
        textField.font = Font("Consolas", Font.PLAIN, 12)
        textField.isVisible = true

        app.add(textField)
    }
}