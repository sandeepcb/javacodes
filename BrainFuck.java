/**
 * 
 */
package com.the.machine;

import java.util.Scanner;

/**
 * @author Sandeep cb
 *
 */
public class BrainFuck {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String code = sc.nextLine();
		int all[] = new int[30000];
		int count = 0, index = 0;
		try {
			for (int i = 0; i < code.length(); i++) {
				if (code.charAt(i) == '.') {
					System.out.println((char) all[count]);
				}
				if (code.charAt(i) == ',') {
					char ab = sc.next().charAt(0);
					all[count] = (int) ab;
				}
				if (code.charAt(i) == '+') {
					all[count]++;
				}
				if (code.charAt(i) == '-') {
					all[count]--;
				}
				if (code.charAt(i) == '>') {
					count++;
				}
				if (code.charAt(i) == '<') {
					count--;
				}
				if (code.charAt(i) == '[') {
					index = i;
					if (all[count] == 0) {
						i = code.indexOf("]");
					}
				}
				if (code.charAt(i) == ']') {
					if (all[count] != 0) {
						i = index;
					}
				}
			}
			sc.close();
		} catch (Exception e) {
			System.out.println("Something went wrong!");
		}
	}

}
