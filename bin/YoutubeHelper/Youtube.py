# RAILGUN DOWNLOADER - VERSION 4.0.0
# Youtube.py
import yt_dlp
import argparse

parser = argparse.ArgumentParser()
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
parser.add_argument(
    "--p",
    type = str,
    required = True
)   

def download(url: str, quality: str, save_path: str) -> None:
    video_options: dict[str, str] = {
        "format": quality,
        "outtmpl": f"{save_path}/%(title)s.%(ext)s"
    }
    with yt_dlp.YoutubeDL(video_options) as video:
        video.download(url)


argument = parser.parse_args()

download(argument.u, argument.q, argument.p)