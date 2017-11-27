import java.util.*;

/**
 * Public round class is used by public Game class. It contains members: sequence, roundPlayers,
 * and methods: run(), printPlayCardNumbers(), selectNominatedPlayer(), printAllPlayerCardSelectedAttribute(String attributeName),
 * playerPickCard(), compareCardAttribute(String attributeName), collectCard(Player winnerPlayer), testPlayerEliminated().
 *
 * @author Zhiyong Liu
 *
 */
public class Round {

    /**
     * The round sequence of the game.
     */
    static int sequence = 1;

    /**
     * Store all the players in current round.
     */
    ArrayList<Player> roundPlayers;

    /**
     * Constructs a round current players.
     *
     * @param allPlayer The reference of the ArrayList which store all the players left.
     */
    Round(ArrayList<Player> allPlayer){
        roundPlayers = allPlayer;
    }

    /**
     * Run one round in game.
     *
     * @return the players left in this round
     */
    public ArrayList<Player> run(){

        //Print round sequence.
        GameFunction.printSeparator();
        System.out.println("Round "+sequence+"\n");
        printPlayCardNumbers();
        GameFunction.printEmptyLine();

        //Each player pick up the card on the top of their own deck.
        playerPickCard();
        System.out.println("Every player picks up card finished!");
        GameFunction.printEmptyLine();

        //Select the nominated player randomly and print the nominated name.
        Player nominatedPlayer = selectNominatedPlayer();
        System.out.println("Nominated player:\n"+nominatedPlayer.getName());
        GameFunction.printEmptyLine();

        //Nominated player select the attribute
        Card pickedCard = nominatedPlayer.getPickedCard();
        System.out.println("Nominated player picked card:");
        pickedCard.print();
        System.out.println(nominatedPlayer.getName()+" is selecting the attribute... ");
        Attribute selectedAttribute = nominatedPlayer.selectAttribute(pickedCard);
        GameFunction.printEmptyLine();

        //Print the attribute getName() selected by the nominated player.
        GameFunction.printEmptyLine();
        System.out.println("The attribute selected by "+nominatedPlayer.getName()+":\n"+selectedAttribute.getName());
        GameFunction.printEmptyLine();

        //Print the value of selected attribute on each player's picked card and compare their value.
        System.out.println("Each player's card attribute value:");
        printAllPlayerCardSelectedAttribute(selectedAttribute.getName());
        GameFunction.printEmptyLine();
        System.out.println("Comparing all the Card...");
        Player winnerPlayer = compareCardAttribute(selectedAttribute.getName());
        System.out.println(winnerPlayer.getName()+" is largest!");

        //Print the winner player name.
        GameFunction.printEmptyLine();
        System.out.println("The winner in this round:\n"+winnerPlayer.getName());

        //Winner collect all the picked cards and put them at the bottom of his deck.
        GameFunction.printEmptyLine();
        collectCard(winnerPlayer);

        //Eliminate th player who does not have cards.
        GameFunction.printEmptyLine();
        testPlayerEliminated();

        //Add the sequence number of round and print the end information.
        GameFunction.printEmptyLine();
        System.out.println("Round "+sequence+" ends!");
        sequence++;

        //Wait the player input to continue.
        GameFunction.inputToContinue();

        //clean the screen
        GameFunction.cleanScreen();

        return roundPlayers;
    }

    /**
     * Print the card number in every play's deck.
     */
    private void printPlayCardNumbers(){
        System.out.println("Each player deck card number:");
        for(Player player: roundPlayers){
            System.out.println(player.getName()+":\n"+ player.deck.size());
        }
    }

    /**
     * Select the nominated player in this round.
     *
     * @return  Player
     */
    private Player selectNominatedPlayer(){
        Random random = new Random();
        int nominatedPlayerSequence = random.nextInt(roundPlayers.size());
        Player nominatedPlayer = roundPlayers.get(nominatedPlayerSequence);
        return nominatedPlayer;
    }

    /**
     * Print the attribute value of each player, where the attribute is selected by nominated player.
     *
     * @param attributeName The name of selected attribute
     */
    private void printAllPlayerCardSelectedAttribute(String attributeName){
        for(Player player: roundPlayers){
            Attribute selectedAttribute = player.getPickedCard().getAttribute(attributeName);
            System.out.println(player.getName()+" picked card: ");
            selectedAttribute.print();
        }
    }

    /**
     * Every player picks up card.
     */
    private void playerPickCard(){
        System.out.println("Every Player is picking up....");
        for(Player player: roundPlayers){
            player.setPickedCard(player.pick());
        }
        GameFunction.gameWait(5000);
    }

    /**
     * Compare the selected attribute value of each player.
     *
     * @param attributeName The name of selected attribute
     * @return Player
     */
    private Player compareCardAttribute(String attributeName){
        Player roundWinner = roundPlayers.get(0);
        for(int i = 0; i < roundPlayers.size(); i++){
            int max = roundWinner.getPickedCard().getAttribute(attributeName).getValue();
            Player comparedPlayer = roundPlayers.get(i);
            int comparedValue = comparedPlayer.getPickedCard().getAttribute(attributeName).getValue();
            if( max < comparedValue ){
                roundWinner = roundPlayers.get(i);
            }
        }
        GameFunction.gameWait(5000);
        return roundWinner;
    }


    /**
     * Collect all the picked cards and put them at the bottom of winner's deck.
     *
     * @param winnerPlayer The reference of winner player
     */
    private void collectCard(Player winnerPlayer){
        System.out.println("Winner "+winnerPlayer.getName()+" is collecting all the picked cards...");
        for(Player player: roundPlayers){
            winnerPlayer.put(player.getPickedCard());
            player.setPickedCard(null);
        }
        GameFunction.gameWait(5000);
        System.out.println("Winner "+winnerPlayer.getName()+" put cards at the bottom of his deck finished");
    }

    /**
     * Tests if there are players who don not have cards and eliminate these players.
     */
    private void testPlayerEliminated(){
         Iterator itr = roundPlayers.iterator();
         while(itr.hasNext()){
             Player player = (Player)itr.next();
             if(player.getDeck().size() == 0){
                 itr.remove();
                 System.out.println(player.getName()+" is eliminated!");
             }
         }
    }
}
