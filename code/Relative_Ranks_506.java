/**
 * Created by ljx on 17-7-18.
 *
 * Given scores of N athletes, find their relative ranks and the people with the top three highest scores, who will be awarded medals: "Gold Medal", "Silver Medal" and "Bronze Medal".

   Example 1:
     Input: [5, 4, 3, 2, 1]
     Output: ["Gold Medal", "Silver Medal", "Bronze Medal", "4", "5"]

   Explanation: The first three athletes got the top three highest scores, so they got "Gold Medal", "Silver Medal" and "Bronze Medal".
     For the left two athletes, you just need to output their relative ranks according to their scores.
 */
public class Relative_Ranks {

    public String[] findRelativeRanks(int[] nums) {
        List<int[]> listNums = new ArrayList<>();
        for (int i=0; i<nums.length; ++i)
            listNums.add(new int[] {nums[i], i});
        Collections.sort(listNums, new Comparator<int[]>() {
            @Override
            public int compare(int[] ints, int[] t1) {
                if (ints[0] > t1[0])
                    return -1;
                return 1;
            }
        });
        String[] result = new String[listNums.size()];
        for (int i=0; i<listNums.size(); ++i) {
            if (i == 0)
                result[listNums.get(i)[1]] = "Gold Medal";
            else if (i == 1)
                result[listNums.get(i)[1]] = "Silver Medal";
            else if (i == 2)
                result[listNums.get(i)[1]] = "Bronze Medal";
            else
                result[listNums.get(i)[1]] = "" + (i+1);
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = {10,3,8,9,4};
        Relative_Ranks rr = new Relative_Ranks();
        String[] result = rr.findRelativeRanks(nums);
        for (String s : result) {
            System.out.println(s);
        }
    }
}
