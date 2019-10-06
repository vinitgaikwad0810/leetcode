package leetcode1087;

import java.util.LinkedList;
import java.util.List;

public class RateLimitingUsingTokenBucketFilter {

    public static void main(String[] args) throws InterruptedException {
        TokenBucketFilter tokenBucketFilter = new TokenBucketFilter<>(100);

        Thread t1 = new Thread(() -> {

            for(int i = 0 ; i < 100 ; i++) {
                try {
                    tokenBucketFilter.addToken(i);
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        Thread t2 = new Thread(() -> {

            for(int i = 0 ; i < 50 ; i++) {
                try {
                    tokenBucketFilter.getToken();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        Thread t3 = new Thread(() -> {

            for(int i = 0 ; i < 50 ; i++) {
                try {
                    tokenBucketFilter.getToken();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        t1.start();
        Thread.sleep(4000);
        t2.start();
        t3.start();

        t1.join();
        t2.join();
        t3.join();
    }

    private static class TokenBucketFilter<T> {

        List<T> tokens = new LinkedList<>();
        final int maxSize;

        public TokenBucketFilter(int N) {
            this.maxSize = N;
        }

        public synchronized T getToken() throws InterruptedException {
            while (tokens.size() == 0) {
                wait();
            }

            T token = tokens.remove(tokens.size() - 1);
            System.out.println("Token " + token + " is removed");
            notifyAll();
            return token;
        }

        public synchronized void addToken(T token) throws InterruptedException {

            while (tokens.size() == maxSize) {
                wait();
            }

            tokens.add(token);
            System.out.println("Token " + token + " is added");

            notifyAll();
        }


    }


}
