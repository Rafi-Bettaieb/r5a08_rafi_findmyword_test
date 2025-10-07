package r5a08_findmyword;

public class Score {
    private String word;
    private Letter result;

    public Score(){
    }

    public Score(String word){
        this.word = word;
    }

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
}