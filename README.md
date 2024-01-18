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

### Iteration 2 – Création d’un Player et capture de cellules

**Objectif de l’itération :**

- Ajouter des objets de type Player qui peuvent capturer les cellules et en devenir “propriétaires”.
- Ajouter la logique qui permet de demander au joueur le coup qu’il désire jouer.

**Cahier des charges :**

- Créer une classe **Player** qui contient :
  - Un attribut **representation** qui prendra les valeurs (String) : **“| X ”** ou **“| O ”**
  - Une méthode **getRepresentation** l’attribut qui retourne l’attribut **representation**

- Ajouter un attribut Player dans la classe TicTacToe
- Ajouter une méthode **getMoveFromPlayer** dans la classe TicTacToe
  - Cette méthode retourne deux coordonnées :
    - Numéro de ligne et colonne.
  - La méthode vérifiera que les coordonnées fournies par le **Player** sont autorisées :
    - Le format des données doit être le bon.
    - Les coordonnées doivent correspondre à un emplacement sur le plateau de jeu
    - Les coordonnées doivent correspondre à un emplacement qui n’est pas déjà occupé par un “pion”.
  - Si le choix de l’utilisateur n’est pas autorisé, il doit re-rentrer des coordonnées jusqu’à ce qu’il en fournisse des correctes.
- Ajouter une méthode **setOwner** dans la classe TicTacToe qui prend en paramètre les deux coordonnées d’une cellule (ligne & colonne) ainsi qu’un Player. Cette méthode change la **représentation** de la **Cell** pour y mettre celle du joueur [ ndlr : c’est une approche possible, il en existe d’autres ]
  - **[ Exemple ]** Si le joueur souhaite capturer la case “ 1 1 ” alors le plateau devra s’afficher comme suit :
  
                        ----------
                        |  |  |  |
                        ----------
                        |  | 0|  |
                        ----------
                        |  |  |  |
                        ----------
              
                  Exemple de rendu après
                  capture de la case 1 1

### Iteration 3 – TicTacToe Multijoueur

**Objectif de l’itération :**

- Ajouter un second joueur dans le jeu.
- Faire jouer les joueurs jusqu’à remplissage du plateau de jeu.

**Cahier des charges :**

- Vous rajouterez un second joueur dans le jeu (il aura sa propre représentation)
- Créer une méthode **play** dans la classe TicTacToe qui gérera la logique générale du jeu.
  - Lorsque un joueur a joué, c’est le second joueur qui posera une pièce.
  - Le jeu s’arrête lorsque les 9 cases sont remplies (c’est une condition
  d’arrêt du jeu simplifiée pour commencer) 
- **[ CONTRAINTE ]** Votre classe **Main** ne contiendra que le code suivant :

        public class Main {
          public static void main(String[] args) {
            TicTacToe ticTacToe = new TicTacToe();
            ticTacToe.play();
          }
        }

### Iteration 4 – Conditions d’arrêt du jeu

**Objectif de l’itération :**

- Demander aux joueurs de jouer tant que 3 pions ne sont pas alignés ou que le plateau est rempli.

**Cahier des charges :**

- Ajouter une méthode **isOver** dans la classe TicTacToe qui retourne un
booléen valant **True** lorsque 3 pions sont alignés ou que le plateau est rempli.

### Iteration 5 – Ajout d’un joueur artificiel

**Objectif de l’itération :**

- Créer un joueur artificiel qui joue des coups aléatoires.

**Cahier des charges :**

- Créer une nouvelle classe ArtificialPlayer qui joue des coups aléatoires.
- Réfléchissez à comment structurer votre code : quelle relation entre un player, player humain et player artificiel ?
- Donner la possibilité d’instancier le TicTacToe avec :
  - 2 joueurs humains
  - 1 humain et un joueur artificiel
  - 2 joueurs artificiels.

**Ressources :**
- https://www.tutorialspoint.com/java/java_abstraction.htm
- https://docs.oracle.com/javase/8/docs/api/java/util/Random.html

### Iteration 6 – Interaction Utilisateur et Affichage

**Objectif de l’itération :**

- Gérer les intéractions utilisateurs et l’affichage en console via des classes spécialisées.

**Cahier des charges :**

- Créer une classe InteractionUtilisateur qui sera en charge d'interagir avec l’utilisateur (récupération du choix de pièce à jouer, quitter le jeu, etc... )
- Créer une classe View qui sera chargée d’afficher en console

**[ DEUX CONTRAINTES ]**
1. A la fin de cette itération, le seul endroit où vous trouverez un attribut de type Scanner sera dans la classe InteractionUtilisateur.
2. A la fin de cette itération, le seul endroit où vous trouverez un appel à la méthode System.out.println() sera dans la classe View

**Remarque :**

Nous avons maintenant à ce stade un jeu de Tic Tac Toe minimaliste mais
fonctionnel. La prochaine partie sera centrée sur la manière de mieux
architecturer ce programme pour pouvoir le rendre plus modulaire,
adaptable et réutilisable.