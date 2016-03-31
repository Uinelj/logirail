# Architecture du logiciel

_Ce document est destiné aux futurs développeurs ou mainteneurs du projet Logirail, afin qu'ils aient un aperçu de l'architecture du code. Pour de plus amples et précises informations, la documentation Java générée par l'outil Javadoc est disponible dans ce répertoire, sous le dossier `javadoc`._

Logirail est découpé en 4 packages :

* __data__ : Gère les données du logiciel.
* __engine__ : Fait tourner la simulation.
* __graphics__ : Modélise la simulation et l'interface.
* __test__ : Tests fonctionnels et d'intégration.

## Package `data`

Les données du logiciel sont chargées depuis des fichiers spécifiques au format `json`, dans des objets base de données.

Pour les codes mission par exemple, c'est l'objet `MissionCodeDatabase` qui est créé. Ces objets sont au nombre de 6 (Cantons, Incidents, Codes mission, Schedule, Station, Modèle de Train).

Ils sont simples, et pour la majorité se contentent d'analyser les fichiers et de stocker leur contenu dans une liste. Leur simplicité réduit la probabilité d'occurrence de bugs.

Tous les objets base de données suivent le design pattern `Singleton`, ce qui nous permet d'assurer une certaine sécurité au niveau de l'entrée/sortie.

Idéalement, toutes les classes lisant et écrivant de la donnée __doivent__ suivre ce design pattern.
Par souci de sécurité supplémentaire, ces classes ne sont pas _threadables_.

## Package `engine`

Le package `engine` est le siège de la simulation.
Il contient d'un côté la modélisation d'un Train roulant sur une ligne et suivant un code mission, d'un autre côté l'horloge, permettant à la simulation de se dérouler, et d'une tour de contrôle, qui permet de lancer les trains ou de les arrêter si un incident se présente sur la ligne.

Ce package contient donc le noyau algorithmique de la simulation, et est fortement _threadé_.

## Package `graphics`

La partie graphique se base tout d'abord sur une interface réalisée via `javaFX` et `JFoenix`, et va appeler les méthodes des classes `engine` afin de récupérer les informations nécessaires à l'affichage de l'interface.

Il est à noter que la ligne en elle-même est réalisée en format `SVG`, et qu'il y a donc dans la partie graphique une composante web.

## Package `test`

Ce package contient tous les tests du projet Logirail.
Les tests fonctionnels sont rassemblés sous le sous-package `white`, tandis que les tests d'intégration se rassemblent dans le sous-package `black`.
