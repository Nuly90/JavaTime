import java.util.Arrays;
import java.util.Random;

// The shoe is the pool of cards
public class Shoe {
	
	// The properties of Shoe are:
	// Number of decks (integer)
	public Integer decks;
	
	// Order of cards (vector)
	public Integer[] cards;
	
	// The GUI stretch goal will also include a property for the skin of the cards
	// For now it will just be a string array
	public String[] cardstrings = new String[52];
	
	// Give Shoe a constructor to define number of decks and fill cardstrings
	public Shoe(Integer numdecks) {
		
		// Define decks
		decks = numdecks;
		
		// Fill cardstrings
		String[] suits = {"c", "d", "h", "s"};
		int i = 0;
		int k = 0;
		while (i < 4) {
			k = 0;
			while (k < 13) {
				cardstrings[(i * 13) + k] = String.format("%1$s%2$d",suits[i], k+1);
				k++;
			}
			i++;
		}
		
	}
	
	// The methods of Shoe are:
	// Shuffle (Fills cards with a randomized order)
	public void shuffle() {
		Random rand = new Random();
		
		// Replace cards with an array with decks * 52 slots
		int numcards = decks * 52;
		cards = new Integer[numcards];
		Arrays.fill(cards, 0);
		
		// Loop while there is room in cards
		int length = 0;
		while (length < numcards) {
			
			// Create a random integer "next"
			Integer next = rand.nextInt(52) + 1;
			
			// Find the number of instances of next in cards "instances"
			int i = 0;
			int elements = 0;
			while (i < numcards) {
				if (cards[i] > 0) {
					elements++;
				}
				i++;
			}
			Integer instances = 0;
			i = 0;
			while (i < elements) {
				if (cards[i] == next) {
					instances++;
				}
				i++;
			}
			
			// if instances < decks, append next to cards and increment length
			if (instances < decks) {
				cards[length] = next;
				length++;
			}
			
		}
		
		// Swap last card into random place in deck
		Integer last = cards[numcards - 1];
		int spot = rand.nextInt(numcards);
		cards[numcards - 1] = cards[spot];
		cards[spot] = last;

	}
	
	// Draw (Returns the last element of cards and removes it)
	public String draw() {
		
		// Validate that there is at least one element in Shoe
		Integer cardnum = 0;
		String card = "Out of cards";
		int i = 0;
		int k = 0;
		int numcards = decks * 52;
		while (i < numcards) {
			if (cards[i] > 0) {
				k++;
			}
			i++;
		}
		if (k > 0) {
		
			// give card the value of the last element in Shoe
			cardnum = cards[k-1];
			card = cardstrings[cardnum - 1];
		
			// Delete the last element in Shoe
			cards[k-1] = 0;
		
		}
		
		return card;
	}

}
