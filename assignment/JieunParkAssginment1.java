import java.util.Scanner;
public class JieunParkAssginment1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int sum=0;
		Scanner reader = new Scanner(System.in);
		
		while(true){
			System.out.println("Enter a positive integer (-3 to print, -2 to reset, -1 to quit)");
			
			int n = reader.nextInt();
			
			if (n>=0){
				sum+=n;}
			else if (n==-3){
				System.out.println("Sum: " + sum);}
			else if(n==-2){
				sum = 0;}
			else if(n==-1){
				System.out.println("Sum: " + sum);
				break;
			}
			
			
			}
		}
	}


