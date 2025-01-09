/*
 * RAILGUN DOWNLOADER - VERSION 4.0.0
 * FindByCode.kt
 */
package railgunDownloaderV4.components.nhentaiUI

import railgunDownloaderV4.components.ulti.DirExists
import railgunDownloaderV4.components.ulti.MatchNumber
import java.awt.Image
import java.awt.Toolkit
import javax.swing.ImageIcon
import javax.swing.JButton
import javax.swing.JFrame
import javax.swing.JOptionPane
import javax.swing.JTextField

class FindByCode (
    private val urlInput: JTextField,
    private val pathInput: JTextField
){
    private val matchNumber: MatchNumber by lazy { MatchNumber() }
    private val dirExists: DirExists by lazy { DirExists() }

    fun setFindByCode(app: JFrame, findByCodeButton: JButton) {

        findByCodeButton.setSize(50, 50)
        findByCodeButton.setLocation(235, 450)
        findByCodeButton.isContentAreaFilled = false
        findByCodeButton.border = null
        findByCodeButton.isBorderPainted = false
        findByCodeButton.isFocusPainted = false

        val buttonIcon = Toolkit.getDefaultToolkit()
            .getImage(this::class.java.getResource("/Search.png"))

        findByCodeButton.icon = ImageIcon(
            buttonIcon.getScaledInstance(50, 50, Image.SCALE_FAST)
        )
        findByCodeButton.toolTipText = "Download doujinshi by code"

        downloadProcess(findByCodeButton)
        app.add(findByCodeButton)
    }

    private fun downloadProcess(findByCodeButton: JButton) {
        findByCodeButton.addActionListener {
            val urlField = urlInput.text
            val pathField = pathInput.text

            if(!matchNumber.matchNumber(urlField)) {
                JOptionPane.showMessageDialog(
                    null,
                    "Please input valid code",
                    "Notification",
                    JOptionPane.INFORMATION_MESSAGE
                )
                return@addActionListener
            }

            if(!dirExists.checkDirExists(pathField)) {
                JOptionPane.showMessageDialog(
                    null,
                    "Please choose your path or make sure this directory path is exists",
                    "Notification",
                    JOptionPane.INFORMATION_MESSAGE
                )
                return@addActionListener
            }
        }
    }
}