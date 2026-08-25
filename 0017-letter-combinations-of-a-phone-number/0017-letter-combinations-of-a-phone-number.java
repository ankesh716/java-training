class Solution {

    public List<String> letterCombinations(String digits) {

        List<String> result = new ArrayList<>();

        if (digits.length() == 0) {
            return result;
        }

        String[] mapping = {
            "", "", "abc", "def", "ghi",
            "jkl", "mno", "pqrs", "tuv", "wxyz"
        };

        backtrack(digits, 0, "", mapping, result);

        return result;
    }

    private void backtrack(String digits, int index,
                           String current,
                           String[] mapping,
                           List<String> result) {

        if (index == digits.length()) {
            result.add(current);
            return;
        }

        int digit = digits.charAt(index) - '0';
        String letters = mapping[digit];

        for (char ch : letters.toCharArray()) {

            current += ch;

            backtrack(digits, index + 1,
                      current, mapping, result);

            current = current.substring(0, current.length() - 1);
        }
    }
}