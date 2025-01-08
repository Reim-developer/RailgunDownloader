/*
 * RAILGUN DOWNLOADER - VERSION 4.0.0
 * PathField.kt
 */
package railgunDownloaderV4.components.nhentaiUI

import java.awt.Color
import java.awt.Font
import javax.swing.JFrame
import javax.swing.JTextField

class PathField {
    fun setPathField(app: JFrame, pathField: JTextField) {
        pathField.setSize(400, 30)
        pathField.border = null
        pathField.background = Color(69, 69, 69)
        pathField.foreground = Color.WHITE
        pathField.setLocation(100, 350)
        pathField.font = Font("Consolas", Font.PLAIN, 12)
        pathField.isEditable = false
        pathField.toolTipText = "Your chosen path is displayed here"

        app.add(pathField)
    }
}