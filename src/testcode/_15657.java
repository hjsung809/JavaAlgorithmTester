package testcode;

import java.io.*;
import java.util.*;

import tester.Executable;

public class _15657 implements Executable {
	static int[] arr;
	static int[] ns;
	static BufferedReader br;
	static BufferedWriter bw;
	static StringBuilder sb;
	static int n ,m;
	
	@Override
	public void main(InputStream in, OutputStream out) throws Exception {
		// TODO Auto-generated method stub
		br = new BufferedReader(new InputStreamReader(in));
		bw = new BufferedWriter(new OutputStreamWriter(out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		sb = new StringBuilder();
		arr = new int[m];
		ns = new int[n];
		
		st = new StringTokenizer(br.readLine(), " ");
		for(int i = 0 ; i < n; i++) {
			ns[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(ns);
		
		backtracking(0);
//		bw.write(sb.toString());
		br.close();
		bw.close();
	}
	
	public static void backtracking(int idx) throws IOException {
		if(idx == m) {
			for(int i = 0; i < m; i++) {
				sb.append(arr[i]).append(' ');
			}
			sb.append('\n');
			bw.write(sb.toString());
			sb = new StringBuilder(); 
			return;
		}
		
		for(int i = 0; i < n; i++) {
			boolean valid = true;
			
			if(idx != 0 && arr[idx - 1] > ns[i]) {
				valid = false;
			}
			
			if(valid) {
				arr[idx] = ns[i]; 
				backtracking(idx + 1);
			}
		}
	}
}
