import java.util.*;

/**
 * Public Card class is used by public Player class. It contains members: sequence, name,
 * attributes, attributeNameArray and methods: setAttribute(int numberAttribute), setAttributeNameArray(String cardType),
 * getAttributes(), getAttribute(String attributeName), print().
 *
 * @author Zhiyong Liu
 *
 */
public class Card {

	/**
	 * The value increases when a card is instanced. It is used to set the name of the card.
	 */
	static int sequence = 1;

	/**
	 * The name of the card.
	 */
	private String name;

	/**
	 * The ArrayList which stores all the attributes of the card.
	 */
	private ArrayList<Attribute> attributes;

	/**
	 * The array which stores all the attribute name according to the card type selected by the player.
	 */
	static private String[] attributeNameArray;

	/**
	 * Constructs a card with specified number of attributes.
	 *
	 * @param numberAttribute the number of attributes
	 */
	public Card(int numberAttribute){
		this.name = "Card "+sequence;
		setAttribute(numberAttribute);
		sequence++;
	}

	/**
	 * Set the attributes of a card.
	 *
	 * @param numberAttribute the number of attributes
	 */
	private void setAttribute(int numberAttribute){
		attributes = new ArrayList<Attribute>();
		for(int i=0; i<numberAttribute; i++){
			String name = attributeNameArray[i];
			int value = (int) (Math.random()*100);
			attributes.add(new Attribute(name, value));
		}
	}

	/**
	 * Determine which attribute name is used according to the cardType selected by player.
	 *
	 * @param cardType the name of card type selected by player
	 */
	public static void setAttributeNameArray(String cardType){
		if(cardType.equals("Pokemon")){
			attributeNameArray = Game.cardTypeOneAttribute;
		}else if(cardType.equals("Soccer star")){
			attributeNameArray = Game.cardTypeTwoAttribute;
		}else{
			attributeNameArray = Game.cardTypeThreeAttribute;
		}
	}

	/**
	 * Return all the attributes of the card.
	 *
	 * @return the attributes of the card
	 */
	public ArrayList<Attribute> getAttributes() {
		return attributes;
	}

	/**
	 * Return one specific attribute of the card.
	 *
	 * @param attributeName the name of th attribute
	 * @return the specific attribute selected
	 */
	public Attribute getAttribute(String attributeName){
		Attribute attributeToGet = null;
		for(Attribute a: attributes){
			if(a.getName().equalsIgnoreCase(attributeName)){
				attributeToGet = a;
			}
		}
		return attributeToGet;
	}

	/**
	 * Print the name and the attributes of the card.
	 */
	public void print(){
		GameFunction.printSeparator();
		System.out.println(name);
		for(Attribute a: attributes){
			a.print();
		}
		GameFunction.printSeparator();
	}
}
