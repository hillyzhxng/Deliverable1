/*
* Rachel Prasad
* Hillary Zhang
* Rishabh Kumar
*/

package ca.sheridancollege.project;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Game {

    private String name;
    private ArrayList<Player> players;
    private GroupOfCards deck;
    private final Scanner input;

    public Game(String name) {
        this.name = name;
        this.players = new ArrayList<>();
        this.deck = new GroupOfCards();
        this.input = new Scanner(System.in);
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<Player> getPlayers() {
        return this.players;
    }

    public void setPlayers(ArrayList<Player> players) {
        this.players = players;
    }

    public GroupOfCards getDeck() {
        return this.deck;
    }

    public void shuffleDeck() {
        Collections.shuffle(this.deck.getCards());
    }

    public void declareWinner(Player player) {
        System.out.println("The winner of this round is " + player.getName() + " with " + player.getCards().get(0).toString() + "!");
    }

    public Player detectCards(Player player1, Player player2) {
        Card player1Card = player1.getCards().remove(0);
        Card player2Card = player2.getCards().remove(0);

        if (player1Card.getRank() > player2Card.getRank()) {
            player1.incrementScore();
            return player1;
        } else if (player2Card.getRank() > player1Card.getRank()) {
            player2.incrementScore();
            return player2;
        } else {
            // War! Declare war and compare the next cards in the pot
            declareWar(player1, player2, player1Card, player2Card);
            return detectCards(player1, player2);
        }
    }

    private void declareWar(Player player1, Player player2, Card player1Card, Card player2Card) {
        ArrayList<Card> pot = new ArrayList<>();
        pot.add(player1Card);
        pot.add(player2Card);

        for (int i = 0; i < 4; i++) {
            if (!player1.getCards().isEmpty() && !player2.getCards().isEmpty()) {
                pot.add(player1.getCards().remove(0));
                pot.add(player2.getCards().remove(0));
            }
        }

        if (player1.getCards().isEmpty()) {
            player2.incrementScore();
            System.out.println(player1.getName() + " is out of cards. " + player2.getName() + " wins!");
            return;
        } else if (player2.getCards().isEmpty()) {
            player1.incrementScore();
            System.out.println(player2.getName() + " is out of cards. " + player1.getName() + " wins!");
            return;
        }

        System.out.println("WAR! Three cards face down and one card face up for each player:");
        for (int i = 0; i < 3; i++) {
            if (!player1.getCards().isEmpty() && !player2.getCards().isEmpty()) {
                pot.add(player1.getCards().remove(0));
                pot.add(player2.getCards().remove(0));
            }
        }

        System.out.println(player1.getName() + " plays " + player1Card.toString());
        System.out.println(player2.getName() + " plays " + player2Card.toString());

        // Compare the next cards in the pot
        detectCards(player1, player2);
    }

public void startGame() {
    // Get player names
    System.out.println("Welcome to the War game!");
    System.out.println("Enter name for Player 1:");
    String name1 = input.nextLine();
    Player player1 = new Player(name1);

    System.out.println("Enter name for Player 2:");
    String name2 = input.nextLine();
    Player player2 = new Player(name2);

    // Add the players to the game
    this.players.add(player1);
    this.players.add(player2);

    // Create a deck of cards and shuffle it
    this.deck = new GroupOfCards();
    this.deck.populate();
    this.shuffleDeck();

    // Deal the cards to the players
    while (this.deck.getCards().size() > 0) {
        player1.getCards().add(this.deck.getCards().remove(0));
        player2.getCards().add(this.deck.getCards().remove(0));
    }

    // Inform the players about the start of the game and the number of cards in their hand
    System.out.println("\nGame starting...");
    System.out.println(name1 + " and " + name2 + ", you each have 26 cards in your hand.");
    System.out.println("The round will now begin. Please flip down a card for each round.");

    // Wait for user input to start the game
    input.nextLine();

    // Play the game
    int round = 1;
    while (player1.getCards().size() > 0 && player2.getCards().size() > 0) {
        // Draw cards and compare
        Card player1Card = player1.getCards().remove(0);
        Card player2Card = player2.getCards().remove(0);
        System.out.println("\nRound " + round + " starts!");
        System.out.println(player1.getName() + " played " + player1Card.toString() + ".");
        System.out.println(player2.getName() + " played " + player2Card.toString() + ".");
        Player winner = detectCards(player1, player2);

        // Update scores
        if (winner == player1) {
            System.out.println(player1.getName() + " wins the round!");
        } else if (winner == player2) {
            System.out.println(player2.getName() + " wins the round!");
        }

        // Print scores
        System.out.println(player1.getName() + "'s score: " + player1.getScore());
        System.out.println(player2.getName() + "'s score: " + player2.getScore());

        // Wait for user input before starting the next round
        input.nextLine();

        round++;
    }

    // Print the winner
    if (player1.getScore() > player2.getScore()) {
        System.out.println(player1.getName() + " wins the game!");
    } else if (player2.getScore() > player1.getScore()) {
        System.out.println(player2.getName() + " wins the game!");
    } else {
        System.out.println("The game is tied!");
    }
}


public static void main(String[] args) {
        Game game = new Game("War");
        game.startGame();
    }

    void setDeck(Object object) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    void addPlayer(Player player2) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    Player detectWinner(Player player1, Player player2) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
