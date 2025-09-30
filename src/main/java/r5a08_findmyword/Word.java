package r5a08_findmyword;

public class Word {
    private String word;
    public Word(String e) {
        this.word = e;
    }

    public Score guess(String guess) {
        return new Score();
    }
}
