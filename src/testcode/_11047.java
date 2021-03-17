package testcode;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;

import tester.Executable;

public class _11047 implements Executable {

	@Override
	public void main(InputStream in, OutputStream out) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(out));
		
		int money = Integer.parseInt(br.readLine().split(" ")[1]);
		int[] coins = br.lines().mapToInt(Integer::parseInt).toArray();
		int count = 0;
		
		for(int i = coins.length - 1; i >= 0; i--) {
			if(coins[i] > money) continue;
			
			int num = money/coins[i];
			count += num;
			money -= coins[i] * num;
		}
		bw.write(String.valueOf(count));
		bw.close();
		br.close();
	}

}
