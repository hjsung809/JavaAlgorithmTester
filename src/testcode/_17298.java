package testcode;

import java.io.*;
import java.util.*;

import tester.Executable;

public class _17298 implements Executable {

	@Override
	public void main(InputStream in, OutputStream out) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(out));
		
		int n = Integer.parseInt(br.readLine());
		int[] arr = new int[n];
		int[] answer = new int[n];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		Deque<Integer> deque = new LinkedList<Integer>();
		deque.add(arr[n - 1]);
		answer[n - 1] = -1;
		
		for(int i = n - 2; i >= 0; i--) {
			while(!deque.isEmpty() && deque.getLast() <= arr[i]) {
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
		for(int a : answer) {
			sb.append(a).append(" ");
		}
		sb.deleteCharAt(sb.length() - 1);
		bw.write(sb.toString());
		
		bw.close();
		br.close();
	}

}
