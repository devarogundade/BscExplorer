# BscExplorer

Android Client Library to all Binance Smart Chain Api functions.

# Requirement
- Hilt (Dependency Injection)
- ApiKey (BscScan api key) visit https://bscscan.com/ to crate your api key

# Guide
![Screenshot 2022-09-02 195618](https://user-images.githubusercontent.com/81397790/188219635-a4bb59d1-ba85-4046-803d-c2c233bac6a5.png)
<br />
![Screenshot 2022-09-02 200110](https://user-images.githubusercontent.com/81397790/188220296-32d3cd6d-bb09-4d9a-9a7f-074f744d23d6.png)

# Coverter
<code>
  val weiToBnb = Converter.convert(value = 100000, from = Converter.Unit.Wei, to = Converter.Unit.BNB)
</code>
<br />
<br />
<b>Units <code>Wei, Kwei, Mwei, Gwei, Szabo, Finney, BNB</code></b>

# Docs
visit https://docs.bscscan.com to learn more about their api
