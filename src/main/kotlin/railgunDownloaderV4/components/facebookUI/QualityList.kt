/*
 * RAILGUN DOWNLOADER - VERSION 4.0.0
 * File: QualityList.kt
 * This project is licensed GPL-3.0 License.
 * LICENSE: https://www.gnu.org/licenses/gpl-3.0.html
 * Contribution: Reim
 */
package railgunDownloaderV4.components.facebookUI

import java.awt.*
import javax.swing.DefaultListCellRenderer
import javax.swing.JFrame
import javax.swing.JLabel
import javax.swing.JList
import javax.swing.ListSelectionModel
import javax.swing.SwingConstants

class QualityList {
    fun setQualityList(app: JFrame, qualityListBox: JList<String>) {
        val listQuality: Array<String> = arrayOf(
            "best",
            "worst",
            "bestvideo",
            "worstvideo",
            "bestaudio",
            "worstaudio"
        )

        qualityListBox.apply {
            setListData(listQuality)
            size = Dimension(70, 108)
            selectionMode = ListSelectionModel.SINGLE_SELECTION
            selectedIndex = 1
            location = Point(320, 440)
            background = Color(69, 69, 69)
            foreground = Color.WHITE
            font = Font("Consolas", Font.PLAIN, 11)
            toolTipText = "Choose quality of video"
        }

        qualityListBox.cellRenderer = object : DefaultListCellRenderer() {
            override fun getListCellRendererComponent(
                list: JList<*>?,
                value: Any?,
                index: Int,
                isSelected: Boolean,
                cellHasFocus: Boolean
            ): Component {
                val component = super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus)

                component.takeIf { it is JLabel }?.apply {
                    horizontalAlignment = SwingConstants.CENTER
                }
                return component
            }
        }
        app.add(qualityListBox)
    }
}