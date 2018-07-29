/*
    MVStack.java

    A custom utility class implementing a stack data structure
 */

package mindvision.utilities;

import java.util.*;

public class MVStack<T> {

    private ArrayList<T> stack;
    private boolean setCapacity = false;
    private int capacity = -1;

    public MVStack() {
        stack = new ArrayList<T>();
    }

    public MVStack(int capacity) {
        stack = new ArrayList<T>(capacity);
        setCapacity = true;
        this.capacity = capacity;
    }

    public void push(T item) {
        if (!setCapacity || stack.size() < capacity) {
            stack.add(item);
        }
    }

    public T pop() {
        try {
            return stack.remove(stack.size() - 1);
        } catch (IndexOutOfBoundsException e) {
            return null;
        }
    }

    public T get(int index) throws IndexOutOfBoundsException {
        return stack.get(index);
    }

    public boolean remove(T item) {
        return stack.remove(item);
    }

    public void shuffle() {
        Collections.shuffle(stack);
    }

    public int size() {
        return stack.size();
    }
}