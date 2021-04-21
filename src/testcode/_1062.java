package testcode;

import tester.Executable;

import java.io.*;
import java.util.Arrays;

public class _1062 implements Executable {
    static int n, k;
    static int defaultMask = "antic".chars()
            .map(c -> c - 'a')
            .reduce(0, (a, b) -> {
                return a | 1 << b;
            });
    static int[] words;
    static int max;

    public static void backtracking(int index, int mask, int count) {
        if(count >= k) {
            // max
            int wordCount = (int) Arrays.stream(words).filter(w -> (w & mask) == w).count();
            max = Math.max(wordCount, max);
            return;
        }
        if(index > 25) return;

        int target = 1 << index;
        if((target & mask) != target) {
            backtracking(index + 1, mask + target, count + 1);
        }
        backtracking(index + 1, mask , count);
    }

    @Override
    public void main(InputStream in, OutputStream out) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(out));
        String[] nk = br.readLine().split(" ");
        n = Integer.parseInt(nk[0]);
        k = Integer.parseInt(nk[1]);

        words = br.lines()
                .mapToInt(s -> {
                    return s.chars()
                            .map(c -> c - 'a')
                            .reduce(0, (a, b) -> {
                                return a | 1 << b;
                            });
                })
                .toArray();
        max = 0;
        if(k >= 5) {
            backtracking(0, defaultMask, 5);
            bw.write(String.valueOf(max));
        } else {
            bw.write(String.valueOf(0));
        }


        br.close();
        bw.close();
    }
}
