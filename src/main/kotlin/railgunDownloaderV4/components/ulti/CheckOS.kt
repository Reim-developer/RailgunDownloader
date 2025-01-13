/*
 * RAILGUN DOWNLOADER - VERSION 4.0.0
 * File: CheckOS.kt
 * This project is licensed GPL-3.0 License.
 * LICENSE: https://www.gnu.org/licenses/gpl-3.0.html
 * Contribution: Reim
 */
package railgunDownloaderV4.components.ulti

import java.util.*

class CheckOS {
    fun sysType(): String {
        val osProperty = System.getProperty("os.name").lowercase(Locale.getDefault())

        if (osProperty.contains("win")) {
            return "Windows"
        } else if (osProperty.contains("nix") || osProperty.contains("nux") || osProperty.contains("aix")) {
            return "Linux"
        }

        return "UnknownOS"
    }
}
