package railgunDownloaderV4.components.ulti

class MatchNumber {
    fun  matchNumber(number: String): Boolean {
        val numberRegex = Regex("^[0-9]+$")
        return numberRegex.matches(number)
    }
}