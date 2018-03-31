/**
 * This is a class that tests the Deck class.
 */
public class DeckTester {
	/**
	 * The main method in this class checks the Deck operations for consistency.
	 *	@param args is not used.
	 */
	public static void main(String[] args) {
    		String suit[] = {"Heart", "Diamond"};
    		String rank[] = {"Jack", "1", "2"};
    		int values[] = {1, 2, 3};
    		Deck a = new Deck(suit, rank, values);
    		System.out.println(a.size());
    		System.out.println(a.deal());
    		System.out.println(a.isEmpty());
	}
}
