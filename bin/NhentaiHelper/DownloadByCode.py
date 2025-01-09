# RAILGUN DOWNLOADER - VERSION 4.0.0
# This project is licensed under GPL 3.0.
# Please read the LICENSE file before cloning or modifying the source code.
# License details:
# https://github.com/Reim-developer/RailgunDownloader?tab=GPL-3.0-1-ov-file
import requests
import os
import argparse
from pathlib import Path
from bs4 import BeautifulSoup
from concurrent.futures import ThreadPoolExecutor

header: dict[str, str] = {
    'User-Agent': 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/91.0.4472.124 Safari/537.36'
}

parser: argparse.ArgumentParser = argparse.ArgumentParser()

def download(saveDir: str, doujinshiCode: str) -> None:
    print(f"[INFO] Download doujinshi code: {doujinshiCode}", flush = True)

    webURL: str = f"https://nhentai.net/g/{doujinshiCode}"
    try:
        response = requests.get(
            webURL,
            timeout = 30,
            headers = header
        )
        response.raise_for_status()
    except requests.exceptions.Timeout:
        print(
            f"[ERROR] Unable download from {webURL}\nThe connection time out. Please check your internet connection and try again.",
            flush = True
        )
    except requests.exceptions.ConnectionError:
        print(
            f"[ERROR] Unable download from {webURL}.\nNo internet connection.\nPlease check your internet connection and try again.",
            flush = True
        )
    except Exception as e:
        print(e)

    if response.status_code == 403:
        print(
            f"[ERROR] This website {webURL} is block your IP.\n[HINT] Use VPN and try again.",
            flush = True
        )
        return

    soup = BeautifulSoup(response.text, "html.parser")

    saveDirName = soup.find("h3", id = "gallery_id")
    if not saveDirName:
        print(
            f"[ERROR] Unable download doujinshi from {webURL}.\nCheck your doujinshi URL and try again.",
            flush = True
        )
        return

    saveDirPath = str(saveDirName.text).replace("#", "")
    absoluteSavePath = os.path.abspath(
        os.path.join(saveDir, saveDirPath)
    )
    
    if os.path.isdir(absoluteSavePath):
        print(
            f"[WARNING] Your doujinshi {saveDirPath} has already been downloaded.\nNo need to download again.",
            flush = True
        )
        return

    print(
        f"[OK] Create save directory with name {saveDirPath}",
        flush = True
    )
    dirPath = Path(absoluteSavePath)
    dirPath.mkdir()

    print(
        f"[OK] Sucessfully created save directory {saveDirPath}",
        flush = True
    )

    print(
        "[INFO] Finding images",
        flush = True
    )
    div_image = soup.find("div", class_ = "thumbs")
    images = div_image.find_all("img", class_ = "lazyload")

    print(
        "[INFO] Preparing download",
        flush = True
    )

    for image in images:
        image_url = image.get("data-src")
        imageBaseName = os.path.basename(image_url)
        savePath = os.path.join(absoluteSavePath, imageBaseName)

        requestDownload = requests.get(
            image_url,
            headers = header,
            timeout = 30
        )
        print(
            f"[INFO] Download {imageBaseName}",
            flush = True
        )

        with open(savePath, "wb") as imgFile:
            imgFile.write(requestDownload.content)
    
    print(
        f"[OK] Download doujinshi {saveDirName.text} successfully.\nSave as {absoluteSavePath}",
        flush = True
    )

parser.add_argument(
    "--d",
    type = str,
    required = True
)
parser.add_argument(
    "--c",
    type = str,
    required = True
)
argument_value = parser.parse_args()

with ThreadPoolExecutor(max_workers = 50) as executor:
    executor.submit(download, argument_value.d, argument_value.c)