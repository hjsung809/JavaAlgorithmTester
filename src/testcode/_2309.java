package testcode;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.util.Arrays;

import tester.Executable;

public class _2309 implements Executable {

	@Override
	public void main(InputStream in, OutputStream out) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(out));
		int[] arr = new int[9];
		int sum = 0;
		
		for(int i = 0 ; i < 9; i++) {
			arr[i] = Integer.parseInt(br.readLine());
			sum += arr[i];
		}
		
		boolean finding = true;
		for(int i = 0; i < 9 && finding; i++) {
			for(int j = 0 ; j < 9; j++) {
				if(i == j) continue;
				
				if(sum - arr[i] - arr[j] == 100) {
					finding = false;
					arr[i] = Integer.MAX_VALUE;
					arr[j] = Integer.MAX_VALUE;
					break;
				}
			}
		}
		
		Arrays.sort(arr);
		for(int i = 0 ; i < 7; i++) {
			bw.write(String.valueOf(arr[i]) + '\n');
		}

		bw.close();
		br.close();
	}

}
