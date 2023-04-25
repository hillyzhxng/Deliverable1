/*
* Rachel Prasad
* Hillary Zhang
* Rishabh Kumar
*/

package ca.sheridancollege.project;

import java.util.ArrayList;
import java.util.Collections;

public class GroupOfCards {
    
    private final ArrayList<Card> deck;
    private final int DECK_SIZE = 52;
    
    public GroupOfCards() {
        deck = new ArrayList<>();
        populate();
    }
    
    public ArrayList<Card> getDeck() {
        return deck;
    }
    
    public void populate() {
        deck.clear();
        for (int i = 2; i <= 14; i++) {
            for (String suit : new String[]{"Hearts", "Diamonds", "Clubs", "Spades"}) {
                deck.add(new Card(i, suit));
            }
        }
    }
    
    public void shuffle() {
        Collections.shuffle(deck);
    }
    
    public Card dealCard() {
        return deck.remove(0);
    }
    
    public int getDeckSize() {
        return DECK_SIZE;
    }
    
    public ArrayList<Card> getCards() {
    return new ArrayList<>(deck);
  }

    void addCard(Card card) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    int size() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    Card removeCard() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    Card getCard(int i) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    GroupOfCards copy() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}