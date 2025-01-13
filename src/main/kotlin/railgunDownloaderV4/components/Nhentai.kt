/*
 * RAILGUN DOWNLOADER - VERSION 4.0.0
 * File: Nhentai.kt
 * This project is licensed GPL-3.0 License.
 * LICENSE: https://www.gnu.org/licenses/gpl-3.0.html
 * Contribution: Reim
 */
package railgunDownloaderV4.components
import javax.swing.JButton
import railgunDownloaderV4.Application
import railgunDownloaderV4.components.nhentaiUI.NhentaiUI
import java.awt.Image
import java.awt.Toolkit
import javax.swing.ImageIcon

class Nhentai (private var appScene: Application) {
    private val nhentaiComponent: NhentaiUI by lazy { NhentaiUI(appScene) }


    fun setNhentaiUIButton(nhentaiButton: JButton) {
        nhentaiButton.setSize(50, 50)
        nhentaiButton.isContentAreaFilled = false
        nhentaiButton.border = null
        nhentaiButton.setLocation(70, 0)
        nhentaiButton.toolTipText = "Download doujinshi from Nhentai.net"

        val buttonIcon: Image = Toolkit
            .getDefaultToolkit().getImage(
                this::class.java.getResource("/Nhentai.png"))
        nhentaiButton.icon = ImageIcon(
            buttonIcon.getScaledInstance( 50, 50, Image.SCALE_FAST)
        )

        loadNhentaiUI(nhentaiButton =  nhentaiButton)
        appScene.app.add(nhentaiButton)
    }

    private fun loadNhentaiUI(nhentaiButton: JButton) {
        nhentaiButton.addActionListener { _ ->
            nhentaiComponent.showNhentaiUI(true)
            appScene.app.isVisible = false
        }
    }
}