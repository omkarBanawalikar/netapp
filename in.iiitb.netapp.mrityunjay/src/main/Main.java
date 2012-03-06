package main;

public class Main {

	/**
	 * @param args
	 */
	
	static int output;
	public static void main(String[] args) {

		int input1;
		String input2;
		

		// if(args.length!=2){
		// System.out.println("Enter 2 arguments");
		// System.exit(0);
		// }
		//
		// int input1 = Integer.parseInt(args[0]);
		// int[][] donationArray = new int[(int) sizeOfMatrix][(int)
		// sizeOfMatrix];

		// testing
		input1 = 4;
		int[][] donationArray = new int[(int) input1][(int) input1];
		input2 = "(1,7,5,2),(5,12,3,6),(100,9,23,16),(16,4,5,9)";
		// testing over

		// returnCode will give the error msg. check the code to get the error
		// is parsing.
		int returnCode = converttoMatrix(input2, input1, donationArray);
		if (returnCode == 1) {
			System.out.println("Incomplete List of House donation values");
		}
		if (returnCode == 2) {
			System.out.println("Donation value is not a number");
		}

		Processor processor = new Processor(input1);
		processor.init(input1, donationArray);
		processor.updateStateofHousesAndstart();
		output = processor.getOutput();
//		
		System.out.println(" The maximum amount collected is " +output );

	}

	private static int converttoMatrix(String string, int sizeOfMatrix,
			int[][] input2String) {

		String[] temp = string.split(",");

		for (int i = 0; i < temp.length; i++) {
			if (temp[i].startsWith("(")) {
				temp[i] = temp[i].substring(1);
			}
			if (temp[i].endsWith(")")) {
				int number = temp[i].indexOf(")");
				temp[i] = temp[i].substring(0, number);
			}

			System.out.println(temp[i]);
		}
		int tempIndex = 0;
		for (int row = 0; row < sizeOfMatrix; row++) {
			for (int column = 0; column < sizeOfMatrix; column++) {
				try {
					input2String[row][column] = Integer
							.parseInt(temp[tempIndex]);
					tempIndex++;
				}
				// if the second argument does not have a number in its array
				catch (NumberFormatException nfex) {
					return 2;
				}

			}

		}

		// checking if all the elements are send in the string
		if (temp.length != (sizeOfMatrix * sizeOfMatrix))
			return 1;

		return 0;

	}

}
