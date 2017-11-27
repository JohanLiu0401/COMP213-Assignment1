
import java.util.*;

/**
 * Public Game class is used by public Main class. It contains members: cardType, numberAttribute,
 * numberPlayerCard, allPlayer, cardTypeOneAttribute, cardTypeTwoAttribute, cardTypeThreeAttribute,
 * and methods: run(), chooseCardType(), setAttributeNumber(), setPlayerCardNumber(), addPlayer(),
 * inputPlayerName(), detectHumanPlayerNameRepeat(String name), detectHumanPlayerNameEmpty(String name),
 * distributeCard(), initialize().
 *
 * @author Zhiyong Liu
 *
 */
public class Game {

	/**
	 * The card type of the game.
	 */
	private String cardType;

	/**
	 * The number of the attributes set by player in this game.
	 */
	private int numberAttribute;

	/**
	 * The number of the cards set by player in this game.
	 */
	private int numberPlayerCard;

	/**
	 * The ArrayList which stores all the players in this game.
	 */
	private ArrayList<Player> allPlayer= new ArrayList<Player>();

	/**
	 * The attribute name of card type one.
	 */
	public static String[] cardTypeOneAttribute = {"Health", "Attack", "Defense", "Weight", "Height"};

	/**
	 * The attribute name of card type two.
	 */
	public static String[] cardTypeTwoAttribute = {"Age", "Height", "Weight", "Transfer value", "Award"};

	/**
	 * The attribute name of card type three.
	 */
	public static String[] cardTypeThreeAttribute = {"Speed", "Price", "Weight", "Popular rank", "Time to market"};

	/**
	 * The whole run procedure of this game.
	 */
	public void run(){

		//Print the brief introduction of game.
		GameFunction.printGameIntroduction();
		GameFunction.inputToContinue();
		GameFunction.cleanScreen();

		//Set the type of card in game.
		chooseCardType();
		GameFunction.cleanScreen();

		//Set the card number of each player.
		setPlayerCardNumber();
		GameFunction.cleanScreen();

		//Set the number of attributes on card.
		setAttributeNumber();
		GameFunction.cleanScreen();

		//Add the player.
		addPlayer();
		GameFunction.cleanScreen();

		//Initialize the game.
		initialize();
		GameFunction.cleanScreen();

		//Start the round repeatedly until only one player is left in the game.
		System.out.println("Game Start!");
		boolean isEnd = false;
		while(!isEnd){
			Round round = new Round(allPlayer);
			allPlayer = round.run();
			if(allPlayer.size() == 1){
				isEnd = true;
				System.out.println("Game ends!\nThe winner of this game is "+allPlayer.get(0).getName()+"!");
			}
		}
	}

	/**
	 * Player set the card type he want to play.
	 */
	private void chooseCardType(){
		System.out.println("Please select the type of the cards you want to play:\n(Choose the item by number and press \'Return\')");
		System.out.print("1. Pokemon\n2. Soccer star\n3. Car\n");
		int input = GameFunction.inputOperation( 1, 3 );
		switch(input){
			case 1:
				cardType = "Pokemon";
				break;
			case 2:
				cardType = "Soccer star";
				break;
			case 3:
				cardType = "Car";
				break;
		}
	}

	/**
	 * Player set the attribute number of one card.
	 */
	private void setAttributeNumber(){
		System.out.println("Please input the number of attributes (range from 3 to 5):");
		numberAttribute = GameFunction.inputOperation( 3, 5 );
	}

	/**
	 * Player set the card number of each player.
	 */
	private void setPlayerCardNumber(){
		System.out.println("Please input the initial number of cards for each player (range from 1 to 10):");
		numberPlayerCard = GameFunction.inputOperation(1,10);
	}

	/**
	 * Add the player in the game.
	 */
	private void addPlayer(){
		boolean isFinished = false;
		while(!isFinished){
			System.out.println("Please add the player:	(Current players number: "+allPlayer.size()+")");
			System.out.println("Choose the item by number and press \'Return\', if you finish adding, select option 5");
			System.out.println("1. Human player\n2. Predictable Computer\n3. Random Computer\n4. Smart Computer\n5. Finish adding and start game");
			int input = GameFunction.inputOperation(1, 5);
			switch(input){
				case 1:
					String name = inputPlayerName();
					HumanPlayer humanPlayer = new HumanPlayer(name);
					allPlayer.add(humanPlayer);
					GameFunction.printEmptyLine();
					System.out.println("Human player added successfully!\n");
					break;
				case 2:
					PredictableComputerPlayer predictableComputerPlayer = new PredictableComputerPlayer();
					allPlayer.add(predictableComputerPlayer);
					GameFunction.printEmptyLine();
					System.out.println("Predictable computer player added successfully!\n");
					break;
				case 3:
					RandomComputerPlayer randomComputerPlayer = new RandomComputerPlayer();
					allPlayer.add(randomComputerPlayer);
					GameFunction.printEmptyLine();
					System.out.println("Random computer player added successfully!\n");
					break;
				case 4:
					SmartComputerPlayer smartComputerPlayer = new SmartComputerPlayer();
					allPlayer.add(smartComputerPlayer);
					GameFunction.printEmptyLine();
					System.out.println("Smart computer player added successfully!\n");
					break;
				case 5:
					if(allPlayer.size() < 2){
						System.out.println("No enough players, please add the player!");
					}else{
						isFinished = true;
					}
					break;
			}
		}
	}

	/**
	 * Input the name of human player.
	 *
	 * @return the name of human player
	 */
	private String inputPlayerName(){
		boolean isValid = false;
		String inputName = null;
		System.out.println("Please enter the human player's name:");
		while (!isValid){
			Scanner kb = new Scanner(System.in);
			inputName = kb.nextLine();

			if(detectHumanPlayerNameEmpty(inputName)){
				System.out.println("No input, please input a legal name:");
			}else if(detectHumanPlayerNameRepeat(inputName)){
				System.out.println("The input name is same as another player in game, please input another name:");
			}else{
				isValid = true;
			}
		}

		return inputName;
	}

	/**
	 * Detect if the input name is repeat in game.
	 *
	 * @param name the input name
	 * @return whether the input name is repeat
	 */
	private boolean detectHumanPlayerNameRepeat(String name){
		boolean isRepeat = false;
		for(Player player: allPlayer){
			if(player.getName().equals("Human player "+name)){
				isRepeat = true;
			}
		}
		return isRepeat;
	}

	/**
	 * Detect if the input name is empty.
	 *
	 * @param name the input name
	 * @return whether the name is empty
	 */
	private boolean detectHumanPlayerNameEmpty(String name){
		boolean isEmpty = false;
		if(name.equals("")){
			isEmpty = true;
		}
		return isEmpty;
	}

	/**
	 * Distribute the initial cards to each player.
	 */
	private void distributeCard(){
		for(Player player: allPlayer){
			for(int i=0; i<numberPlayerCard;i++){
				Card card = new Card(numberAttribute);
				player.getDeck().add(card);
			}
		}
	}

	/**
	 * Game initialize.
	 */
	private void initialize(){
		System.out.println("Game initializing......");
		Card.setAttributeNameArray(cardType);
		distributeCard();
		GameFunction.gameWait(3000);
		System.out.println("Game initialized finished");
	}
}
