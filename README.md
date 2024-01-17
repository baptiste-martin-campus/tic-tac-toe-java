# Projet Jeux de plateaux :<br> Tic - Tac - Toe

## Modalités :
- Toute cette partie est à réaliser en solo
- La durée estimée de cette partie est de 2 jours environ

## Objectifs pédagogiques :
- Familiarisation avec la programmation orientée objet (POO) en Java
- Mise en place de l’architecture logicielle de base du Tic Tac Toe

## Objectifs pratiques :
- Conception d’un jeu de Tic Tac Toe en utilisant Java.

## Démarche pédagogique :
- Ce sujet sera assez finement guidé sur les premières étapes, puis de moins en
moins au fur et à mesure de l’avancement du projet pour vous aider à vous
autonomiser. N’hésitez pas à demander de l’aide aux formateurs, et à aller explorer
des ressources externes.

## Règles du Tic Tac Toe :
- Le jeu tic tac toe (aussi connu sous le nom de morpion) est un jeu pour deux joueurs
qui se joue sur une grille de 3x3. Les joueurs doivent alterner en plaçant leur
symbole (soit un rond ou une croix) dans les cases vides de la grille. Le but du jeu
est d'aligner trois de ses symboles horizontalement, verticalement ou en diagonale
avant que l'autre joueur ne le fasse. Si la grille est remplie sans qu'aucun joueur n'ait
réussi à aligner trois symboles, la partie se termine sur un match nul.

### Iteration 1 – Afficher le plateau de jeu

**Deux ressources [très] utiles avant de commencer :**

- POO en Java avec OpenClassrooms :
    - [Définition d’objets](https://openclassrooms.com/en/courses/6173501-apprenez-a-programmer-en-java/6458101-definissez-les-objets-et-leurs-attributs-avec-des-classes)
    - [Héritage et Polymorphisme](https://openclassrooms.com/en/courses/6173501-apprenez-a-programmer-en-java/6458196-specialisez-vos-classes-avec-l-heritage-et-le-polymorphisme)
    - [Collections d’objets](https://openclassrooms.com/en/courses/6173501-apprenez-a-programmer-en-java/6458461-gerez-les-piles-de-donnees-avec-la-bonne-collection)

**Objectif de l’itération :**

- Structurer correctement son code et afficher le plateau de jeu

**Cahier des charges :**

- Créer une classe **Cell** qui contient :
    - Une méthode **getRepresentation** qui retourne le String suivant : “| ” _(ndlr : barre verticale suivie de 3 espaces)_
    - Ce String nous permettra de représenter une cellule du TicTacToe dans la console.

- Créer une classe **TicTacToe** qui contient :
  - Un attribut constant **size** qui définit la taille du plateau de jeu.
  - Un tableau à une dimension d’objets de type **Cell** _(ndlr : ou deux  dimensions, au choix)_
  - Une méthode **display** qui affiche le plateau de jeu en console.
  
- L’affichage en console de votre jeu pourra ressembler à ceci :



        ----------
        |  |  |  |
        ----------
        |  |  |  |
        ----------
        |  |  |  |
        ----------

    Exemple de rendu (simple)
    que vous pouvez obtenir

- **[ CONTRAINTE ]** Votre classe **Main** ne contiendra que le code suivant :

- **[ Indice ]** La méthode **display** devra parcourir le tableau de cellules et
demander à chacune de lui fournir sa représentation pour construire la
représentation du TicTacToe dans son ensemble.

**Remarque :**

Le sujet vous guide vers la création de ce jeu mais n’hésitez pas à ajouter
des méthodes si besoin.