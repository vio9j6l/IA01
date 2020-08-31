/*
 * Name: JiaJia Liu
 * Email: JPL5840@psu.edu
 * Course: IST 261
 * Assignment: IA01
 */

package com.company;
import java.util.Random;

public class Main {

    public static void main(String[] args) {
        System.out.println("Name: JiaJia Liu");
        System.out.println("Email: JPL5840@psu.edu");
        System.out.println("Course: IST 261");
        System.out.println("Assignment: IA01");

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
        System.out.println(randomInt);

    }
}
