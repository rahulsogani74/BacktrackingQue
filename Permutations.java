import java.util.ArrayList;
import java.util.List;
public class Permutations {
    public static void main(String[] args) {
        List<List<Integer>> permutations = permute(new int[]{1, 2, 3});
        for (List<Integer> permutation : permutations) {
            System.out.println(permutation);
        }
    }
    private static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> permutations = new ArrayList<>();
        backtrack(nums, new ArrayList<>(), permutations);
        return permutations;
    }
    private static void backtrack(int[] nums, List<Integer> currentPermutation, List<List<Integer>> permutations) {
        if (currentPermutation.size() == nums.length) {
            permutations.add(new ArrayList<>(currentPermutation));
        } else {
            for (int i = 0; i < nums.length; i++) {
                if (currentPermutation.contains(nums[i])) {
                    continue;
                }
                currentPermutation.add(nums[i]);
                backtrack(nums, currentPermutation, permutations);
                currentPermutation.remove(currentPermutation.size() - 1);
            }
        }
    }
}