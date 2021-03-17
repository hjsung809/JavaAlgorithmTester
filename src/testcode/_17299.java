package testcode;

import java.io.*;
import java.util.*;

import tester.Executable;

public class _17299 implements Executable {

	@Override
	public void main(InputStream in, OutputStream out) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(out));
		
		int n = Integer.parseInt(br.readLine());
		int[] arr = new int[n + 1];
		int[] f = new int[1000001];
		int[] answer = new int[n + 1];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 1; i <= n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			f[arr[i]]++;
		}
		
		Deque<Integer> deque = new LinkedList<Integer>();
		deque.add(arr[n]);
		answer[n] = -1;
		
		for(int i = n - 1; i > 0; i--) {
			while(!deque.isEmpty() && f[deque.getLast()] <= f[arr[i]]) {
				deque.pollLast();
			}
			
			if(deque.isEmpty()) {
				answer[i] = -1;
			} else {
				answer[i] = deque.getLast();
			}
			deque.add(arr[i]);
		}
		
		StringBuilder sb = new StringBuilder();
		for(int i = 1; i <= n; i++) {
			sb.append(answer[i]).append(" ");
		}
		bw.write(sb.toString());
		
		bw.close();
		br.close();
	}

}
