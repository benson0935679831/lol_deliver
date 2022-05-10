import sys  #系統用的lib
import requests #HTTP GET元件

from requests.exceptions import HTTPError       #連線錯誤的lib

def searchAndInsert(name, mail, pwd):
    phpurl='http://localhost:8080/delivery/registerCheck.php?userIdentity=customer&userName=%s&userMail=%s&userPassword=%s'
    senddata= phpurl % (name, mail, pwd)
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
    searchAndInsert("Tom","Tom3810@mail.com","123465")

if __name__ == "__main__":
    main()