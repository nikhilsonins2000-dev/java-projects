
import java.util.Random;
import java.util.Scanner;
class getnumber{
    public int computerguess;
    public int userguess;
    Scanner sc=new Scanner(System.in);
    public void getRandom(){
        Random rand=new Random();
        computerguess=rand.nextInt(100)+1;
    }
    public void getUserguess(){

        System.out.print("Enter your guess(1 to 100): ");
        userguess=sc.nextInt();
    }
}
public class guessthenumber extends getnumber {
    int chances=0;
    public void checkGuess(){
        do {
            getUserguess();
            if (computerguess == userguess) {
                System.out.println("You guessed correctly");
                chances++;
            } else if (computerguess > userguess) {
                System.out.println("too low!!");
                chances++;
                System.out.println("Attempts left: " + (5 - chances));

            } else if (Math.abs(computerguess - userguess) <= 5){
                System.out.println("you are close");
                chances++;
                System.out.println("Attempts left: " + (5 - chances));
            }
           else{
               System.out.println("too high!!");
                System.out.println("Attempts left: " + (5 - chances));
                chances++;

           }

        }while(userguess!=computerguess && chances<5 );
        if(userguess==computerguess)
        {
            System.out.println("you took "+chances+" guesses");
        }
        else {
            System.out.println("GAME OVER!!");
            System.out.println("computer guessed was : "+computerguess);

        }
        System.out.println("do you wanna play again(yes/no) : ");
        sc.nextLine();
        String ask=sc.nextLine();
        if(ask.equalsIgnoreCase("yes"))
        {
            chances=0;
            getRandom();
            checkGuess();
        }
        else if(ask.equalsIgnoreCase("no"))
        {
            System.out.println("okay thank you !! byee!!");
        }
        else {
            System.out.println("Invalid input");
        }
    }

    public static void main(String[] args) {
        guessthenumber check=new guessthenumber();
        check.getRandom();
        check.checkGuess();
    }

}
