import java.util.ArrayList;

/**
 * public SmartComputerPlayer class extends the public abstract Player class. It is used by public Round class.
 * It implements the selectedAttribute(Card card) method in the public Player class.
 *
 * @author Zhiyong Liu
 */
public class SmartComputerPlayer extends Player{

    /**
     * The value increases when a smart computer player is instanced. It is used to set the name of smart computer player.
     */
    private static int sequence = 1;

    /**
     * Constructs a random computer.
     */
    SmartComputerPlayer(){
        this.name = "Smart computer player "+sequence;
        sequence++;
    }

    /**
     * Smart computer player select the largest attribute of picked card.
     *
     * @param card the card which is picked by smart computer player
     * @return the attribute which is selected by smart computer player
     */
    @Override
    Attribute selectAttribute(Card card) {
        GameFunction.gameWait(5000);
        ArrayList<Attribute> attributes = card.getAttributes();
        Attribute selectedAttribute = attributes.get(0);
        for(Attribute attribute: attributes){
            if(selectedAttribute.getValue() < attribute.getValue()){
                selectedAttribute = attribute;
            }
        }
        return selectedAttribute;
    }
}
