import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class LetterCombinationsOfaPhoneNumber {
    public List<String> latterCombinations(String digits){
        List<String> ans = new ArrayList<>();
        if (digits.length() == 0) return ans;

        HashMap<Character, String> hashMap = new HashMap<>();
        hashMap.put('2', "abc");
        hashMap.put('3',"def");
        hashMap.put('4', "ghi");
        hashMap.put('5',"jkl");
        hashMap.put('6', "mno");
        hashMap.put('7',"pqrs");
        hashMap.put('8', "tuv");
        hashMap.put('9',"wxyz");

        backtrack(digits,0,hashMap,new StringBuilder(),ans);
        return ans;
    }

    private static void backtrack(String digits, int i, HashMap<Character, String> hashMap, StringBuilder sb, List<String> ans ){
        if (i == digits.length()){
            ans.add(sb.toString());
            return;
        }
        String curr = hashMap.get(digits.charAt(i));
        for (int k=0; k < curr.length(); k++){
            sb.append(curr.charAt(k));
            backtrack(digits,i+1,hashMap,sb,ans);
            sb.deleteCharAt(sb.length() -1);
        }
    }

    public static void main(String[] args) {
        LetterCombinationsOfaPhoneNumber solution = new LetterCombinationsOfaPhoneNumber();
        String digits = "23";
        List<String> combinations = solution.latterCombinations(digits);
        System.out.println(combinations);
    }
}
