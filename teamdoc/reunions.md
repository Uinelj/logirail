<center>Conception IHM+Moteur</center>
===================================
<center>_Conception séparée de l'interface graphique et descrption du fonctionnement du moteur._</center>


## Moteur
1.  Notre simulation se déroule sur la ligne du RER A. Celle-ci est un ensemble de cantons et de gares rassemblés dans un graphe. Les gares sont considérées comme des cantons. Lors du démarrage du logiciel, la simulation génère le graphe à partir d’un fichier ( format xml, Json, etc ).
2.  Lorsque la simulation démarre, une horloge, est lancé pour une durée donnée. Il permettra de gérer les horaires, vitesses et déplacements des trains.
3. On instancie régulièrement de nouveaux trains  :
  * Chacun est caractérisé par un code mission ( ex : NORA, TOLA, etc ), choisi aléatoirement parmi ceux disponibles et par son modèle.
  * Tous les codes missions et les modèles sont aussi stockés dans un fichier
  * Le code mission indique le trajet potentiel du train. Tous les trains ont un trajet dynamique qui contient la liste de toutes les gares restantes par lesquelles il doit passer. Nous générons donc le trajet qui s’adapte en fonction des incidents potentiels sur la ligne.
4.  Le train est positionné sur la gare de départ de son trajet et peut démarrer :
5.  Le  train incrémente sa position avec une certaine vitesse. Son trajet dépend aussi de la taille du canton. La position est actualisée toutes les X secondes.
  La règle principale et l’utilité des cantons est qu’un seul train peut être présent dans un canton donné.

  On vérifie donc avant chaque canton :
    *   Si le canton contient un train : on s’arrête
    *   Sinon on continue

  S’il ne reste plus qu’un seul canton avant la prochaine gare, on vérifie à nouveau :
    *   S’ il y a un train dans la gare on s’arrête
    *   Sinon on continue

  Ainsi il ne peut y avoir un train arrêté dans une gare et un autre juste avant
    Si deux cantons plus loin il y a un embranchement :
    *   On vérifie le canton de l’autre branche juste avant l’embranchement. S’il y a un train, on attend, sinon on avance.
    Si le canton actuel est le terminus, on retire le train de la simulation

6.  Génération aléatoire d’incidents aléatoire : (toutes les x secondes)
  *  Si les trains sont dans un trajet impacté par l’incident, pn re-calcule leur trajet.
7.  L’horloge influe sur la vitesse de la simulation.
## IHM
L'IHM se veut être conviviale et intuitive, et un grand nombre d'informations doivent être accessibles au coin de l'oeil. L'interface se veut claire et sans fioritures, afin de maximiser la lisibilité des informations.
![mockupMac.jpg](http://uinelj.eu/misc/Logirail/mockupMAC.jpg)
![mockupMac.jpg](http://uinelj.eu/misc/Logirail/mockup2MAC.jpg)
![mockupMac.jpg](http://uinelj.eu/misc/Logirail/mockup.jpg)
![mockupMac.jpg](http://uinelj.eu/misc/Logirail/mockup2.jpg)
