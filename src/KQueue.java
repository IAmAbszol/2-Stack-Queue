import java.util.Stack;

public class KQueue {

    private Stack<Integer> stackA;
    private Stack<Integer> stackB;

    public KQueue() {
        stackA = new Stack<Integer>();
        stackB = new Stack<Integer>();
    }

    // Worst case O(n), Best case O(1) --> *CONST*
    public void add(int i) {
        if (stackA.isEmpty()) {
            if (stackB.isEmpty()) {
                stackA.push(i);
                return;
            }
            while(!stackB.isEmpty()) {
                stackA.push(stackB.pop());
            }
        }
        stackA.push(i);
    }

    // Worst case O(n), Best case O(1) --> *CONST*
    public int poll() {
        // in order
        if(!stackB.isEmpty()) {
            return stackB.pop();
        } else
            while(!stackA.isEmpty()) {
                stackB.push(stackA.pop());
            }
        return stackB.pop();
    }

    // Worst case O(n), Best case O(1) --> *CONST*
    public int peek() {
        // in order
        int tmp = 0;
        if(!stackB.isEmpty()) {
            tmp = stackB.pop();
            stackB.push(tmp);
            return tmp;
        } else
            while(!stackA.isEmpty()) {
                stackB.push(stackA.pop());
            }
        tmp = stackB.pop();
        stackB.push(tmp);
        return tmp;
    }

    public static void main(String[] args) {
        KQueue queue = new KQueue();
        int[] list = { 1, 4, 6, 10, 15 };
        for (int i = 0; i < list.length; i++) {
            queue.add(list[i]);
            if (i % 2 == 0) {
                System.out.println(queue.poll());
            }
        }
        System.out.println("Just peeking : " + queue.peek());
        System.out.println("Grabbing : " + queue.poll());
    }

}