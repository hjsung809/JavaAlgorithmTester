package testcode;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;

import tester.Executable;

public class _10799 implements Executable{

	@Override
	public void main(InputStream in, OutputStream out) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(out));
		char[] tmp = br.readLine().toCharArray();
		int sum = 0;
		int ironBar = 0;
		boolean isRaser = true;
		
		for(char c : tmp) {
			if(c == '(') {
				ironBar++;
				isRaser = true;
			} else {
				ironBar--;
				// 레이저 일때.
				if(isRaser) {
					sum += ironBar;
					isRaser = false;
				} else {
					sum += 1;
				}
			}
		}
		
		bw.write(String.valueOf(sum));
		bw.close();
		br.close();
	}
	
}
