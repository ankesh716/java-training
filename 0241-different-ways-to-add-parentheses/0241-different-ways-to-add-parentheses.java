class Solution {
    public List<Integer> diffWaysToCompute(String s) {
        List<Integer> ans = new ArrayList<>();

        for (int i = 0; i < s.length(); i++) {
            char op = s.charAt(i);

            if (op == '+' || op == '-' || op == '*') {
                List<Integer> left = diffWaysToCompute(s.substring(0, i));
                List<Integer> right = diffWaysToCompute(s.substring(i + 1));

                for (int a : left) {
                    for (int b : right) {
                        if (op == '+') ans.add(a + b);
                        if (op == '-') ans.add(a - b);
                        if (op == '*') ans.add(a * b);
                    }
                }
            }
        }

        if (ans.isEmpty())
            ans.add(Integer.parseInt(s));

        return ans;
    }
}