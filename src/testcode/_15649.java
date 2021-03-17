package testcode;

import java.io.*;
import java.util.*;

import tester.Executable;

public class _15649 implements Executable {
	static int[] arr;
	static StringBuilder sb;
	static int n ,m;
	
	@Override
	public void main(InputStream in, OutputStream out) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		sb = new StringBuilder();
		arr = new int[m];
		
		backtracking(0);
		bw.write(sb.toString());
		br.close();
		bw.close();
	}
	
	public static void backtracking(int idx) {
		if(idx == m) {
			for(int i = 0; i < m; i++) {
				sb.append(arr[i]).append(' ');
			}
			sb.append('\n');
			return;
		}
		
		for(int i = 1; i <= n; i++) {
			boolean valid = true;
			for(int j = 0; j < idx; j++) {
				if(arr[j] == i) {
					valid = false;
					break;
				}
			}
			
			if(valid) {
				arr[idx] = i; 
				backtracking(idx + 1);
			}
		}
	}
}
