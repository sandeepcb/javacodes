package com.the.machine;

import java.util.Date;

public class Random {
	public static void main(String[] args) {
		long all=make(),fin = 0;
		if(make()!=0){
			for(int i=0;i<all;i++){
				if(i==0){
					fin=make();
				}
				fin=(fin*10)+make();
			}
			System.out.println(fin);
		}
	}
	public static long make(){
		Date yes= new Date();
		return yes.getTime()%10;
	}
}
