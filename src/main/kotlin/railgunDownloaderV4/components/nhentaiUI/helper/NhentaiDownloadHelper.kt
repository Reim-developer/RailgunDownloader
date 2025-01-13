/*
 * RAILGUN DOWNLOADER - VERSION 4.0.0
 * File: NhentaiDownloadHelper.kt
 * This project is licensed GPL-3.0 License.
 * LICENSE: https://www.gnu.org/licenses/gpl-3.0.html
 * Contribution: Reim
 */
package railgunDownloaderV4.components.nhentaiUI.helper

import java.io.BufferedReader
import java.io.InputStreamReader
import javax.swing.JTextArea
import javax.swing.SwingUtilities
import kotlin.io.path.Path
import kotlin.io.path.absolutePathString

class NhentaiDownloadHelper {
    fun startDownload(relativePath: String, downloadOptions: String, logArea: JTextArea, saveDir: String, doujinshiURL: String) {
        val getPath = Path(relativePath)
        val absolutePath = getPath.absolutePathString()

        val processBuilder = ProcessBuilder(
            absolutePath,
            "--d", saveDir,
            downloadOptions, doujinshiURL
        )

        val printJobThread = Thread {
            val process: Process = processBuilder.start()
            val bufferStdout = BufferedReader(InputStreamReader(process.inputStream))

            var lineContent: String?
            while (bufferStdout.readLine().also { lineContent = it } != null) {
                SwingUtilities.invokeLater { logArea.append("$lineContent\n") }
            }
        }
        printJobThread.start()
    }
}