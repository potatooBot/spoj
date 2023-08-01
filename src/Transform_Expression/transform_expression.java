package Transform_Expression;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.*;

public class transform_expression {
    public static int prece(char ch){
        if(ch=='^'){
            return 3;
        }
        if(ch=='*'||ch=='/'){
            return 2;
        }
        if(ch=='+'||ch=='-'){
            return 1;
        }
        else {
            return -1;
        }
    }
    public static String infixToPostfix(String exp) {
        String ans="";
        int n=exp.length();
        Stack<Character> stk=new Stack<>();
        for (int i = 0; i <n ; i++) {
            if((exp.charAt(i)>='a'&&exp.charAt(i)<='z')||(exp.charAt(i)=='A'&&exp.charAt(i)<='Z')||(exp.charAt(i)>='0'&&exp.charAt(i)<='9')){
                ans=ans+exp.charAt(i);
            }
            else if (exp.charAt(i)=='(') {
                stk.push(exp.charAt(i));
            }
            else if(exp.charAt(i)==')'){
                while (!stk.empty()&&stk.peek()!='('){
                    ans=ans+stk.peek();
                    stk.pop();
                }
                if(!stk.isEmpty()){
                    stk.pop();
                }

            }
            else {
                while (!stk.empty()&&prece(stk.peek())>=prece(exp.charAt(i))){
                    ans=ans+stk.peek();
                    stk.pop();
                }
                stk.push(exp.charAt(i));
            }
        }
        while (!stk.isEmpty()){
            ans=ans+stk.peek();
            stk.pop();
        }
        // Your code here
        return ans;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(sc.readLine());
        for (int i = 0; i <t; i++) {
            String str = sc.readLine();
            String ans = infixToPostfix(str);
            System.out.println(ans);
        }
    }
}
