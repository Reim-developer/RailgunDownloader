/*
 * RAILGUN DOWNLOADER - VERSION 4.0.0
 * MatchURL.kt
 */

package railgunDownloaderV4.components.ulti

class MatchURL {
    fun matchURL(url: String): Boolean{
        val urlRegex: Regex = """^(https?://)?([a-zA-Z0-9-]+\.)+[a-zA-Z]{2,}(/\S*)?$""".toRegex()

        return urlRegex.matches(url.trim().lowercase())
    }
}