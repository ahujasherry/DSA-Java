class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();

        for (String c : tokens) {
            if (c.equals("+")) {
                int second = stack.pop();
                int first = stack.pop();
                long result = (long) first + (long) second;
                if (result > Integer.MAX_VALUE || result < Integer.MIN_VALUE) {
                    throw new ArithmeticException("Integer overflow in addition");
                }
                stack.push((int) result);
            } else if (c.equals("-")) {
                int second = stack.pop();
                int first = stack.pop();
                stack.push(first - second);
            } else if (c.equals("*")) {
                int second = stack.pop();
                int first = stack.pop();
                long result = (long) first * (long) second;
                if (result > Integer.MAX_VALUE || result < Integer.MIN_VALUE) {
                    throw new ArithmeticException("Integer overflow in multiplication");
                }
                stack.push((int) result);
            } else if (c.equals("/")) {
                int second = stack.pop();
                int first = stack.pop();
                stack.push(first / second);
            } else {
                stack.push(Integer.parseInt(c));
            }
        }

        return stack.peek();
    }
}
