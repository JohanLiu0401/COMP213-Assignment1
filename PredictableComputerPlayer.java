
import java.util.*;

/**
 * public PredictableComputerPlayer class extends the public abstract Player class. It is used by public Round class.
 * It implements the selectedAttribute(Card card) method in the public Player class.
 *
 * @author Zhiyong Liu
 *
 */
public class PredictableComputerPlayer extends Player {

	/**
	 * The value increases when a predictable computer player is instanced. It is used to set the name of predictable computer player.
	 */
	private static int sequence = 1;

	/**
	 * The count of selecting attribute by predictable computer player.
	 */
	private int selectAttributeTime = 1;

	/**
	 * The sequence of attribute in card selected by predictable computer player.
	 */
	private int selectedAttributeSequence;

	/**
	 * Constructs a predictable computer player.
	 */
	PredictableComputerPlayer(){
		this.name = "Predictable computer player "+sequence;
		sequence++;
	}


	/**
	 * Predictable computer select one attribute of picked card.
	 *
	 * @param card the card which is picked by predictable player
	 * @return the attribute which is selected by predictable player
	 */
	@Override
	Attribute selectAttribute(Card card) {
		GameFunction.gameWait(5000);
		Attribute selectedAttribute;
		if(selectAttributeTime == 1){
			Random random = new Random();
			selectedAttributeSequence = random.nextInt(card.getAttributes().size());
			selectedAttribute = card.getAttributes().get(selectedAttributeSequence);
		} else{
			selectedAttribute = card.getAttributes().get(selectedAttributeSequence);
		}
		selectAttributeTime++;
		return selectedAttribute;
	}
}
