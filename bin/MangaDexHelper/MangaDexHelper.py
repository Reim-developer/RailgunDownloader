# RAILGUN DOWNLOADER - VERSION 4.0.0
# MangaDexHelper.py
# This project is licensed under the GPL-3.0
import requests
import os
import argparse

parser = argparse.ArgumentParser()

def download(saveDir: str, mangaID: str) -> None:
    mangaFeedURL = f"https://api.mangadex.org/manga/{mangaID}"

    try:
        response = requests.get(mangaFeedURL)
        response.raise_for_status()
    except requests.exceptions.RequestException:
        print(f"Error fetching manga info: {mangaFeedURL}", flush = True)
        return
    
    mangaInfo = response.json()
    mangaTitle = mangaInfo["data"]["attributes"]["title"].get("en", "Manga")
    
    print(f"Search manga: {mangaTitle}", flush = True)
    
    if os.path.exists(os.path.join(saveDir, mangaTitle)):
        print(f"Manga {mangaTitle} already exists in your PC", flush = True)
        return
    
    print(f"Create save directory {mangaTitle}", flush = True)
    os.mkdir(os.path.join(saveDir, mangaTitle))
    
    absolutePath = os.path.join(saveDir, mangaTitle)
    feedUrl = f"https://api.mangadex.org/manga/{mangaID}/feed"
    
    try:
        feedResponse = requests.get(feedUrl)
        feedResponse.raise_for_status()
    except requests.exceptions.RequestException:
        print(f"Error fetching manga feed: {feedUrl}", flush = True)
        return
    
    chapters = feedResponse.json()["data"]
    
    for chapter in chapters:
        chapterID = chapter["id"]
        chapterTitle = chapter["attributes"]["title"] or "No Title"
        print(f"Found chapter: {chapterTitle}", flush = True)
        
        chapterFolder = os.path.join(absolutePath, chapterTitle)
        
        print(f"Create save chapter image folder {chapterTitle}", flush = True)
        os.makedirs(chapterFolder, exist_ok = True)
        
        chapterURL = f"https://api.mangadex.org/at-home/server/{chapterID}"
        
        try:
            chapterResponse = requests.get(chapterURL)
            chapterResponse.raise_for_status()
        except requests.exceptions.RequestException:
            print(f"Error fetching chapter {chapterURL}", flush = True)
            continue
        
        chapterData = chapterResponse.json()
        baseURL = chapterData["baseUrl"]
        hashValue = chapterData["chapter"]["hash"]
        data = chapterData["chapter"]["data"]
        
        for webPage in data:
            imageURL = f"{baseURL}/data/{hashValue}/{webPage}"
            print(f"Download image from {imageURL}", flush = True)
            
            try:
                imageResponse = requests.get(imageURL)
                imageResponse.raise_for_status()
            except requests.exceptions.RequestException:
                print(f"Error when downloading image {imageURL}", flush = True)
                continue
            
            imageSaveDir = os.path.join(chapterFolder, webPage)
            
            with open(imageSaveDir, "wb") as imgFile:
                imgFile.write(imageResponse.content)
                print(f"Downloaded image {webPage} in chapter {chapterTitle}", flush = True)
                
    print(f"Download all chapters successfully at:\n{absolutePath}", flush = True)

parser.add_argument(
    "--d",
    type = str,
    required = True
)
parser.add_argument(
    "--m",
    type = str,
    required = True
)

argument = parser.parse_args()
download(argument.d, argument.m)