package u3pp;
public class PalindromeTester{

    /**
     * Tests whether a string is a palindrome. Case insensitive. 
     * @param s  the string to test
     * @return true if the string is a palindrome
     */
    public static boolean isPalindrome(String s) {
        boolean answer = false;
        String reverse = "";
        String w = s.toLowerCase();

        
    
            for (int i = w.length() - 1; i >=0; --i){
                reverse = reverse + w.charAt(i);
            }
            if (w.equals(reverse)){
                answer = true;
            }
        return answer;

        
    }

}

// System.out.println ("Please enter a word"); 
// String reverse = "";
// String s = s.nextLine();


// for (int i = s.length() - 1; i >=0; i--){
//     reverse += s.charAt(i);
//     System.out.println (reverse);
// }
// boolean answer = true;
// for (int i = 0; i < s.length(); i++) {
//     if (s.charAt(i) != reverse.charAt(i)) {
//         answer = false;
//         System.out.println (answer);
//     }
// }
// if (answer) {
//     System.out.println("It's a palindrome.");
// } 
// else {
//     System.out.println("It's not a palindrome.");
// }
//make isPalindrome constructor
//create reversed string
//enhanced for loop to run through each letter
//return number of 
//use i++ to run through each letter
//return letters
//use i- - ? to reverse order?
//return letters

//if letters = letters, then return 