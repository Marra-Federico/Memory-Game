package org.fmarra.memorygame;

/**
 * Class that implement the memoryCard
 */
public class MemoryCard extends Card {

    private boolean matched;

    /**
     * Constructor of a memoryCard
     * @param suit is the suit of the card
     * @param faceName us the faceName of the card
     * matched is false just created the card
     */
    public MemoryCard(String suit, String faceName) {
        super(suit, faceName);
        this.matched = false;
    }

    /**
     * Method that return if the card is matched or not
     * @return true if the card is matched, false if the card is not matched
     */
    public boolean isMatched() {
        return matched;
    }

    /**
     * Method that set the value matched, true if is matched, false if is not matched
     * @param matched is the value to set in matched
     */
    public void setMatched(boolean matched) {
        this.matched = matched;
    }

    /**
     * Method that return  if 2 memoryCard are the same
     * @param otherCard is the second card to compare with the first
     * @return true if 2 memoryCard are the same, false if not are the same
     */
    public boolean isSameCard(MemoryCard otherCard) {
        return (this.getSuit().equals(otherCard.getSuit()) && this.getFaceName().equals(otherCard.getFaceName()));
    }

}