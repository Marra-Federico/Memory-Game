package org.fmarra.memorygame;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.FlowPane;

import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.ResourceBundle;

/**
 * Class that implement the logic of the memory game
 */
public class MemoryGameController implements Initializable {

    @FXML
    private Label correctLabel;

    @FXML
    private Label guessesLabel;

    @FXML
    private FlowPane imagesFlowPane;

    private ArrayList<MemoryCard> cardsInGame;

    private MemoryCard firstCard, secondCard;
    private int numGuess;
    private int numMatches;

    /**
     * Method that deal the card and place the card
     */
    @FXML
    void playAgain() {
        firstCard = null;
        secondCard = null;

        Deck deck = new Deck();
        deck.shuffle();

        cardsInGame = new ArrayList<>();

        for(int i = 0; i < imagesFlowPane.getChildren().size() / 2; i++) {
            Card cardDealt = deck.deal();
            cardsInGame.add(new MemoryCard(cardDealt.getSuit(), cardDealt.getFaceName()));
            cardsInGame.add(new MemoryCard(cardDealt.getSuit(), cardDealt.getFaceName()));
        }
        Collections.shuffle(cardsInGame);

        numGuess = 0;
        numMatches = 0;
        updateLabels();
        flipAllCard();

    }

    /**
     * Method that initialize the game
     */
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        initializeImageView();
        playAgain();
    }

    /**
     * Method that add a number to each ImageView and set the image to be the back of a card
     */
    private void initializeImageView() {
        for(int i = 0; i < imagesFlowPane.getChildren().size(); i++) {
            ImageView imageView = (ImageView) imagesFlowPane.getChildren().get(i);
            imageView.setImage(new Image(Card.class.getResourceAsStream("images/back_of_card.png")));
            imageView.setUserData(i);

            imageView.setOnMouseClicked(event-> {
                flipCard((int) imageView.getUserData());
            });
        }
    }

    /**
     * Method that flip back the cards that are not matched
     */
    private void flipAllCard() {
        for(int i = 0; i < cardsInGame.size(); i++) {

            ImageView imageView = (ImageView) imagesFlowPane.getChildren().get(i);
            MemoryCard card = cardsInGame.get(i);

            if(card.isMatched()) {
                imageView.setImage(card.getImage());
            }
            else {
                imageView.setImage(card.getBackCardImage());
            }
        }
    }

    /**
     * Method that flip the card
     * @param indexCard is the index of the card to flip
     */
    private void flipCard(int indexCard) {

        if(firstCard == null && secondCard == null) {
            flipAllCard();
        }

        ImageView imageView = (ImageView) imagesFlowPane.getChildren().get(indexCard);

        if (firstCard == null) {
            firstCard = cardsInGame.get(indexCard);
            imageView.setImage(firstCard.getImage());
        }
        else if (secondCard == null) {
            numGuess++;
            secondCard = cardsInGame.get(indexCard);
            imageView.setImage(secondCard.getImage());
            checkMatch();
            updateLabels();
        }
    }

    /**
     * Method that update the number of guess label and the number of match label
     */
    private void updateLabels() {
        correctLabel.setText(Integer.toString(numMatches));
        guessesLabel.setText(Integer.toString(numGuess));
    }

    /**
     * Method that check if two cards are matched and update the matches number
     */
    private void checkMatch() {
        if(firstCard.isSameCard(secondCard)) {
            numMatches++;
            firstCard.setMatched(true);
            secondCard.setMatched(true);
        }
        firstCard = null;
        secondCard = null;
    }
}