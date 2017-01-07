package com.the.machine;

import java.util.*;
/**
 * @author Sandeep cb
 *
 */
public class GreyCode {

	public static void main(String[] args) {
		String ab = "000";
		List<String> all= new ArrayList<String>();
		all.add(ab);
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		sc.close();
		double b=8;
		int count=4;
		for (int i = 0; i < n-1; i++) {
			//if(i==7||i==23||i==55||i==119||i==251){
			if(i==b-1){
				b=b+Math.pow(2, count);
				count++;
				ab="1"+ab;
				all.add(ab);
				continue;
			}
			for (int j = 0; j < ab.length(); j++) {
				if (ab.charAt(j) == '0') {
					String abc=ab.substring(0,j)+"1"+ab.substring(j+1,ab.length());
					if(!all.contains(abc)){
						all.add(abc);
						ab=abc;
						break;
					}
				}
				if (ab.charAt(j) == '1') {
					String abc=ab.substring(0,j)+"0"+ab.substring(j+1,ab.length());
					if(!all.contains(abc)){
						all.add(abc);
						ab=abc;
						break;
					}
				}
			}
		}
		for (String aa: all){
			System.out.println(aa);
		}
	}
}
