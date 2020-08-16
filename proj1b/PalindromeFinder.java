/** This class outputs all palindromes in the words file in the current directory. */
public class PalindromeFinder {

    public static void main(String[] args) {
        int minLength = 4;
        In in = new In("../library-sp18/data/words.txt");
        Palindrome palindrome = new Palindrome();
        CharacterComparator cc = new OffByN(0);

        while (!in.isEmpty()) {
            String word = in.readString();
            if (word.length() >= minLength && palindrome.isPalindrome(word, cc)) {
                System.out.println(word);
            }
        }
    }

    /** Uncomment this class once you've written isPalindrome.
    *
    * Deque is a interface
     *
     * Array Deque and LinkedListDeque implement this interface
     *
     *
     *
     * In testIsPalindromeCcc() method,
     *
     * 1. obo == an instance of "OffByOne" class, "OffByOne" implement cc, use method "equalChars"
     *
     * 2. palindrome.isPalindrome(word, obo)
     * 	3. isPalindrome(wordToDeque(word), obo)
     * 		4. wordToDeque(word), return a 'Deque'
     * 			5. isPalindrome('Deque', obo)
     * 					6. obo.equalChar
    *
    */

}
