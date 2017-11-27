package edu.hackerrank.strings;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RepeatedRegex {
    private static final String ipRegex = "\\b(\\w+)\\s+\\1{1,}\\b";

    public static void main(String[] args){
        String[] inputs = {"I love Love to To tO code"};

        for(String input: inputs){
            Pattern pattern = Pattern.compile(RepeatedRegex.ipRegex,Pattern.CASE_INSENSITIVE);
            Matcher m = pattern.matcher(input);

            while (m.find()){
                input = input.replaceAll(m.group(0),m.group(1));
            }

            System.out.println(input);
        }
    }
}
