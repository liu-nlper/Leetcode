import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by ljx on 17-7-17.
 *
 * Suppose Andy and Doris want to choose a restaurant for dinner, and they both have a list of favorite restaurants represented by strings.

   You need to help them find out their common interest with the least list index sum. If there is a choice tie between answers, output all of them with no order requirement. You could assume there always exists an answer.

   Example 1:
   Input:
     ["Shogun", "Tapioca Express", "Burger King", "KFC"]
     ["Piatti", "The Grill at Torrey Pines", "Hungry Hunter Steakhouse", "Shogun"]
   Output: ["Shogun"]
   Explanation: The only restaurant they both like is "Shogun".

   Example 2:
   Input:
     ["Shogun", "Tapioca Express", "Burger King", "KFC"]
     ["KFC", "Shogun", "Burger King"]
   Output: ["Shogun"]
   Explanation: The restaurant they both like and have the least index sum is "Shogun" with index sum 1 (0+1).

   Note:
     1. The length of both lists will be in the range of [1, 1000].
     2. The length of strings in both lists will be in the range of [1, 30].
     3. The index is starting from 0 to the list length minus 1.
     4. No duplicates in both lists.
 */
public class Minimum_Index_Sum_of_Two_Lists_599 {

    public String[] findRestaurant(String[] list1, String[] list2) {
        Map<String, Integer> listMap = new HashMap<>();
        for (int i=0; i<list1.length; ++i) {
            listMap.put(list1[i], -i);
        }
        int index, minIndex = 2000;
        for (int i=0; i<list2.length; ++i) {
            if (listMap.containsKey(list2[i])) {
                index = -listMap.get(list2[i]) + i;
                listMap.put(list2[i], index);
                if (index < minIndex)
                    minIndex = index;
            }
        }
        ArrayList<String> result = new ArrayList<>();
        for (String s : listMap.keySet()) {
            if  (listMap.get(s) == minIndex) {
                result.add(s);
            }
        }
        String[] resultList = new String[result.size()];
        result.toArray(resultList);
        return resultList;
    }

    public static void main(String[] args) {
        String[] list1 = {"Shogun","Tapioca Express","Burger King","KFC"};
        String[] list2 = {"KFC","Burger King","Tapioca Express","Shogun"};
        String[] result = new Minimum_Index_Sum_of_Two_Lists_599().findRestaurant(list1, list2);
        for (String r : result) {
            System.out.println(r);
        }
    }
}
