import java.util.LinkedList;

public class FloatStack {
    private LinkedList<Float> stack = new LinkedList<>();

    public void push(float element) {
        stack.addFirst(element);
    }

    public float pop() {
        if (isEmpty()) {
            throw new IllegalStateException("Stack is empty");
        }
        return stack.removeFirst();
    }

    public boolean isEmpty() {
        return stack.isEmpty();
    }

    public int size() {
        return stack.size();
    }
}
