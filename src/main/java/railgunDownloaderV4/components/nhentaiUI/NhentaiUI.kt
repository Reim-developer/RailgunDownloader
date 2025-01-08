package railgunDownloaderV4.components.nhentaiUI

import railgunDownloaderV4.Application
import java.awt.event.WindowAdapter
import java.awt.event.WindowEvent
import javax.swing.JFrame
import javax.swing.WindowConstants

class NhentaiUI (private val appScene: Application){

    fun showNhentaiUI(visible: Boolean = false) {
        val nhentaiUI = JFrame()
        nhentaiUI.title = "Download from Nhentai.net"
        nhentaiUI.setSize(600, 600)
        nhentaiUI.defaultCloseOperation = WindowConstants.DISPOSE_ON_CLOSE
        nhentaiUI.setLocationRelativeTo(null)
        nhentaiUI.isVisible = visible

        closingWindow(nhentaiUI = nhentaiUI)
    }

    private fun closingWindow(nhentaiUI: JFrame) {
        nhentaiUI.addWindowListener(object: WindowAdapter() {
            override fun windowClosing(e: WindowEvent?) {
                appScene.App.isVisible = true
            }
        })
    }
}