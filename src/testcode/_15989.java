package testcode;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;

import tester.Executable;

public class _15989 implements Executable {
	
	@Override
	public void main(InputStream in, OutputStream out) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(out));
		int t = Integer.parseInt(br.readLine());
		int[] dp = new int[10001];
		dp[0] = 1;
		
		for(int i = 1; i <= 3; i++){
	        for(int j = 1; j <= 10000; j++){
	            if(j - i >= 0)dp[j] += dp[j - i];
	        }
	    }
		
		while(t-- > 0) {
			int n = Integer.parseInt(br.readLine());			
			bw.write(dp[n] + "\n");
		}
		bw.close();
		br.close();
	}

}
