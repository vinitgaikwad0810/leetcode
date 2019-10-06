package leetcode1087;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by vinitgaikwad on 7/4/19.
 */
public class Solution {


    public static void main(String[] args) {

//        new Solution().expand("{a,b}c{d,e}f");
        new Solution().expand("abcd");

    }


    public String[] expand(String S) {

        List<String[]> words = new ArrayList();

        StringBuilder sb = new StringBuilder();

        List<String> chars = new ArrayList();

        int index = 0;
        while (index < S.length()) {

            System.out.println(index);
            char c = S.charAt(index);

            if (c == '{') {

                if (sb.length() != 0) {

                    words.add(new String[]{sb.toString()});
                    sb = new StringBuilder();
                }

                chars = new ArrayList();
                while (c != '}') {

                    index++;

                    c = S.charAt(index);

                    if(c == ',') {
                        continue;
                    }

                    if (c == '}') {
                        words.add(chars.toArray(new String[0]));
                        index++;
                        break;
                    }
                    chars.add(new String(new char[]{c}));

                }

            } else {
                sb.append(c);
                index++;
            }


        }

        if (sb.length() != 0) {

            words.add(new String[]{sb.toString()});
        }

//        for (String[] w : words) {
//
//            for (int i = 0; i < w.length; i++) {
//
//                System.out.print(i + ":" + w[i]);
//            }
//
//            System.out.println();
//        }

        List<String> ret = new ArrayList<>();
        String s = new String();
         expand(words, 0, ret, s);

//         ret.forEach(s1 -> System.out.println(s1));
        return ret.toArray(new String[0]);
    }

    private void expand(List<String[]> words, int index, List<String> ret, String s) {

        if(index == words.size()) {
            ret.add(s);
            return;
        }

        String[] cur = words.get(index);

        for (int i = 0; i < cur.length; i++) {

            StringBuilder sb = new StringBuilder(s);
            sb.append(cur[i]);
            expand(words, index+1, ret, sb.toString());
        }

    }

}

