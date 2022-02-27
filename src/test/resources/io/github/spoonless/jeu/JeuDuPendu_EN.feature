Feature: Playing the hangman game

 Scenario: The game is over when all letters are found

   Given the word to be guessed is aaa
   When the player suggests the letter a
   Then the player won
   And the player did not lose

 Scenario Outline: Knowing the occurence and position of one letter in the word

    Given the word to be guessed is cucumber
    When the player suggests the letter <letter>
    Then the letter is found <occurrence> times
    And the word is <word>


  Examples:

  | letter | occurrence |    word  |
  |      c |          2 | c-c----- |
  |      u |          2 | -u-u---- |
  |      m |          1 | ----m--- |
  |      w |          0 | -------- |