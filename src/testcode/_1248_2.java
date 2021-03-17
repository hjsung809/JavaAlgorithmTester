package testcode;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;

import tester.Executable;

public class _1248_2 implements Executable {
	static int n;
	static char[] arr;
	static boolean[] check;
	static int[] answer;
	
	static StringBuilder sb;

	@Override
	public void main(InputStream in, OutputStream out) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(out));
		n = Integer.parseInt(br.readLine());
		arr = br.readLine().toCharArray();
		answer = new int[n];
		check = new boolean[21];
		sb = new StringBuilder();
		
		backtracking(0);
		bw.write(sb.toString());
		bw.close();
		br.close();
	}
	
	static void backtracking(int idx) {
		if(idx == n) {
			for(int a: answer) {
				sb.append(a).append(" ");
			}
			sb.append('\n');
			return;
		}
		
		for(int i = 0; i <= 20; i++) {
			if(!check[i]) {
				int num = i <= 10 ? i : -1 * (i - 10);
				answer[idx] = num;
				
				if(isValid(idx)) {
					check[i] = true;
					backtracking(idx + 1);
					check[i] = false;
				}
			}
		}
	}
	
	static boolean isValid(int idx) {
		int idxOffset = 0;
		
		for(int i = 0; i <= idx; i++) {
			int sum = 0;
			for(int j = i; j <= idx; j++) {
				sum += answer[j];
			}
			
			switch(arr[idxOffset + idx -i]) {
				case '+':
					if(sum <= 0) return false;
					break;
				case '-':
					if(sum >= 0) return false;
					break;
				case '0':
					if(sum != 0) return false;
					break;
			}
			idxOffset += n - i;
		}
		return true;
	}
}
