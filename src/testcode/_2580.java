package testcode;

import tester.Executable;

import java.io.*;
import java.util.*;

public class _2580 implements Executable{
	static int[][] arr;
	static int[] rowCheck, colCheck, sectionCheck;
	static ArrayList<EmptyBlock> emptyBlocks;

	static class EmptyBlock {
		int r, c;

		public EmptyBlock(int i, int j) {
			this.r = i;
			this.c = j;
		}
	}

	public static int getSectionIndex(int i, int j) {
		int sr = (i - 1) / 3;
		int sc = (j - 1) / 3;
		return sr * 3 + sc + 1;
	}

	public static boolean backtracking(int index) {
		if(index == emptyBlocks.size()) return true;

		EmptyBlock block = emptyBlocks.get(index);
		int avail = rowCheck[block.r] & colCheck[block.c] & sectionCheck[getSectionIndex(block.r, block.c)];
		for(int i = 1, j = 2; i <= 9; i++, j <<= 1) {
			if((avail & j) == j) {
				arr[block.r][block.c] = i;
				rowCheck[block.r] -= j;
				colCheck[block.c] -= j;
				sectionCheck[getSectionIndex(block.r, block.c)] -= j;

				if(backtracking(index + 1)) {
					return true;
				}

				arr[block.r][block.c] = 0;
				rowCheck[block.r] += j;
				colCheck[block.c] += j;
				sectionCheck[getSectionIndex(block.r, block.c)] += j;
			}
		}
		return false;
	}
	
	@Override
	public void main(InputStream in, OutputStream out) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(out));

		// 비트 연산 체커
		rowCheck = new int[10];
		colCheck = new int[10];
		sectionCheck = new int[10];
		int adder = 0;
		for(int i = 1, j = 2; i <=9; i++, j <<= 1) {
			adder += j;
		}
		for(int i = 1; i <= 9; i++) {
			rowCheck[i] = adder;
			colCheck[i] = adder;
			sectionCheck[i] = adder;
		}

		// 배열 읽기
		arr = new int[10][10];
		emptyBlocks = new ArrayList<>();
		StringTokenizer st;

		for(int i = 1; i <=9; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 1; j <= 9; j++) {
				int tmp = Integer.parseInt(st.nextToken());
				arr[i][j] = tmp;

				if(tmp == 0) {
					emptyBlocks.add(new EmptyBlock(i, j));
				} else {
					adder = 1 << tmp;
					rowCheck[i] -= adder;
					colCheck[j] -= adder;
					sectionCheck[getSectionIndex(i,j)] -= adder;
				}
			}
		}

		backtracking(0);

		StringBuilder sb = new StringBuilder();
		for(int i = 1; i <= 9; i++) {
			for(int j = 1; j <= 9; j++) {
				sb.append(arr[i][j]).append(' ');
			}
			sb.append('\n');
		}
		bw.write(sb.toString());
		br.close();
		bw.close();
	}
}
