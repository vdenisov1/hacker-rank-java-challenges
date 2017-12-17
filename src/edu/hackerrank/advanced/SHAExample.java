package edu.hackerrank.advanced;


import javax.xml.bind.DatatypeConverter;
import java.security.MessageDigest;
import java.util.Scanner;

public class SHAExample {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        String text = in.nextLine();
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            digest.update(text.getBytes());
            String hash = DatatypeConverter.printHexBinary(digest.digest()).toLowerCase();
            System.out.println(hash);
        }catch(Exception e){
            System.out.println(e.toString());
        }
    }
}
