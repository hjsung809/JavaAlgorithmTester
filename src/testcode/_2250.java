package testcode;

import java.io.*;
import java.util.*;

import tester.Executable;

public class _2250 implements Executable {
	static int n;
	static Node[] nodes;
	static int count;
	
	static int[] min;
	static int[] max;
	static int maxRow;
	
	public static class Node {
		int idx;
		int row;
		int col;
		boolean isParent;

		Node left;
		Node right;
		
		Node(int idx) {
			this.idx = idx;
			isParent = true;
		}
	}

	@Override
	public void main(InputStream in, OutputStream out) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(out));
		
		n = Integer.parseInt(br.readLine());
		nodes = new Node[n + 1];
		min = new int[n + 1];
		max = new int[n + 1];
		maxRow = 0;
		
		for(int i = 1; i <= n; i++) {
			nodes[i] = new Node(i);
			min[i] = Integer.MAX_VALUE;
			max[i] = 0;
		}
		
		
		int root = -1;
		for(int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			int current = Integer.parseInt(st.nextToken());
			int left = Integer.parseInt(st.nextToken());
			int right = Integer.parseInt(st.nextToken());
			
			if(left != -1) {
				nodes[current].left = nodes[left];
				nodes[left].isParent = false;
			}
			if(right != -1) {
				nodes[current].right = nodes[right];
				nodes[right].isParent = false;
			}
		}
		
		for(int i = 1; i <= n; i++) {
			if(nodes[i].isParent) {
				root = i;
				break;
			}
		}
		

		count = 1;
		inorder(nodes[root], 1);
		
//		for(int i = 1; i <= n; i++) {
//			System.out.println(i + "th row:" + nodes[i].row + " col: " + nodes[i].col);
//			nodes[i].row;
//		}
		
		
//		System.out.println(maxRow);
		int sol = 0;
		int solRow = -1;
		for(int i = maxRow; i >= 1; i--) {
//			System.out.println(i);
//			System.out.println("row:" + i + " width:" + (max[i] - min[i] + 1));
			if(sol <= max[i] - min[i] + 1) {
				sol = max[i] - min[i] + 1;
				solRow = i;
			}
		}
		
		bw.write(solRow + " " + sol);
		bw.close();
		br.close();
	}
	
	public static void inorder(Node current, int row) {
		if(current == null) return;
		inorder(current.left, row + 1);
		
		maxRow = Math.max(maxRow, row);
		current.row = row;
		current.col = count++;
		min[row] = Math.min(min[row], current.col);
		max[row] = Math.max(max[row], current.col);
		
		inorder(current.right, row + 1);
	}
}
