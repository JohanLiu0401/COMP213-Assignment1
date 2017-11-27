
import java.util.Scanner;

/**
 * public GameFunction is used by all other class. It contains method printSeparator(),
 * printEmptyLine(), inputOperation(int min, int max), inputToContinue(), printGameIntroduction(),
 * gameWait(int time), cleanScreen().
 *
 * @author Zhiyong Liu
 *
 */
public class GameFunction {

    /**
     * Print the separator in the game.
     */
    public static void printSeparator(){
        System.out.println("-------------------------------------------");
    }

    /**
     * Print the empty line in the game.
     */
    public static void printEmptyLine(){
        System.out.println();
    }

    /**
     * Process the input operation in the game.
     *
     * @param min the upper bound of input
     * @param max the lower bound of inout
     * @return the value of player input
     */
    public static int inputOperation(int min, int max){
        int input = 0;
        boolean isValid = false;
        while(!isValid){
            try{
                Scanner kb = new Scanner(System.in);
                String inputString = kb.nextLine();
                int inputInt = Integer.parseInt(inputString);

                if(inputInt >= min && inputInt <=max){
                    input = inputInt;
                }else{
                    throw new Exception();
                }

                isValid = true;
            }catch(Exception e){
                System.out.println("Invalid input, please enter again:");
            }
        }
        return input;
    }

    /**
     * Wait player to input to continue game.
     */
    public static void inputToContinue(){
        System.out.println("Press any key to continue...");
        Scanner kb = new Scanner(System.in);
        kb.nextLine();
    }

    /**
     * Print the brief game introduction.
     */
    public static void printGameIntroduction(){
        System.out.println("Welcome to Card Game!\nplease see following brief introduction before playing:");
        printEmptyLine();
        System.out.println("1. Game allow set three different types of card:");
        System.out.println("<1> Pokemon(which is a kind of elf)\n\tAttribute: Health, Attack, Defense, Weight, Height");
        System.out.println("<2> Soccer player\n\tAttribute: Age, Height, Weight, Transfer value, Award");
        System.out.println("<3> Car\n\tAttribute: Speed, Price, Weight, Popular rank, Time to market");
        printEmptyLine();
        System.out.println("2. Player can set the initial number of cards of each player (ranger from 1 to 10)");
        System.out.println("3. Player can set the number of attributes of the card (range from 3 to 5)");
        System.out.println("4. The Game allow multiple human players and multiple computer players");
        System.out.println("5. The nominated player in each round is selected randomly and the winner of each round is whose card has the largest selected attribute value");
        printEmptyLine();
        System.out.println("Now, please enjoy your game!");
        printEmptyLine();
    }

    /**
     * Simulate the time cost in the game.
     *
     * @param time the time to cost
     */
    public static void gameWait(int time){
        try {
            for(int i = time/1000; i > 0; i--){
                System.out.print(i+" ");
                Thread.sleep(1000);
            }
            System.out.println();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**
     * Clean the screen in game
     */
    public static void cleanScreen(){

        try
        {
            String os = System.getProperty("os.name");

            if (os.contains("Windows"))
            {
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            }
            else
            {
                System.out.print("\033[H\033[2J");
                System.out.flush();
            }
        }
        catch (Exception e)
        {

        }
    }
}
