package testcode;

import java.io.*;
import java.util.*;

import tester.Executable;

public class _15664 implements Executable {
	static BufferedReader br;
	static BufferedWriter bw ;
	static StringBuilder sb;
	
	static int n ,m;
	static int[] arr;
	
	static ArrayList<int[]> ns;
	
	@Override
	public void main(InputStream in, OutputStream out) throws Exception {
		// TODO Auto-generated method stub
		br = new BufferedReader(new InputStreamReader(in));
		bw = new BufferedWriter(new OutputStreamWriter(out));
		sb = new StringBuilder();
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		

		arr = new int[m];
		ns = new ArrayList<>();
		
		st = new StringTokenizer(br.readLine(), " ");
		for(int i = 0 ; i < n; i++) {
			int tmp = Integer.parseInt(st.nextToken());
			boolean isExist = false;
			
			for(int[] c : ns) {
				if(c[0] == tmp) {
					isExist = true;
					c[1]++;
					break;
				}
			}
			
			if(!isExist) {
				ns.add(new int[]{tmp, 1});
			}
		}
		Collections.sort(ns, (a, b) -> a[0] - b[0]);
		
		backtracking(0);
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
		
		for(int i = 0; i < ns.size(); i++) {
			boolean valid = true;
			int[] tmp = ns.get(i);
			
			if(tmp[1] <= 0 || (idx != 0 && arr[idx - 1] > tmp[0])) {
				valid = false;
				
			}
			
			if(valid) {
				arr[idx] = tmp[0]; 
				tmp[1]--;
				backtracking(idx + 1);
				tmp[1]++;
			}
		}
	}
}
