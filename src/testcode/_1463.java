package testcode;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;

import tester.Executable;

public class _1463 implements Executable {

	@Override
	public void main(InputStream in, OutputStream out) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(out));
		int n = Integer.parseInt(br.readLine());
		int[] dp = new int[n + 1];
		dp[1] = 0;
		
		for(int i = 2; i <= n; i++) {
			dp[i] = dp[i - 1] + 1;
			if(i % 3 == 0) dp[i] = Math.min(dp[i], dp[i/3] + 1);
			if(i % 2 == 0) dp[i] = Math.min(dp[i], dp[i/2] + 1);
		}
		
		bw.write(String.valueOf(dp[n]));
		bw.close();
		br.close();
	}

}
