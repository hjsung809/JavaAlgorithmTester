package testcode;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

import tester.Executable;

public class _10973 implements Executable {
	static int[] arr;
	static boolean[] check; //썻는지 안썻는지.
	static int n;

	@Override
	public void main(InputStream in, OutputStream out) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(out));
		
		n = Integer.parseInt(br.readLine());
		arr = new int[n + 1];
		check = new boolean[n + 1];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 1; i <= n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			check[i] = true;
		}
		preArr();
		
		if(arr != null) {
			for(int i = 1; i <= n; i++) {
				bw.write(String.valueOf(arr[i]) + " ");
			}
		} else {
			bw.write("-1");
		}
		
		br.close();
		bw.close();
	}
	
	static void preArr() {
		for(int i = n; i > 1; i--) {
			check[arr[i]] = false;
			int pre = findPre(i - 1);

			if(pre != -1) {
				check[arr[i - 1]] = false;
//				System.out.println("next: " + next + "i: " + i);
				check[pre] = true;
				arr[i - 1] = pre;
				fillArr(i);
				return;
			}
		}
		
		arr = null;
	}
	
	static int findPre(int idx) {
		for(int i = arr[idx] - 1; i >= 1; i--) {
			if(!check[i]) {
				return i;
			}
		}
		return -1;
	}
	
	static void fillArr(int idx) {
		int start = n;
		for(int i = idx; i <= n; i++) {
			for(int j = start; j >= 1; j--) {
				if(!check[j]) {
					arr[i] = j;
					start = j - 1;
//					check[j] = true;
					break;
				}
			}
		}
	}
}
