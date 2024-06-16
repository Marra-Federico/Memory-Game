package org.fmarra.memorygame;

import javafx.scene.image.Image;
import java.util.Arrays;
import java.util.List;

/**
 * Class that implement a card of the deck
 */
public class Card {
    private String suit;
    private String faceName;

    /**
     * Constructor of a card
     * @param suit is the suit of the card
     * @param faceName is the name of the card
     */
    public Card(String suit, String faceName) {
        setSuit(suit);
        setFacename(faceName);
    }

    /**
     * Method that return value of the suit's card
     * @return the suit's card
     */
    public String getSuit() {
        return suit;
    }

    /**
     * Method that return the possible Suits of a card
     * @return a list of possible Suits of a card
     */
    public static List<String> getValidSuits() {
        return Arrays.asList("hearts", "diamonds", "clubs", "spades");
    }

    /**
     * Method that set the suit's card and check if the suit is correct, valid suits are: hearts, diamonds, clubs, spades.
     * @param suit is the suit's card
     */
    public void setSuit(String suit) {
        suit = suit.toLowerCase();
        if(getValidSuits().contains(suit)) {
            this.suit = suit;
        }
        else {
            throw new IllegalArgumentException("The suits " + suit + " is an invalid suit, must be on of " + getValidSuits());
        }
    }

    /**
     * Method that return value of the faceName's card
     * @return the faceName's card
     */
    public String getFaceName() {
        return faceName;
    }

        public static List<String> getValidFaceName() {
            return Arrays.asList("2", "3", "4", "5", "6", "7", "8", "9", "10", "jack", "queen", "king", "ace");
        }
    /**
     * Method that set the faceName's card and check if the faceName is correct, valid faceName are 2, 3, 4, 5, 6, 7, 8, 9, 10, jack, queen, king, ace
     * @param faceName is the faceName's card
     */
    public void setFacename(String faceName) {
        faceName = faceName.toLowerCase();
        if(getValidFaceName().contains(faceName)) {
            this.faceName = faceName;
        }
        else {
            throw new IllegalArgumentException("The faceNmae + " + faceName + " is an invalid face, must be on of " + getValidFaceName());
        }
    }

    /**
     *  Method that transform the Card's attributes in String to print
     * @return a String that contain the values of the attributes of the card
     */
    @Override
    public String toString() {
        return "Card{" +
                "suit='" + suit + '\'' +
                ", faceName='" + faceName + '\'' +
                '}';
    }

    /**
     * Method that return the color of a card
     * @return the color of the card
     */
    public String getColour() {
        if (suit.equals("hearts") || suit.equals("diamonds") ) {
            return "red";
        }
        else {
            return "black";
        }
    }

    /**
     * Method that return the value of a card, 2, 3, 4, 5, 6, 7, 8, 9, 10, jack, queen, king, ace
     *                                  index  0  1  2  3  4  5  6  7  8   9     10     11    12
     * The value is not important in this game, so we can calculate the value card with this simple method
     * @return the value of the card
     */
    public int getCardValue() {
        return getValidFaceName().indexOf(faceName) + 2;
    }

    public Image getImage() {
        String pathName = "images/" + getFaceName() + "_of_" + suit +".png";
        return new Image(Card.class.getResourceAsStream(pathName));
    }

    /**
     * Method that return the back-card image of the card
     * @return the back-card image
     */
    public Image getBackCardImage() {
        return new Image(Card.class.getResourceAsStream("images/back_of_card.png"));
    }

}