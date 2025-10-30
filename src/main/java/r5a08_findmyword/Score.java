package r5a08_findmyword;

public class Score {
    private String word;
    private Letter[] results;

    public Score(String word){
        this.word = word;
        this.results = new Letter[word.length()];
    }

    public void assess(String attempt) {
        for (int i = 0; i < word.length(); i++) {
            char attemptedChar = attempt.charAt(i);
            if (isCorrectLetter(i, attempt)) {
                results[i] = Letter.CORRECT;
            } else if (isPartCorrect(attemptedChar)) {
                results[i] = Letter.PART_CORRECT;
            } else {
                results[i] = Letter.INCORRECT;
            }
        }
    }

    private boolean isPartCorrect(char attemptChar0) {
        return word.contains(String.valueOf(attemptChar0));
    }

    private boolean isCorrectLetter(int index, String attempt) {
        return word.charAt(index) == attempt.charAt(index);
    }


    public Letter letter(int i) {
        return results[i];
    }
}