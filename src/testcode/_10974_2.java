package testcode;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

import tester.Executable;

public class _10974_2 implements Executable {
	static int[] arr;
	static int n;
	static BufferedWriter bw;
	static StringBuilder sb;
	

	@Override
	public void main(InputStream in, OutputStream out) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(in));
		bw = new BufferedWriter(new OutputStreamWriter(out));
		sb = new StringBuilder();
		
		n = Integer.parseInt(br.readLine());
		arr = new int[n];

		backtracking(0);		
		br.close();
		bw.close();
	}
	
	static void backtracking(int idx) throws IOException {
		if(idx == n) {
			for(int i = 0; i < n; i++) {
				sb.append(arr[i]).append(" ");
			}
			sb.append('\n');
			bw.write(sb.toString());
			sb = new StringBuilder();
			return;
		}
	
		
		for(int i = 1; i <= n; i++) {
			boolean valid = true;
			
			for(int j = 0; j < idx; j++) {
				if(arr[j] == i) {
					valid = false;
				}
			}
			
			if(valid) {
				arr[idx] = i;
				backtracking(idx + 1);
			}
		}
	}
}
