import sys  #系統用的lib
import requests #HTTP GET元件
import json     #解譯json元件
import time     ##時間用的lib
import datetime #時間用的lib
from datetime import datetime       #轉unix time to date time 用的lib
import math     #數學用的lib
import os      #作業系統元件
import http.client  #網頁連線物件lib
import unicodedata  #解unicode用的lib
from pathlib import Path   #解路徑用的lib

from requests.exceptions import HTTPError       #連線錯誤的lib

def searchAndInsert(dt, stockno):
    id = '123@mail.com'
    pwd = '123456'
    phpurl='http://localhost:8080/delivery/loginCheck.php?userID=%s&userPWD=%s'
    senddata= phpurl % (id,pwd)
    print(senddata)
    try:
        res = requests.get(senddata)
        res.raise_for_status()
    except HTTPError as http_err:
        print(f'HTTP error occurred: {http_err}')
        sys.exit(0)
    except Exception as err:
        print('Other error occurred: {}'.format(err))
        sys.exit(0)
    else:
        print(res.text)    

def main():
    searchAndInsert("20210131","1101")

if __name__ == "__main__":
    main()