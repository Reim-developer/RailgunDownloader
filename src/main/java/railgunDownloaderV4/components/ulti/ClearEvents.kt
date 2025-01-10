/*
 * RAILGUN DOWNLOADER - VERSION 4.0.0
 * ClearEvents.kt
 */
package railgunDownloaderV4.components.ulti

import javax.swing.JButton

class ClearEvents {
    fun clearActionListeners(buttonTarget: JButton) {
        buttonTarget.actionListeners.forEach(buttonTarget::removeActionListener)
    }
}