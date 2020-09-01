/*
 * Name: JiaJia Liu
 * Email: JPL5840@psu.edu
 * Course: IST 261
 * Assignment: IA01
 */

package com.company;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
import java.util.Collections;

public class Main {
    public static ArrayList<Integer> answerList = new ArrayList<Integer>();
    public static ArrayList<Integer> correctList = new ArrayList<Integer>();
    public static ArrayList<Integer> wrongList = new ArrayList<Integer>();
    public static ArrayList<Integer> randomList = new ArrayList<Integer>();

    public static void main(String[] args) {
        System.out.println("Name: JiaJia Liu");
        System.out.println("Email: JPL5840@psu.edu");
        System.out.println("Course: IST 261");
        System.out.println("Assignment: IA01");

        Random random = new Random();
        
        /*
         * We multiple 2 to random.nextInt(5) + 1 which double the integers
         * between 1 and 5 and returns integers between 2 and 10.
         *
         * Random.nextInt(5) methods returns a integer between 0 and 4
         * 0 is inclusive and 4 is exclusive. To get integer between 1 and 5,
         * we add 1 to the random.nextInt(5) method.
         *
         */
        int randomInt = 2 * (random.nextInt(5) + 1);

        Scanner keyboard = new Scanner(System.in);
        System.out.print("What is half of " + randomInt + " ? ");
        randomList.add(randomInt);
        int userInputHalf = keyboard.nextInt();
        answerList.add(userInputHalf);
        System.out.println("You answered: " + userInputHalf);
        getHalfValue(randomInt, userInputHalf);

        keyboard = new Scanner(System.in);
        System.out.print("Another number? ");
        String userInput = keyboard.nextLine();

        String nextRound = Character.toString('Y');
        String endRound = Character.toString('N');

        while(userInput.equals(nextRound)){
                randomInt = 2 * (random.nextInt(5) + 1);
                System.out.print("What is half of " + randomInt + " ? ");
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
        System.out.println("Game over");
        System.out.println("You answered " + answerList.size() + " questions");
        System.out.println(correctList.size() + " were right");
        System.out.println(wrongList.size() + " were wrong");
        getPercentageGrade(correctList, answerList);
        getHighestRandomNumber(randomList);
        getLowestRandomNumber(randomList);


    }
    public static void getHalfValue(int randomInt, int userInputHalf){
        int halfValue = randomInt / 2;
        if (userInputHalf == halfValue){
            correctList.add(userInputHalf);
            System.out.println("Correct!");
        }else {
            wrongList.add(userInputHalf);
            System.out.println("Wrong!");
        }
    }

    public static void getPercentageGrade(ArrayList correctList, ArrayList answerList) {
        //double percentageGrade = 0.0d;
        double percentageGrade;
        double correctAnswer = Double.valueOf(correctList.size());
        double totalAnswer = Double.valueOf(answerList.size());

        percentageGrade = ((correctAnswer / totalAnswer) * 100);
        //int percentageTotalGrade = (int)percentageGrade;
        System.out.println("You got " + (int)percentageGrade + "% right");
    }

    public static void getHighestRandomNumber(ArrayList randomList){
        System.out.println( "The highest random number you were given: " + Collections.max(randomList));
    }
    public static void getLowestRandomNumber(ArrayList randomList){
        System.out.println( "The highest random number you were given: " + Collections.min(randomList));
    }

}
