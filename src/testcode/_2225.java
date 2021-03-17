package testcode;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

import tester.Executable;

public class _2225 implements Executable {
	public static int DIVISOR = 1000000000;
	@Override
	public void main(InputStream in, OutputStream out) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		int[][] dp = new int[k + 1][n + 1];
		
		for(int i = 0; i <= n; i++) {
			dp[1][i] = 1;
		}
		
		
		for(int i = 2; i <= k; i++) {
			dp[i][0] = 1;
			for(int j = 1; j <=n; j++) {
				dp[i][j] = (dp[i][j - 1] + dp[i - 1][j]) % 1000000000; 
			}
		}
		
		bw.write(dp[k][n] + "");
		bw.close();
		br.close();
	}

}
