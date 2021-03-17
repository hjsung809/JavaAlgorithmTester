package testcode;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

import tester.Executable;

public class _6603 implements Executable {
	static int k;
	static int[] arr;
	static int[] target;
//	static boolean[] check;
	
	static BufferedWriter bw;
	
	@Override
	public void main(InputStream in, OutputStream out) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(in));
		bw = new BufferedWriter(new OutputStreamWriter(out));
		
		while(true) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			k = Integer.parseInt(st.nextToken());
			if(k == 0) break;
			
			arr = new int[k];
			target = new int[6];
//			check = new boolean[k];
			
			for(int i = 0 ; i < k; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			Arrays.sort(arr);
			backtracking(0);
			bw.write('\n');
		}
		bw.close();
		br.close();
	}
	
	static void backtracking(int idx) throws IOException {
		if(idx == 6) {
			StringBuilder sb = new StringBuilder();
			for(int i = 0; i < 6; i++) {
				sb.append(target[i]).append(' ');
			}
			sb.append('\n');
			bw.write(sb.toString());
			return;
		}
		
		for(int i = 0; i < k; i++) {
			if(idx == 0 || target[idx - 1] < arr[i]) {
				target[idx] = arr[i];
				backtracking(idx + 1);
			}
		}
	}

}
