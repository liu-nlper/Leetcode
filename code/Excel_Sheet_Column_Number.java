/**
 * Created by ljx on 17-7-18.
 *
 * Given a column title as appear in an Excel sheet, return its corresponding column number.

 For example:

 A -> 1
 B -> 2
 C -> 3
 ...
 Z -> 26
 AA -> 27
 AB -> 28
 */
public class Excel_Sheet_Column_Number {

    public int titleToNumber(String s) {
        int result = 0;
        for (int i=s.length()-1; i>=0; --i) {
            result += (s.charAt(i) - 'A' + 1) * Math.pow(26, s.length()-i-1);
        }
        return result;
    }

    public static void main(String[] args) {
        Excel_Sheet_Column_Number escn = new Excel_Sheet_Column_Number();
        int result = escn.titleToNumber("AB");
        System.out.println(result);
    }
}
