            /**
 * This class provides a convenient way to test shuffling methods.
 */
import java.util.*;

public class Shuffler {
    
    /**
     * The number of consecutive shuffle steps to be performed in each call
     * to each sorting procedure.
     */
    private static final int SHUFFLE_COUNT = 2;


    /**
     * Tests shuffling methods.
     * @param args is not used.
     */
    public static void main(String[] args) {
        System.out.println("Results of " + SHUFFLE_COUNT +
                                 " consecutive perfect shuffles:");
        int[] values1 = {0, 1, 2, 3};
        for (int j = 1; j <= SHUFFLE_COUNT; j++) {
            perfectShuffle(values1);
            System.out.print("  " + j + ":");
            for (int k = 0; k < values1.length; k++) {
                System.out.print(" " + values1[k]);
            }
            System.out.println();
        }
        System.out.println();

        System.out.println("Results of " + SHUFFLE_COUNT +
                                 " consecutive efficient selection shuffles:");
        int[] values2 = {0, 1, 2, 3, 5, 6, 7, 8, 98, 7};
        for (int j = 1; j <= SHUFFLE_COUNT; j++) {
            selectionShuffle(values2);
            System.out.print("  " + j + ":");
            for (int k = 0; k < values2.length; k++) {
                System.out.print(" " + values2[k]);
            }
            System.out.println();
        }
        System.out.println();
        flip(); 
    }


    /**
     * Apply a "perfect shuffle" to the argument.
     * The perfect shuffle algorithm splits the deck in half, then interleaves
     * the cards in one half with the cards in the other.
     * @param values is an array of integers simulating cards to be shuffled.
     */
    public static void perfectShuffle(int[] values) {
        int temp[] = new int [values.length];
        int k = 0;
        for (int j = 0; j<(values.length+1)/2; j++){
           temp[j] = values[k];
           k = k+2;
        }
        k = 1;
        for (int j = (values.length+1)/2; j<values.length; j++){
            //shuffled[j] = values [k];
            temp[j] = values[k];
            k = k+2;
        }
        
        for (int x = 0; x< values.length; x++){
            values[x] = temp[x];
        }
    }

    /**
     * Apply an "efficient selection shuffle" to the argument.
     * The selection shuffle algorithm conceptually maintains two sequences
     * of cards: the selected cards (initially empty) and the not-yet-selected
     * cards (initially the entire deck). It repeatedly does the following until
     * all cards have been selected: randomly remove a card from those not yet
     * selected and add it to the selected cards.
     * An efficient version of this algorithm makes use of arrays to avoid
       * searching for an as-yet-unselected card.
     * @param values is an array of integers simulating cards to be shuffled.
     */
    public static void selectionShuffle(int[] values) {
        Random rnd = new Random();
        int a; 
        List<Integer> initialFull = new ArrayList<Integer>();
        int initialempty[] = new int[values.length];
        for (int b = 0; b < values.length; b++){
            initialFull.add(values[b]);
        }
        for (int k = 0 ; k < values.length ; k++){
            if (initialFull.size() > 1){
                a = rnd.nextInt(initialFull.size()-1);
                initialempty[k] = initialFull.get(a);
                initialFull.remove(a);
            } else {
                initialempty[k] = initialFull.get(0);
            }
        }
            
        for (int x = 0; x< values.length; x++){
            values[x] = initialempty[x];
        }
    }
    public static void flip(){
        Random Rn = new Random();
        int a = 6;
        System.out.println("Number of Flips: " + a);
        for (int b = 0; b<a; b++){
            int ran = Rn.nextInt(3);
            if (ran == 0 || ran == 1){
                System.out.println("Heads");
            } else {
                System.out.println("Tails");
            }
        }
    }
    public static boolean arePermutations(){
        int totalOne = 0;
        int totalTwo = 0;
        int aOne[] = {1, 2, 3, 4, 5, 6, 7};
        int aTwo[] = {7, 6, 5, 4, 3, 2, 1};
        for (int k=0; k<aOne.length; k++){
            totalOne += aTwo[k];
            totalTwo += aTwo[k];
        }
        if ((totalOne ==totalTwo) && aOne.length == aTwo.length){
            return true;
        } else {
            return false;
        }
    }
}

