package r5a08_findmyword;

public class Word {
    private String word;
    public Word(){
    }
    public Word(String e) {
        this.word = e;
    }

    public Score guess(String attempt) {
        Score score = new Score(word);

        /* Calcule le score pour la lettre d'indice 0
           de la tentative
         */

        score.assess(attempt);

        return score;
    }
}
