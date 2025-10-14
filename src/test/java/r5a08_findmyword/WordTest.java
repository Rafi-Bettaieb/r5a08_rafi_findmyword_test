package r5a08_findmyword;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class WordTest {
    @Test
    public void should_check_one_incorrect_letter(){
        Word word = new Word("E");
        Score score = word.guess("B");
        Assert_Letter_At_Index(score, 0, Letter.INCORRECT);
    }

    @Test
    public void should_check_one_correct_letter(){
        Word word = new Word("E");
        Score score = word.guess("E");
        Assert_Letter_At_Index(score, 0, Letter.CORRECT);
    }


    @Test
    public void should_check_two_letters_one_correct_one_incorrect(){
        // Arrange
        Word word = new Word("AZ");

        // Act
        Score score = word.guess("AY");

        // Assert
        Assert_Letter_At_Index(score, 0, Letter.CORRECT);   // 'A' vs 'A' -> CORRECT
        Assert_Letter_At_Index(score, 1, Letter.INCORRECT); // 'Z' vs 'Y' -> INCORRECT
    }

    private void Assert_Letter_At_Index(Score score , int index, Letter expected) {
        Letter actual = score.letter(index);
        assertEquals(expected, actual);
    }
}