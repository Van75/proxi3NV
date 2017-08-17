	************************************
*****  	Livrables:			   	*****
	************************************	

Diagrammes UML : Proxi3NV.png , Proxi3NVmetier.png
Application Proxibanque livrables: sur Github le projet Proxybanquev3, diagrammes UML, la documentation Javadoc, les maquettes balasamik, l'archive war : Proxybanquev3.war



	************************************
*****  	Description de l'application:   	*****
	************************************

ProxiBanqueSI est une application visant à faciliter les différentes missions des conseillers.
Elle permet à un conseiller :

- de lire les informations concernant un client enregistré (nom, prenom, ville) ;
- créer client
- éditer un client
- voir la liste de tous les clients

Concernant la visualisation de la liste des comptes, cette fonction n'a pas pu être terminée.

L'application est structurée en 4 packages :
- view
- model
- dao
- service


Le package view contient les différents controllers, qui permettent de faire le lien entre la vue et le service.

Le package model contient les classes métier, notamment le Client, le Conseiller et les différents Comptes, appelées au sein
des autres packages pour la mise en oeuvre des fonctionnalités de l'application.

Le package dao contient la classe Dao, où sont appelées les méthodes du CRUD (insérer, lire, modifier, supprimer) sur la base de données. 
L'interface IDao sert à réguler l'interaction entre la classe Dao et le
package service.

Le package service contient la classe ServiceClient, qui comporte des méthodes permettant
le fonctionnement de l'application, et l'interface IServiceClient, qui régule l'interaction
du package service avec les packages dao et view.




	
	************************************
***** 	Execution de l'application:    		*****
	************************************

Veuillez suivre les indications suivantes:

1) Sur Github: Allez sur la commande de git et faites un "git clone git@github.com: van75/proxi3NV.git	************************************
*****  	Livrables:			   	*****
	************************************	

Diagrammes UML : Diagramme_de_classes.png
Application Proxibanque : l'application : Le dossier éclipse de l'application : Proxybanquev2, la documentation Javadoc, l'archive war : Proxybanquev2.war
Base de données : Proxibanquev2.sql


	************************************
*****  	Description de l'application:   	*****
	************************************

ProxiBanqueSI est une application visant à faciliter les différentes missions des conseillers.
Elle permet à un conseiller :

- de lire les informations concernant un client enregistré (coordonnées) ;
- créer client
- éditer un client
- voir la liste de tous les clients

Concernant la visualisation de la liste des comptes, cette fonction ne marche pas, elle n'a pas pu être terminée.

L'application est structurée en 4 packages :
- view
- model
- dao
- service


Le package view contient les différents controllers faisant le lient entre vue et service.

Le package model contient les classes métier, notamment le Client, le Conseiller et les différents Comptes, appelées au sein
des autres packages pour la mise en oeuvre des fonctionnalités de l'application.

Le package dao contient la classe Dao, où sont appelées les méthodes du CRUD (insérer, lire, modifier, supprimer) sur la base de données. 
L'interface IDao sert à réguler l'interaction entre la classe Dao et le
package service.

Le package service contient la classe ServiceClient, qui comporte des méthodes permettant
le fonctionnement de l'application, et l'interface IServiceClient, qui régule l'interaction
du package service avec les packages dao et view.



	
	************************************
***** 	Execution de l'application:    		*****
	************************************

Veuillez suivre les indications suivantes:




1) Dans la commande de git tapper: git clone git@github.com:Van75/proxy3NV.git


2) Pour lancer l'application, récupérez le ficher Proxybanquev3NV.war et placez le dans le dossier bin/webapps de votre conteneur web Apache Tomcat

2) Lancez une invite de commande (cmd.exe) et placez vous dans le répertoire bin de votre conteneur web Apache Tomcat

3) Démarrez Tomcat en utilisant la commande : startup.bat

4) Ouvrez votre navigateur web et rentrez l'adresse : http://localhost:8080/Proxybanquev3NV/

5) Pour se connecter il faut entrer en login 'toto', et en mot de passe'toto'.

2) Pour lancer l'application, récupérez le ficher Proxybanquev2.war et placez le dans le dossier bin/webapps de votre conteneur web Apache Tomcat

2) Lancez une invite de commande (cmd.exe) et placez vous dans le répertoire bin de votre conteneur web Apache Tomcat

3) Démarrez Tomcat en utilisant la commande : startup.bat

4) Ouvrez votre navigateur web et rentrez l'adresse : http://localhost:8080/Proxybanquev3NV/

5) Pour se connecter il faut entrer en login 'toto', et en mot de passe'toto'.