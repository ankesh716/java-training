class FreqStack {
    HashMap<Integer, Integer> freq = new HashMap<>();
    HashMap<Integer, Stack<Integer>> stack = new HashMap<>();
    int max = 0;

    public FreqStack() {
    }

    public void push(int val) {
        int f = freq.getOrDefault(val, 0) + 1;
        freq.put(val, f);

        if (!stack.containsKey(f))
            stack.put(f, new Stack<>());

        stack.get(f).push(val);

        max = Math.max(max, f);
    }

    public int pop() {
        int val = stack.get(max).pop();

        freq.put(val, freq.get(val) - 1);

        if (stack.get(max).isEmpty())
            max--;

        return val;
    }
}

/**
 * Your FreqStack object will be instantiated and called as such:
 * FreqStack obj = new FreqStack();
 * obj.push(val);
 * int param_2 = obj.pop();
 */