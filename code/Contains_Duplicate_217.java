import java.util.HashSet;
import java.util.Set;

/**
 * Created by ljx on 17-7-19.
 *
 *  Given an array of integers, find if the array contains any duplicates. Your function should return true if any value appears at least twice in the array, and it should return false if every element is distinct.
 */
public class Contains_Duplicate_217 {

    public static void main(String[] args) {
        Contains_Duplicate_217 cd = new Contains_Duplicate_217();
        int[] nums = {1, 2, 3, 1};
        System.out.println(cd.containDuplicate(nums));
    }

    public boolean containDuplicate(int[] nums) {
        if (nums.length == 0)
            return false;
        Set<Integer> numSet = new HashSet<>();
        for (int num : nums) {
            if (!numSet.add(num))
                return true;
        }
        return false;
    }
}
