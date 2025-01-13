/*
 * RAILGUN DOWNLOADER - VERSION 4.0.0
 * File: Facebook.kt
 * This project is licensed GPL-3.0 License.
 * LICENSE: https://www.gnu.org/licenses/gpl-3.0.html
 * Contribution: Reim
 */
package railgunDownloaderV4.components

import railgunDownloaderV4.Application
import railgunDownloaderV4.components.facebookUI.FacebookUI
import railgunDownloaderV4.components.facebookUI.events.LoadUI
import railgunDownloaderV4.components.ulti.SetIconButton
import javax.swing.JButton

class Facebook (private val appScene: Application){
    private val setIconButton: SetIconButton by lazy { SetIconButton() }
    private val facebookUI: FacebookUI by lazy { FacebookUI(appScene) }
    private val loadUI: LoadUI by lazy { LoadUI(appScene) }

    fun setFacebookButton(facebookButton: JButton) {
        facebookButton.setSize(50, 50)
        facebookButton.setLocation(135, 0)
        facebookButton.isBorderPainted = false
        facebookButton.isFocusPainted = false
        facebookButton.isContentAreaFilled = false
        facebookButton.border = null

        setIconButton.setIcon(
            facebookButton,"/Facebook.png", 50, 50
        )

       loadUI.setLoadUI(facebookButton, facebookUI::showFacebookUI)
       appScene.app.add(facebookButton)
    }
}