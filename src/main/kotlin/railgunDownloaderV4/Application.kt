/*
 * RAILGUN DOWNLOADER - VERSION 4.0.0
 * File: Application.kt
 * This project is licensed under GPL-3.0 License.
 * LICENSE: https://www.gnu.org/licenses/gpl-3.0.html
 * Contribution: Reim
 */
package railgunDownloaderV4

import railgunDownloaderV4.components.*
import railgunDownloaderV4.components.ulti.SetIcon
import java.awt.Color
import java.awt.Dimension
import javax.swing.JButton
import javax.swing.JFrame
import javax.swing.SwingUtilities
import javax.swing.WindowConstants

class Application {
    val app: JFrame by lazy { JFrame() }
    private val youtubeComponent: Youtube by lazy { Youtube(this) }
    private val nhentaiComponent: Nhentai by lazy { Nhentai(this) }
    private val facebookComponent: Facebook by lazy { Facebook(this) }
    private val mangaDexComponent: MangaDex by lazy { MangaDex(this) }
    private val hitomiComponent: Hitomi by lazy { Hitomi(this) }
    private val bilibiliComponent: Bilibili by lazy { Bilibili(this) }
    private val instagramComponent: Instagram by lazy { Instagram(this) }
    private val tiktokComponent: Tiktok by lazy { Tiktok(this) }
    private val deviantArtComponent: DeviantArt by lazy { DeviantArt(this) }
    private val setIcon: SetIcon by lazy { SetIcon() }

    private val youtubeButton: JButton by lazy { JButton() }
    private val nhentaiButton: JButton by lazy { JButton() }
    private val facebookButton: JButton by lazy { JButton() }
    private val mangaDexButton: JButton by lazy { JButton() }
    private val hitomiButton: JButton by lazy { JButton() }
    private val bilibiliButton: JButton by lazy { JButton() }
    private val instagramButton: JButton by lazy { JButton() }
    private val tiktokButton: JButton by lazy { JButton() }
    private val deviantArtButton: JButton by lazy { JButton() }

    private fun setProperty() {
        app.title = "Railgun Downloader V4"
        app.iconImage = setIcon.setAppIcon()
        app.setSize(600, 600)
        app.maximumSize = Dimension(600, 600)
        app.layout = null
        app.setLocationRelativeTo(null)
        app.contentPane.background = Color(21, 21, 21)
        app.defaultCloseOperation = WindowConstants.EXIT_ON_CLOSE
        app.isResizable = false
        app.isVisible = true
    }

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            SwingUtilities.invokeLater {
                val appScene = Application()
                appScene.setProperty()
                appScene.youtubeComponent.setYoutubeButton(appScene.youtubeButton)
                appScene.nhentaiComponent.setNhentaiUIButton(appScene.nhentaiButton)
                appScene.facebookComponent.setFacebookButton(appScene.facebookButton)
                appScene.mangaDexComponent.setMangaDex(appScene.mangaDexButton)
                appScene.hitomiComponent.setHitomiButton(appScene.hitomiButton)
                appScene.bilibiliComponent.setBilibili(appScene.bilibiliButton)
                appScene.instagramComponent.setInstagram(appScene.instagramButton)
                appScene.tiktokComponent.setTiktok(appScene.tiktokButton)
                appScene.deviantArtComponent.setDevianArt(appScene.deviantArtButton)
            }
        }
    }
}
