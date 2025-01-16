/*
 * RAILGUN DOWNLOADER - VERSION 4.0.0
 * File: Downloader.kt
 * This project is licensed GPL-3.0 License.
 * LICENSE: https://www.gnu.org/licenses/gpl-3.0.html
 * Contribution: Reim
 */

package railgunDownloaderV4.components.hitomiUI.events

import okhttp3.OkHttpClient
import okhttp3.Request
import org.openqa.selenium.By
import org.openqa.selenium.NoSuchElementException
import org.openqa.selenium.WebDriver
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

class Downloader(
    private val urlField: JTextField,
    private val pathField: JTextField,
    private val logResult: JTextArea
) {

    private val messageDialog: MessageDialog by lazy { MessageDialog() }

    private fun downloadImage(imageURL: String, saveDir: String, imageName: String) {
        val client = OkHttpClient()
        val request = Request.Builder()
            .url(imageURL)
            .header("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/87.0.4280.88 Safari/537.36")
            .header("Referer", "https://hitomi.la/")
            .header("Accept", "image/avif,image/webp,image/apng,image/*,*/*;q=0.8")
            .header("Accept-Language", "en-US,en;q=0.5")
            .build()
        val saveDirectory = File("$saveDir/$imageName")

        client.newCall(request).execute()
            .use { response ->
                FileOutputStream(saveDirectory).use { output ->
                    response.body?.bytes()?.let { output.write(it) }
                    SwingUtilities.invokeLater { logResult.append("Download: $imageName\n") }
                }
            }
    }

    private fun hitomiDownloadProcess() {
        SwingUtilities.invokeLater { logResult.append("Starting download doujinshi, please wait\n") }
        val option = ChromeOptions()
        option.addArguments("--headless")
        val webDriver: WebDriver = ChromeDriver(option)

        WebDriverWait(webDriver, Duration.ofSeconds(30))
        webDriver.get(urlField.text)

        val doujinshiName: WebElement?
        try { doujinshiName = webDriver.findElement(By.cssSelector("h1#gallery-brand")) }
        catch (notFoundException: NoSuchElementException){
            messageDialog.showMessageNotification("Doujinshi not found. Please try again")
            SwingUtilities.invokeLater { logResult.append("Download failed with error: DOUJINSHI_NOT_FOUND\n") }
            return
        }

        val doujinshiImages: List<WebElement?>
        try { doujinshiImages = webDriver.findElements(By.cssSelector("ul.thumbnail-list img.lazyload")) }
        catch (notFoundException: NoSuchElementException) {
            messageDialog.showMessageNotification("Can't find any image in doujinshi $doujinshiName")
            SwingUtilities.invokeLater { logResult.append("Download image failed with error: IMAGE_NOT_FOUND") }
            return
        }

        val absoluteDir = File("${pathField.text}/${doujinshiName.text}")
        absoluteDir.takeIf { !it.exists() }?.let {
            SwingUtilities.invokeLater { logResult.append("Created save doujinshi folder ${doujinshiName.text}\n") }
            it.mkdirs()
        } ?: run{
            messageDialog.showMessageNotification("Doujinshi ${doujinshiName.text} is exists in your PC")
            SwingUtilities.invokeLater { logResult.append("Doujinshi ${doujinshiName.text} is exists in your PC") }
            return
        }

        doujinshiImages.forEach { image ->
            val imageName = image.getDomAttribute("data-src")?.let { URI(it).path.substringAfterLast('/').substring(50) }
            imageName?.let {
                downloadImage(
                    image.getDomAttribute("data-src")!!,
                    absoluteDir.absolutePath, it
                )
            }
        }
        SwingUtilities.invokeLater { logResult.append("Successfully download doujinshi $doujinshiName to:\n$absoluteDir") }
    }

    fun setDownloader() {
        object : SwingWorker<Unit, Unit>() {
            override fun doInBackground() {
                hitomiDownloadProcess()
            }
        }.execute()
    }
}