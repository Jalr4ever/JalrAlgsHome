package jindian;

import java.util.*;

class SortStack {
    public static void main(String[] args) {
        int[] aa = { 2, 3, 4, 1 };
        new SortStack().twoStacksSort(aa);

    }

    public ArrayList<Integer> twoStacksSort(int[] numbers) {

        ArrayList<Integer> result = new ArrayList<>();
        Stack<Integer> originalStack = new Stack<>();
        Stack<Integer> helpStack = new Stack<>();

        for (int i = numbers.length - 1; i >= 0; i--) {
            originalStack.push(numbers[i]);
        }

        while (!originalStack.isEmpty()) {
            int current = originalStack.pop();

            while (!helpStack.isEmpty() && current < helpStack.peek()) {
                originalStack.push(helpStack.pop()); // 保证放到 helpStack 的往下看都是从大到小的
            }

            helpStack.push(current);
        }

        while (!helpStack.isEmpty()) {
            result.add(helpStack.pop());
        }

        return result;
    }

}