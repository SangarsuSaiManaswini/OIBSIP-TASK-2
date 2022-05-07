import java.util.Scanner;
import java.util.Random;
//NumberGuessGame class
class NumberGuessGame{
	int sysInput;
	int GamerInput;
	int Guesses=0;
	
	//generatin random number in default constructor
	NumberGuessGame(){
		Random random = new Random();
		this.sysInput=random.nextInt(100)+1;
	}
	
	//method to take user guess
	public boolean takeGamerInput(){
		if(Guesses<10){
				System.out.print("Guess the number : ");
				this.GamerInput=GuessTheNumber.takeIntInput(100);
				Guesses++; 
				return false;
		}
		else{
			System.out.println("Number of attempts are Over... Better Luck next time\n");
			return true;
		}
	}
	
	//To check Gamer guess status
	public boolean isCorrectGuess(){
		if(sysInput==GamerInput){
			System.out.println("Congratulations and celebrations, You DID IT! "+ sysInput+" in " + Guesses +" guesses");
			switch(Guesses) {
				case 1:
				System.out.println("Your score is 100");
				break;
				case 2:
				System.out.println("Your score is 90");
				break;
				case 3:
				System.out.println("Your score is 80");
				break;
				case 4:
				System.out.println("Your score is 70");
				break;
				case 5:
				System.out.println("Your score is 60");
				break;
				case 6:
				System.out.println("Your score is 50");
				break;
				case 7:
				System.out.println("Your score is 40");
				break;
				case 8:
				System.out.println("Your score is 30");
				break;
				case 9:
				System.out.println("Your score is 20");
				break;
				case 10:
				System.out.println("Your score is 10");
				break;
			}
			System.out.println();
			return true;
		}
		else if(Guesses<10 && GamerInput>sysInput){
			if(GamerInput-sysInput>10){
				System.out.println("Too High");
			}
			else{
				System.out.println("Little High");
			}
			
		}
		else if(Guesses<10 && GamerInput<sysInput){
			if(sysInput-GamerInput>10){
				System.out.println("Too Low");
			}
			else{
				System.out.println("Little Low");
			}
			
		}
		return false;
	}
}		

// main class

public class GuessTheNumber {
	// static method to take integer inputs without any limit and exception error
	public static int takeIntInput(int limit){
		int ip=0;
		boolean flag=false;
		
		while(!flag){
			//Exception handling
			try{
				Scanner sc=new Scanner(System.in);
				ip=sc.nextInt();
				flag=true;
				
				if(flag && ip>limit || ip<1){
					System.out.println("Choose the number between 1 to "+limit);
					flag=false;
				}
			}
			catch(Exception e){
				System.out.println("Enter only int value");
				flag=false;
			}
			
		};
		return ip;
		
	}
// main method
	public static void main(String args[]){
		//Input to start the game
		System.out.println("1. Start the Game \n 2. Exit");
		System.out.print("Enter your choice:");
		int choice=takeIntInput(2);
		int nextRound=1;
		int noOfRounds=0;
		
		if(choice==1){
			
			//to check whether next round is there or not
			while(nextRound==1){
				//creating object of Game class
				NumberGuessGame game=new NumberGuessGame();
				boolean isMatch=false;
				boolean limitCross=false;
				System.out.println("\nRound "+ ++noOfRounds+" Starts...");
				
				//To check correct guess and limit cross
				while(!isMatch && !limitCross){
					limitCross=game.takeGamerInput();
					isMatch=game.isCorrectGuess();
				}
				//input for next round
				System.out.println("1. Next Round\n 2. Exit");
				System.out.print("Enter your choice:");
				nextRound=takeIntInput(2);
				if(nextRound!=1){
					System.exit(0);
				}
			}
		}
		else{
			System.exit(0);
		}
	}
					
}	