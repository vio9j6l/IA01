/*
 * Name: JiaJia Liu
 * Email: JPL5840@psu.edu
 * Course: IST 261
 * Assignment: IA01
 */

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import java.util.Scanner;

public class Demo
{
    /*
     * Four ArrayList of Integer type are created to contains answers,
     * correct answers, wrong answers, and random numbers.
     */
    public static ArrayList<Integer> answerList = new ArrayList<Integer>();
    public static ArrayList<Integer> correctList = new ArrayList<Integer>();
    public static ArrayList<Integer> wrongList = new ArrayList<Integer>();
    public static ArrayList<Integer> randomList = new ArrayList<Integer>();

    public void runDemo() {
        /*
         * We multiple 2 to random.nextInt(5) + 1 which double the integers
         * between 1 and 5 and returns integers between 2 and 10.
         *
         * Random.nextInt(5) methods returns a integer between 0 and 4
         * 0 is inclusive and 4 is exclusive. To get integer between 1 and 5,
         * we add 1 to the random.nextInt(5) method.
         *
         */
        Random random = new Random();
        int randomInt = 2 * (random.nextInt(5) + 1);

        /*
         * Prompt user to answer the question and add the given random integer
         * and answer to the arraylist.
         */
        Scanner keyboard = new Scanner(System.in);
        System.out.print("What is half of " + randomInt + " ? ");
        randomList.add(randomInt);
        int userInputHalf = keyboard.nextInt();
        answerList.add(userInputHalf);

        /*
         * Display user with answers they just entered in,
         * and call the getHalfValue() method with variables of
         * randomInt and userInputHalf being passing in.
         */
        System.out.println("You answered: " + userInputHalf);
        getHalfValue(randomInt, userInputHalf);

         //Prompt user to enter Y or N for another random number
        keyboard = new Scanner(System.in);
        System.out.print("Another number? ");
        String userInput = keyboard.nextLine();

        String nextRound = Character.toString('Y');

        /*
         * While loop will continue displaying questions and their answers
         * as long as user didn't enter in N.
         * Random number will add into the Arraylist named randomList,
         * All entered answers will add into the ArrayList name answerList.
         *
         * While loop stopped when user enter in N for question of Another number.
         * When the while loop stops, user will get a message of game over,
         * the number of questions they answered, the number of correct and wrong
         * answers, their percentage grade of how many correct answers out
         * of total answers, the given highest random and lowest random number.
         */
        while (userInput.equals(nextRound)) {
            randomInt = 2 * (random.nextInt(5) + 1);
            System.out.print("\nWhat is half of " + randomInt + " ? ");
            randomList.add(randomInt);
            keyboard = new Scanner(System.in);
            userInputHalf = keyboard.nextInt();
            answerList.add(userInputHalf);
            System.out.println("You answered: " + userInputHalf);
            getHalfValue(randomInt, userInputHalf);

            keyboard = new Scanner(System.in);
            System.out.print("Another number? ");
            userInput = keyboard.nextLine();
        }
        System.out.println("\nGame over");
        System.out.println("You answered " + answerList.size() + " questions");
        System.out.println(correctList.size() + " were right");
        System.out.println(wrongList.size() + " were wrong");
        getPercentageGrade(correctList, answerList);
        getHighestRandomNumber(randomList);
        getLowestRandomNumber(randomList);
    }

    /*
     * getHalfValue() method takes in integer variables of randomInt
     * and userInputHalf. Variable halfValue has the answer of half of
     * the random number. This method used variable halfValue to compare to
     * answers from users and tells user whether their answer are correct
     * or not.
     */
    public static void getHalfValue(int randomInt, int userInputHalf) {
        int halfValue = randomInt / 2;
        if (userInputHalf == halfValue) {
            correctList.add(userInputHalf);
            System.out.println("Correct!");
        }
        else {
            wrongList.add(userInputHalf);
            System.out.println("Wrong!");
        }
    }

    /*
     * getPercentageGrade method gets user's percentage grade by using
     * ((correctAnswer / totalAnswer) * 100). Then use (int) percentageGrade
     * to convert the double variable into integer type.
     */
    public static void getPercentageGrade(ArrayList correctList, ArrayList answerList) {
        double percentageGrade;
        double correctAnswer = Double.valueOf(correctList.size());
        double totalAnswer = Double.valueOf(answerList.size());

        percentageGrade = ((correctAnswer / totalAnswer) * 100);
        System.out.println("You got " + (int) percentageGrade + "% right");
    }

    /*
     * getHighestRandomNumber method displays the highest random number
     * that were given to the user. It used Collections.max(randomList)
     * to get the highest integer from the arraylist of randomList.
     */
    public static void getHighestRandomNumber(ArrayList randomList) {
        System.out.println("The highest random number you were given: " + Collections.max(randomList));
    }

    /*
     * getLowestRandomNumber method displays the lowest random number
     * that were given to the user. It used Collections.min(randomList)
     * to get the lowest integer from the arraylist of randomList.
     */
    public static void getLowestRandomNumber(ArrayList randomList) {
        System.out.println("The highest random number you were given: " + Collections.min(randomList));
    }

}
