package testcode;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;

import tester.Executable;

public class _1309 implements Executable {

	@Override
	public void main(InputStream in, OutputStream out) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(out));
		int n = Integer.parseInt(br.readLine());
		int[][] dp = new int[n + 1][2];
		dp[1][0] = 1;
		dp[1][1] = 2;
		
		for(int i = 2; i <= n; i++) {
			dp[i][0] = (dp[i - 1][0] + dp[i - 1][1]) % 9901;
			dp[i][1] = (dp[i - 1][0] * 2 + dp[i - 1][1]) % 9901;
		}
		bw.write(((dp[n][0] + dp[n][1]) % 9901) + "");
		bw.close();
		br.close();
	}

}
