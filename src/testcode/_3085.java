package testcode;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;

import tester.Executable;

public class _3085 implements Executable {
	static int n;
	static char[][] arr;
	
	@Override
	public void main(InputStream in, OutputStream out) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(out));
		n = Integer.parseInt(br.readLine());
		arr = new char[n][];
		for(int i = 0 ; i < n; i++) {
			arr[i] = br.readLine().toCharArray();
		}
		
		int sol = countCandy();
		
		
		for(int i = 0 ; i < n; i++) {
			for(int j = 0; j < n; j++) {
//				if(i - 1 > 0)  sol = Math.max(sol, changeAndCount(i, j, i - 1, j));
				if(i + 1 < n)  sol = Math.max(sol, changeAndCount(i, j, i + 1, j));
//				if(j - 1 > 0)  sol = Math.max(sol, changeAndCount(i, j, i, j - 1));
				if(j + 1 < n)  sol = Math.max(sol, changeAndCount(i, j, i, j + 1));
			}
		}

		bw.write(String.valueOf(sol));
		bw.close();
		br.close();
	}
	
	public static int changeAndCount(int i1, int j1, int i2, int j2) {
		int  count;
		char tmp = arr[i1][j1];
		arr[i1][j1] = arr[i2][j2];
		arr[i2][j2] = tmp;
		count = countCandy();
		arr[i2][j2] = arr[i1][j1];
		arr[i1][j1] = tmp;
		return count;
	}
	
	public static int countCandy() {
		int count = 0;
		
		char tmp;
		int current = 0;
		
		for(int i = 0 ; i < n; i++) {
			tmp = arr[i][0];
			current = 1;
			
			for(int j = 1; j < n; j++) {
				if(arr[i][j] == tmp) {
					current++;
				} else{
					count = Math.max(count, current);
					tmp = arr[i][j];
					current = 1;
				}
			}
			count = Math.max(count, current);
			
			tmp = arr[0][i];
			current = 1;
			for(int j = 1; j < n; j++) {
				if(arr[j][i] == tmp) {
					current++;
				} else{
					count = Math.max(count, current);
					tmp = arr[j][i];
					current = 1;
				}
			}
			count = Math.max(count, current);
		}
		
		return count;
	}

}
