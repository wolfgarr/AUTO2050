import java.util.Scanner;

public class fuzzycolors
{
	public static void main(String[] args)
	{
		boolean debug = false; // Change this to true to enable debug messages
		
		int[][] referenceColors = {{0,0,0},{255,0,0},{0,255,0},{0,0,255},{255,255,255},{127,127,127},{255,255,0},{0,255,255},{255,0,255},{255,127,0},{218,165,32},{140,70,20},{128,0,128}}; // reference table to check RGB codes for different colors
		String[] referenceNames = {"black","red",    "green",  "blue",   "white",      "gray",      "yellow",   "cyan",     "magenta",  "orange",   "gold",      "brown",    "purple"}; // Names for the colors in the referenceColors array
		Scanner in = new Scanner(System.in);
		int[] rgb = new int[3];
		
		while (true)
		{
			System.out.println("Enter RGB value (Space between values, -1 to quit): ");
			rgb[0] = in.nextInt();
			if(rgb[0] == -1)
				break;
			rgb[1] = in.nextInt();
			rgb[2] = in.nextInt();
			
			int[] difference = new int[referenceColors.length];
			
			for(int i = 0; i < referenceColors.length; i++)
			{
				// Comparing the color to the colors in the reference table using Pythagorean theorem
				difference[i] = (int)Math.sqrt(((rgb[0] - referenceColors[i][0])*(rgb[0] - referenceColors[i][0])) + ((rgb[1] - referenceColors[i][1])*(rgb[1] - referenceColors[i][1])) + ((rgb[2] - referenceColors[i][2])*(rgb[2] - referenceColors[i][2])));
				
				if(debug)
					System.out.print(difference[i] + "   ");
			}
			
			int minimumDifference = 0;
			// Finding out which reference color is closest to the compared color
			for(int i = 0; i < difference.length; i++)
			{
				if(difference[i] < difference[minimumDifference])
					minimumDifference = i;
			}
			
			if(debug)
				System.out.println(minimumDifference);
			
			String adjective = "";
			
			if(difference[minimumDifference] < 5)
				adjective = "extremely";
			else if (difference[minimumDifference] < 20)
				adjective = "very";
			else if (difference[minimumDifference]< 40)
				adjective = "quite";
			else if (difference[minimumDifference] < 100)
				adjective = "pretty";
			else 
				adjective = "a little";
			
			System.out.println("\nThe given color is "+ adjective + " " + referenceNames[minimumDifference] + ".");
		}
	}
	
}