# r5a8_junit_tests

## Dépôt pour les séances de tavail pratique pour la ressource R5A08 qualité de développement


Preparation du projet :
 -cloner le dépôt git en utilisant SSH
 -creation de nouvelle branche : git checkout -b r5a08_Rafi_findmyword_step_1
 
Question 1 :
Création de la classe WordTest

Question 2 :
écriture de la méthode should_check_one_incorrect_letter()
  // Arrange
  Word word = new Word("E"); // Le mot a déviner fait une lettre
  création de la classe Word avec son constructeur paramétré
Note : la classe Word doit être dans le dossier src/main/java/r5a08_findmyword

Question 3 :

// Act
  word.guess("B"); // tentative du joueur
  test fail -> création de la méthode guess() dans la classe word

Question 4 :
On commence par écrire le test
  // Assert
  Letter Expected = Letter.INCORRECT ;
  Letter Actual = score.letter(0);
  assertEquals(Expected, Actual);

le test ne se compile pas car la classe Score et le enum Lettre n'existent pas

en applicant le principe de KISS la méthode lettre dans la classe Score va retourner Letter.INCORRECT;
et la fonction guess dans la classe Word va retourner un nouveau Score : new Score();

--> maintenant dans le cas ou les lettres sont incorrectes le teste passe avec succés(Green)
