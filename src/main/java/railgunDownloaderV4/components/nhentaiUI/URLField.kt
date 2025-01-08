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

        app.add(urlField)
    }
}