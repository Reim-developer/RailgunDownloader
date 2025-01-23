/*
 * RAILGUN DOWNLOADER - VERSION 4.0.0
 * File: QualityBox.kt
 * This project is licensed GPL-3.0 License.
 * LICENSE: https://www.gnu.org/licenses/gpl-3.0.html
 * Contribution: Reim
 */

package railgunDownloaderV4.components.global

import java.awt.*
import javax.swing.*

class QualityBox {
    fun setQualityBox(
        appTarget: JFrame,
        qualityBox: JList<String>,
        location: Point,
        size: Dimension
    ) {
        val qualityList = arrayOf(
            "Best Quality",
            "Worst Quality",
            "Best Video",
            "Worst Video",
            "Best Audio",
            "Worst Audio"
        )

        qualityBox.setListData(qualityList)
        qualityBox.selectionMode = ListSelectionModel.SINGLE_SELECTION
        qualityBox.size = size
        qualityBox.location = location
        qualityBox.background = Color(21, 21, 21)
        qualityBox.foreground = Color.WHITE
        qualityBox.selectedIndex = 0
        qualityBox.font = Font("Consolas", Font.PLAIN, 10)
        qualityBox.toolTipText = "Choose your video quality"

        qualityBox.cellRenderer = object : DefaultListCellRenderer() {
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

        appTarget.add(qualityBox)
    }
}