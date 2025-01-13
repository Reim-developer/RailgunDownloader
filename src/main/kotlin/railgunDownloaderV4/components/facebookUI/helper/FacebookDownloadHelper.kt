/*
 * RAILGUN DOWNLOADER - VERSION 4.0.0
 * File: FacebookDownloadHelper.kt
 * This project is licensed GPL-3.0 License.
 * LICENSE: https://www.gnu.org/licenses/gpl-3.0.html
 * Contribution: Reim
 */
package railgunDownloaderV4.components.facebookUI.helper

import java.io.BufferedReader
import java.io.InputStreamReader
import javax.swing.JTextArea
import javax.swing.SwingUtilities
import kotlin.io.path.Path
import kotlin.io.path.absolutePathString

class FacebookDownloadHelper {
    fun start(
        relativePath: String,
        saveDir: String,
        facebookVideoUrl: String,
        videoQuality: String,
        logArea: JTextArea
    ) {
        val absolutePath = Path(relativePath).absolutePathString()

        val processBuilder = ProcessBuilder(
            absolutePath,
            "--d", saveDir,
            "--u", facebookVideoUrl,
            "--q", videoQuality
        )

        val process = processBuilder.start()

        val printResultJob = Thread {
            val stdout = BufferedReader(InputStreamReader(process.inputStream))
            var resultContent: String?

            while (stdout.readLine().also { resultContent = it } != null) {
                SwingUtilities.invokeLater { logArea.append("$resultContent\n") }
            }
        }
        printResultJob.start()
    }
}