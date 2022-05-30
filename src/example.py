import requests

ipurl = "http://ip-api.com/json/"
ipresp = requests.get(url=ipurl)
ipdata = ipresp.json()

owm = "9d0b009eb6f5a98d4ca58bf0c96f0744"
owmurl = "https://api.openweathermap.org/data/2.5/weather?lat="+ str(ipdata["lat"]) + "&lon=" + str(ipdata["lon"]) + "&appid=" + str(owm)
owmresp = requests.get(url=owmurl)
owmdata = owmresp.json()

print(owmdata["main"]["temp"])