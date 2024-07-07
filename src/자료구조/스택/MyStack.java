package 자료구조.스택;

import java.util.Arrays;
import java.util.EmptyStackException;

public class MyStack<E> {
    // 생성자로 생성
    // 관련

    private static final int CAPACITY = 6;
    private Object[] arr;
    private int top;

    public MyStack(){
        arr = new Object[CAPACITY];
        top = -1;
    }

    public boolean isFull(){
        return top == arr.length - 1;
    }

    public boolean isEmpty(){
        return top == -1;
    }

    private void resize(){
        int arr_capacity = arr.length -1;
        if(top == arr_capacity){
            int new_capacity = arr.length * 2;
            arr = Arrays.copyOf(arr, new_capacity);
            return;
        }
        if(top < (arr_capacity / 2)){
            int half_capacity = arr.length / 2;
            arr = Arrays.copyOf(arr, Math.max(half_capacity, CAPACITY));
            return;
        }
    }

    public E push(E value){
        if(isFull()) resize();
        top += 1;
        arr[top] = value;
        return value;
    }

    @SuppressWarnings("unchecked")
    public E pop(){
        if(isEmpty()) throw new EmptyStackException();
        E value = (E)arr[top];
        top -= 1;
        resize();
        return value;
    }

    @SuppressWarnings("unchecked")
    public E peek(){
        if(isEmpty()) throw new EmptyStackException();
        return (E) arr[top];
    }

    public int search(E value){
        for(int i = top; i >= 0; i--){
            if(arr[i].equals(value)){
                return top - i + 1;
            }
        }
        return -1;
    }

    @Override
    public String toString(){
        return Arrays.toString(arr);
    }
}
