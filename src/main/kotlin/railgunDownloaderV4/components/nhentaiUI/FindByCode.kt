/*
 * RAILGUN DOWNLOADER - VERSION 4.0.0
 * File: FindByCode.kt
 * This project is licensed GPL-3.0 License.
 * LICENSE: https://www.gnu.org/licenses/gpl-3.0.html
 * Contribution: Reim
 */
package railgunDownloaderV4.components.nhentaiUI

import railgunDownloaderV4.components.nhentaiUI.helper.NhentaiDownloadHelper
import railgunDownloaderV4.components.ulti.*
import javax.swing.JButton
import javax.swing.JFrame
import javax.swing.JTextArea
import javax.swing.JTextField

class FindByCode (
    private val urlInput: JTextField,
    private val pathInput: JTextField,
    private val logArea: JTextArea
){
    private val matchNumber: MatchNumber by lazy { MatchNumber() }
    private val dirExists: DirExists by lazy { DirExists() }
    private val messageDialog: MessageDialog by lazy { MessageDialog() }
    private val setIconButton: SetIconButton by lazy { SetIconButton() }
    private val nhentaiDownloadHelper: NhentaiDownloadHelper by lazy { NhentaiDownloadHelper(urlInput, pathInput, logArea) }
    private val clearEvents: ClearEvents by lazy { ClearEvents() }

    fun setFindByCode(app: JFrame, findByCodeButton: JButton) {
        findByCodeButton.setSize(50, 50)
        findByCodeButton.setLocation(235, 450)
        findByCodeButton.isContentAreaFilled = false
        findByCodeButton.border = null
        findByCodeButton.isBorderPainted = false
        findByCodeButton.isFocusPainted = false

        setIconButton.setIcon(
            findByCodeButton,
            "/Search.png",
            50,
            50
        )
        findByCodeButton.toolTipText = "Download doujinshi by code"

        downloadProcess(findByCodeButton)
        app.add(findByCodeButton)
    }

    private fun downloadProcess(findByCodeButton: JButton) {

        clearEvents.clearActionListeners(findByCodeButton)

        findByCodeButton.addActionListener {
            val doujinshiCode = urlInput.text
            val pathField = pathInput.text

            if(!matchNumber.matchNumber(doujinshiCode)) {
                messageDialog.showMessageNotification(
                    "Please input valid code"
                )
                return@addActionListener
            }

            if(!dirExists.checkDirExists(pathField)) {
                messageDialog.showMessageNotification(
                    "Please choose your path or make sure this directory path is exists"
                )
                return@addActionListener
            }

            nhentaiDownloadHelper.executeDownload("BY_CODE")
        }
    }
}