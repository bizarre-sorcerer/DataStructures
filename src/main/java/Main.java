import datastructures.collections.stack.MyStack;

public class Main {

    public static void main(String[] args) {
        MyStack<Integer> stack = new MyStack<>();

        stack.push(1);
        stack.push(2);
        stack.push(3);

        stack.pop();
        stack.pop();
        stack.pop();

        System.out.println(stack);
    }
}
