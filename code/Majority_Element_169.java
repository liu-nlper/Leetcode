import java.util.HashMap;
import java.util.Map;

/**
 * Created by ljx on 17-7-19.
 *
 * Given an array of size n, find the majority element. The majority element is the element that appears more than ⌊ n/2 ⌋ times.

   You may assume that the array is non-empty and the majority element always exist in the array.
 */
public class Majority_Element_169 {

    /***
     * 解法１：设置hashmap计数
     */
    public int majorityElement(int[] nums) {
        int half = nums.length / 2;
        Map<Integer, Integer> intMap = new HashMap<>();
        for (int num : nums) {
            intMap.put(num, 1 + intMap.getOrDefault(num, 0));
            if (intMap.get(num) > half)
                return num;
        }
        return -1;
    }

    /**
     * 解法2: Moore Voting算法
     */
    public int majorityElement_2(int[] nums) {
        int major = nums[0], count = 1;
        for (int i=1; i<nums.length; ++i) {
            if (count == 0) {
                ++ count;
                major = nums[i];
            } else if (major == nums[i]) {
                ++ count;
            } else {
                -- count;
            }
        }
        return major;
    }

    public static void main(String[] args) {
        Majority_Element_169 me = new Majority_Element_169();
        int[] nums = {3, 3, 5, 3, 6};
        int m = me.majorityElement_2(nums);
        System.out.println(m);
    }
}
