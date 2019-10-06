package leetcode811;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by vinitgaikwad on 7/4/19.
 */
public class Solution {

    public static void main(String[] args) {

        new Solution().subdomainVisits(new String[]{"9001 discuss.leetcode.com"}).forEach(s -> System.out.println(s));
    }

    public List<String> subdomainVisits(String[] cpdomains) {

        Map<String, Integer> m = new HashMap();

        for (String cpdomain : cpdomains) {

            String[] s1 = cpdomain.split(" ");

            m.computeIfPresent(s1[1], (k, o) -> (o != null ? o : 0) + Integer.valueOf(s1[0]));
            System.out.println(s1[1]);

            for (int i = 0; i < s1[1].length(); i++) {
                if (s1[1].charAt(i) == '.') {

                    m.computeIfPresent(s1[1].substring(i + 1), (k, o) -> {

                        System.out.println(Integer.valueOf(s1[0]));
                        return (o != null ? o : 0) + Integer.valueOf(s1[0]);
                    });
                    //  System.out.println(Integer.valueOf(s1[0]));
                }


            }
        }


        List<String> ret = new ArrayList();

        for (Map.Entry<String, Integer> e : m.entrySet()) {


            StringBuilder sb = new StringBuilder();

            sb.append(String.valueOf(e.getValue()));
            sb.append(" ");
            sb.append(e.getKey());

            ret.add(sb.toString());
            System.out.println(String.valueOf(e.getValue()));

        }

        return ret;
    }
}

