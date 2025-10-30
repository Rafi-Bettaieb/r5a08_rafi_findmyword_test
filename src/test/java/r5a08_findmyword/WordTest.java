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
    public void should_check_two_letters_one_correct_one_correct(){
        // Arrange
        Word word = new Word("AB");

        // Act
        Score score = word.guess("AB");

        // Assert
        Assert_Letter_At_Index(score, 0, Letter.CORRECT);
        Assert_Letter_At_Index(score, 1, Letter.CORRECT);
    }
    @Test
    public void should_check_two_letters_one_correct_one_incorrect(){
        // Arrange
        Word word = new Word("AZ");

        // Act
        Score score = word.guess("AY");

        // Assert
        Assert_Letter_At_Index(score, 0, Letter.CORRECT);
        Assert_Letter_At_Index(score, 1, Letter.INCORRECT);
    }

    @Test
    public void should_check_two_letters_one_incorrect_one_correct(){
        // Arrange
        Word word = new Word("CB");

        // Act
        Score score = word.guess("AB");

        // Assert
        Assert_Letter_At_Index(score, 0, Letter.INCORRECT);
        Assert_Letter_At_Index(score, 1, Letter.CORRECT);
    }

    @Test
    public void should_check_two_letters_one_incorrect_one_incorrect(){
        // Arrange
        Word word = new Word("CB");

        // Act
        Score score = word.guess("AM");

        // Assert
        Assert_Letter_At_Index(score, 0, Letter.INCORRECT);
        Assert_Letter_At_Index(score, 1, Letter.INCORRECT);
    }

    @Test
    public void should_check_two_letters_incorrect_part_correct() {
        // Arrange
        Word word = new Word("AB");

        // Act
        Score score = word.guess("CA");

        // Assert
        Assert_Letter_At_Index(score, 0, Letter.INCORRECT);
        Assert_Letter_At_Index(score, 1, Letter.PART_CORRECT);
    }

    @Test
    public void should_check_two_letters_part_correct_incorrect() {
        // Arrange
        Word word = new Word("CA");

        // Act
        Score score = word.guess("AB");

        // Assert
        Assert_Letter_At_Index(score, 0, Letter.PART_CORRECT);
        Assert_Letter_At_Index(score, 1, Letter.INCORRECT);
    }

    @Test
    public void should_check_two_letters_part_correct_part_correct() {
        // Arrange
        Word word = new Word("BA");

        // Act
        Score score = word.guess("AB");

        // Assert
        Assert_Letter_At_Index(score, 0, Letter.PART_CORRECT);
        Assert_Letter_At_Index(score, 1, Letter.PART_CORRECT);
    }

    @Test
    public void should_check_more_than_two_letters_with_mixed_results() {
        // Arrange
        Word word = new Word("ABC");

        // Act
        Score score = word.guess("ABB");

        // Assert
        Assert_Letter_At_Index(score, 0, Letter.CORRECT);
        Assert_Letter_At_Index(score, 1, Letter.CORRECT);
        Assert_Letter_At_Index(score, 2, Letter.PART_CORRECT);
    }

    @Test
    public void should_check_six_letters_with_mixed_results() {
        // Arrange
        Word word = new Word("ABCDEF");

        // Act
        Score score = word.guess("AEBZXA");

        // Assert
        Assert_Letter_At_Index(score, 0, Letter.CORRECT);
        Assert_Letter_At_Index(score, 1, Letter.PART_CORRECT);
        Assert_Letter_At_Index(score, 2, Letter.PART_CORRECT);
        Assert_Letter_At_Index(score, 3, Letter.INCORRECT);
        Assert_Letter_At_Index(score, 4, Letter.INCORRECT);
        Assert_Letter_At_Index(score, 5, Letter.PART_CORRECT);
    }


    private void Assert_Letter_At_Index(Score score , int index, Letter expected) {
        Letter actual = score.letter(index);
        assertEquals(expected, actual);
    }
}