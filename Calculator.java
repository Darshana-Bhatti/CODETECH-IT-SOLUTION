import java.util.Scanner;
public class Calculator{
public static void main(String args[]){
Scanner scanner = new Scanner(System.in);
System.out.println("Enter first number:");
double num1 = scanner.nextDouble();
System.out.println("Enter second number");
double num2 = scanner.nextDouble();
System.out.println("Choose operation:");
System.out.println("1. Addition (+)");
System.out.println("2. Subtraction(-)");
System.out.println( "3. Multiplication(*)");
System.out.println("4. Division (/)");
System.out.println("Enter operation number:");
int choice = scanner.nextInt();
double result = 0;
switch(choice){
case 1:
result = num1+num2;
break;
case 2:
result = num1-num2;
break;
case 3:
result = num1*num2;
break;
case 4:
if(num2 != 0){
	result = num1/num2;
}
else{
	System.out.println("Cannot divide by zero.");
	return;
}
break; 
default:
	System.out.println("Invalid operation choice");
	return;
}
System.out.println("Result:" +result);
}
}
