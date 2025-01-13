/*
 * RAILGUN DOWNLOADER - VERSION 4.0.0
 * File: MessageDialog.kt
 * This project is licensed GPL-3.0 License.
 * LICENSE: https://www.gnu.org/licenses/gpl-3.0.html
 * Contribution: Reim
 */
package railgunDownloaderV4.components.ulti

import javax.swing.JOptionPane

class MessageDialog {
    fun showMessageNotification(message: String) {
        JOptionPane.showMessageDialog(
            null,
            message,
            "Notification",
            JOptionPane.INFORMATION_MESSAGE
        )
    }
}