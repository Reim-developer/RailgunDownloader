/*
 * RAILGUN DOWNLOADER - VERSION 4.0.0
 * File: DownloadProcess.kt
 * This project is licensed GPL-3.0 License.
 * LICENSE: https://www.gnu.org/licenses/gpl-3.0.html
 * Contribution: Reim
 */

package railgunDownloaderV4.components.global.events

import java.io.BufferedReader
import java.io.InputStreamReader
import javax.swing.JTextArea
import javax.swing.SwingUtilities
import kotlin.io.path.Path
import kotlin.io.path.absolutePathString

class DownloadVideoProcess {
    fun setDownloadVideoProcess(videoURL: String, saveDir: String, logArea: JTextArea) {
        val absolutePath = Path("bin/Helper.lib").absolutePathString()
        val processBuilder = ProcessBuilder(
            absolutePath,
            "-o",
            "$saveDir/%(title)s.%(ext)s", videoURL
        )
        val process = processBuilder.start()
        val reader = BufferedReader(InputStreamReader(process.inputStream))
        var content: String?

        val showResultJob = Thread {
            while (reader.readLine().also { content = it } != null) {
                SwingUtilities.invokeLater { logArea.append("$content\n") }
            }
        }
        showResultJob.start()
    }
}