/*
 * RAILGUN DOWNLOADER - VERSION 4.0.0
 * File: ProcessCancel.kt
 * This project is licensed GPL-3.0 License.
 * LICENSE: https://www.gnu.org/licenses/gpl-3.0.html
 * Contribution: Reim
 */
package railgunDownloaderV4.components.ulti

class ProcessCancel {
    private var checkOS: CheckOS = CheckOS()

    private fun killProcess(vararg command: String) {
        ProcessBuilder(*command).start()
    }

    fun taskKill(taskName: String) {
        val osProperty = checkOS.sysType()

        when(osProperty) {
            "Windows" -> println("windows")
            "Linux" -> killProcess("pkill", "-n", taskName)
            else -> println("Unknown os")
        }
    }

}