
public class PlayArgs {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println("PlayArgs got passed in " + args.length + " command-line arguments.");
		System.out.println();
		
		//Loop through the args and print each one
		//Question: why does it print i + 1??
		
		for (int i = 0; i < args.length; i++)
			System.out.println("Arg " + (i +1) + " is: " + args[i]);
	}

}
