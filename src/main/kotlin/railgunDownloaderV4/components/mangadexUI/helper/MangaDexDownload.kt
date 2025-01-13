/*
 * RAILGUN DOWNLOADER - VERSION 4.0.0
 * File: MangaDexDownload.kt
 * This project is licensed GPL-3.0 License.
 * LICENSE: https://www.gnu.org/licenses/gpl-3.0.html
 * Contribution: Reim
 */
package railgunDownloaderV4.components.mangadexUI.helper

import java.io.BufferedReader
import java.io.InputStreamReader
import javax.swing.JTextArea
import javax.swing.SwingUtilities
import kotlin.io.path.Path
import kotlin.io.path.absolutePathString

class MangaDexDownload {
    fun start(
        relativeLib: String,
        relativeSaveDir: String,
        mangaDexID: String,
        logArea: JTextArea
    ) {
        val absolutePath = Path(relativeLib).absolutePathString()

        val processBuilder = ProcessBuilder(
            absolutePath,
            "--d", relativeSaveDir,
            "--m", mangaDexID
        )

        val process = processBuilder.start()
        val downloadJob = Thread {
            val stdout = BufferedReader(InputStreamReader(process.inputStream))
            var readlineContent: String?

            while (stdout.readLine().also { readlineContent = it } != null) {
                SwingUtilities.invokeLater { logArea.append("$readlineContent\n") }
            }
        }
        downloadJob.start()
    }
}