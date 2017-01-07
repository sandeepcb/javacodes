package com.the.machine;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class NanakuPrematho {


	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		int n=sc.nextInt();
		sc.close();
		List<Integer> all=new ArrayList<Integer>();
		for(int i=1;i<n+1;i++){
			all.add(i);
		}
		int count=0;
		while(true){
			if(count==all.size())
				count=0;
			if(count==all.size()-1){
				count=-1;
			}
			if(all.size()==1)
				break;
			all.remove(all.get(count+1));
			count++;
		}
		System.out.println(all.get(0));
	}


}
