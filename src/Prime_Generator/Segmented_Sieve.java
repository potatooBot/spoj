package Prime_Generator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Segmented_Sieve {
    public static void simpleSieve(boolean prime[]){

        Arrays.fill(prime,true);
prime[1]=false;
        for (int p = 2; p*p <=1000000 ; p++) {
            if(prime[p]==true) {
                for (int i = p * p; i <=1000000; i = i + p) {
                    prime[i] = false;
                }
            }
        }
    }
    public static ArrayList<Integer> getPrime(int n,boolean prime[] ){
        ArrayList<Integer> ds=new ArrayList<>();
        for (int i = 2; i <=n ; i++) {
            if(prime[i]==true) {
                ds.add(i);
            }
        }
        return ds;
    }
    public static void segmentedSieve(int left,int right,ArrayList<Integer> primeValues){
        int dummy[]=new int[right-left +1];

        Arrays.fill(dummy,1);


        for ( int ele :primeValues) {


            int firstMultiple =(left/ele)*ele;

            if(firstMultiple<left){
                firstMultiple=firstMultiple+ele;
            }

            for (int i = Math.max(firstMultiple,ele*ele); i <=right ; i=i+ele) {
dummy[i-left]=0;
            }
        }
long ans=1;
        int mod=1000000007;
        for (int i = left; i <=right ; i++) {
            if(dummy[i-left]==1){
                if(i==1) continue;
                System.out.println(i);
           ans=(ans*i)%mod;
            }
        }
        System.out.println(ans);
    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);

        int t=sc.nextInt();
        boolean prime[]=new boolean[1000001];
    simpleSieve(prime);
        for (int i = 0; i <t ; i++) {
            int left=sc.nextInt();
            int right=sc.nextInt();
            ArrayList<Integer> primeValue=getPrime((int)Math.sqrt(right),prime);
            segmentedSieve(left,right,primeValue);
            primeValue.clear();
        }



    }
}
