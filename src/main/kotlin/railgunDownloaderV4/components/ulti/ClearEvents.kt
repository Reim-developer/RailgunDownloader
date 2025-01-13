/*
 * RAILGUN DOWNLOADER - VERSION 4.0.0
 * File: ClearEvents.kt
 * This project is licensed GPL-3.0 License.
 * LICENSE: https://www.gnu.org/licenses/gpl-3.0.html
 * Contribution: Reim
 */
package railgunDownloaderV4.components.ulti

import javax.swing.JButton

class ClearEvents {
    fun clearActionListeners(buttonTarget: JButton) {
        buttonTarget.actionListeners.forEach(buttonTarget::removeActionListener)
    }
}