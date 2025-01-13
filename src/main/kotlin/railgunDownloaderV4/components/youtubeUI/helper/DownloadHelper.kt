/*
 * RAILGUN DOWNLOADER - VERSION 4.0.0
 * File: DownloadHelper.kt
 * This project is licensed GPL-3.0 License.
 * LICENSE: https://www.gnu.org/licenses/gpl-3.0.html
 * Contribution: Reim
 */
package railgunDownloaderV4.components.youtubeUI.helper

import java.io.BufferedReader
import java.io.File
import java.io.InputStreamReader
import javax.swing.JTextArea
import javax.swing.SwingUtilities

class DownloadHelper {
    fun startDownload(logResult: JTextArea, videoURL: String?, videoQuality: String?, saveDir: String?) {
        val relativePath = "bin/YoutubeHelper/Youtube.lib"

        val youtubeDownloadFile = File(relativePath)
        val absolutePath = youtubeDownloadFile.absolutePath

        val processBuild = ProcessBuilder(
            absolutePath,
            "--u", videoURL,
            "--q", videoQuality,
            "--p", saveDir
        )

        val logThread = Thread {
                val helperProcess = processBuild.start()
                val stdout = BufferedReader(
                    InputStreamReader(helperProcess.inputStream)
                )

                val logBuilder = StringBuilder()
                var resultContent: String?

                while ((stdout.readLine().also { resultContent = it }) != null) {
                    logBuilder.append(resultContent).append("\n")
                    SwingUtilities.invokeLater { logResult.text = logBuilder.toString() + "\n" }
                }
            }
        logThread.start()
    }
}
