import java.util.ArrayList;
import java.util.List;

/**
 * Created by ljx on 17-7-14.
 *
 * Given an array of integers where 1 ≤ a[i] ≤ n (n = size of array), some elements
 * appear twice and others appear once.
 *
 * Find all the elements of [1, n] inclusive that do not appear in this array.
 *
 * Could you do it without extra space and in O(n) runtime? You may assume the
 * returned list does not count as extra space.
 *
 * Example:
 *   Input:
 *     [4,3,2,7,8,2,3,1]
 *   Output:
 *     [5,6]
 */
public class Find_All_Numbers_Disappeared_in_an_Array_448 {

    /***
     * 思路：由于nums中所有整数是在[1,n]之间的，考虑将这些数字-1为下标的nums处的值加n，
     * 　　　那么出现在[1,n]间的数字至少被加了一次，而那些没有出现的数字-1的下标处的值
     * 　　　必定小于或者等于n.
     */
    public List<Integer> findDisappearedNUmber(int[] nums) {
        List<Integer> list = new ArrayList<>();
        int n = nums.length;
        for (int i=0; i<n; ++i) {
            nums[(nums[i]-1) % n] += n;
        }
        for (int i=0; i<n; ++i) {
            if (nums[i] <= n)
                list.add(i+1);
        }
        return list;
    }

    public static void main(String[] args) {
        int[] nums = {4,3,2,7,8,2,3,1};
        System.out.println(new Find_All_Numbers_Disappeared_in_an_Array_448().findDisappearedNUmber(nums));
    }
}
