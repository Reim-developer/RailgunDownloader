/*
 * RAILGUN DOWNLOADER - VERSION 4.0.0
 * ProcessCancel.kt
 */

package railgunDownloaderV4.components.ulti

class ProcessCancel {
    private var checkOS: CheckOS = CheckOS()

    private fun killProcess(vararg command: String) {
        ProcessBuilder(*command).start()
    }

    fun taskKill(taskName: String) {
        val osProperty = checkOS.SysType()

        when(osProperty) {
            "Windows" -> println("windows")
            "Linux" -> killProcess("pkill", "-n", taskName)
            else -> println("Unknown os")
        }
    }

}