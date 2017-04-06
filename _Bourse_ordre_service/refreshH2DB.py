import pprint
from pymongo import MongoClient
import requests
from bs4 import BeautifulSoup
import re
import urllib
import urllib2

class Ordre(object):
    def __init__(self,qte=None, date_ordre=None, nbre=None, price=None, type_ordre=None, code_societe=None):
        self.qte = qte
        self.date_ordre = date_ordre
        self.nbre = nbre
        self.price = price
        self.type_ordre = type_ordre
        self.code_societe = code_societe

OrdresAchat = []
OrdresVente = []

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
    for d in data_nbre_actions:
        nbre = (d.text).encode('utf-8').strip()
        if(nbre != "-"):
            qte = (data_qte_actions[cc].text).encode('utf-8').strip()
            price = (data_prix_action[cc].text).encode('Windows-1252').strip()
            price = urllib.quote(price)
            price = str(price).replace('%A0','%20')
            price = str(price).replace('%2C','%2E')
            OrdresAchat.append(Ordre(qte,date_ordre,nbre,price,"Achat",code_societe))
            print "Scraping ..."
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
            OrdresVente.append(Ordre(qte_V,date_ordre,nbre_V,price_V,"Vente",code_societe))
            print "Scraping ..."
        cc+=1

requests.get("http://localhost:8882/deleteAll")

for oa in OrdresAchat:
    requests.get("http://localhost:8882/save?prix_action="+oa.price+"&qte="+oa.qte+"&date_ordre="+oa.date_ordre+"&nbre_actions="+oa.nbre+"&code_societe="+oa.code_societe+"&type_ordre=Achat")
    print "Row Inserted"

for oa in OrdresVente:
    requests.get("http://localhost:8882/save?prix_action="+oa.price+"&qte="+oa.qte+"&date_ordre="+oa.date_ordre+"&nbre_actions="+oa.nbre+"&code_societe="+oa.code_societe+"&type_ordre=Vente")
    print "Row Inserted"
