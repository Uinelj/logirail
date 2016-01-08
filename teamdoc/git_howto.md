Comment utiliser git ?
======================

git, c'est un peu comme SVN, avec quelques nuances et une syntaxe différente.

## Nuances

* Sur SVN, quand on commit, on va balancer notre commit sur le dépôt. Avec git, on commit en __local__, et après ça on balance notre commit sur le dépôt. Ca permet par exemple de travailler un bout de temps hors-ligne, puis de push tout ses commits après.
* [Différences plus "profondes" ...](https://git-scm.com/book/fr/v1/D%C3%A9marrage-rapide-Rudiments-de-Git)

## Comment ça marche ?

Imaginons un scénario : On a un dépôt ( aussi appelé repo ) git sur Github, qui contient du code C qui affiche "Hello, world!". On veut récupérer ce code, le modifier pour qu'il affiche "Hello, Bilel!", puis propager cette modification sur le dépôt distant.

_NB: La première fois que vous utilisez git, il va vous demander de setup votre nom et mail. Faites-le, sans ça Github vous refusera les modifications sur le dépôt distant._

1. __Récupérer le contenu__

La commande git pour récupérer un repo distant est `git clone`. Par exemple, pour notre dépôt d'exemple, nommé `hello` sur le compte Github `gims`, ça nous donne :

```
  git clone https://github.com/gims/hello.git
```
 On devrait se retrouver avec un dossier `hello` dans le répertoire d'où on a executé le `clone`.

 2. __Modifier le contenu__

 Pour modifier le contenu faites comme si git n'était pas là.

 3. __Ajouter les fichiers modifiés au prochain commit__

 Une fois la modification faite, il faut ajouter les fichiers à commit. On peut en ajouter qu'un seul, par exemple `git add main.c`, soit tout ceux du dossier, avec `git add .`.

 4. __Faire un commit__

 Pour faire un commit, on peut utiliser la commande courte `git commit -m "Changement du printf pour qu'il affiche Bilel"`, soit utiliser `git commit`, qui va nous ouvrir un éditeur de texte où vous pourrez expliquer ce que vous avez envie.

 5. __Envoyer son travail__

 Pour envoyer son travail, il faut faire `git push origin master`.

 6. __Rester à jour sur sa version locale du projet__

 Avec le temps, si vous voulez mettre à jour vos fichiers, un coup de `git pull origin master` le fera pour vous.

 Pour voir des features plus avancées, allez sur le site de [git](https://git-scm.com/).

 __BONUS :__ Petite [infographie](http://byte.kde.org/~zrusin/git/git-cheat-sheet-medium.png) sympa.
