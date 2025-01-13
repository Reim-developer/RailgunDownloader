/*
 * RAILGUN DOWNLOADER - VERSION 4.0.0
 * File: MatchURL.kt
 * This project is licensed GPL-3.0 License.
 * LICENSE: https://www.gnu.org/licenses/gpl-3.0.html
 * Contribution: Reim
 */

package railgunDownloaderV4.components.ulti

class MatchURL {
    fun matchURL(url: String): Boolean{
        val urlRegex: Regex = """^(https?://)?([a-zA-Z0-9-]+\.)+[a-zA-Z]{2,}(/\S*)?$""".toRegex()

        return urlRegex.matches(url.trim().lowercase())
    }
}