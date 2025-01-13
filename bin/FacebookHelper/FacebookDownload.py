#  *
#  * RAILGUN DOWNLOADER - VERSION 4.0.0
#  * File: FacebookDownload.py
#  * This project is licensed under GPL-3.0 License.
#  * LICENSE: https://www.gnu.org/licenses/gpl-3.0.html
#  * Contribution: Reim
#  *

import yt_dlp
import argparse

parser: argparse.ArgumentParser = argparse.ArgumentParser()

def download(saveDir: str, facebookVideoUrl: str, videoQuality: str) -> None:
    video_options: dict = {
        "outtmpl": f"{saveDir}/%(title)s.%(ext)s",
        "format": videoQuality
    }

    with yt_dlp.YoutubeDL(video_options) as downloader:
        downloader.download(facebookVideoUrl)

parser.add_argument(
    "--d",
    type = str,
    required = True
)
parser.add_argument(
    "--u",
    type = str,
    required = True
)
parser.add_argument(
    "--q",
    type = str,
    required = True
)

argumentValue = parser.parse_args()

download(argumentValue.d, argumentValue.u, argumentValue.q)