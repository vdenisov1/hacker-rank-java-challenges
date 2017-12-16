package edu.hackerrank.datastructures;

import java.util.*;

public class ArrayGame {
    public static boolean canWin(int leap, int[] game){
        // Return true if you can win, otherwise false.
        /**
         * Rules:
         *  * Move Backward: If cell i - 1 exists and contains a 0, you can walk back to cell i - 1
         *  * Move Forward:
         *      - If cell i + 1 contains a zero, you can walk to cell i + 1
         *      - If cell i + leap contains a zero, you can jump to cell i + leap
         *      - If you're standing in cell n - 1 or the value of i + leap >= n, you can walk or jump off the end of
         *          the end of the array and win the game.
         * In other words you can move from index i to index i + 1, i - 1, i + leap as long as the destination index is
         *  a cell containing a 0. If the destination index is greater than n - 1, you win the game.
         *
         *  Input Format:
         *    The first line contains an integer, q, denoting the number of queries. The 2 * q subsequent lines describe
         *    each query over two lines.
         *      1. The first line contains two space-separated integers describing the respective values of n and leap.
         *      2. The second line contains n space-separated binary integers describing the respective values of game0,
         *        game1, ..., game<n-1>
         *
         *  Constraints:
         *    1 <= q <= 5000
         *    2 <= n <= 100
         *    0 <= leap <= 100
         *    It is guaranteed that the value of game[0] is always 0.
         */
        int i = 0;
        boolean availableMove = true;
        Set<Integer> visited = new HashSet<>();
        SortedSet<Integer> checkpoints = new TreeSet<>();
        Set<Integer> checkpointsChecked = new HashSet<>();

        while(availableMove) {

            int back_i = i - 1;
            int nextMove = i + 1;
            int nextLeap = i + leap;

//            System.out.format("i = %d, back_i = %d, nextMove = %d, nextLeap = %d", i, back_i, nextMove, nextLeap);
//            System.out.println("");

            if (nextLeap >= game.length || nextMove >= game.length)
                return true;

            if (game[nextMove] < 1 && !visited.contains(nextMove)) {
                i = nextMove;
            } else if (game[nextLeap] < 1 && !visited.contains(nextLeap)) {
                if(!checkpointsChecked.contains(i))
                    checkpoints.add(i);
                i = nextLeap;
            } else if (back_i >= 0 && game[back_i] < 1) {
                i = back_i;
            } else if(checkpoints.size() > 0){
                i = checkpoints.last();
                checkpointsChecked.add(i);
                checkpoints.remove(i);
            }else{
                availableMove = false;
            }

            visited.add(i);
        }

        return false;
    }

    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        int q = scan.nextInt();
        while(q-- > 0){
            int n = scan.nextInt();
            int leap = scan.nextInt();

            int[] game = new int[n];

            for(int i = 0; i < n; i++){
                game[i] = scan.nextInt();
            }

            System.out.println( (canWin(leap, game)) ? "YES" : "NO");
        }

        scan.close();
    }
}
