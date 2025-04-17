# Hönnun

---
## UML

Hér að neðan má sjá UML klasa skýringarmynd fyrir forritið:

![UML](uml.png)

## Hönnunarmynstur

### Facade mynstur

[Facade](https://sourcemaking.com/design_patterns/facade) eða framhlið er mynstur þar sem einn klasi býr til samræmda ásýnd yfir nokkra aðra og þá sérstaklega flókna klasa.  
Tilgangurinn er að búa til einfalda hlið á flóknu undirkerfi.  

Við notum þetta mynstur í Game klasanum okkar eins og sjá má á UML skýringarmyndinni hér að ofan.  
Klasinn virðist kannski ekki vera einfaldur við fyrstu sýn en hann er í grunninn bara með eina aðferð sem notandinn sér.  
Allt annað eru hjálparaðferðir sem vinna með undirklösu, og viðmótsklösum.

Þetta mynstur gerir vinnsluhluta forritsins mun einfaldari.

### Observer mynstur

[Observer](https://sourcemaking.com/design_patterns/observer) mynstur eða áhorfanda mynstur er mynstur þar sem einn klasi fylgist með öðrum í þeim tilgangi að uppfærast í samræmi við hann.  
Þetta er afar hentugt í viðmótsklösum forrits sem fylgist með vinnsluklösum þess.  

Við notum þetta mynstur í viðmótsklösum forritsins hér til þess að uppfæra stöðu leikmanna á borðinu til dæmis.  
Við notum þetta einnig til að sýna með mynd hvað kemur upp á teningnum eftir að honum er kastað.  