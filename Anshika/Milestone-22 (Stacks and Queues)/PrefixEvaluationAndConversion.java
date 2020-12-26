//https://www.pepcoding.com/resources/online-java-foundation/stacks-and-queues/prefix-official/ojquestion

import java.io.*;
import java.util.*;

public class PrefixEvaluationAndConversion{

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String exp = br.readLine();

        Stack<Integer> digit=new Stack<Integer>();
        Stack<String> infix=new Stack<String>();
        Stack<String> postfix=new Stack<String>();  

        int a,b,result;
        char symbol;

        for (int i=exp.length()-1; i>=0; i--) {

            char ch=exp.charAt(i);
            String c=Character.toString(ch);

            if (Character.isDigit(ch)) {

                digit.push(ch-48);
                infix.push(c);
                postfix.push(c);

            } else {

                a=digit.pop();
                b=digit.pop();

                result=calculation(a,b,ch);
                digit.push(result);

                String x=infix.pop();
                String y=infix.pop();

                String s="("+x+ch+y+")";
                infix.push(s);

                x=postfix.pop();
                y=postfix.pop();

                s=x+y+ch;
                postfix.push(s);            
            }
        }

        System.out.println (digit.pop()+"\n"+infix.pop()+"\n"+postfix.pop());
        // code
    }

    static int calculation (int a, int b, char ch) {
        if (ch=='+') {
            return a+b;
        } else if (ch=='-') {
            return a-b;
        } else if (ch=='*') {
            return a*b;
        } else {
            return a/b;
        }
    }
}