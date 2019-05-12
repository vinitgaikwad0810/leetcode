package leetcode1041;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {

    static Map<char[], List<char[]>> m = new HashMap();
    static char[] y_1 = new char[] {'y','+'};
    static char[] y_0 = new char[] {'y','-'};
    static char[] x_0 = new char[] {'x','-'};
    static char[] x_1 = new char[] {'x','+'};



    public static void main(String[] args) {
        System.out.println(new Solution().isRobotBounded("GGLLGG"));
    }

    public boolean isRobotBounded(String instructions) {

        int index = 0;
        char[] init = y_1;
        int[] cur = new int[] {0, 0};
        int countI = 0;
        char[] newPos = y_1;
        while(true) {


            switch(instructions.charAt(index)) {
                case 'G':
                    //  newPos = move('G', init);
                    cur = move(newPos, cur);
                    break;
                case 'L':
                    newPos = move('L', newPos);
                    // cur = move(newPos, cur);
                    break;
                case 'R':
                    newPos = move('R', newPos);
                    //  cur = move(newPos, cur);
                    break;

            }



            index = (index + 1) % instructions.length();

            if(index == 0)
            {
                if(cur[0] == 0 && cur[1] == 0)
                    return true;

                countI++;
            }

            if(countI == 100)
                break;
        }

        return false;

    }




    private int[] move(char[] position, int[] curCo) {


        if(position[0] == 'y') {

            if(position[1] == '+') {

                return new int[] {curCo[0], curCo[1] + 1};
            } else {
                return new int[] {curCo[0], curCo[1] - 1};
            }

        } else {

            if(position[1] == '+') {

                return new int[] {curCo[0]+1, curCo[1]};
            } else {
                return new int[] {curCo[0]-1, curCo[1]};
            }
        }

    }

    private char[] move(char move, char[] position) {

        m.put(y_1, Arrays.asList(x_0, x_1));
        m.put(y_0, Arrays.asList(x_1, x_0));
        m.put(x_0, Arrays.asList(y_0, y_1));
        m.put(x_1, Arrays.asList(y_1, y_0));

        switch(move) {
            case 'L':
                return m.get(position).get(0);
            case 'R':
                return m.get(position).get(1);
            case 'G':
                return position;
        }
        return null;

    }
}
