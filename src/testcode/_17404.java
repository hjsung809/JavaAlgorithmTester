package testcode;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

import tester.Executable;

public class _17404 implements Executable {

	@Override
	public void main(InputStream in, OutputStream out) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(out));
		
		int n = Integer.parseInt(br.readLine());
		int[][] arr = new int[n + 1][3];
		int[][] dp = new int[n + 1][3];
		
		for(int i = 1; i <= n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			arr[i][0] = Integer.parseInt(st.nextToken());
			arr[i][1] = Integer.parseInt(st.nextToken());
			arr[i][2] = Integer.parseInt(st.nextToken());
		}
		
		
		int sol = Integer.MAX_VALUE;
		for(int j = 0; j < 3; j++) {
			dp[1][0] = 1000001;
			dp[1][1] = 1000001;
			dp[1][2] = 1000001;
			dp[1][j] = arr[1][j];
			
			for(int i = 2; i <= n; i++) {
				dp[i][0] = Math.min(dp[i - 1][1], dp[i - 1][2]) + arr[i][0];
				dp[i][1] = Math.min(dp[i - 1][0], dp[i - 1][2]) + arr[i][1];
				dp[i][2] = Math.min(dp[i - 1][0], dp[i - 1][1]) + arr[i][2];
			}
			
			for(int i = 0; i < 3; i++) {
				if(j == i) continue;
				sol = Math.min(dp[n][i], sol);
			}
		}
		bw.write(String.valueOf(sol));
		bw.close();
		br.close();
	}

}
