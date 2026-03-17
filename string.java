import java.util.*;

public class string {
    // question 26

     public static void question26() {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a string: ");
        String input = sc.nextLine();

        String result = moveHashes(input);
        System.out.println("Output: " + result);
    }

    // Function to move '#' to end
    public static String moveHashes(String str) {
        StringBuilder nonHash = new StringBuilder();
        int hashCount = 0;

        for (char ch : str.toCharArray()) {
            if (ch == '#') {
                hashCount++;
            } else {
                nonHash.append(ch);
            }
        }

        for (int i = 0; i < hashCount; i++) {
            nonHash.append('#');
        }

        return nonHash.toString();
    }

    // question 27 

     public static void question27() {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter month (1-12): ");
        int month = sc.nextInt();

        String season = getSeason(month);
        System.out.println(season);
    }

  
    public static String getSeason(int month) {
        if (month < 1 || month > 12) {
            return "Invalid Month Entered";
        }

         switch (month) {
            case 3: case 4: case 5:
                return "Season: Spring";
            case 6: case 7: case 8:
                return "Season: Summer";
            case 9: case 10: case 11:
                return "Season: Autumn";
            case 12: case 1: case 2:
                return "Season: Winter";
            default:
                return "Invalid Month Entered"; 
        }
    }

    // question 28

     public static void question28() {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of steps: ");
        int n = sc.nextInt();

        System.out.print("Enter sequence of steps (U/D): ");
        String steps = sc.next();

        int result = countValleys(n, steps);
        System.out.println("Number of Valleys: " + result);
    }

    // Function to count valleys
    public static int countValleys(int n, String steps) {
        int level = 0;   // sea level
        int valleys = 0;

        for (char step : steps.toCharArray()) {
            if (step == 'U') {
                level++;
                if (level == 0) { // just came up to sea level
                    valleys++;
                }
                 } else if (step == 'D') {
                level--;
            }
        }

        return valleys;
    }

    // question 29 

     public static void question29() {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a string: ");
        String input = sc.nextLine();

        String result = compressString(input);
        System.out.println("Output: " + result);
    }

    // Function to compress string
    public static String compressString(String str) {
        StringBuilder sb = new StringBuilder();
        int count = 1;

        for (int i = 1; i <= str.length(); i++) {
            if (i == str.length() || str.charAt(i) != str.charAt(i - 1)) {
                sb.append(str.charAt(i - 1)).append(count);
                count = 1; // reset count
            } else {
                count++;
            }
        }

        return sb.toString();
    }

    // question 30

    public static void question30() {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a string: ");
        String input = sc.nextLine();

        String result = reverseString(input);
        System.out.println("Reversed String: " + result);
    }

    // Function to reverse string manually
    public static String reverseString(String str) {
        char[] chars = str.toCharArray();
        int start = 0, end = chars.length - 1;

        while (start < end) {
            char temp = chars[start];
            chars[start] = chars[end];
            chars[end] = temp;
            start++;
            end--;
        }

        return new String(chars);
    }
     public static String reverseStringBuiltIn(String str) {
        return new StringBuilder(str).reverse().toString();
    }   

    // question 31 

     public static void question31() {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter first string: ");
        String s = sc.nextLine();

        System.out.print("Enter second string: ");
        String t = sc.nextLine();

        boolean result = isAnagram(s, t);
        System.out.println("Are they anagrams? " + result);
    }

    // Function to check anagram using frequency count
    public static boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) return false;

        int[] count = new int[26]; // assuming lowercase letters only

        for (char c : s.toCharArray()) {
            count[c - 'a']++;
        }

        for (char c : t.toCharArray()) {
            count[c - 'a']--;
        }


        for (int val : count) {
            if (val != 0) return false;
        }

        return true;
    }

    // question 32 

     public static void question32() {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a string: ");
        String s = sc.nextLine();

        int result = firstUniqChar(s);
        System.out.println("Index of first unique character: " + result);
    }

    // Function to find first unique character
    public static int firstUniqChar(String s) {
        int[] freq = new int[26]; // assuming lowercase letters only

        // Step 1: Count frequency
        for (char c : s.toCharArray()) {
            freq[c - 'a']++;
        }

        // Step 2: Find first unique
        for (int i = 0; i < s.length(); i++) {
            if (freq[s.charAt(i) - 'a'] == 1) {
                return i;
            }
        }

        return -1;
    }

    // question 33 

     public static void question33() {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a string: ");
        String s = sc.nextLine();

        char result = firstNonRepeatedChar(s);
        if (result == '\0') {
            System.out.println("No unique character found");
        } else {
            System.out.println("First non-repeated character: " + result);
        }
    }

    public static char firstNonRepeatedChar(String s) {
        Map<Character, Integer> freq = new LinkedHashMap<>();

        
        for (char c : s.toCharArray()) {
            freq.put(c, freq.getOrDefault(c, 0) + 1);
        }
         for (Map.Entry<Character, Integer> entry : freq.entrySet()) {
            if (entry.getValue() == 1) {
                return entry.getKey();
            }
        }

        return '\0';
    }

    // question 34 

     public static void question34() {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a string: ");
        String s = sc.nextLine();

        boolean result = isPalindrome(s);
        System.out.println("Is Palindrome? " + result);
    }

    // Function to check palindrome
    public static boolean isPalindrome(String s) {
        int start = 0;
        int end = s.length() - 1;

        while (start < end) {
            if (s.charAt(start) != s.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }

        return true;
    }

    // question 35 

    public static void question35() {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a string: ");
        String s = sc.nextLine();

        String result = longestPalindrome(s);
        System.out.println("Longest Palindromic Substring: " + result);
    }

    // Expand Around Center approach
    public static String longestPalindrome(String s) {
        if (s == null || s.length() < 1) return "";

        int start = 0, end = 0;

        for (int i = 0; i < s.length(); i++) {
            int len1 = expandFromCenter(s, i, i);     // odd length
            int len2 = expandFromCenter(s, i, i + 1); // even length
            int len = Math.max(len1, len2);

            if (len > end - start) {
                start = i - (len - 1) / 2;
                end = i + len / 2;
            }
        }


        return s.substring(start, end + 1);
    }

    
    private static int expandFromCenter(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        return right - left - 1; // length of palindrome
    }

    // question 36 

    public static void question36() {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of strings: ");
        int n = sc.nextInt();
        sc.nextLine(); // consume newline

        String[] strs = new String[n];
        System.out.println("Enter the strings:");
        for (int i = 0; i < n; i++) {
            strs[i] = sc.nextLine();
        }

        String result = longestCommonPrefix(strs);
        System.out.println("Longest Common Prefix: \"" + result + "\"");
    }

    
    public static String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) return "";

        String prefix = strs[0];

        for (int i = 1; i < strs.length; i++) {
               while (strs[i].indexOf(prefix) != 0) {
                prefix = prefix.substring(0, prefix.length() - 1);
                if (prefix.isEmpty()) return "";
            }
        }

        return prefix;
    }

    // question 37 

     public static void question37() {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter first string (s): ");
        String s = sc.nextLine();

        System.out.print("Enter second string (goal): ");
        String goal = sc.nextLine();

        boolean result = rotateString(s, goal);
        System.out.println("Can s be rotated to goal? " + result);
    }

   
    public static boolean rotateString(String s, String goal) {
        if (s.length() != goal.length()) return false;
        String doubled = s + s;
        return doubled.contains(goal);
    }
// question 38 

 public static void question38() {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a string: ");
        String s = sc.nextLine();

        int result = lengthOfLongestSubstring(s);
        System.out.println("Length of longest substring without repeating characters: " + result);
    }

    // Sliding Window approach
    public static int lengthOfLongestSubstring(String s) {
        Set<Character> set = new HashSet<>();
        int left = 0, maxLength = 0;

        for (int right = 0; right < s.length(); right++) {
            while (set.contains(s.charAt(right))) {
                set.remove(s.charAt(left));
                left++;
            }
            set.add(s.charAt(right));
            maxLength = Math.max(maxLength, right - left + 1);
        }

        return maxLength;
    }



    public static void main(String[] args) {
        question26(); 
        question27();
        question28();
        question29();
        question30();
        question31();
        question32();
        question33();
        question34();
        question35();
        question36();
        question37();
        question38();
      
                
    }
}
    

