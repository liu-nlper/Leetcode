/**
 * Created by ljx on 17-7-14.
 *
   Given a word, you need to judge whether the usage of capitals in it is right or not.

   We define the usage of capitals in a word to be right when one of the following cases holds:

   All letters in this word are capitals, like "USA".
   All letters in this word are not capitals, like "leetcode".
   Only the first letter in this word is capital if it has more than one letter, like "Google".
   Otherwise, we define that this word doesn't use capitals in a right way.

   Example 1:
     Input: "USA"
     Output: True

   Example 2:
     Input: "FlaG"
     Output: False

   Note: The input will be a non-empty word consisting of uppercase and lowercase latin letters.
 */
public class Detect_Capital_520 {
    public Detect_Capital_520() {}

    /***
     * 思路：若word长度为1，，返回true
     *   计算word中大写字母的数量，若数量为１：判断首字母是否是大写，若是大写，返回true，否则返回false
     *   若大写字母数量大于1，判断数量是否等于word长度，若等于word长度，返回true，否则，返回false
     */
    public boolean detectCapitalUse(String word) {
        if (word.length() == 1)
            return true;
        char c;
        int upperCount = 0;  // 大写字母的数量
        for (int i=0; i<word.length(); ++i) {
            c = word.charAt(i);
            if (c >= 'A' && c <= 'Z') {
                upperCount += 1;
            }
        }
        if (upperCount == 1) {
            if (isUpper(word.charAt(0)))
                return true;
            return false;
        } else {
            if (upperCount == word.length() || upperCount == 0)
                return true;
            return false;
        }
    }

    private boolean isUpper(char c) {
        if (c >= 'A' && c <= 'Z')
            return true;
        return false;
    }

    public static void main(String[] args) {
        String word = "GGG";
        System.out.println(new Detect_Capital_520().detectCapitalUse(word));
    }
}
