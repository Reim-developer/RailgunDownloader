/*
 * RAILGUN DOWNLOADER - VERSION 4.0.0
 * MessageDialog.kt
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