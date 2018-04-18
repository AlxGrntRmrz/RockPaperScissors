import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class RockPaperScissors {
    static Scanner in = new Scanner(System.in);
    static int choice;
    static int computerChoice;
    static Random rand = new Random();
    static String[] RPS = {"ROCK", "PAPER", "SCISSOR"};

    private static void computerChoice(){
        computerChoice = rand.nextInt(3);
        System.out.println("COMPUTER CHOSE " + RPS[computerChoice]);
    }

    private static void choose(){
        boolean flag = true;
        do {
            System.out.println("CHOOSE");
            System.out.println("1. ROCK");
            System.out.println("2. PAPER");
            System.out.println("3. SCISSORS");
            try {

                choice = in.nextInt()-1;
                if(choice >= 0 && choice <= 2){
                    flag = false;
                }
            } catch(InputMismatchException e){
                System.out.println("Input is not valid");
                in.next();
                choice = 0;
            }
        }while(flag);
        System.out.println("YOU CHOSE " + RPS[choice]);
    }

    private static void countDown() {
        System.out.println("ROCK");
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("PAPER");
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("SCISSORS");
    }

    private static void compare(int choice1, int choice2){
        if (choice1 == 0 && choice2 == 0) {
            System.out.println("DRAW");
        }
        if (choice1 == 1 && choice2 == 1) {
            System.out.println("DRAW");
        }
        if (choice1 == 2 && choice2 == 2) {
            System.out.println("DRAW");
        }

        if(choice1 == 0 && choice2 == 2){
            System.out.println("ROCK BEATS SCISSORS");
            System.out.println("YOU WIN");
        }
        if(choice1 == 1 && choice2 == 0){
            System.out.println("PAPER BEATS ROCK");
            System.out.println("YOU WIN");
        }
        if(choice1 == 2 && choice2 == 1){
            System.out.println("SCISSORS BEATS ROCK");
            System.out.println("YOU WIN");
        }

        if(choice2 == 0 && choice1 == 2){
            System.out.println("ROCK BEATS SCISSORS");
            System.out.println("YOU LOSE");
        }
        if(choice2 == 1 && choice1 == 0){
            System.out.println("PAPER BEATS ROCK");
            System.out.println("YOU LOSE");
        }
        if(choice2 == 2 && choice1 == 1){
            System.out.println("SCISSORS BEATS ROCK");
            System.out.println("YOU LOSE");
        }
    }

    private static void RockPaperScissor(){
        choose();
        countDown();
        computerChoice();
        compare(choice, computerChoice);
    }

    public static void main(String[] args) {
        RockPaperScissor();
    }
}
