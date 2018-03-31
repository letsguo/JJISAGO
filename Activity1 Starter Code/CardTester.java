/**
 * This is a class that tests the Card class.
 */
public class CardTester {

    /**
     * The main method in this class checks the Card operations for consistency.
     *  @param args is not used.
     */
    public static void main(String[] args) {
        Card cardiB = new Card("3", "Heart", 5);
        Card cardA = new Card("7", "Spade", 9);
        Card check = new Card("7", "Spade", 9);
        Card cardC = new Card("5", "Diamond", 7);
        System.out.println(cardC.toString()); 
        System.out.println(cardA.matches(check));;

        
    }
}

