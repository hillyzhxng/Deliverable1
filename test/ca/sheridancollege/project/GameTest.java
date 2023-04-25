/*
* Rachel Prasad
* Hillary Zhang
* Rishabh Kumar
*/
package ca.sheridancollege.project;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Rachel Prasad
 */
public class GameTest {
    
    public GameTest() {
    }
    /**
     * Test of getName method, of class Game.
     */
    @Test
public void testGetName_good() {
    System.out.println("getName (good)");
    Game instance = new Game("Test");
    String expResult = "Test";
    String result = instance.getName();
    assertEquals(expResult, result);
}

@Test
public void testGetName_bad() {
    System.out.println("getName (bad)");
    Game instance = null;
    try {
        String result = instance.getName();
        fail("Expected NullPointerException not thrown");
    } catch (NullPointerException ex) {
        // pass
    }
}

@Test
public void testGetName_boundary() {
    System.out.println("getName (boundary)");
    Game instance = new Game("");
    String expResult = "";
    String result = instance.getName();
    assertEquals(expResult, result);
}

    /**
     * Test of setName method, of class Game.
     */
    @Test
    public void testSetName_good() {
    System.out.println("setName");
    Player player = new Player("");
    Scanner scanner = new Scanner("John"); 
    player.setName(scanner.nextLine());
    assertEquals("John", player.getName());
    }
    
    @Test
    public void testSetName_bad() {
    System.out.println("setName");
    Player player = new Player("");
    Scanner scanner = new Scanner("");
    player.setName(scanner.nextLine());
    assertEquals("", player.getName());
    }
    
    @Test
    public void testSetName_boundary() {
    System.out.println("setName");
    Player player = new Player("");
    Scanner scanner = new Scanner("ThisNameIsTooLong"); 
    player.setName(scanner.nextLine());
    assertEquals("ThisNameIsTooLo", player.getName());
    }
    
    /**
     * Test of getPlayers method, of class Game.
     */
    @Test
    public void testGetPlayers_good() {
        System.out.println("getPlayers (good)");
        Game instance = new Game("Test");
        ArrayList<Player> players = new ArrayList<>();
        players.add(new Player("Alice"));
        players.add(new Player("Bob"));
        instance.setPlayers(players);
        ArrayList<Player> expResult = players;
        ArrayList<Player> result = instance.getPlayers();
        assertEquals(expResult, result);
    }

    @Test
    public void testGetPlayers_bad() {
        System.out.println("getPlayers (bad)");
        Game instance = new Game("Test");
        ArrayList<Player> expResult = null;
        ArrayList<Player> result = instance.getPlayers();
        assertNotEquals(expResult, result);
    }

    @Test
    public void testGetPlayers_boundary() {
        System.out.println("getPlayers (boundary)");
        Game instance = new Game("Test");
        ArrayList<Player> expResult = new ArrayList<>();
        ArrayList<Player> result = instance.getPlayers();
        assertEquals(expResult, result);
    }

    /**
     * Test of setPlayers method, of class Game.
     */
    @Test
    public void testSetPlayers_good() {
        System.out.println("setPlayers (good)");
        Game instance = new Game("Test");
        ArrayList<Player> players = new ArrayList<>();
        players.add(new Player("Alice"));
        players.add(new Player("Bob"));
        instance.setPlayers(players);
        ArrayList<Player> expResult = players;
        ArrayList<Player> result = instance.getPlayers();
        assertEquals(expResult, result);
    }

    @Test
    public void testSetPlayers_bad() {
        System.out.println("setPlayers (bad)");
        Game instance = new Game("Test");
        ArrayList<Player> players = new ArrayList<>();
        players.add(new Player("Alice"));
        players.add(new Player("Bob"));
        instance.setPlayers(players);
        ArrayList<Player> expResult = null;
        instance.setPlayers(expResult);
        ArrayList<Player> result = instance.getPlayers();
        assertNotEquals(expResult, result);
    }

    @Test
    public void testSetPlayers_boundary() {
        System.out.println("setPlayers (boundary)");
        Game instance = new Game("Test");
        ArrayList<Player> expResult = null;
        instance.setPlayers(expResult);
        ArrayList<Player> result = instance.getPlayers();
        assertEquals(expResult, result);
    }

    /**
     * Test of getDeck method, of class Game.
     */
    @Test
    public void testGetDeck_good() {
        System.out.println("getDeck (good)");
        Game game = new Game("War");
        game.shuffleDeck();
        GroupOfCards deck = game.getDeck();
        assertNotNull(deck);
    }
    
    @Test
    public void testGetDeck_boundary() {
        System.out.println("getDeck (boundary)");
        Game game = new Game("War");
        GroupOfCards deck = game.getDeck();
        assertEquals(52, deck.size());
    }
    
    @Test
    public void testGetDeck_bad() {
        System.out.println("getDeck (bad)");
        Game game = new Game("War");
        game.setDeck(null);
        assertThrows(NullPointerException.class, () -> game.getDeck());
    }

    /**
     * Test of shuffleDeck method, of class Game.
     */
    @Test
    public void testShuffleDeck_good() {
        System.out.println("shuffleDeck (good)");
        Game game = new Game("War");
        GroupOfCards oldDeck = game.getDeck().copy();
        game.shuffleDeck();
        GroupOfCards newDeck = game.getDeck();
        assertNotEquals(oldDeck, newDeck);
    }
    
    @Test
    public void testShuffleDeck_bad() {
        System.out.println("shuffleDeck (bad)");
        Game game = new Game("War");
        game.setDeck(null);
        assertThrows(NullPointerException.class, () -> game.shuffleDeck());
    }
    
    @Test
    public void testShuffleDeck_boundary() {
        System.out.println("shuffleDeck (boundary)");
        Game game = new Game("War");
        Player player1 = new Player("Player 1");
        Player player2 = new Player("Player 2");
        Card card = new Card(14, Suit.CLUBS);
        GroupOfCards deck = new GroupOfCards();
        deck.addCard(card);
        game.setDeck(deck);
        game.detectCards(player1, player2);
        GroupOfCards shuffledDeck = game.getDeck();
        Card firstCard = shuffledDeck.getCard(0);
        assertNotEquals(card, firstCard);
    }

    /**
     * Test of declareWinner method, of class Game.
     */
    @Test
    public void testDeclareWinner_good() {
        System.out.println("declareWinner (good)");
        Game game = new Game("War");
        Player player1 = new Player("Player 1");
        Player player2 = new Player("Player 2");
        player1.incrementScore(10);
        player2.incrementScore(15);
        Player winner = game.detectWinner(player1, player2);
        String expectedOutput = "The winner is " + winner.getName();
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));
        game.declareWinner(winner);
        assertEquals(expectedOutput, outputStream.toString().trim());
    }
    
    @Test
    public void testDeclareWinner_bad() {
        System.out.println("declareWinner (bad)");
        Game game = new Game("War");
        Player player1 = new Player("Player 1");
        Player player2 = new Player("Player 2");
        player1.setScore(0);
        player2.setScore(0);
        assertThrows(NullPointerException.class, () -> game.declareWinner(null));
    }
    
    @Test
    public void testDeclareWinner_boundary() {
        System.out.println("declareWinner (boundary)");
        Game game = new Game("War");
        Player player1 = new Player("Player 1");
        Player player2 = new Player("Player 2");
        player1.incrementScore(10);
        player2.incrementScore(21);
        Player winner = game.detectWinner(player1, player2);
        String expectedOutput = "The winner is " + winner.getName();
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));
        game.declareWinner(winner);
        assertEquals(expectedOutput, outputStream.toString().trim());
    }
    
    

    /**
     * Test of detectCards method, of class Game.
     */
    
    @Test
    public void testDetectCards_good() {
        System.out.println("detectCards (good)");
        Game game = new Game("War");
        Player player1 = new Player("Player 1");
        Player player2 = new Player("Player 2");
        Card card1 = new Card(14, "CLUBS");
        Card card2 = new Card(13, "SPADES");
        player1.addCard(card1);
        player2.addCard(card2);
        Player winner = game.detectCards(player1, player2);
        assertEquals(player2, winner);
    }
    
    @Test
    public void testDetectCards_bad() {
        System.out.println("detectCards (bad)");
        Game game = new Game("War");
        Player player1 = new Player("Player 1");
        Player player2 = new Player("Player 2");
        assertThrows(IllegalArgumentException.class, () -> game.detectCards(player1, player2));
    }
    
    @Test
public void testDetectCards_boundary() {
    System.out.println("detectCards (boundary)");
    Game game = new Game("War");
    Player player1 = new Player("Alice");
    Player player2 = new Player("Bob");
    game.addPlayer(player1);
    game.addPlayer(player2);

    // create a deck with 50 cards (excluding cards held by players)
    GroupOfCards deck = new GroupOfCards();
    for (Suit suit : Suit.values()) {
        for (Rank rank : Rank.values()) {
            Card card = new Card(rank.ordinal() + 2, suit);
            if (!card.equals(player1.getCard()) && !card.equals(player2.getCard())) {
                deck.addCard(card);
            }
        }
    }

    // deal cards to players
    int numCardsPerPlayer = deck.size() / game.getPlayers().size();
    for (Player player : game.getPlayers()) {
        for (int i = 0; i < numCardsPerPlayer; i++) {
            player.addCard(deck.removeCard());
        }
    }

    Player winner = game.detectCards(player1, player2);
    assertNotNull(winner);
}


    /**
     * Test of startGame method, of class Game.
     */
    @Test
    public void testStartGame_good() {
        System.out.println("startGame (good)");
        Game game = new Game("War");
        game.startGame();
        assertTrue(game.getPlayers().size() > 0);
        assertNotNull(game.getDeck());
    }
    
    @Test
    public void testStartGame_bad() {
        System.out.println("startGame (bad)");
        Game game = null;
        game.startGame();
    }
    
    @Test
    public void testStartGame_boundary() {
    System.out.println("startGame (boundary)");
    Game game = new Game("War");
    game.startGame();
    int maxPlayers = 4;
    List<Player> players = new ArrayList<>();
    for (int i = 0; i < maxPlayers; i++) {
        players.add(new Player("Player " + (i + 1)));
    }
    game.setPlayers((ArrayList<Player>) players);
    assertTrue(game.getPlayers().size() == maxPlayers);
}

    
    
}
