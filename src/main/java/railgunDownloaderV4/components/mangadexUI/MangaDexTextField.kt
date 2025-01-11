/*
 * RAILGUN DOWNLOADER - VERSION 4.0.0
 * MangaDexTextField.kt
 */
package railgunDownloaderV4.components.mangadexUI

import java.awt.Color
import java.awt.Dimension
import java.awt.Font
import java.awt.Point
import javax.swing.JFrame
import javax.swing.JTextField

class MangaDexTextField {
    fun setTextField(
        app: JFrame,
        textField: JTextField,
        isEditable: Boolean,
        location: Point,
        size: Dimension,
        toolTipText: String
    ) {

        textField.size = size
        textField.location = location
        textField.isEditable = isEditable
        textField.toolTipText = toolTipText
        textField.background = Color(69, 69, 69)
        textField.border = null
        textField.font = Font("Consolas", Font.PLAIN, 12)
        textField.foreground = Color.WHITE

        app.add(textField)
    }
}