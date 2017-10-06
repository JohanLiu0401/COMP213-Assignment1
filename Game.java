import java.util.*;

/**
 * 
 */

/**
 * @author liuzhiyong
 *
 */
public class Game {
	
	private String cardType;
	private ArrayList<Player> allPlayer= new ArrayList<Player>();
	
	public void procedure(){
		chooseCardType();
		addPlayer();
	}
	
	private void chooseCardType(){
		System.out.println("Welocome to Card Game, please select the type of the cards you want to play:\n(Choose the item by number and press \'Return\')");
		System.out.print("1. Pokemon\n2. Soccer star\n3. Architecture\n");
		Scanner kb = new Scanner(System.in);
		int input;
		boolean isValid = false;
		while(!isValid){
			input = kb.nextInt();
			switch(input){
				case 1:
					cardType = "Pokemon";
					break;
				case 2:
					cardType = "Soccer star";
					break;
				case 3:
					cardType = "Architecture";
					break;
				default:
					System.out.println("Invalid option, please enter agagin:");
			}
			
			if(input==1 || input==2 || input==3)
				isValid = true;
		}
	}
	
	private void addPlayer(){
		System.out.println("Please add the player:\n(Choose the item by number and press \'Return\')");
		System.out.print("1. Human player\n2. Random Computer\n3. Predictable Computer\n4. Smart computer\n");
	
	}
	
	public void testPrint(){
		System.out.print(cardType);
	}
}
