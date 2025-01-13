/*
 * RAILGUN DOWNLOADER - VERSION 4.0.0
 * File: QualityList.kt
 * This project is licensed GPL-3.0 License.
 * LICENSE: https://www.gnu.org/licenses/gpl-3.0.html
 * Contribution: Reim
 */
package railgunDownloaderV4.components.youtubeUI

import java.awt.*
import javax.swing.*

class QualityList {
    fun setQuality(app: JFrame, qualityListBox: JList<String>) {
        val qualityItems = arrayOf(
            "best",
            "worst",
            "bestvideo",
            "worstvideo",
            "bestaudio",
            "worstaudio"
        )

        qualityListBox.setListData(qualityItems)
        qualityListBox.selectionMode = ListSelectionModel.SINGLE_SELECTION
        qualityListBox.size = Dimension(70, 180)
        qualityListBox.location = Point(330, 420)
        qualityListBox.background = Color(21, 21, 21)
        qualityListBox.foreground = Color.WHITE
        qualityListBox.selectedIndex = 0
        qualityListBox.font = Font("Consolas", Font.PLAIN, 10)

        qualityListBox.toolTipText = "Choose your video quality"

        qualityListBox.cellRenderer = object : DefaultListCellRenderer() {
            override fun getListCellRendererComponent(
                list: JList<*>?,
                value: Any,
                index: Int,
                isSelected: Boolean,
                cellHasFocus: Boolean
            ): Component {
                val qualityLabel = super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus) as JLabel

                qualityLabel.horizontalAlignment = CENTER
                return qualityLabel
            }
        }

        app.add(qualityListBox)
    }
}
