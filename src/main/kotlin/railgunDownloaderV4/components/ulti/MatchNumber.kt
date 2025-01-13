/*
 * RAILGUN DOWNLOADER - VERSION 4.0.0
 * File: MatchNumber.kt
 * This project is licensed GPL-3.0 License.
 * LICENSE: https://www.gnu.org/licenses/gpl-3.0.html
 * Contribution: Reim
 */
package railgunDownloaderV4.components.ulti

class MatchNumber {
    fun  matchNumber(number: String): Boolean {
        val numberRegex = Regex("^[0-9]+$")
        return numberRegex.matches(number)
    }
}