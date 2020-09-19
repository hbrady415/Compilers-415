package chess;

import java.util.Scanner;

public class sLang {

	static int a=0;
	static int b=0;
	static int c=0;
	static boolean ainit=false;
	static boolean binit=false;
	static boolean cinit=false;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		
		while (true) {
			System.out.println("Enter Input:  ");
		String str = scanner.next();
		if (str.compareTo("stop") == 0) {
			System.out.println("Thank you, come again!");
			break;
		}
		if (str.length() <3) {
			System.out.println("syntax error");
			return;
		}
		if (str.charAt(str.length()-1) != '.') {
			System.out.println("syntax error");
			return;
		}
		//String str= "a=3;b=-a1;c=7;c=+-abc;!c;c=+ab;!c.";
		String subStr= "";
		int i=0;
		int k=0;
		int exprValue=-1;
		while (i< (str.length())) {
			if (str.charAt(i) == '.') {
				if (i != (str.length()-1)) {
					System.out.println("syntax error");
					return;
				}
				subStr=str.substring(k,i);
				if (subStr.length() < 2) {
					System.out.println("syntax error");
				}
				//System.out.println(subStr);
				
				//do the stuff
				if (subStr.charAt(0) == '!') {
					//print
					if (subStr.length() != 2) {System.out.println("syntax error"); return;}
					if (subStr.charAt(1) != 'a' && subStr.charAt(1) != 'b' && subStr.charAt(1) != 'c') {
						System.out.println("syntax error");
						return;
					}
					if (subStr.charAt(1) == 'a') {
						if (ainit ==false) {
							System.out.println("exception");
							return;
						}
						System.out.println(a);
					}
					if (subStr.charAt(1) == 'b') {
						if (binit ==false) {
							System.out.println("exception");
							return;
						}
						System.out.println(b);
					}
					if (subStr.charAt(1) == 'c') {
						if (cinit ==false) {
							System.out.println("exception");
							return;
						}
						System.out.println(c);
					}
					k=i+1;
					i++;
					continue;
				}
				if (subStr.charAt(0) == 'a' || subStr.charAt(0) == 'b' || subStr.charAt(0) == 'c') {
					//Assign
					if (subStr.charAt(1) != '=') {
						System.out.println("syntax error");
						return;
					}
					if (subStr.charAt(2) == '+' || subStr.charAt(2) == '-' || subStr.charAt(2) == '*' || subStr.charAt(2) == '/') {
						exprValue=exprSolve(subStr.charAt(2),subStr.substring(3));
						if (exprValue==-10000) {
							return;
						}
						//System.out.println("EXPR:"+exprValue);
						if (subStr.charAt(0) == 'a') {
							a=exprValue;
							ainit=true;
						}
						if (subStr.charAt(0) == 'b') {
							b=exprValue;
							binit=true;
						}
						if (subStr.charAt(0) == 'c') {
							c=exprValue;
							cinit=true;
						}
						k=i+1;
						i++;
						continue;
					}
					if (subStr.charAt(2) == 'a') {
						if (ainit == false) {
							System.out.println("exception");
							return;
						}
						if (subStr.length() > 3) {
							System.out.println("syntax error");
							return;
						}
						if (subStr.charAt(0) == 'a') {a= a;ainit=true;}
						if (subStr.charAt(0) == 'b') {b= a;binit=true;}
						if (subStr.charAt(0) == 'c') {c= a;cinit=true;}
						k=i+1;
						i++;
						continue;
					}
					if (subStr.charAt(2) == 'b') {
						if (binit == false) {
							System.out.println("exception");
							return;
						}
						if (subStr.length() > 3) {
							System.out.println("syntax error");
							return;
						}
						if (subStr.charAt(0) == 'a') {a= b;ainit=true;}
						if (subStr.charAt(0) == 'b') {b= b;binit=true;}
						if (subStr.charAt(0) == 'c') {c= b;cinit=true;}
						k=i+1;
						i++;
						continue;
					}
					if (subStr.charAt(2) == 'c') {
						if (cinit == false) {
							System.out.println("exception");
							return;
						}
						if (subStr.length() > 3) {
							System.out.println("syntax error");
							return;
						}
						if (subStr.charAt(0) == 'a') {a= c;ainit=true;}
						if (subStr.charAt(0) == 'b') {b= c;binit=true;}
						if (subStr.charAt(0) == 'c') {c= c;cinit=true;}
						k=i+1;
						i++;
						continue;
					}
					if (subStr.charAt(2) <= '9' && subStr.charAt(2) >= '0') {
						if (subStr.length() > 3) {
							System.out.println("syntax error");
							return;
						}
						if (subStr.charAt(0) == 'a') {a= Character.getNumericValue(subStr.charAt(2));ainit=true;}
						if (subStr.charAt(0) == 'b') {b= Character.getNumericValue(subStr.charAt(2));binit=true;}
						if (subStr.charAt(0) == 'c') {c= Character.getNumericValue(subStr.charAt(2));cinit=true;}
						k=i+1;
						i++;
						continue;
					}
					System.out.println("syntax error");
					//END ASSIGN
				}
				
				System.out.println("syntax error");
				return;
			}
			if (str.charAt(i) == ';') {
				subStr=str.substring(k, i);
				//System.out.println(subStr);
				
				//do the stuff
				if (subStr.charAt(0) == '!') {
					//print
					if (subStr.charAt(1) != 'a' && subStr.charAt(1) != 'b' && subStr.charAt(1) != 'c') {
						System.out.println("syntax error");
						return;
					}
					if (subStr.charAt(1) == 'a') {
						System.out.println(a);
					}
					if (subStr.charAt(1) == 'b') {
						System.out.println(b);
					}
					if (subStr.charAt(1) == 'c') {
						System.out.println(c);
					}
					k=i+1;
					i++;
					continue;
				}
				
				if (subStr.charAt(0) == 'a' || subStr.charAt(0) == 'b' || subStr.charAt(0) == 'c') {
					//Assign
					if (subStr.charAt(1) != '=') {
						System.out.println("syntax error");
						return;
					}
					if (subStr.charAt(2) == '+' || subStr.charAt(2) == '-' || subStr.charAt(2) == '*' || subStr.charAt(2) == '/') {
						exprValue=exprSolve(subStr.charAt(2),subStr.substring(3));
						if (exprValue==-10000) {
							return;
						}
						//System.out.println("EXPR:"+exprValue);
						if (subStr.charAt(0) == 'a') {
							a=exprValue;
							ainit=true;
						}
						if (subStr.charAt(0) == 'b') {
							b=exprValue;
							binit=true;
						}
						if (subStr.charAt(0) == 'c') {
							c=exprValue;
							cinit=true;
						}
						k=i+1;
						i++;
						continue;
					}
					if (subStr.charAt(2) == 'a') {
						if (ainit == false) {
							System.out.println("exception");
							return;
						}
						if (subStr.length() > 3) {
							System.out.println("syntax error");
							return;
						}
						if (subStr.charAt(0) == 'a') {a= a;ainit=true;}
						if (subStr.charAt(0) == 'b') {b= a;binit=true;}
						if (subStr.charAt(0) == 'c') {c= a;cinit=true;}
						k=i+1;
						i++;
						continue;
					}
					if (subStr.charAt(2) == 'b') {
						if (binit == false) {
							System.out.println("exception");
							return;
						}
						if (subStr.length() > 3) {
							System.out.println("syntax error");
							return;
						}
						if (subStr.charAt(0) == 'a') {a= b;ainit=true;}
						if (subStr.charAt(0) == 'b') {b= b;binit=true;}
						if (subStr.charAt(0) == 'c') {c= b;cinit=true;}
						k=i+1;
						i++;
						continue;
					}
					if (subStr.charAt(2) == 'c') {
						if (cinit == false) {
							System.out.println("exception");
							return;
						}
						if (subStr.length() > 3) {
							System.out.println("syntax error");
							return;
						}
						if (subStr.charAt(0) == 'a') {a= c;ainit=true;}
						if (subStr.charAt(0) == 'b') {b= c;binit=true;}
						if (subStr.charAt(0) == 'c') {c= c;cinit=true;}
						k=i+1;
						i++;
						continue;
					}
					if (subStr.charAt(2) <= '9' && subStr.charAt(2) >= '0') {
						if (subStr.length() > 3) {
							System.out.println("syntax error");
							return;
						}
						if (subStr.charAt(0) == 'a') {a= Character.getNumericValue(subStr.charAt(2));ainit=true;}
						if (subStr.charAt(0) == 'b') {b= Character.getNumericValue(subStr.charAt(2));binit=true;}
						if (subStr.charAt(0) == 'c') {c= Character.getNumericValue(subStr.charAt(2));cinit=true;}
						k=i+1;
						i++;
						continue;
					}
					System.out.println("syntax error");
					//END ASSIGN
				}
				
				System.out.println("syntax error");
				
				
			}
			
			i++;
		}
		
		
		}
		return;
	}
	
	public static int exprSolve(char oper,String exprStr) {
		if (exprStr.length() < 2) {
			System.out.println("syntax error");
			return -10000;
		}
		//System.out.println("str:"+exprStr);
		int ticker=0;
		int val1=-5;
		int val2=-5;
		String subExpr1="";
		String subExpr2="";
		int i=0;
		int k=0;
		int lol=0;
		//Check for base case and work to most complicated
		if (exprStr.charAt(0) == 'a') {
			if (ainit == false) {
				System.out.println("exception");
				return -10000;
			}
			val1=a;
			lol=1;
		}
		if (exprStr.charAt(0) == 'b') {
			if (binit == false) {
				System.out.println("exception");
				return -10000;
			}
			val1=b;
			lol=1;
		}
		if (exprStr.charAt(0) == 'c') {
			if (cinit == false) {
				System.out.println("exception");
				return -10000;
			}
			val1=c;
			lol=1;
		}
		if (exprStr.charAt(0) >= '0' && exprStr.charAt(0) <= '9') {
			val1=Character.getNumericValue(exprStr.charAt(0));
			lol=1;
		}
		if (lol==1) {
			//we have first expr and need second
			if (exprStr.charAt(1) == 'a') {
				if (ainit == false) {
					System.out.println("exception");
					return -10000; 
				}
				val2=a;
			}
			if (exprStr.charAt(1) == 'b') {
				if (binit == false) {
					System.out.println("exception");
					return -10000;
				}
				val2=b;
			}
			if (exprStr.charAt(1) == 'c') {
				if (cinit == false) {
					System.out.println("exception");
					return -10000;
				}
				val2=c;
			}
			if (Character.getNumericValue(exprStr.charAt(1)) >= 0 && Character.getNumericValue(exprStr.charAt(1)) <= 9) {
				val2=Character.getNumericValue(exprStr.charAt(1));
				//System.out.println(val2);
			}
			if (exprStr.charAt(1) == '+' || exprStr.charAt(1) == '-' || exprStr.charAt(1) == '*' || exprStr.charAt(1) == '/') {
			//must find second expr
				ticker=2;
				i=2;
				k=1;
				while (i<exprStr.length()) {
					if (ticker == 0) {
						subExpr2=exprStr.substring((k+1),i);
						val2=exprSolve(exprStr.charAt(k),subExpr2);
						if (val2==-10000) {
							return -10000;
						}
						break;
					} //exit
					if (exprStr.charAt(i) == 'a' || exprStr.charAt(i) == 'b' || exprStr.charAt(i) == 'c') {
						i++;
						ticker--;
						continue;
					}
					if (exprStr.charAt(i) >= '0' && exprStr.charAt(i) <= '9') {
						i++;
						ticker--;
						continue;
					}
					if (exprStr.charAt(i) == '+' || exprStr.charAt(i) == '-' || exprStr.charAt(i) == '*' || exprStr.charAt(i) == '/') {
						ticker++;
						i++;
						continue;
					}
					System.out.println("syntax error");
				}
			}//NOW WE HAVE SECOND EXPR
			
		}
		
		if (lol==0) {
		if (exprStr.charAt(0) == '+' || exprStr.charAt(0) == '-' || exprStr.charAt(0) == '*' || exprStr.charAt(0) == '/') {
			ticker=2;
			i=1;
			k=0;
			//find first expr
			while (i<exprStr.length()) {
				if (ticker == 0) {
					subExpr1=exprStr.substring((k+1),i);
					val1=exprSolve(exprStr.charAt(k),subExpr1);
					if (val1==-10000) {
						return -10000;
					}
					break;
				} //exit
				if (exprStr.charAt(i) == 'a' || exprStr.charAt(i) == 'b' || exprStr.charAt(i) == 'c') {
					i++;
					ticker--;
					continue;
				}
				if (exprStr.charAt(i) >= '0' && exprStr.charAt(i) <= '9') {
					i++;
					ticker--;
					continue;
				}
				if (exprStr.charAt(i) == '+' || exprStr.charAt(i) == '-' || exprStr.charAt(i) == '*' || exprStr.charAt(i) == '/') {
					ticker++;
					i++;
					continue;
				}
				System.out.println("syntax error");
			}
			//System.out.println("val1:"+val1);
			//NOW WE HAVE FIRST EXPR
			k=i-1;
			if (exprStr.charAt(i) == 'a') {
				if (ainit == false) {
					System.out.println("exception");
					return -10000;
				}
				val2=a;
			}
			if (exprStr.charAt(i) == 'b') {
				if (binit == false) {
					System.out.println("exception");
					return -10000;
				}
				val2=b;
			}
			if (exprStr.charAt(i) == 'c') {
				if (cinit == false) {
					System.out.println("exception");
					return -10000;
				}
				val2=c;
			}
			if (exprStr.charAt(i) >= '0' && exprStr.charAt(i) <= '9') {
				val2=Character.getNumericValue(exprStr.charAt(i));
			}
			if (exprStr.charAt(i) == '+' || exprStr.charAt(i) == '-' || exprStr.charAt(i) == '*' || exprStr.charAt(i) == '/') {
			//must find second expr
				ticker=2;
				while (i<exprStr.length()) {
					if (ticker == 0) {
						subExpr2=exprStr.substring((k+1),i);
						val2=exprSolve(exprStr.charAt(k),subExpr2);
						if (val2==-10000) {
							return -10000;
						}
						break;
					} //exit
					if (exprStr.charAt(i) == 'a' || exprStr.charAt(i) == 'b' || exprStr.charAt(i) == 'c') {
						i++;
						ticker--;
						continue;
					}
					if (exprStr.charAt(i) >= '0' && exprStr.charAt(i) <= '9') {
						i++;
						ticker--;
						continue;
					}
					if (exprStr.charAt(i) == '+' || exprStr.charAt(i) == '-' || exprStr.charAt(i) == '*' || exprStr.charAt(i) == '/') {
						ticker++;
						i++;
						continue;
					}
					System.out.println("syntax error");
				}
			}//NOW WE HAVE SECOND EXPR
			//System.out.println("val2:"+val2);
			
			
		}}//end first if +-*/
		//System.out.println("val1:"+val1);
		//System.out.println("val2:"+val2);
		if (oper == '+') {
			return (val1+val2);
		}
		if (oper == '-') {
			return (val1-val2);
		}
		if (oper == '*') {
			return (val1*val2);
		}
		if (oper == '/') {
			if (val2 == 0 ) {
				System.out.println("exception");
				return -10000;
			}
			return (val1/val2);
		}
		System.out.println("syntax error");
		
		return -1;
	}

}
