import java.util.*;

public class Solution {
    public int[] solution(int[] A, int Y) {
        Set<Integer> seen = new HashSet<>();

        for (Integer num : A) {
            seen.add(num);  // Step 1: Add current number to set}
        }

        Arrays.sort(A);  // Step 2: Sort the array
        for (int num : A) {
            int complement = Y - num;
            seen.remove(num);  // Step 3: Remove current number from set
            if (seen.contains(complement)) {
                return new int[]{num, complement};
            }
            seen.add(num);  // Step 4: Add it back to the set
        }
        return result;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] A = {1, 2, 3, 4, 5};
        int Y = 6;
        int[] result = solution.solution(A, Y);
        System.out.println(Arrays.toString(result)); // Output: [1, 5] or [2, 4]
    }
}