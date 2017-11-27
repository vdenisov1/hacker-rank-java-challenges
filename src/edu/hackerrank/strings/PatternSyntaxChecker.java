package edu.hackerrank.strings;

import java.util.Scanner;
import java.util.regex.*;

public class PatternSyntaxChecker {

    public static void main(String[] args){
        String[] inputs = {"3","([A-Z])(.+)","[AZ[a-z](a-z)","batcatpat(nat}"};
        int nTestCases = Integer.parseInt(inputs[0]);
        String[] regex = new String[nTestCases];

        for(int i = 0; i < nTestCases; i++){
            regex[i] = inputs[i+1];
        }

        PatternSyntaxChecker psc = new PatternSyntaxChecker();
        psc.syntaxChecker(nTestCases,regex);
    }

    public void syntaxChecker(int numberOfTestCases, String[] regex){
        for(int i = 0; i < numberOfTestCases; i++){
            try{
                Pattern.compile(regex[i]);
                System.out.println("Valid");
            }catch(PatternSyntaxException e){
                System.out.println("Invalid");
            }
        }
    }

}
