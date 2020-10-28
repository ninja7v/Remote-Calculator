# Calculator

Calculator coded by Luc PREVOST and 1 class mates !

Du côté du Service nous avons 5 fichiers :
- L’interface : Calcul.java
Elle contient la signature de la fonction calcul.
- Le contenu de la fonction calcul elle même : CalculImpl.java
On gère les expeptions avec le mot clef throw.
- Les Erreurs : DivisionParZero.java, NombreNegatif.java, ResultatNegatif.java
On utilise super() qui permet d’appeler le contructeur parent.

Du côté du Serveur nous avons 1 fichier :
- L’interface : Calcul.java
On cree un skeleton avec UnicastRemoteObject.exportObject(new CalculImpl(),0) puis un registre.
On ecrit un message d’information chez le serveur.
On lie (bind) ou on on lie en écrasant (rebind) si "Calculator" existe dans le
serveur des noms.

Du côté du Client nous avons 1 fichier :
- InterfaceGraphique.java :
Ce fichier est composé de 2 classes : InterfaceGraphique() et MyActionListener.
La première consiste à afficher la calculatrice et à détecter les événements à
déclencher.
On créer la zone au premier niveau avec BorderLayout().
on rempli ensuite la zone de le texte (au nord) avec JTextField et de panneau
(au centre) avec GridLayout.
Ce panneau est lui-même rempli de boutons avec JButton.
On récupère les actions de l’utilisateur (ici les clics de la souris) avec addAction-
Listener. La deuxième permet gerer les actions commandées par l’utilisateur.
Pour effacer le dernier caractère on utilise input.substring.
Pour ajouter un caractère on utilise input += " " + actionCommand + " ".
Les 2 espaces servant à séparer.
On comunique ensuite avec le RMI

Pour exécuter on complile les fichiers .java dans le Service, le Serveur et le Client.
On copie les .class du Service dans le Servieur et dans le Client.
On exécute le Serveur puis le Client.
