/*
 * RAILGUN DOWNLOADER - VERSION 4.0.0
 * File: MangaDexUI.kt
 * This project is licensed GPL-3.0 License.
 * LICENSE: https://www.gnu.org/licenses/gpl-3.0.html
 * Contribution: Reim
 */
package railgunDownloaderV4.components.mangadexUI

import railgunDownloaderV4.Application
import railgunDownloaderV4.components.mangadexUI.events.DownloadMangaDex
import railgunDownloaderV4.components.mangadexUI.events.OpenDir
import railgunDownloaderV4.components.mangadexUI.events.WindowClosing
import railgunDownloaderV4.components.ulti.SetIcon
import java.awt.Color
import java.awt.Dimension
import java.awt.Point
import javax.swing.JButton
import javax.swing.JFrame
import javax.swing.JTextArea
import javax.swing.JTextField
import javax.swing.SwingUtilities

class MangaDexUI (appScene: Application){

    private val windowClosing: WindowClosing by lazy { WindowClosing(appScene) }
    private val mangaDexTextField: MangaDexTextField by lazy { MangaDexTextField() }
    private val mangaDexButton: MangaDexButton by lazy { MangaDexButton() }
    private val setIcon: SetIcon by lazy { SetIcon() }
    private val openDir: OpenDir by lazy { OpenDir(this) }
    private val downloadMangaDex: DownloadMangaDex by lazy { DownloadMangaDex(mangaDexIDField, mangaDexSaveDir, logResultArea) }
    private val setLogResult: LogResult by lazy { LogResult() }

    private val mangaDexIDField: JTextField by lazy { JTextField() }
    val mangaDexSaveDir: JTextField by lazy { JTextField() }
    private val saveDirButton: JButton by lazy { JButton() }
    private val downloadMangaButton: JButton by lazy { JButton() }
    private val logResultArea: JTextArea by lazy { JTextArea() }

    fun setMangaDexUI(visible: Boolean = false) {
        val  app = JFrame()
        SwingUtilities.invokeLater {
            app.title = "Download from MangaDex"
            app.size = Dimension(600, 600)
            app.isResizable = false
            app.setLocationRelativeTo(null)
            app.isResizable = false
            app.contentPane.background = Color(21, 21, 21)
            app.layout = null
            app.maximumSize = Dimension(600, 600)
            app.iconImage = setIcon.setAppIcon()

            mangaDexTextField.setTextField(
                app, mangaDexIDField, true,
                Point(100, 450), Dimension(400, 30),
                "Input your MangaDex manga ID"
            )
            mangaDexTextField.setTextField(
                app, mangaDexSaveDir, false,
                Point(100, 400), Dimension(400, 30),
                "Your chosen save directory path will be displayed here"
            )

            mangaDexButton.setMangaDexButton(
                app, saveDirButton,
                Dimension(50, 50), Point(100, 490),
                "/FolderPath.png", "Choose save directory"
            )
            openDir.setOpenDir(saveDirButton)

            mangaDexButton.setMangaDexButton(
                app, downloadMangaButton,
                Dimension(50, 50), Point(170, 490),
                "/Download.png", "Download manga"
            )
            downloadMangaDex.download(downloadMangaButton)

            setLogResult.setLogResult(app, logResultArea)

            app.isVisible = visible
        }

        windowClosing.setWindowClosing(app)
    }
}