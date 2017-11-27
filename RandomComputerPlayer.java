
import java.util.*;

/**
 * public RandomComputerPlayer class extends the public abstract Player class. It is used by public Round class.
 * It implements the selectedAttribute(Card card) method in the public Player class.
 *
 * @author liuzhiyong
 *
 */
public class RandomComputerPlayer extends Player {

	/**
	 * The value increases when a random computer player is instanced. It is used to set the name of random computer player.
	 */
	private static int sequence = 1;

	/**
	 * Constructs a random computer.
	 */
	RandomComputerPlayer(){
		this.name = "Random computer player "+sequence;
		sequence++;
	}

	/**
	 * Random computer player select one attribute of picked card.
	 *
	 * @param card the card which is picked by random computer player
	 * @return the attribute which is selected by random computer player
	 */
	@Override
	Attribute selectAttribute(Card card) {
		GameFunction.gameWait(5000);
		Random random = new Random();
		int selectedAttributeSequence = random.nextInt(card.getAttributes().size());
		Attribute selectedAttribute = card.getAttributes().get(selectedAttributeSequence);
		return selectedAttribute;
	}
}
