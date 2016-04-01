## Outils de gestion

_Ce document permet de se familiariser avec les logiciels et méthodes d'organisation et de collaboration de l'équipe Logirail. Il permet de comprendre à quelle fréquence et comment l'équipe se réunit et communique sur l'avancement, les releases, et les problèmes à régler._

## Réunions

Une réunion a été prévue et réalisée au moins une semaine sur deux, afin de connaître le point d'avancement de l'équipe sur le projet, les difficultés rencontrées, les améliorations proposées et suggestions, ainsi qu'une petite séance de brainstorming sur un aspect en particulier, par exemple, la façon de considérer et de différencier les gares et les cantons.
L'organisation des réunions et leurs thèmes peut être retrouvé dans le cahier des charges initial, disponible dans ce répertoire, sous le nom `doc_cdc.pdf`.

## Communication

Toute la communication de l'équipe passe par Slack. Slack est un outil assimilable aux salons IRC : Ce sont des salons de chat, qui permettent aux participants de discuter sur différents sujets. Le Slack Logirail dispose de différents salons, nommés `#architecture`, `#documentation`, `#git`, `#qualite`, `#direction`, qui nous permettent de diviser les discussions. Un historique nous permet de garder trace des discussions, ainsi que des fichiers partagés sur les salons (Premier jets de documents, snippets de code, etc.).

TODO: METTRE UNE IMAGE DU SLACK.    

## Collaboration

Le projet Logirail est synchronisé dans son entièreté via [Github](https://github.com/Uinelj/Logirail). La documentation, les documents annexes ainsi que les ressources graphiques sont également versionnées, au même titre que le code source.
La granularité des vérifications est au niveau des commits : Dès lors qu'un commit est poussé vers le site, les responsables qualité et documentation doivent revoir respectivement la qualité du code (algorithmes optimisés, tests fonctionnels et d'intégration), et la précision de la documentation (Javadoc et documents annexes). De plus, un serveur d'intégration continue [Travis](https://travis-ci.org/Uinelj/logirail) recompile le projet et lance les tests afin de vérifier qu'il n'y a pas eu de régression. Au stade actuel du projet, ce serveur n'est pas pleinement configuré.

 
