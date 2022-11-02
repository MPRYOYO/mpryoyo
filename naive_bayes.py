import pandas as pd
import numpy as np

df = pd.read_csv("naive_bayes.csv")
print(df.head())


tcount = df[df.Play == "Yes"].Play.count()
fcount = df[df.Play == "No"].Play.count()


def getProb(value, columnName):
    df1 = df[df[columnName] == value]
    yesCount = df1[df1.Play == "Yes"].Play.count()
    noCount = df1[df1.Play == "No"].Play.count()
    return (yesCount/tcount, noCount/fcount)


c1 = input("Please enter Outlook : ")
# Rainy
c2 = input("Please enter Temperature : ")
# Cool
c3 = input("Please enter Humidity : ")
# High
c4 = int(input("Enter '0' if it's not windy and '1' if's windy : "))
# 0

ans1y, ans1n = getProb(c1, "Outlook")
ans2y, ans2n = getProb(c2, "Temperature")
ans3y, ans3n = getProb(c3, "Humidity")
ans4y, ans4n = getProb(c4, "Windy")


Yes = ans1y*ans2y*ans3y*ans4y*(tcount/tcount+fcount)
No = ans1n*ans2n*ans3n*ans4n*(fcount/tcount+fcount)
print(Yes, No)
if(Yes > No):
    print("Plays Golf")
else:
    print("No Golf")
