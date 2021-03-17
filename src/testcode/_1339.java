package testcode;

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

import tester.Executable;

public class _1339 implements Executable{
	static int n , max;
	static int c;
	static List<Integer[]> words;
	static List<Integer> chars;
	
	static int[] map;
	static boolean[] check;
	
	@Override
	public void main(InputStream in, OutputStream out) throws Exception {
		// TODO Auto-generated method stub
		max = 0;
		map = new int[26];
		check = new boolean[10];
		
		BufferedReader br = new BufferedReader(new InputStreamReader(in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(out));
		n = Integer.parseInt(br.readLine());
		
		words = br.lines()
				.map(s -> s.chars().boxed().toArray(Integer[]::new))
				.collect(Collectors.toList());
		
		chars = words.stream()
				.flatMap(Arrays::stream)
				.distinct()
				.collect(Collectors.toList());
				
		c = chars.size();
		
		//백트래킹
		backtracking(0);
		bw.write(String.valueOf(max));
		
		br.close();
		bw.close();
	}
	
	public static void backtracking(int idx) {
		if(idx == c) {
			max = Math.max(max, cal());
			return;
		}
		
		for(int i = 9; i > 9 - c; i--) {
			if(!check[i]) {
				check[i] = true;
				map[chars.get(idx) - 'A'] = i;
				backtracking(idx + 1);
				check[i] = false;				
			}
		}
	}
	
	public static int cal() {
		return words.stream()
				.mapToInt(s -> {
					int sum = 0;

					for(int i = s.length - 1, j = 1; i >=0; i--, j *= 10) {
						sum += map[s[i] - 'A'] * j;
					}
					return sum;
				})
				.sum();
	}
	
}
