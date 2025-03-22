import java.util.*;
import java.util.Arrays;

public class FLAMES {
	private String boy;
	private String girl;
	char[] All;
	char[] result;
	
//-----------------main-------------------------------------------------------------
	public static void main(String[] args) {
		FLAMES obj=new FLAMES();
		System.out.print("What's your gender :");
		obj.gender();
		obj.convert();
		obj.calc();
		obj.prnt();	
	}
	

//--------------user input--------------------------------------------------------
	public void gender() {
		Scanner inp=new Scanner(System.in);
		String gen=inp.nextLine();
		System.out.println("--------------------------------------------");
		if(gen.equalsIgnoreCase("M")||gen.equalsIgnoreCase("Male")) {
			System.out.print("Enter your name : ");
			 this.boy=inp.nextLine();
			System.out.print("Enter her name : ");
			this.girl=inp.nextLine();
			
		}
		else if(gen.equalsIgnoreCase("F")||gen.equalsIgnoreCase("Female")){
			System.out.print("Enter your name : ");
			this.girl=inp.nextLine();
			System.out.print("Enter his name : ");
			this.boy=inp.nextLine();
		}
		else {
			System.out.print("Invalid Input");
		}
		
//-----------------------converting string to char----------------------------------
	}
	public void convert() {
		char[] All=new char[boy.length()+girl.length()];
		String ad=this.boy+this.girl;
		ad=ad.toLowerCase();
 		this.All=ad.toCharArray();
	}
	
	
//-------------------------calculating the number of charcters remain after cancelling the common characters------
	
	public void calc() {
        int[] count = new int[256]; // Array to count occurrences
        for (char c : this.All) {
            count[c]++;
        }
        char[] temp = new char[this.All.length]; // Temporary array for valid characters
        int uniqueIndex = 0;
    
        for (char c : this.All) {
            if (count[c] % 2 != 0) { 
                temp[uniqueIndex++] = c;
                count[c] = 0; 
            }
        }
    
        this.result = new char[uniqueIndex];
        for (int i = 0; i < uniqueIndex; i++) {
            this.result[i] = temp[i];    
     }
	}
	
	
//--------------------based on the numbers calculating the charcter with respect to relation------------------- 
	public void prnt() {
        char[] flames = {'F', 'L', 'A', 'M', 'E', 'S'};
        int flamesLength = flames.length;
        int currentIndex = 0;
        int remainingCount = this.result.length;

        while (flamesLength > 1) {
            currentIndex = (currentIndex + remainingCount - 1) % flamesLength;
            for (int i = currentIndex; i < flamesLength - 1; i++) {
                flames[i] = flames[i + 1];
            }
            flames[flamesLength - 1] = '\0';
            flamesLength--; // Reduce the size of the array
        }
        // Output the result
        char relationship = flames[0];
        
        System.out.println("--------------------------------------------");
        
        switch(relationship) {
        case 'F':
        	System.out.println("According to FLAMES law, you both are friends...");
        	break;
        case 'L':
        	System.out.println("According to FLAMES law, you both are Lovers...");
        	break;
        case 'A':
        	System.out.println("According to FLAMES law, you both will have an Arranged Marriage...");
        	break;
        case 'M':
        	System.out.println("According to FLAMES law, you both will get Married...");
        	break;
        case 'E':
        	System.out.println("According to FLAMES law, you both will be Enemies....");
        	break;
        case 'S':
        	System.out.println("According to FLAMES law, you both will be like Brother and Sister...");
        	break;
        default:
        	System.out.println("Invalid relationship");
        	break;
        	}   
        }
	}
    
