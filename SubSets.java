import java.util.ArrayList;
import java.util.List;

public class SubSets {
    public static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(nums, 0, result, new ArrayList<>());
        return result;
    }
    private static void backtrack(int[] nums, int index, List<List<Integer>> result, List<Integer> temp) {
        result.add(new ArrayList<>(temp));
        for (int i = index; i < nums.length; i++) {
            temp.add(nums[i]);
            backtrack(nums, i + 1, result, temp);
            temp.remove(temp.size() - 1);
        }
    }
    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        List<List<Integer>> subsets = subsets(nums);
        for (List<Integer> subset : subsets) {
            for (int i : subset) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }
}
