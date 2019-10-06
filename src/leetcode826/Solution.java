package leetcode826;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

/**
 * Created by vinitgaikwad on 5/20/19.
 */
public class Solution {
    public int maxProfitAssignment(int[] difficulty, int[] profit, int[] worker) {

        int ret = 0;

        Node[] nodes = makeNodeArray(difficulty);

        Arrays.sort(nodes,
            (Node n1, Node n2) -> n1.element - n2.element
        );

        for(int i = 0 ; i < worker.length ; i++) {


            int index = Arrays.binarySearch(nodes, new Node(0, worker[i]), (Node n1, Node n2) -> n1.element - n2.element);

            if(index >= 0) {

                ret = ret + profit[nodes[index].index];
                System.out.println(profit[nodes[index].index]);
            } else {

                int insertionPoint = ((index + 1) * -1);

                if(insertionPoint != 0) {
                    ret = ret + profit[nodes[insertionPoint-1].index];
                    System.out.println(profit[nodes[insertionPoint-1].index]);
                }
            }

        }

        return ret;
    }

    private Node[] makeNodeArray(int[] difficulty) {
        Node[] nodes = new Node[difficulty.length];
        for (int i = 0; i < difficulty.length; i++) {
            nodes[i] = new Node(i, difficulty[i]);

        }

        return nodes;

    }

    private class Node {


        int index;
        int element;

        public Node() {


        }
        public Node(int index, int element) {

            this.index = index;
            this.element = element;
        }
    }

    public static void main(String[] args ){

        System.out.println(new Solution().maxProfitAssignment(new int[]{68,35,52,47,86}, new int[]{67,17,1,81,3}, new int[]{92,10,85,84,82}));
    }
}


/**
 * [68,35,52,47,86]
 [67,17,1,81,3]
 [92,10,85,84,82]
 */

