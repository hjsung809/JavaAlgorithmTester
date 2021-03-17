package testcode;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;

import tester.Executable;

public class _1790 implements Executable {

	@Override
	public void main(InputStream in, OutputStream out) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(out));
		String[] tmp = br.readLine().split(" ");
		long n = Long.parseLong(tmp[0]);
		long k = Long.parseLong(tmp[1]);
		
		// 12345678910111213141516
		// 9: 1  90:2 900:3 9000: 4
		// k : 14
		// k - 9  -> 2
		// k - 90 -> 안댐.
		long num = 1;
		long width = 1;
		long amount = 9;
		
		while(k > width * amount) {
			k -= width * amount;
			width ++;
			amount *= 10;
			num *= 10;
		}
		k--;
		long step = k /width;// 2 23 - 9 14
		num += step; //num = 12
		k -= step * width; //4 1
		
		if(num > n) {
			bw.write("-1");
		} else {
			char sol = String.valueOf(num).charAt((int)k);
			bw.write(sol);
		}
		
		bw.close();
		br.close();
		
	}

}
