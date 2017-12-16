package edu.hackerrank.datastructures;

import java.util.BitSet;
import java.util.Scanner;

public class MyBitSet {

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        int M = in.nextInt();
        BitSet[] bitSetSet = { new BitSet(N), new BitSet(N) };

        for(int i = 0; i < M; i++){
            String command = in.next();
            int input1 = in.nextInt();
            int input2 = in.nextInt();

            if(command.equals("AND"))
                bitSetSet[input1 - 1].and(bitSetSet[input2 - 1]);

            if(command.equals("OR"))
                bitSetSet[input1 - 1].or(bitSetSet[input2 - 1]);

            if(command.equals("XOR"))
                bitSetSet[input1 - 1].xor(bitSetSet[input2 - 1]);

            if(command.equals("FLIP"))
                bitSetSet[input1 - 1].flip(input2);

            if(command.equals("SET"))
                bitSetSet[input1 - 1].set(input2);

            System.out.format("%d %d\n", bitSetSet[0].cardinality(), bitSetSet[1].cardinality());
        }

        in.close();
    }
}
