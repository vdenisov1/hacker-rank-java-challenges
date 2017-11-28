package edu.hackerrank.advanced;

import javax.xml.bind.DatatypeConverter;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Scanner;

public class HashGenerator {

    public static void main(String[] args) throws NoSuchAlgorithmException {
        Scanner in = new Scanner(System.in);
        String pw = in.nextLine();
        MessageDigest md = MessageDigest.getInstance("MD5");
        md.update(pw.getBytes());
        String hash = DatatypeConverter.printHexBinary(md.digest()).toLowerCase();
        System.out.println(hash);
    }
}
