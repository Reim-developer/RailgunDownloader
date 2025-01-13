/*
 * RAILGUN DOWNLOADER - VERSION 4.0.0
 * File: MangaDexButton.kt
 * This project is licensed GPL-3.0 License.
 * LICENSE: https://www.gnu.org/licenses/gpl-3.0.html
 * Contribution: Reim
 */
package railgunDownloaderV4.components.mangadexUI

import railgunDownloaderV4.components.ulti.SetIconButton
import java.awt.Dimension
import java.awt.Point
import javax.swing.JButton
import javax.swing.JFrame

class MangaDexButton {

    private val setIconButton: SetIconButton by lazy { SetIconButton() }

    fun setMangaDexButton(
        app: JFrame,
        buttonTarget: JButton,
        size: Dimension,
        location: Point,
        iconPath: String,
        toolTipText: String
    ) {
        buttonTarget.size = size
        buttonTarget.location = location
        buttonTarget.isContentAreaFilled = false
        buttonTarget.border = null
        buttonTarget.isBorderPainted = false
        buttonTarget.isFocusPainted = false
        buttonTarget.toolTipText = toolTipText
        setIconButton.setIcon(
            buttonTarget, iconPath,
            50, 50
        )

        app.add(buttonTarget)
    }
}