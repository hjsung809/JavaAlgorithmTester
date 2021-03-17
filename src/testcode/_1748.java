package testcode;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;

import tester.Executable;

public class _1748 implements Executable {

	@Override
	public void main(InputStream in, OutputStream out) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(out));
		
		int n = Integer.parseInt(br.readLine());
		int sol = 0;
		int count = 1;
		int st = 10;
		
		while(n >= st) {
			sol += count * (st - st/10);
			st *= 10;
			count++;
		}
		sol += (n - st/10 + 1) * count;
		
		bw.write(String.valueOf(sol));
		bw.close();
		br.close();
	}

}
