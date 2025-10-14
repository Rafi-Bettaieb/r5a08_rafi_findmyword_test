package r5a08_findmyword;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class WordTest {
    @Test
    public void should_check_one_incorrect_letter(){

        // Arrange
        Word word = new Word("E");

        // Act
        Score score = word.guess("B");

        // Assert
        Assertion(score,0);
    }

    private void Assertion(Score score , int index) {
        Letter Expected = Letter.INCORRECT ;
        Letter Actual = score.letter(index);

        assertEquals(Expected, Actual);
    }

    @Test
    public void should_check_one_correct_letter(){
        Word word = new Word("E");

        // Act
        Score score = word.guess("E");

        // Assert
        Letter Expected = Letter.CORRECT ;
        Letter Actual = score.letter(0);

        assertEquals(Expected, Actual);
    }

}
