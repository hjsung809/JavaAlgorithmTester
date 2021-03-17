package testcode;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;

import tester.Executable;

public class _9095 implements Executable {

	@Override
	public void main(InputStream in, OutputStream out) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(out));
		int t = Integer.parseInt(br.readLine());
		int[] dp = {0, 1, 2, 4, 7, 13, 24, 44, 81, 149, 274};
		
		for(int i = 0; i < t; i++) {
			int n = Integer.parseInt(br.readLine());	
			bw.write(dp[n] + "\n");
		}
		
		bw.close();
		br.close();
	}

}
