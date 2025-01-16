/*
* RAILGUN DOWNLOADER - VERSION 4.0.0
* File: Application.kt
* This project is licensed under GPL-3.0 License.
* LICENSE: https://www.gnu.org/licenses/gpl-3.0.html
* Contribution: Reim
*/
package railgunDownloaderV4.components.global

import railgunDownloaderV4.components.ulti.SetIconButton
import java.awt.Dimension
import javax.swing.JButton
import javax.swing.JFrame
import java.awt.Point

class ButtonUI {

    private val setIconButton: SetIconButton by lazy { SetIconButton() }

    fun setButtonUI(
        app: JFrame,
        button: JButton,
        size: Dimension,
        location: Point,
        iconPath: String,
        toolTipText: String
    ) {
        button.size = size
        button.location = location
        button.isContentAreaFilled = false
        button.border = null
        button.isFocusPainted = false
        button.isBorderPainted = false

        setIconButton.setIcon(
            button, iconPath,
            button.width, button.height
        )
        button.toolTipText = toolTipText

        app.add(button)
    }
}