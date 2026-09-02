import java.util.*;

class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> ans = new ArrayList<>();
        backtrack(s, 0, new ArrayList<>(), ans);
        return ans;
    }

    void backtrack(String s, int start, List<String> list, List<List<String>> ans) {
        if (start == s.length()) {
            ans.add(new ArrayList<>(list));
            return;
        }

        for (int i = start; i < s.length(); i++) {
            String str = s.substring(start, i + 1);

            if (isPalindrome(str)) {
                list.add(str);
                backtrack(s, i + 1, list, ans);
                list.remove(list.size() - 1);
            }
        }
    }

    boolean isPalindrome(String s) {
        int l = 0, r = s.length() - 1;

        while (l < r) {
            if (s.charAt(l++) != s.charAt(r--))
                return false;
        }

        return true;
    }
}