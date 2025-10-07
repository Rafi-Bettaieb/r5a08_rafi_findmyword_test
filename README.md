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

Question 5 :
en applicant le principe de KISS la méthode lettre dans la classe Score va retourner Letter.INCORRECT;
et la fonction guess dans la classe Word va retourner un nouveau Score : new Score();

--> maintenant dans le cas ou les lettres sont incorrectes le teste passe avec succés(Green)


Question 6 :


Question 7 :
La prochaine fonctionnalité logique serait de tester le cas où la lettre est correcte.

Question 8 :
création de la fonction de test should_check_one_correct_letter() -> le test fail
@Test
public void should_check_one_correct_letter(){
    // Arrange
    Word word = new Word("E");
    
    // Act
    Score score = word.guess("E");
    
    // Assert
    Letter Expected = Letter.CORRECT;
    Letter Actual = score.letter(0);
    assertEquals(Expected, Actual);
}

Question 9 :
Le test échoue parce que la méthode letter() de la classe Score retourne toujours Letter.INCORRECT de manière codée en dur. Quand on devine correctement ("E" vs "E"), on attend Letter.CORRECT mais on reçoit Letter.INCORRECT
il faut donc modifier la méthode guess() et la méthode lettre()


après modification :


    public void assess(int index, String attempt) {
        if (word.charAt(index) == attempt.charAt(index)) {
            result = Letter.CORRECT;
        } else {
            result = Letter.INCORRECT;
        }
    }

    public Letter letter(int i) {
        return result;
    }
    
    public Score guess(String attempt) {
        Score score = new Score(word);

        /* Calcule le score pour la lettre d'indice 0
           de la tentative
         */
        score.assess(0, attempt);

        return score;
    }
maintenant le test passe au vert
    
