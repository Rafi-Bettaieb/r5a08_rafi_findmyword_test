package r5a08_findmyword;

public class Score {
    private String word;
    private Letter[] results;


    public Score(){
    }

    public Score(String word){
        this.word = word;
        this.results = new Letter[word.length()];
    }

    public void assess(String attempt) {

        if (isCorrectLetter(0, attempt)) {
            results[0] = Letter.CORRECT;
        } else {
            results[0] = Letter.INCORRECT;
        }
        if (word.length() > 1) {
            if (isCorrectLetter(1, attempt)) {
                results[1] = Letter.CORRECT;
            } else {
                results[1] = Letter.INCORRECT;
            }
        }
    }

    private boolean isCorrectLetter(int index, String attempt) {
        return word.charAt(index) == attempt.charAt(index);
    }

    // Retourne le résultat à l'index demandé depuis le tableau
    public Letter letter(int i) {
        return results[i];
    }
}