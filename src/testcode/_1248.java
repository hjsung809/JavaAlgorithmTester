package testcode;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

import tester.Executable;

public class _1248 implements Executable {
	static int n;
	static char[][] arr;
	

	static ArrayList<Integer> answer;
//	static boolean[] check;
	
	static StringBuilder sb;

	@Override
	public void main(InputStream in, OutputStream out) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(out));
		n = Integer.parseInt(br.readLine());
		String str = br.readLine();
		arr = new char[n][n];
		
		int count = 0;
		for(int i = 0; i < n; i++) {
			for(int j = i; j < n; j++) {
				arr[i][j] = str.charAt(count++);
			}
		}
		
//		for(int i = 0; i < n; i++) {
//			for(int j = 0; j < n; j++) {
//				System.out.print(arr[i][j] + " ");
//			}
//			System.out.println();
//		}
		
		answer = new ArrayList<>();
//		check = new boolean[21];
		sb = new StringBuilder();
//		
		backtracking();
		bw.write(sb.toString());
		bw.close();
		br.close();
	}
	
	static public void backtracking() {
		if(answer.size() == n) {
			for(int a : answer) {
				sb.append(a).append(" ");
			}
			return;
		}
		
		for(int i = 0; i < 21 && sb.length() == 0; i ++) {
//			if(!check[i]) {
				int num = i <= 10 ? i : -1 * (i - 10);
				answer.add(num);
				
				if(isValid()) {
//					check[i] = true;
					backtracking();
//					check[i] = false;
				}
				
				answer.remove(answer.size() - 1);
//			}
		}
	}
	
	static public boolean isValid() {
		int index = answer.size() - 1;
		int num = answer.get(index);
		
		int sum = 0;
		for(int i = index; i >= 0; i--) {
			sum += answer.get(i);
			
			switch(arr[i][index]) {
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
		}
		
		return true;
	}
}
