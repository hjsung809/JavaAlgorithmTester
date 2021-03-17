package testcode;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

import tester.Executable;

public class _10972_2 implements Executable {
	static int[] arr;
	static int[] target;
	static int[] pre;
	
	static int n;
	static StringBuilder sb;
	

	@Override
	public void main(InputStream in, OutputStream out) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(out));
		sb = new StringBuilder();
		
		n = Integer.parseInt(br.readLine());
		arr = new int[n];
		target = new int[n];
		pre = new int[n];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0; i < n; i++) {
			target[i] = Integer.parseInt(st.nextToken());
		}
//		arr[0] = target[0];
		backtracking(0);
		
		if(sb.length() == 0) {
			bw.write("-1");
		} else {
			bw.write(sb.toString());
		}
		
		br.close();
		bw.close();
	}
	
	static void backtracking(int idx) {
		if(idx == n) {
			boolean match = true;
			for(int i = 0; i < n; i++) {
				if(pre[i] != target[i]) {
					match = false;
					break;
				}
			}
			
			if(match) {
				for(int i = 0; i < n; i++) {
					sb.append(arr[i]).append(" ");
				}
			} else {
				for(int i = 0; i < n; i++) {
					pre[i] = arr[i];
				}
			}
			return;
		}
		
		// target[idx], arr[idx]
		
		for(int i = 1; i <= n && sb.length() == 0; i++) {
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
