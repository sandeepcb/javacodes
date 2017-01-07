package com.the.machine;

import java.util.Scanner;
/**
 * @author Sandeep cb
 *
 */
public class Sudoku {
	static int sud[][] = new int[9][9];

	public static void solveGame() {
		for (int k = 0; k < 9; k++) {
			for (int j = 0; j < 9; j++) {
				if (sud[k][j] == 0) {
					int foo = 0;
					int count = 0;
					boolean force = false;
					for (int num = 1; num < 10; num++) {
						int flag = 0;
						int countC = 0;
						int countR = 0;
						for (int i = 0; i < 9; i++) {
							// checking the row
							if (sud[k][i] == num) {
								flag = 1;
								break;
							}
							// checking the column
							if (sud[i][j] == num) {
								flag = 1;
								break;
							}
						}
						// checking the sub-grid
						for (int x = (k / 3) * 3; x < ((k / 3) + 1) * 3; x++)
							for (int z = (j / 3) * 3; z < ((j / 3) + 1) * 3; z++)
								if (sud[x][z] == num) {
									flag = 1;
								}

						if(flag==1)
							continue;
						// checking the corresponding grids for the number
						int kk = k / 3, jj = j / 3;
						int r=0,c=0;
						
						for (int p = 0; p < 3; p++) {
							for (int q = 0; q < 3; q++) {
								//check the columns for number.
								if (q == jj) {
									if (p != kk) {
										for (int xx = 0; xx < 9; xx++) {
											for (int zz = 0; zz < 9; zz++) {
												if (xx / 3 == p && zz / 3 == jj) {
													if (zz != j) {
														if (sud[xx][zz] == num) {
															countC++;
															c=zz;
														}
													}
												}
											}
										}
									}
								}
								//check the rows for number.
								if (p == kk) {
									if (q != jj) {
										for (int xx = 0; xx < 9; xx++) {
											for (int zz = 0; zz < 9; zz++) {
												if (xx / 3 == kk && zz / 3 == q) {
													if (xx != k) {
														if (sud[xx][zz] == num) {
															countR++;
															r=xx;
														}
													}
												}
											}
										}
									}
								}
							}
						}
						if(countR == 0 && countC == 1){
							int add = 1;
							for (int sa = (k / 3) * 3; sa < ((k / 3) + 1) * 3; sa++) {
								for (int as = (j / 3) * 3; as < ((j / 3) + 1) * 3; as++) {
									if(as!=c)
										if(!(sa==k&&as==j))
											if (sud[sa][as] == 0)
												add = 0;
								}
							}
							if (add == 1) {
								force = true;
								foo = num;
								break;
							}
						}
						if(countR == 1 && countC == 0){
							int add = 1;
							for (int sa = (k / 3) * 3; sa < ((k / 3) + 1) * 3; sa++) {
								for (int as = (j / 3) * 3; as < ((j / 3) + 1) * 3; as++) {
									if(sa!=r)
										if(!(sa==k&&as==j))
											if (sud[sa][as] == 0)
												add = 0;
								}
							}
							if (add == 1) {
								force = true;
								foo = num;
								break;
							}
						}
						if(countR == 1 && countC == 1){
							int add = 1;
							for (int sa = (k / 3) * 3; sa < ((k / 3) + 1) * 3; sa++) {
								for (int as = (j / 3) * 3; as < ((j / 3) + 1) * 3; as++) {
									if(sa!=r&&as!=c)
										if(!(sa==k&&as==j))
											if (sud[sa][as] == 0)
												add = 0;
								}
							}
							if (add == 1) {
								force = true;
								foo = num;
								break;
							}
						}
						if(countR == 2 && countC == 1){
							int add = 1;
							for (int sa = (k / 3) * 3; sa < ((k / 3) + 1) * 3; sa++) {
								for (int as = (j / 3) * 3; as < ((j / 3) + 1) * 3; as++) {
									if (sa == k )
										if (as != j && as!=c)
											if (sud[sa][as] == 0)
												add = 0;
								}
							}
							if (add == 1) {
								force = true;
								foo = num;
								break;
							}
						}
						if(countR == 1 && countC == 2){
							int add = 1;
							for (int sa = (k / 3) * 3; sa < ((k / 3) + 1) * 3; sa++) {
								for (int as = (j / 3) * 3; as < ((j / 3) + 1) * 3; as++) {
									if (as == j)
										if (sa != k &&sa!=r)
											if (sud[sa][as] == 0)
												add = 0;
								}
							}
							if (add == 1) {
								force = true;
								foo = num;
								break;
							}
						}
						if (countR == 2 && countC == 0) {
							int add = 1;
							for (int sa = (k / 3) * 3; sa < ((k / 3) + 1) * 3; sa++) {
								for (int as = (j / 3) * 3; as < ((j / 3) + 1) * 3; as++) {
									if (sa == k)
										if (as != j)
											if (sud[sa][as] == 0)
												add = 0;
								}
							}
							if (add == 1) {
								force = true;
								foo = num;
								break;
							}
						}
						if (countR == 0 && countC == 2) {
							int add = 1;
							for (int sa = (k / 3) * 3; sa < ((k / 3) + 1) * 3; sa++) {
								for (int as = (j / 3) * 3; as < ((j / 3) + 1) * 3; as++) {
									if (as == j)
										if (sa != k)
											if (sud[sa][as] == 0)
												add = 0;
								}
							}
							if (add == 1) {
								force = true;
								foo = num;
								break;
							}
						}
						if (countC == 2 && countR == 2) {
							force = true;
							foo = num;
							break;
						}
						if (flag == 0) {
							count++;
							foo = num;
						}
					}
					if (count == 1 || force)
						sud[k][j] = foo;
				}
			}
		}
	}

	public static String[] solve(String args[]) {
		//Scanner sc = new Scanner(System.in);
		int just=0;
		for (int l = 0; l < 9; l++){
			for (int m = 0; m < 9; m++){
				// input zeros for no input please
				sud[l][m] = Integer.parseInt(args[just]);
		        just++;
			}
		}
		
		while (true) {
			int flag = 0;
			solveGame();
			for (int i = 0; i < 9; i++)
				for (int k = 0; k < 9; k++)
					if (sud[i][k] == 0)
						flag = 1;
			if (flag == 0)
				break;
		}
		just=0;
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				
					args[just]=Integer.toString(sud[i][j]);
					just++;
				
			}
		}
		return args;
	}
}
