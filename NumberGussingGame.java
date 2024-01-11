import java.util.Scanner;
public class NumberGussingGame
{
public static void main(String args[])
{
Scanner scanner = new Scanner(System.in);
int lowerBound = 1;
int upperBound = 100;
int numberToGuess = (int)(Math.random()*(upperBound-lowerBound+1))+lowerBound;
int maxAttempts = 10;
System.out.println("Welcome to number Gussing Game!");
System.out.println("I have select number between 1 to 100. try to guss it.");
for(int attempt = 1; attempt <=maxAttempts; attempt++)
{
System.out.print("Attempt"+ attempt +":Enter your gusse:");
int userGuess = scanner.nextInt();
if(userGuess == numberToGuess){
System.out.println("Congratulations! you gussed the correct number.");
break;
}
else if(userGuess < numberToGuess)
{
System.out.println("Too low. Try again!");
}
else{
System.out.println("Too high. Try again");
}
if(attempt == maxAttempts){
System.out.println("Sorry, you'have reached the maximum number of attempts. The correct number was:"+ numberToGuess);
}
}
scanner.close();
}
}

 