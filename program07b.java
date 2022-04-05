package program07b;
import java.util.Scanner;
public class program07b {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner std = new Scanner(System.in);
		String n;
		int w = 0 ;// to  calculate how many times he won
		int l  = 0;// how many times he lost
		int t  = 0;// how many times it was a tie
		int p = 0;// how many times the player played
		int pp; // number recieved from the method for p
		int c;
		String r;
		welcome ();
		
		do {
			System.out.print("Do you want to play (y/n):");
			n = std.nextLine();
			n.toLowerCase();
			if (n.equals("y")) {	
				System.out.println("\nPlayer\n"
						+ "------------");
				pp = randomnum();
				System.out.println("\nComputer\n"
						+ "------------");
				c = randomnum();
				r =  results(pp, c);
				System.out.println(r);
				w = win(pp,c, w);
				l = lose(pp,c, l);
				t = tie(pp,c, t);
				++p;
			}
			
		}while (!n.equals("n") );
		end(p, w, t, l);
		
		std.close();
	}
	public static int randomnum() {/*This method is to check the values of the dice and to give back an int that describes 
		if is a triple, pair, junk*/
			int triple = 9;// made this the max pair can be so I can assure that triple always wins  
			int pair  = 2;
			int junk = 1;// this one is the lowest to make sure junk losses againts all the others
			int d1 = (int) ((Math.random() *6) +1);
			int d2 = (int) ((Math.random() *6) +1);
			int d3 = (int) ((Math.random() *6) +1);
			System.out.println(d1 + " " + d2 + " " + d3);
			if (d1 == d2 && d2 == d3) {// this check for triples 
				return triple + d1;// this adds the value of triple with the value of the dice roll to see if is a high triple
			}else if(d1 == d2 || d2 == d3 || d1 == d3) {// this check for pairs 
				if (d1 == d2){//this if's are to add the value of pair with the number of the pair to know if they they are a high pair 
				return pair + d1;
				}else 
				if (d2 == d3){
					return pair + d2;
				}else 
				if (d1== d3){
					return pair + d1;
				}else {
					return pair;
				}
				
			}else {
				return junk ;
			}
			
			
		}
		public static String results (int x, int y) {
			int p = x;
			int c = y;
			if (p > c) {// checks if the value of player is higher 
				return "\nYou Winnnn!!! :)\n";
			}else if (p == c) {// checks if the value is the same so its a tie 
				return "\nIts a tie :|\n";		
			}else {// this checks if is not bigger or equal then is lower so its a lose
				return "\nyou lost tough luck :(\n";
			
			}
			
		}
		public static int win (int x, int y, int z) {
			int p = x;
			int c = y;
			int w = z;
			if (p > c) {// checks if the value of player is higher 
				return ++w;
			}else return w;
		}
		public static int lose (int x, int y, int z) {
			int p = x;
			int c = y;
			int l = z;
			if (p < c) {// checks if the value of player is higher 
				return ++l;
			}else return l;
		}
		public static int tie (int x, int y, int z) {
			int p = x;
			int c = y;
			int t = z;
			if (p == c) {// checks if the value of player is higher 
				return ++t;
			}else return t;
		}
		public static void welcome() {
			System.out.println("Welcome to Opponent Dice\n"
					+ "---------------------------------------------------------\n"
					+ "You will be playing dice against the opponent\n"
					+ "High beats low, and same ties\n"
					+ "Triples beat Pairs and Junk\n"
					+ "Pairs beat Junk\n"
					+ "In the case of two identical Pairs - high card decides\n"
					+ "in the case of two Junks - its a tie\n"
					+ "--------------------------------------------------------- ");
		}
		public static void end(int x, int y, int z, int c) {
			int p = x;
			int w = y;
			int t = z;
			int l = c;
			System.out.println("\nPlayer’s Dice Results\n"
					+ "----------------------\n"
					+ "You played "+ p + " rounds\n"
					+ "Rounds won: " + w + "\n"
					+ "Rounds tied: " + t + "\n"
					+ "Rounds lost: " + l + "\n"
					+ "---------------------");
		}

}
