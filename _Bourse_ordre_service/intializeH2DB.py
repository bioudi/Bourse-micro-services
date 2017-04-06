import pprint
from pymongo import MongoClient
import requests
from bs4 import BeautifulSoup
import re
import urllib
import urllib2

r = requests.get("https://www.wafabourse.com/marches/actions/r")
soup = BeautifulSoup(r.content,'html.parser')
data = soup.find_all("td",{"class": "longNameQS"})
c=0
for d in data:
    link = "https://www.wafabourse.com/"+str(d.a.get("href"))
    r1 = requests.get(link)
    soup_societe_titles = BeautifulSoup(r1.content,'html.parser')
    data_societe_titles = soup_societe_titles.find_all("div",{"class": "titre"})
    data_societe_codes = soup_societe_titles.find_all("div",{"class": "markettitleisin"})
    data_nbre_actions = soup_societe_titles.find_all("td",{"class": "bidNbOrders"})
    data_qte_actions = soup_societe_titles.find_all("td",{"class": "bidVolume"})
    data_prix_action = soup_societe_titles.find_all("td",{"class": "bidPrice"})
    data_date_ordre = soup_societe_titles.findAll("td",{"class": "lastPriceDateTime"})
    date_ordre = (data_date_ordre[1].text).encode('utf-8').strip()
    date_ordre = str(date_ordre).replace('/','%2F')
    date_ordre = str(date_ordre).replace(' ','%20')
    date_ordre = str(date_ordre).replace(':','%3A')
    cc=0
    code_societe = (data_societe_codes[0].text).encode('utf-8').strip()
    nom_societe = (data_societe_titles[0].h1.text).encode('utf-8').strip()
    for d in data_nbre_actions:
        nbre = (d.text).encode('utf-8').strip()
        if(nbre != "-"):
            qte = (data_qte_actions[cc].text).encode('utf-8').strip()
            price = (data_prix_action[cc].text).encode('Windows-1252').strip()
            price = urllib.quote(price)
            price = str(price).replace('%A0','%20')
            price = str(price).replace('%2C','%2E')
            requests.get("http://localhost:8882/save?prix_action="+price+"&qte="+qte+"&date_ordre="+date_ordre+"&nbre_actions="+nbre+"&code_societe="+code_societe+"&type_ordre=Achat&nom_societe="+nom_societe)
            print "Row Inserted"
        cc+=1
    data_nbre_actions_V = soup_societe_titles.find_all("td",{"class": "askNbOrders"})
    data_qte_actions_V = soup_societe_titles.find_all("td",{"class": "askVolume"})
    data_prix_action_V = soup_societe_titles.find_all("td",{"class": "askPrice"})
    cc = 0
    for d in data_nbre_actions_V:
        nbre_V = (d.text).encode('utf-8').strip()
        if(nbre_V != "-"):
            qte_V = (data_qte_actions_V[cc].text).encode('utf-8').strip()
            price_V = (data_prix_action_V[cc].text).encode('Windows-1252').strip()
            price_V = urllib.quote(price_V)
            price_V = str(price_V).replace('%A0','%20')
            price_V = str(price_V).replace('%2C','%2E')
            requests.get("http://localhost:8882/save?prix_action="+price_V+"&qte="+qte_V+"&date_ordre="+date_ordre+"&nbre_actions="+nbre_V+"&code_societe="+code_societe+"&type_ordre=Vente&nom_societe="+nom_societe)
            print "Row Inserted"
        cc+=1
