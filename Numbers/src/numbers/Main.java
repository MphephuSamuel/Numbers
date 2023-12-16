package numbers;
import java.util.*;
public class Main {
	Random generator = new Random();
	Scanner input = new Scanner(System.in);
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.println("which one do you want to play\n1.Random numbers\n2.even and odd\n");
		int choice = input.nextInt();
		if(choice==1)
			randomNumbers();
		else if(choice==2)
			evenOdd();
		input.close();
		
	}
	public static void randomNumbers() {
		Random generator = new Random();
		Scanner input = new Scanner(System.in);
		int num1;
		int num2;
		int sign;
		int temp;
		double result=0;
		double ans;
		char theSign='+';
		int attempt=0;
		System.out.print("enter the number of maximum attempts : ");
		int maxAttempt= input.nextInt();
		double percent;
		int correctOptions=0;
		int[] persCalculator = new int[maxAttempt];
		System.out.println();
		while(attempt<maxAttempt) {
			num1 = generator.nextInt(1,20);
			num2 = generator.nextInt(1,20);
			sign = generator.nextInt(4);
			switch(sign) {
				case 0:
					theSign='+';
					result=num1+num2;
					break;
				case 1:
					theSign='-';
					if(num1>=num2)
						result=num1-num2;
					else {
						result=num2-num1;
						temp = num1;
						num1=num2;
						num2=temp;
						}
					break;
				case 2:
					theSign='/';
					while(true) {
						if(num1>=num2&&((double)num1%num2==0)) {
							result=(double)num1/num2;
							break;
						}
						else if(num2>num1&&((double)num2%num1==0)) {
							result=(double)num2/num1;
							temp=num1;
							num1=num2;
							num2=temp;
							break;
						}
						else {
							num1=generator.nextInt(1,12);
							num2=generator.nextInt(1,12);
						}
					}
					break;
				case 3:
					theSign='*';
					result=num1*num2;
					break;
			}
			System.out.print(num1 + "" + theSign + "" + num2);
			System.out.println();
			ans=input.nextDouble();
			input.nextLine();
			if(ans==result) {
				persCalculator[attempt]=1;
				System.out.println("Correct");
				persCalculator[attempt]=1;
			}
			else {
				persCalculator[attempt]=0;
				System.out.println("Incorrect\n" + "The correct answer is " + result);
			}
			++attempt;
		}
		for(int x=0;x<maxAttempt;++x) {
			correctOptions=correctOptions+persCalculator[x];
		}
		percent=((double)correctOptions/maxAttempt)*100;
		System.out.println();
		System.out.println("you got " + percent+"%");
	}
	
	public static void evenOdd() {
		Random generator = new Random();
		Scanner input = new Scanner(System.in);
		int num;
		int choice=1;
		int ans;
		String evenOdd="Even";
		int attempt=0;
		System.out.print("enter the number of maximum attempts : ");
		int maxAttempt= input.nextInt();
		int[] persCalculator = new int[maxAttempt];
		while(attempt<maxAttempt) {
			num=generator.nextInt(1,101);
			if(num%2==0) {
				choice=0;
			}
			if(choice==1)
				evenOdd="even";
			System.out.println(num
					+ "\n0.Even\n1.Odd\n");
			ans=input.nextInt();
			if(ans==choice) {
				System.out.println("Correct");
			}
			else {
				System.out.println("Incorrect" + "\nThe number is " + evenOdd);
			}
			++attempt;
		}
	}
}
