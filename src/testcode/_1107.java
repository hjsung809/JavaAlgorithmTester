package testcode;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

import tester.Executable;

public class _1107 implements Executable {
	static int n;
	static int nLength;
	static int m;
	static ArrayList<Integer> key;
	
	int closeTmp;
	int closeGap;
	
	@Override
	public void main(InputStream in, OutputStream out) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(out));
		String tmp = br.readLine();
		nLength = tmp.length();
		n = Integer.parseInt(tmp);
		m = Integer.parseInt(br.readLine());;
		
		key = new ArrayList<Integer>();
		for(int i = 0; i <= 9; i++) key.add(i);
		
		
		if(m > 0) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			while(st.hasMoreTokens()) {
				key.remove((Integer)Integer.parseInt(st.nextToken()));				
			}
			Collections.sort(key);
		}
		
		int channel = 100;
		int choice1 = Math.abs(channel - n);
		
		if(key.size() > 0 ) {
			int closeNumber = makeCloseNumber();
			int closeNumberLength;
			if(closeNumber < 10 ) {
				closeNumberLength = 1;
			} else {
				closeNumberLength = (int)Math.log10(closeNumber) + 1;
			}
			
//			System.out.println(closeNumber + "," + closeNumberLength);
			
			int choice2 = closeNumberLength + Math.abs(closeNumber - n);
			
			bw.write(String.valueOf(Math.min(choice1, choice2)));
		} else {
			bw.write(String.valueOf(choice1));
		}
		
		bw.close();
		br.close();
	}
	
	public static int makeCloseNumber() {
		int[] c = new int[nLength + 1];
		boolean finding = true;
		// 조합을 만드는 배열.
		
		int closeNumber = Integer.MAX_VALUE;
		int gap = Integer.MAX_VALUE;
		int gapTmp;
		int num;
		
		int lastKey = key.get(key.size() - 1);
		int firstKey = key.get(0);
		
		c[c.length - 1] = firstKey;
		while(finding) {
//			System.out.println(calNum(c));
			
			num = calNum(c);
			gapTmp = Math.abs(num - n);
			if(gapTmp < gap) {
				gap = gapTmp;
				closeNumber = num;
			}
			
			if(c[c.length - 1] == lastKey) {
				int idx = c.length - 1;
				while(idx >= 0 && c[idx] == lastKey) {
					c[idx] = firstKey;
					idx--;
				}
				
				if(idx < 0) {
					finding = false;
				} else {
					c[idx] = nextKey(c[idx]);
				}
			} else {
				c[c.length - 1] = nextKey(c[c.length - 1]);
			}
		}
		return closeNumber;
	}
	
	public static int nextKey(int k) {
		return key.get(key.indexOf(k) + 1);
	}
	
	public static int calNum(int[] c) {
		int sum = 0;
		int offset = 1;
		
		for(int i = c.length - 1; i >= 0; i--) {
			sum += offset * c[i];
			offset *= 10;
		}
		return sum;
	}
}
