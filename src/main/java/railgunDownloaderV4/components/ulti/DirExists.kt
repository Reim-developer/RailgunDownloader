/*
 * RAILGUN DOWNLOADER - VERSION 4.0.0
 * DirExists.kt
 */
package railgunDownloaderV4.components.ulti

import java.io.File

class DirExists {
    fun checkDirExists(dirPath: String): Boolean {
        val saveDir = File(dirPath)

        return saveDir.exists() && saveDir.isDirectory
    }
}