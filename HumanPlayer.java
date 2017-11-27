import java.util.*;

/**
 * public HumanPlayer class extends the public abstract Player class. It is used by public Round class.
 * It implements the selectedAttribute(Card card) method in the public Player class.
 *
 * @author Zhiyong Liu
 *
 */
public class HumanPlayer extends Player {

	/**
	 * Constructs a human player.
	 */
	HumanPlayer(String name){
		this.name = "Human player " + name;
	}

	/**
	 * Human player select one attribute of picked card.
	 *
	 * @param card the card which is picked
	 * @return the attribute selected by player
	 */
	@Override
	Attribute selectAttribute(Card card) {
		Attribute selectedAttribute = null;
		System.out.println("Please input the name of attribute which you want to choose(ignore case):");
		Scanner kb = new Scanner(System.in);
		boolean isMatch = false;
		while(!isMatch){
			String input = kb.nextLine();
			for(Attribute attribute: card.getAttributes()){
				if(attribute.getName().equalsIgnoreCase(input)){
					selectedAttribute = attribute;
					isMatch = true;
				}
			}

			if(isMatch == false){
				System.out.println("Attribute not exist! Please enter again:");
			}
		}

		return selectedAttribute;
	}
}
