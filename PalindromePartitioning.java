import java.util.*;
public class PalindromePartitioning {
    public List<List<String>> partition(String s) {
        List<List<String>>ans = new ArrayList();
        back(s, new ArrayList(), 0, ans);
        return ans;
    }
    public void back(String s, List<String> temp, int index,List<List<String>> ans ){
        if(s.length()==index){
            ans.add(new ArrayList(temp));
        }else{
            for(int i= index+1; i<=s.length(); i++){
                String k = s.substring(index, i);
                if(valid(k)){
                    temp.add(k);
                    back(s,temp,i,ans);
                    temp.remove(temp.size()-1);
                }
            }
        }
    }
    public boolean valid(String s){
        int start=0;
        int end=s.length()-1;
        while(start<end){
            if(s.charAt(start) != s.charAt(end)){
                return false;
            }
            start++;
            end--;
        }
        return true;
    }
    public static void main(String[] args) {
        PalindromePartitioning solution = new PalindromePartitioning();
        String input = "aab";
        List<List<String>> partitions = solution.partition(input);
        for (List<String> partition : partitions) {
            System.out.println(partition);
        }
    }
}
