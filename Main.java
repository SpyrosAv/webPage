// AVOURIS SPYRIDON 321/2017001
// EXERCISE 1 

package exercise1;

import java.util.Scanner;

// Orimsos klashs Main
public class Main {

    public static void main(String[] args) throws Exception {

        FilioiThread th;
        int usersNumber;
        int begin = 0;
        Scanner scan = new Scanner(System.in);

        // Anagnwsh arithmou thread pou epithymei o xrhsths
        System.out.println("Enter the number of "
                + "threads (1-16) you wish the programme to have: ");
        usersNumber = scan.nextInt();

        while (usersNumber < 1 || usersNumber > 16) {
            System.out.println("Wrong number. Try again: ");
            usersNumber = scan.nextInt();
        }
        System.out.println("------------START------------");
        System.out.println("Please wait for the results...\n\n");
        
        // Dhmiourgia toswn thread oswn eishgage o xrhsths
        for (int i = 1; i <= usersNumber; i++) {
            new FilioiThread(begin, i / usersNumber).start();
            begin = i / usersNumber;
        }
    }
}
