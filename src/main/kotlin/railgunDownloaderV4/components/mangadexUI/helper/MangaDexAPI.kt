/*
 * RAILGUN DOWNLOADER - VERSION 4.0.0
 * File: MangaDexAPI.kt
 * This project is licensed GPL-3.0 License.
 * LICENSE: https://www.gnu.org/licenses/gpl-3.0.html
 * Contribution: Reim
 */
package railgunDownloaderV4.components.mangadexUI.helper
import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import okhttp3.OkHttpClient
import okhttp3.Request
import com.fasterxml.jackson.module.kotlin.readValue
import railgunDownloaderV4.components.ulti.MessageDialog
import java.io.File
import java.io.FileOutputStream
import java.net.URI
import javax.swing.JTextArea
import javax.swing.SwingUtilities
import javax.swing.SwingWorker

class MangaDexAPI (
    private val logArea: JTextArea
){

    private val messageDialog: MessageDialog by lazy { MessageDialog() }

    @JsonIgnoreProperties(ignoreUnknown = true)
    data class Attributes(
        val title: Map<String, String>
    )

    @JsonIgnoreProperties(ignoreUnknown = true)
    data class Chapter(
        val id: String
    )
    @JsonIgnoreProperties(ignoreUnknown = true)
    data class ChapterAttributes(
        val title: String
    )
    @JsonIgnoreProperties(ignoreUnknown = true)
    data class ChapterName(
        val attributes: ChapterAttributes
    )

    @JsonIgnoreProperties(ignoreUnknown = true)
    data class ImageProperty(
        val baseUrl: String,
        val result: String,
        val chapter: Image
    )

    @JsonIgnoreProperties(ignoreUnknown = true)
    data class Image(
        val hash: String,
        val data: List<String>
    )

    @JsonIgnoreProperties(ignoreUnknown = true)
    data class Manga(
        val attributes: Attributes
    )

    private fun fetchMangaName(mangaID: String): Manga? {
        val client = OkHttpClient()
        val request = Request.Builder()
            .url("https://api.mangadex.org/manga/$mangaID")
            .build()

        client.newCall(request)
            .execute().use { response ->
                if(!response.isSuccessful) {
                    messageDialog.showMessageNotification("Can't GET response body. Please check your Manga ID and try again")
                    return null
                }

                val mapper = jacksonObjectMapper()
                val jsonData = response.body?.string() ?: return null

                val data = mapper.readTree(jsonData).get("data")
                return mapper.treeToValue(data, Manga::class.java)
            }
    }

    private fun fetchChapterName(mangaID: String): List<ChapterName>? {
        val client = OkHttpClient()
        val request = Request.Builder()
            .url("https://api.mangadex.org/manga/$mangaID/feed")
            .build()

        client.newCall(request).execute()
            .use { response ->
                if(!response.isSuccessful) {
                    messageDialog.showMessageNotification("Can't get manga name. Please try again")
                    return null
                }

                val mapper =  jacksonObjectMapper()
                val jsonData = response.body?.string() ?: return null

                val chapterData = mapper.readTree(jsonData)
                    .get("data")

                return mapper.treeToValue(chapterData, Array<ChapterName>::class.java)?.toList()
            }
    }

    private fun fetchChapterID(mangaID: String): List<Chapter>? {
        val client = OkHttpClient()
        val request = Request.Builder()
            .url("https://api.mangadex.org/manga/$mangaID/feed")
            .build()

        client.newCall(request)
            .execute().use { response ->
                if(!response.isSuccessful) {
                    messageDialog.showMessageNotification("Can't fetch chapter ID. Please try again")
                    return null
                }

                val mapper = jacksonObjectMapper()
                val jsonData = response.body?.string() ?: return null

                val chapterData = mapper.readTree(jsonData)
                    .get("data")

                return mapper.treeToValue(chapterData, Array<Chapter>::class.java)?.toList()
            }
    }

    private fun fetchImageData(chapterID: String): ImageProperty? {
        val client = OkHttpClient()
        val request = Request.Builder()
            .url(chapterID)
            .build()

        client.newCall(request).execute().use { response ->
            if (!response.isSuccessful) {
                messageDialog.showMessageNotification("Can't fetch image data. Please try again")
                return null
            }

            val mapper = jacksonObjectMapper()
            val jsonData = response.body?.string() ?: return null

            return mapper.readValue(jsonData)
        }
    }

    private fun download(imageURL: String, saveDir: String, imageName: String) {
        val client = OkHttpClient()
        val request = Request.Builder()
            .url(imageURL)
            .build()
        val savePath = File("$saveDir/$imageName")

        client.newCall(request).execute()
            .use { response ->
                if(!response.isSuccessful) return
                FileOutputStream(savePath).use { output ->
                    response.body?.bytes()?.let { output.write(it) }
                }
            }
    }

    private fun getBaseName(urlTarget: String): String {
        return URI(urlTarget).path.substringAfterLast('/')
    }

    private fun downloadProcess(hashValue: String?, imgURL: String, saveDir: String) {
        val cleanImgNames = imgURL.replace("[", "").replace("]", "")

        cleanImgNames.split(", ").forEach { img ->
            val imageURL = "https://cmdxd98sb0x3yprd.mangadex.network/data/$hashValue/$img"
            val baseName = getBaseName(imageURL)

            download(
                imageURL,
                saveDir, baseName
            )
            SwingUtilities.invokeLater{ logArea.append("Download $baseName\n") }
        }
        SwingUtilities.invokeLater { logArea.append("Successfully all chapters as $saveDir\n") }
    }

    fun startDownloadProcess(mangaID: String, downloadDir: String) {
        object : SwingWorker<Unit, Unit>() {
            override fun doInBackground() {
                val mangaName = fetchMangaName(mangaID)
                val chapterIDs = fetchChapterID(mangaID)?.
                map { "https://api.mangadex.org/at-home/server/${it.id}" }

                val chapterNames = fetchChapterName(mangaID)
                    ?.map { it.attributes.title }

                val saveDir = File(downloadDir)
                mangaName?.let {
                    SwingUtilities.invokeLater {  logArea.append("Found manga: ${it.attributes.title["en"]}\n") }

                    saveDir.mkdirs()
                } ?: { messageDialog.showMessageNotification("Can't fetch MangaID $mangaID") }

                chapterNames?.forEachIndexed { index, chapterName ->
                    val chapterDir = File(saveDir, chapterName)
                    chapterDir.mkdirs()

                    val chapterID = chapterIDs?.get(index) ?: return@forEachIndexed
                    val imageData = fetchImageData(chapterID)
                    val imageURL = imageData?.chapter?.data

                    downloadProcess(
                        imageData?.chapter?.hash,
                        imageURL.toString(),
                        chapterDir.absolutePath
                    )
                }
            }
        }.execute()
    }

}