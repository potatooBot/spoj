package Palin_Spoj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.Scanner;
import java.util.*;
public class next_perm {
    public static String incrementString(String value) {
        char[] chars = value.toCharArray();
        int carry = 1;

        for (int i = chars.length - 1; i >= 0 && carry > 0; i--) {
            int digit = chars[i] - '0';
            int sum = digit + carry;
            chars[i] = (char) ((sum % 10) + '0');
            carry = sum / 10;
        }

        if (carry > 0) {
            String result = "1" + new String(chars); // If there's a carry left, add '1' at the beginning
            return result;
        } else {
            return new String(chars);
        }
    }
    public static boolean checkPalim(String str){
        int start=0;
        int end=str.length()-1;
        while (start<=end){
            if(str.charAt(start)!=str.charAt(end)){
                return false;
            }
            start++;
            end--;
        }
        return true;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader sc=new BufferedReader(new InputStreamReader(System.in));

       int t=Integer.parseInt(sc.readLine());
        for (int l = 0; l <t ; l++) {
            String str=sc.readLine();

            while (true) {
                String val = incrementString(str);
            if(checkPalim(val)==true){
                System.out.println(val);
                break;
            }
                str=val;
            }
        }

    }


}
