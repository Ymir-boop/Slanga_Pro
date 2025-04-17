
# Slönguspil Pro

## Um forritið

Forritið er snakes and ladders leikur.  
Í því getur notandinn valið fjölda leikmanna og stillt stærð borðsins og útlit þess.  

Fyrst opnast upphafsgluggi með mynd.  
Ef haldi er áfram opnast leikurinn með sjálfgefnum stillingum völdum.  
Hægt er að byrja að spila með því að kasta teningnum eða velja 'Nýr leikur' undir menu.  

Einnig er hægt að velja stillingar í menu.  
Þá opnast gluggi þar sem hægt er að fjölga leikmönnum og breyta stærð borðs og þema þess.  



## Maven leiðbeiningar

Gerið clone á forritið með linknum: https://github.com/Ymir-boop/Slanga_Pro.git  
Byggið svo og keyrið forritið með skipuninni:
``` mvn javafx:run ```(hægt að ýta á það hér)  


## Leik leiðbeiningar
Keyrðu forritið með því að fylgja leiðbeiningunum hér að ofan.  
Ýttu á spila á upphafsskjá og opnaðu leikinn.  
Leikurinn er spilaður með því að ýta á teninginn eða opna 'Leikur' undir menu og velja 'Nýr leikur'.  
Stillingar eru opnaðar með því að velja 'Stillingar' undir 'Leikur'.  

Skemmtu þér!

## Núverandi ástand
Leikurinn er tilbúinn til spilana.   
Enn leynast einhverjar villur en þær ættu ekki að hamla upplifun notandans.  
Fundarlaun eru í boði fyrir þá sem uppgötva ófundnar villur.  
Tilkynna má villur í síma 555 5555.

## Verkefni til notendaprófana

 - Opnaðu leikinn og byrjaðu að spila. Kláraðu leikinn. (Það er bara einn leikmaður sjálfgefið)  
 - Farðu í stillingar og breyttu stillingunum. Veldu þrjá leikmenn.  
 - Breyttu stillingunum enn frekar. Veldu létta borðið og líka þema. Spilaðu svo leikinn aftur.  
 - Farðu nú í stillingar á ný og veldu erfiða borðið. Prófaðu það.  
 - Prófaðu að velja nýjan leik á meðan leikurinn er enn í gangi.  

## Eignarréttur
Eignarétt forritsins má finna undir [LICENSE](LICENSE)

# Hugbúnaðarhönnun

## Maven leiðbeiningar
Maven samþykkir þessar skipanir:  
- ``` mvn compile ```  
- ``` mvn test ```  
- ``` mvn javafx:run ```  
- ``` mvn package ```  
- ``` mvn site ```  

notum ``` mvn javafx:run ``` í stað ``` mvn exec:java ``` því þetta er javafx forrit svo seinni skipunin virkar ekki.

### Bygging

Forritið er byggt með því að keyra skipunina ``` mvn compile ```

### Keyrsla

Forritið er keyrt með skipuninni ``` mvn javafx:run ```

### Prófanir

Skoða má hvort forritið standist prófanir með skipuninni ``` mvn test ```

### Skjölun

Skoða má skjölun forritsins með skipuninni ``` mvn site ``` en þá verður til [skjal](target/site/index.html) sem hægt er að opna í vafra.

### Pökkun

Til þess að bygga forritið og pakka því er keyrt skipunina ``` mvn package ```

Einnig er hægt að pakka forritinu með skriptunni [.\build.cmd](build.cmd) í endastöð (terminal)

og keyra með skriptunni [.\run.cmd](run.cmd) ef þú ert ekki með forritunarumhverfi með Maven innbygðu.

### Hönnun

Við fylgjum [facade](https://en.wikipedia.org/wiki/Facade_pattern) hönnunarmynstrinu í [Game](src/main/java/vinnsla/Game.java) klasanum.  
Game einfaldar og umlykur (encapsulates) undirkerfið [Player](src/main/java/vinnsla/Player.java), [Dice](src/main/java/vinnsla/Dice.java) og [SnakesNLadders](src/main/java/vinnsla/SnakesNLadders.java).

Einnig notum við [observer](https://en.wikipedia.org/wiki/Observer_pattern) hönnun í viðmótsklösum forritsins sem fylgjast þannig með vinnsluklösum þess.

Finna má meira um hönnun forritsins [hér](src/site/markdown/documentation.md).