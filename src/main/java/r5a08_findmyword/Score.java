package r5a08_findmyword;

public class Score {
    private String word;
    public Score(String word){
        this.word = word;
    }
    public Letter letter(int i) {
        return Letter.INCORRECT;
    }
}
