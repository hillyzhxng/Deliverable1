/*
* Rachel Prasad
* Hillary Zhang
* Rishabh Kumar
*/

package ca.sheridancollege.project;

import java.util.ArrayList;

public class Player {

    private String name;
    private int score;
    private ArrayList<Card> cards;

    public Player(String name) {
        this.name = name;
        score = 0;
        cards = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getScore() {
        return score;
    }

        /**
 * Increases the player's score by 1.
 */
    public void incrementScore() {
    score++;
    }

/**
 * Increases the player's score by a given amount.
 * @param amount the amount to increase the score by.
 */
    public void incrementScore(int amount) {
    score += amount;
    }

/**
 * Resets the player's score to 0.
 */
    public void resetScore() {
    score = 0;
    }

    public void addCard(Card card) {
    
        cards.add(card);
    
    }
    
/**
 * Returns the cards in the player's hand.
 *
 * @return the cards in the player's hand
 */
    public ArrayList<Card> getCards() {
    
        return cards;
    }

/**
 * Removes all of the player's cards.
 */
    public void removeAllCards() {
    cards.clear();
    }

/**
 * Returns the number of cards that the player has.
 * @return the number of cards.
 */
    public int getNumberOfCards() {
    return cards.size();
    }

/**
 * Removes the top card from the player's deck of cards.
 * @return the top card.
 */
    public Card removeTopCard() {
    return cards.remove(0);
    }

    Object getCard() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    void setScore(int i) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
