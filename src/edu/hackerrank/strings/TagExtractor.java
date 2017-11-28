package edu.hackerrank.strings;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TagExtractor {
    private final static String regex = "<(.+)>([^<]+)</\\1>";

    public static void main(String[] args){
        String[] inputs = {"<h1></h1>","<h1>had</h1><h1>public</h1>","<h1>Nayeem loves counseling</h1>",
                "<h1><h1>Sanjay has no watch</h1></h1><par>So wait for a while</par>",
                "<Amee>safat codes like a ninja</amee>","<SA premium>Imtiaz has a secret crush</SA premium>}"};

        for(String input: inputs){
            Pattern p = Pattern.compile(TagExtractor.regex);
            Matcher m = p.matcher(input);
            boolean found = false;

            while(m.find()){
                found = true;
                System.out.println(m.group(2));
            }

            if(!found){
                System.out.println("None");
            }
        }
    }
}