/*
 * RAILGUN DOWNLOADER - VERSION 4.0.0
 * File: DevianArtDownload.kt
 * This project is licensed GPL-3.0 License.
 * LICENSE: https://www.gnu.org/licenses/gpl-3.0.html
 * Contribution: Reim
 */
package railgunDownloaderV4.components.devianArtUI.events

import okhttp3.OkHttpClient
import okhttp3.Request
import org.openqa.selenium.By
import org.openqa.selenium.NoSuchElementException
import org.openqa.selenium.TimeoutException
import org.openqa.selenium.WebElement
import org.openqa.selenium.chrome.ChromeDriver
import org.openqa.selenium.chrome.ChromeOptions
import org.openqa.selenium.support.ui.WebDriverWait
import railgunDownloaderV4.components.ulti.MessageDialog
import java.io.File
import java.io.FileOutputStream
import java.net.URI
import java.time.Duration
import javax.swing.JTextArea
import javax.swing.JTextField
import javax.swing.SwingUtilities
import javax.swing.SwingWorker

class DevianArtDownload (
    private val urlField: JTextField,
    private val pathField: JTextField,
    private val logArea: JTextArea
){

    private val messageDialog: MessageDialog by lazy { MessageDialog() }

    private fun downloadImage(imgURL: String, saveDir: String, imgName: String) {
        val client = OkHttpClient()
        val requestBuilder = Request.Builder()
            .url(imgURL)
            .header("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/87.0.4280.88 Safari/537.36")
            .header("Referer", imgURL)
            .header("Accept", "image/avif,image/webp,image/apng,image/*,*/*;q=0.8")
            .header("Accept-Language", "en-US,en;q=0.5")
            .build()
        val saveDirectory = File("$saveDir/$imgName")

        client.newCall(requestBuilder).execute()
            .use { response ->
                FileOutputStream(saveDirectory).let { result ->
                    response.body?.bytes()?.let { result.write(it) }
                    SwingUtilities.invokeLater {
                        logArea.append("Successfully download image $imgName")

                    }
                }
            }
    }

    private fun devianArtDownload() {
        val chromeOptions = ChromeOptions()
        chromeOptions.addArguments("--headless")

        val chromeDriver = ChromeDriver(chromeOptions)
        WebDriverWait(chromeDriver, Duration.ofSeconds(30))
        SwingUtilities.invokeLater {
            logArea.append("Get your DevianArt URL, please wait\n")
        }
        chromeDriver.get(urlField.text)

        val imageElement: WebElement?
        try { imageElement = chromeDriver.findElement(By.cssSelector("img.TZM0T._2NIJr")) }
        catch (noSuchElement: NoSuchElementException) {
            messageDialog.showMessageNotification("Can't find any image in your DevianArt URL. Please try again")
            return
        } catch (timeout: TimeoutException) {
            messageDialog.showMessageNotification("Connection timeout. Please check your internet connection and try again")
            return
        }

        val imgBaseName = imageElement.getDomAttribute("src")?.let { URI(it).path.substringAfterLast('/') }
        val imgURL = imageElement.getDomAttribute("src")

        downloadImage(
            imgURL!!, pathField.text,
            imgBaseName!!
        )
    }

    fun setDevianArtDownload() {
        object : SwingWorker<Unit, Unit>() {
            override fun doInBackground() {
                devianArtDownload()
            }
        }.execute()
    }
}