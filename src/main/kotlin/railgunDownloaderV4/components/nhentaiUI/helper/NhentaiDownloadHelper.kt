/*
 * RAILGUN DOWNLOADER - VERSION 4.0.0
 * File: NhentaiDownloadHelper.kt
 * This project is licensed GPL-3.0 License.
 * LICENSE: https://www.gnu.org/licenses/gpl-3.0.html
 * Contribution: Reim
 */
package railgunDownloaderV4.components.nhentaiUI.helper

import okhttp3.OkHttpClient
import okhttp3.Request
import org.jsoup.Connection.Response
import org.jsoup.HttpStatusException
import org.jsoup.Jsoup
import railgunDownloaderV4.components.ulti.MatchNumber
import railgunDownloaderV4.components.ulti.MessageDialog
import java.io.File
import java.io.FileOutputStream
import java.net.URI
import java.net.http.HttpConnectTimeoutException
import javax.swing.JTextArea
import javax.swing.JTextField
import javax.swing.SwingUtilities
import javax.swing.SwingWorker

class NhentaiDownloadHelper(
    private val targetURL: JTextField, private val saveDir: JTextField, private val resultLog: JTextArea
) {

    private val messageDialog: MessageDialog by lazy { MessageDialog() }
    private val matchNumber: MatchNumber by lazy { MatchNumber() }

    private fun downloadImages(targetUrl: String, saveDir: String, doujinshiDir: String, imageName: String) {
        val client = OkHttpClient()
        val request = Request.Builder()
            .url(targetUrl)
            .build()
        val filePath = File("$saveDir/$doujinshiDir", imageName)

        client.newCall(request)
            .execute().use { response ->
                response.takeIf { !it.isSuccessful }?.let {
                    SwingUtilities.invokeLater { resultLog.append("HTTP request failed. Please check your internet connection and try again\n") }
                    return
                }

                FileOutputStream(filePath).use { output ->
                    response.body?.bytes()?.let { output.write(it) }
                    SwingUtilities.invokeLater { resultLog.append("Download $imageName\n") }
                }
            }
    }

    private fun getBaseName(urlTarget: String): String {
        return URI(urlTarget).path.substringAfterLast('/')
    }

    private fun downloadByDoujinshiURL() {
        val webDocument = Jsoup.connect(targetURL.text).get()
        val doujinshiCode = webDocument.select("h3#gallery_id")
        val imgTags = webDocument.select("div.thumbs img.lazyload")

        val doujinshi = doujinshiCode.text().replace("#", "")
        val saveDoujinshiDir = File("${saveDir.text}/$doujinshi")

        matchNumber.takeIf { !it.matchNumber(doujinshi) }?.let {
            messageDialog.showMessageNotification("Doujinshi with URL: ${targetURL.text} not found")
            return
        }

        saveDoujinshiDir.takeIf { !it.exists() }?.apply {
            mkdirs()
        } ?: run { messageDialog.showMessageNotification("Doujinshi $doujinshi is exists in your PC"); return }

        SwingUtilities.invokeLater { resultLog.append("Send HTTP request to $targetURL, please wait\n") }
        imgTags.forEach { image ->
            downloadImages(
                targetURL.text, saveDir.text, doujinshi,
                getBaseName(image.attr("data-src"))
            )
        }
        messageDialog.showMessageNotification("Successfully download doujinshi $doujinshiCode")
    }

    private fun downloadByCode() {
        SwingUtilities.invokeLater { resultLog.append("Searching doujinshi code: ${targetURL.text}\n") }
        val webResponse: Response?
        val doujinshiCodeTarget = "https://nhentai.net/g/${targetURL.text}"
        try {
            webResponse = Jsoup.connect(doujinshiCodeTarget).execute()
        }catch (exception: HttpStatusException) {
            messageDialog.showMessageNotification("Doujinshi ${targetURL.text} not found")
            return
        } catch (exception: HttpConnectTimeoutException) {
            messageDialog.showMessageNotification("Connection timeout. Please check your internet connection and try again")
            return
        }
        val webDocument = webResponse.parse()
        val doujinshiCode = webDocument.select("h3#gallery_id")
        val imgTags = webDocument.select("div.thumbs img.lazyload")
        val doujinshi = doujinshiCode.text().replace("#", "")

        val saveDoujinshiDir = File("${saveDir.text}/$doujinshi")
        saveDoujinshiDir.takeIf { !it.exists() }?.apply {
            mkdirs()
        } ?: run { messageDialog.showMessageNotification("Doujinshi $doujinshi is exists in your PC"); return }

        SwingUtilities.invokeLater { resultLog.append("Find doujinshi code $doujinshi, please wait\n") }
        imgTags.forEach{image ->
            downloadImages(
                doujinshiCodeTarget, saveDir.text, doujinshi,
                getBaseName(image.attr("data-src"))
            )
        }
    }

    fun executeDownload(choice: String) {
        object : SwingWorker<Unit, Unit>() {
            override fun doInBackground() {
                when(choice) {
                    "BY_URL" -> downloadByDoujinshiURL()
                    "BY_CODE" -> downloadByCode()
                }
            }
        }.execute()
    }
}