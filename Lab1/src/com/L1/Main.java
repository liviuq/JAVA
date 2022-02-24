/**
 * This is the Compulsory part of Lab1
 * @author  Petrache Andrei Liviu
 * @group 2A3
 * @version 1.0
 * @since   24 Feb 2022
 */

package com.L1;

public class Main
{
    public static void main(String[] args)
    {
        /**
         * ---------Compulsory---------
         */
        /**
         * Display on the screen the message "Hello World!". Run the application.
         */
        System.out.println("Hello World!");

        /**
         * Define an array of strings languages, containing
         * {"C", "C++", "C#", "Python", "Go", "Rust", "JavaScript", "PHP", "Swift", "Java"}
         */
        String[] languages = {"C", "C++", "C#", "Python", "Go", "Rust", "JavaScript", "PHP", "Swift", "Java"};

        /**
         * Generate a random integer n: int n = (int) (Math.random() * 1_000_000);
         */
        int n = (int) (Math.random() * 1000000);

        /**
         *   multiply n by 3;
         *   add the binary number 10101 to the result;
         *   add the hexadecimal number FF to the result;
         *   multiply the result by 6;
         */
        n = n * 3;
        n = n + 0b10101;
        n = n + 0xFF;
        n = n * 6;
        System.out.printf("%d\n", n);

        /**
         * Compute the sum of the digits in the result obtained in the previous step. This is the new result.
         * While the new result has more than one digit, continue to sum the digits of the result.
         */
        int result = 0;
        do
        {
            while (n != 0)
            {
                result = result + n % 10;
                n = n / 10;
            }
            System.out.printf("result = %d\n", result);
            n = result;
            result = 0;
        }while(n >= 10);
        result = n;

        /**
         * Display on the screen the message:
         * "Willy-nilly, this semester I will learn " + languages[result].
         */
        System.out.printf("Willy-nilly, this semester I will learn " + languages[result] + ".\n");
    }
}
