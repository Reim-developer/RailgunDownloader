/*
 * RAILGUN DOWNLOADER - VERSION 4.0.0
 * File: ShowPath.kt
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

class ShowPath {
    fun setShowPath(app: JFrame, showPathField: JTextField) {
        showPathField.size = Dimension(400, 30)
        showPathField.border = null
        showPathField.font = Font("Consolas", Font.PLAIN, 15)
        showPathField.isEditable = false
        showPathField.background = Color(69, 69, 69)
        showPathField.foreground = Color.WHITE
        showPathField.location = Point(100, 300)

        showPathField.toolTipText = "Your chosen path is displayed here"

        app.add(showPathField)
    }
}
