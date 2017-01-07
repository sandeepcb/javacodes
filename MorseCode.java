/**
 * 
 */
package com.the.machine;

import java.util.Scanner;

/**
 * @author Sandeep cb
 *
 */
public class MorseCode {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int a=sc.nextInt();
		String code[]={".-",};
		if(a==0){
			encode(sc);
		}
		else{
			decode(sc);
		}
	}
	public static void encode(Scanner sc){
		String ac=sc.next();
		sc.close();
		System.out.println();
		
	}
	public static void decode(Scanner sc){
		String ac=sc.next();
		sc.close();
		System.out.println();
	}
}
