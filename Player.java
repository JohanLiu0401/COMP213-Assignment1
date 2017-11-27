import java.util.LinkedList;

/**
 * This class is Player class, it contains members: name, pickedCard, deck and methods:
 * selectAttribute(Card card), pick(), put(Card card), getDeck(), getPickedCard(),
 * getName(), setPickedCard(Card card).
 *
 * @author Zhiyong Liu
 *
 */
public abstract class Player {

	/**
	 * The name of the player.
	 */
	protected String name;

	/**
	 * The card which is picked up by player.
	 */
	protected Card pickedCard;

	/**
	 * The LinkedList which contains all the cards in player's deck.
	 */
	protected LinkedList<Card> deck = new LinkedList<Card>();

	/**
	 * Player select one attribute of picked card.
	 *
	 * @param card the card which is picked by player
	 * @return the attribute selected by the player
	 */
	abstract Attribute selectAttribute(Card card);

	/**
	 * Player picks up the card at the top of his deck.
	 *
	 * @return the card which is picked by the player
	 */
	Card pick(){
		Card pickedCard = deck.poll();
		return pickedCard;
	}

	/**
	 * Player put the card at the bottom of his deck.
	 *
	 * @param card the card which will be put
	 */
	void put(Card card){
		deck.add(card);
	}

	/**
	 * Return the LinkedList which contains all the cards in player's deck.
	 *
	 * @return the deck of player
	 */
	public LinkedList<Card> getDeck() {
		return deck;
	}

	/**
	 * Return the picked card of player.
	 *
	 * @return the card which is picked by player
	 */
	public Card getPickedCard(){
		return pickedCard;
	}

	/**
	 * Return the name of player
	 *
	 * @return the name of player
	 */
	public String getName(){
		return name;
	}


	/**
	 * Set the picked card of player.
	 *
	 * @param card the card which is picked by player
	 */
	public void setPickedCard(Card card){
		pickedCard = card;
	}
}
