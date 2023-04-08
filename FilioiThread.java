// AVOURIS SPYRIDON 321/2017001
// EXERCISE 1 

package exercise1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//  Orismos ypoklashs FilioiThread me ta aparaithta melh
public class FilioiThread extends Thread {

    protected int first;
    protected int last;

    // Constractor me orismata to evros ths anazhthshs gia to kathe thread
    public FilioiThread(int first, int last) {
        this.first = first;
        this.last = last;
    }

    //  Orismos synarthshs append gia thn prosthiki timwn se pinaka
    private static Integer[] append(Integer[] dieretes1, int element) {
        List<Integer> list = new ArrayList<>(Arrays.asList(dieretes1));
        list.add(element);

        return list.toArray(new Integer[0]);
    }

    // Orismos synarthshs run h opoia anairei thn default synarthsh run twn thread
    @Override
    public void run() {
        int temp = 0, filioi = 0;

        // Arxikopoihsh pinaka apothikeushs athroismatwn tou kathe diaireth
        Integer[] athroismata = {};
        long N = 1000;  // Dhlwsh evrous anazhthshs arithmwn

        // loop anazhthshs diairetwn twn arithmwn apo to 1 mexri to evros
        for (int i = 1; i <= N; i++) {
            int athroisma = 0;
            Integer[] dieretes1 = {};//Arxikopoishsh pinaka apothikeushs diairetwn

            for (int j = 1; j < i; j++) {

                // Ean o arithmos j, diairei akrivws (ypoloipo 0) ton arithmo i, 
                // tote o j einai akeraios diaireths tou i
                if ((i % j) == 0) {
                    dieretes1 = append(dieretes1, j);
                    athroisma = athroisma + j;
                }
            }
            // Prosthiki athroismatos twn diaretwn ston pinaka "athroismata"
            athroismata = append(athroismata, athroisma);

            /*System.out.println("\n" + getName() + " -> Αριθμός: " + i + ",  "
            + "Άθροισμα διαιρετών: " + athroisma);
            
            System.out.println(getName() + " -> Αριθμός : " + i + "\n Οι διαιρέτες του "
            + "" + i + ":" + " \n"
            + " " + Arrays.toString(dieretes1) + " \n\n");*/
            
            // loop gia thn apothikeush tou arithmou twn filiwn pou vrethikan
            for (int x = 0; x < athroismata.length; x++) {
                if (athroismata[x] == i) {
                    filioi++;
                    temp = x;
                } else {
                    x++;
                }
            }
            
            // Kathysterhsh dhmioyrgias kainoyrgiou thread gia thn omalh 
            // leitourgia tou epeksergasth
            try {
                sleep(10);
            } catch (InterruptedException e) {
            }

        }
        System.out.println(" Βρέθηκε " + filioi + " ζευγάρι φίλιων  αριθμών! \n");
        System.out.println("\nΑθροίσματα:\n" + Arrays.toString(athroismata));
    }
}
