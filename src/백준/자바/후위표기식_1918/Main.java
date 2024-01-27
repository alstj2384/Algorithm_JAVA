package 백준.자바.후위표기식_1918;

import java.io.*;
import java.util.*;

public class Main {
    private int prec(char op){
        switch(op){
            case '(' : case ')' : return 0;
            case '+' : case '-' : return 1;
            case '*' : case '/' : return 2;
        }
        return -1;
    }
    public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();

        Stack<Character> stack = new Stack<>();

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < s.length(); i++){
            char ch = s.charAt(i);
            switch(ch){
                case '+' : case '-' : case '*' : case '/':
                    while(!stack.isEmpty() && (prec(ch) <= prec(stack.peek())))
                        sb.append(stack.pop());
                    stack.push(ch);
                    break;
                case '(':
                    stack.push(ch);
                    break;
                case ')':
                    char top_op = stack.pop();
                    while(top_op != '('){
                        sb.append(top_op);
                        top_op = stack.pop();
                    }
                    break;
                default:
                    sb.append(ch);
                    break;
            }
        }
        while(!stack.isEmpty()){
            sb.append(stack.pop());
        }

        System.out.println(sb);
    }


    public static void main(String[] args) throws Exception{
        new Main().solution();
    }
}
