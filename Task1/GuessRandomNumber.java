import java.util.Scanner;

public class GuessRandomNumber {

    static int points = 0;

    static void playGame() {

        try {
            int rand = (int) (Math.random() * 100);
            Scanner sc = new Scanner(System.in);
            System.out.println("WELCOME TO Guess the number GAME");

            System.out.println("Attention and read rule carefully");
            System.out.println("For each round won in the game, you will receive 100 points");
            System.out.println("you have five chance to correctly guess this number ");
            System.out.println("############################################");


            System.out.println("Enter any  Number between 0 to 100 to guess ");
            int input = sc.nextInt();
            int chance = 0;

            while (input != rand && chance < 5) {


                if (input > rand) {
                    System.out.println("Too High");
                    System.out.println("Enter any  Number between 0 to 100 to guess ");
                    input = sc.nextInt();
                    chance++;
                } else if (input < rand) {
                    System.out.println("Too Low");
                    System.out.println("Enter any  Number between 0 to 100 to guess ");
                    input = sc.nextInt();
                    chance++;

                }


            }

            if (input == rand) {
                points += 100;
                System.out.println("You win and u guess it in " + chance + "chance");
                System.out.println("your points till now " + "=" + points);
            } else if (chance >= 5) {
                System.out.println("ohh  ! you have cross limit of 5 chance ");
            }


            System.out.println("do you want to play this game again  enter yes or no");
            String opinion = sc.next();
            if (opinion.equals("yes")) {
                playGame();
            }
            if (opinion.equals("no")) {
                System.out.println("your total points =" + points);
                return;
            }
        }
        catch (Exception e)
        {
            System.out.println(e);
        }

    }

    public static void main(String[] args) {


        playGame();


    }
}
