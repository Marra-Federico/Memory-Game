package org.fmarra.memorygame;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Class that implement a Deck of cards
 */
public class Deck {
    private ArrayList<Card> deck;

    /**
     * Constructor of a Deck of cards
     */
    public Deck() {
        this.deck = new ArrayList<>();

        List<String> suits = Card.getValidSuits();
        List<String> faceNames = Card.getValidFaceName();
        for (String suit : suits) {
            for (String faceName : faceNames) {
                this.deck.add(new Card(suit, faceName));
            }
        }

    }

    /**
     * Method that shuffle the deck of card
     */
    public void shuffle() {
        Collections.shuffle(this.deck);
    }

    /**
     * Method that return the top card from the deck
     * If the deck is empty it will return null
     * @return the top card of the deck
     */
    public Card deal() {
        if(deck.size() > 0) {
            return deck.remove(0);
        }
        else {
            return null;
        }
    }

    /**
     * Method that return the number of the card left in the deck
     * @return the number of card left in the deck
     */
    public int getNumberOfCards() {
        return this.deck.size();
    }
}