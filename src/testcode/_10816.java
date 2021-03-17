package testcode;

import java.io.*;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

import tester.Executable;

public class _10816 implements Executable {
	static int n, m;
	static Map<Integer, Long> map;
	
	@Override
	public void main(InputStream in, OutputStream out) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(out));
		map = new HashMap<>();
		StringBuilder sb =new StringBuilder();
		
		n = Integer.parseInt(br.readLine());
		map = Arrays.stream(br.readLine().split(" "))
			.mapToInt(Integer::parseInt)
			.boxed()
			.collect(Collectors.groupingBy(s->s, Collectors.counting()));
		
		m = Integer.parseInt(br.readLine());
		Arrays.stream(br.readLine().split(" "))
			.mapToInt(Integer::parseInt)
			.forEach(i -> {
				Long count = map.get(i);
				if(count == null) count = 0L;
				sb.append(String.valueOf(count)).append(" ");
			});
			
		bw.write(sb.toString());
		bw.close();
		br.close();
	}

}
