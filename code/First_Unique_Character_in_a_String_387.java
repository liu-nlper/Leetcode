import java.util.HashMap;
import java.util.Map;

/**
 * Created by ljx on 17-7-18.
 *
 * Given a string, find the first non-repeating character in it and return it's index. If it doesn't exist, return -1.

 Examples:

 s = "leetcode"
 return 0.

 s = "loveleetcode",
 return 2.
 */
public class First_Unique_Character_in_a_String_387 {

    public int firstUniqueChar(String s) {
        Map<Character, Integer> charMap = new HashMap<>();
        char[] chars = s.toCharArray();
        for (char c : chars) {
            charMap.put(c, 1 + charMap.getOrDefault(c, 0));
        }
        for (int i=0; i<chars.length; ++i) {
            if (charMap.get(chars[i]) == 1) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        First_Unique_Character_in_a_String_387 fu = new First_Unique_Character_in_a_String_387();
        int result = fu.firstUniqueChar("loveleetcode");
        System.out.println(result);
    }
}
