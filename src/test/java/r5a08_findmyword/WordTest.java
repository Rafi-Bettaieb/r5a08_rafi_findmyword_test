package r5a08_findmyword;

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
        Letter Expected = Letter.INCORRECT ;
        Letter Actual = score.letter(0);

        assertEquals(Actual,Expected);
    }

}
