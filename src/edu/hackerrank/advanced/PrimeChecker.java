package edu.hackerrank.advanced;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import static java.lang.System.in;

class Prime{
    public void checkPrime(int ... n){
        ArrayList<String> primes = new ArrayList<>();

        for(int i = 0; i < n.length; i++){
            boolean isPrime = true;

            if(n[i] == 1) {
                isPrime = false;
            }else {
                for (int j = 2; j < n[i]; j++) {
                    if (n[i] % j == 0) {
                        isPrime = false;
                        j = n[i];
                    }
                }
            }

            if(isPrime)
                primes.add(Integer.toString(n[i]));
        }

        if(primes.isEmpty()){
            System.out.println("");
        }else{
            for(String prime: primes){
                System.out.print(prime + " ");
            }
            System.out.print("\n");
        }
    }
}

public class PrimeChecker {
    public static void main(String[] args) {
        try{
            BufferedReader br = new BufferedReader(new InputStreamReader(in));
            int n1=Integer.parseInt(br.readLine());
            int n2=Integer.parseInt(br.readLine());
            int n3=Integer.parseInt(br.readLine());
            int n4=Integer.parseInt(br.readLine());
            int n5=Integer.parseInt(br.readLine());
            Prime ob=new Prime();
            ob.checkPrime(n1);
            ob.checkPrime(n1,n2);
            ob.checkPrime(n1,n2,n3);
            ob.checkPrime(n1,n2,n3,n4,n5);
            Method[] methods=Prime.class.getDeclaredMethods();
            Set<String> set=new HashSet<>();
            boolean overload=false;
            for(int i=0;i<methods.length;i++)
            {
                if(set.contains(methods[i].getName()))
                {
                    overload=true;
                    break;
                }
                set.add(methods[i].getName());

            }
            if(overload)
            {
                throw new Exception("Overloading not allowed");
            }
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
    }
}
