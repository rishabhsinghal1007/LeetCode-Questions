// Kth Smallest Element in a Sorted Matrix
// Given an n x n matrix where each of the rows and columns are sorted in ascending order, return the kth smallest element in the matrix.

import java.io.*;
import java.util.*;

public class Q378_kthSmallest{
    public static int kthSmallest(int[][] matrix, int k) {
        int n = matrix.length, m = matrix[0].length;
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> {
            return matrix[a / m][a % m] - matrix[b / m][b % m];
        });

        for (int i = 0; i < n; i++)
            pq.add(i * m);

        while (--k > 0) {
            int idx = pq.remove();
            int r = idx / m;
            int c = (idx % m);
            if (c + 1 < m)
                pq.add(r * m + c + 1);
        }

        int idx = pq.peek();
        return matrix[idx / m][idx % m];
    }

    // public static int kthSmallest(int[][] matrix, int k) {
    //     int n = matrix.length, m = matrix[0].length;
    //     PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> {
    //         return matrix[a / m][a % m] - matrix[b / m][b % m];
    //     });

    //     for (int i = 0; i < n; i++)
    //         pq.add(i * m);

    //     int r = 0;
    //     int c = 0;

    //     while (--k >= 0) {
    //         int idx = pq.remove();
    //         r = idx / m;
    //         c = idx % m ;
    //         if (c + 1 < m)
    //         pq.add(r * m + c + 1);
    //     }
    //     return matrix[r][c];
    // }

    public static void main(String[] args){
        Scanner scn = new Scanner(System.in);
        // int[][] arr = { {1,5,9}, {10,11,13}, {12,13,15} };
        int[][] arr = { {1,2}, {3,3}};
        int k = scn.nextInt();
        System.out.print("Kth Smallest Element in a Sorted Matrix : ");
        System.out.println(kthSmallest(arr,k));
    }
}