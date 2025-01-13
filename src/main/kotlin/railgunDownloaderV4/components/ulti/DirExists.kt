/*
 * RAILGUN DOWNLOADER - VERSION 4.0.0
 * File: DirExists.kt
 * This project is licensed GPL-3.0 License.
 * LICENSE: https://www.gnu.org/licenses/gpl-3.0.html
 * Contribution: Reim
 */
package railgunDownloaderV4.components.ulti

import java.io.File

class DirExists {
    fun checkDirExists(dirPath: String): Boolean {
        val saveDir = File(dirPath)

        return saveDir.exists() && saveDir.isDirectory
    }
}