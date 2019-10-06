/**
 * Created by vinitgaikwad on 8/7/19.
 */
public class mcodility {

    public int solution(int[] A, int[] B, int N) {

        int max = 0;
        boolean[] visited = new boolean[N];
        for (int i = 1; i <= N; i++) {

            max = Math.max(max, dfs(A, B, N, i, visited, 1));

        }

        return max;
    }

    private int dfs(int[] A, int[] B, int N, int c, boolean[] visited, int count) {

        int max = 0;
        for (int i = 1; i <= N; i++) {

            if (A[i - 1] == c && !visited[B[i - 1] - 1]) {
                visited[B[i - 1] - 1] = true;
                max = Math.max(max, dfs(A, B, N, B[i - 1], visited, count + 1));
            }
        }

        return max;

    }

    public static void main(String[] args) throws InterruptedException {

        final int sumTo = Integer.MAX_VALUE;
        final long[] sum = {0};

        Runnable one = () -> {

            for (int i = 0; i < sumTo; i++) {
                sum[0] += i;
            }
        };

        Thread t1 = new Thread(one);

        long start = System.currentTimeMillis();
        t1.start();
        t1.join();
        long end = System.currentTimeMillis();

        System.out.println("Time elapsed: " + String.valueOf(end - start) + " sum: " + sum[0]);

        final long[] sum2 = new long[2];

        Runnable two1 = () -> {
            for (int i = 0; i <= sumTo / 2; i++) {
                sum2[0] += i;
            }
        };

        Runnable two2 = () -> {
            for (int i = ((sumTo / 2) + 1); i < sumTo; i++) {
                sum2[1] += i;
            }
        };

        Thread t2 = new Thread(two1);
        Thread t3 = new Thread(two2);

        start = System.currentTimeMillis();
        t2.start();
        t3.start();

        t2.join();
        t3.join();

        end = System.currentTimeMillis();

        long total = sum2[0] + sum2[1];
        System.out.println("Time elapsed: " + String.valueOf(end - start) + " sum: " + total);
    }
}
