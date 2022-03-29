package tm;

import java.util.HashSet;

/*
Given a dictionary of words, find all strings that match the given pattern where
every character in the pattern is uniquely mapped to a character in the dictionary.

Input:
dict = ["abb", "abc", "xyz", "xyy"];
pattern = "foo"
Output: [xyy abb]
xyy and abb have same character at
index 1 and 2 like the pattern

Input:
dict = ["abb", "abc", "xyz", "xyy"];
pat = "mno"
Output: [abc xyz]
abc and xyz have all distinct characters,
similar to the pattern.
------------
Word='xxyzzaa'
Pattern='mmnoopp'
Step 1-: map['m'] = x
Step 2-: 'm' is already mapped to some value,
check whether that value is equal to current
character of word-:YES ('m' is mapped to x).
Step 3-: map['n'] = y
Step 4-: map['o'] = z
Step 5-: 'o' is already mapped to some value,
check whether that value is equal to current
character of word-:YES ('o' is mapped to z).
Step 6-: map['p'] = a
Step 7-: 'p' is already mapped to some value,
check whether that value is equal to current
character of word-: YES ('p' is mapped to a).
No contradiction so current word matches the pattern
 */
public class Dictionary {
    static boolean check(String pattern, String word)
    {

        if (pattern.length() != word.length())
            return false;

        int[] ch = new int[128];
        int Len = word.length();

        for(int i = 0; i < Len; i++)
        {
            if (ch[(int)pattern.charAt(i)] == 0)
            {
                ch[(int)pattern.charAt(i)] = word.charAt(i);
            }
            else if (ch[(int)pattern.charAt(i)] != word.charAt(i))
            {
                return false;
            }
        }
        return true;
    }

    // Function to print all the
    // strings that match the
    // given pattern where every
    // character in the pattern is
    // uniquely mapped to a character
    // in the dictionary
    static void findMatchedWords(HashSet<String> dict, String pattern)
    {
        // len is length of the pattern
        int Len = pattern.length();

        // For each word in the dictionary
        String result = " ";
        for(String word : dict)
        {
            if (check(pattern, word))
            {
                result = word + " " + result;
            }
        }
        System.out.print(result);
    }

    // Driver code
    public static void main(String[] args) {
        HashSet<String> dict = new HashSet<String>();
        dict.add("abb");
        dict.add("abc");
        dict.add("xyz");
        dict.add("xyy");

        String pattern = "foo";

        findMatchedWords(dict, pattern);
    }
}
