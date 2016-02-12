

import java.util.Scanner;

public class Driver 
{
	public static void main(String[] args) {
		int rowNumber=0, colNumber = 0;
		int rowNumber2=0, colNumber2 = 0;
		int thirdRow=0, thirdCol=0;
		int firstRow=0; int secondRow=0;int  targetRow=0;
		String option="";
		String inputString = null;
		Grid grid=new Grid();
		while(option!="quit")
		{
			menu();
			System.out.println();
			Scanner sc = new Scanner(System.in);
			option=sc.nextLine();

			System.out.println(option);
			switch(option.toLowerCase())
			{
			case "dis":
				grid.display();
				break;
			case "as":
				System.out.println("Enter a value for the cell: ");
				inputString=sc.nextLine();
				System.out.println("Enter a row number: ");
				rowNumber=sc.nextInt();
				System.out.println("Enter a col number: ");
				colNumber=sc.nextInt();
				System.out.println(inputString);
				grid.assign_cell(rowNumber, colNumber, inputString);			
				break;		

			case "f":
				System.out.println("Enter a word ");
				inputString=sc.nextLine();
				System.out.println("From row: ");
				rowNumber=sc.nextInt();
				System.out.println("From column");
				colNumber=sc.nextInt();
				System.out.println("To row: ");
				rowNumber2=sc.nextInt();
				System.out.println("to column");
				colNumber2=sc.nextInt();
				grid.fill(rowNumber, colNumber, rowNumber2, colNumber2, inputString);			
				break;

			case "n":
				System.out.println("From row: ");
				rowNumber=sc.nextInt();
				System.out.println("From column");
				colNumber=sc.nextInt();
				System.out.println("To row: ");
				rowNumber2=sc.nextInt();
				System.out.println("to column");
				colNumber2=sc.nextInt(); 
				grid.number(rowNumber, colNumber, rowNumber2, colNumber2);
				break;

				//public void add  (int fR, int fC, int sR, int sC, int tR, int tC
			case "a":

				System.out.println("First row: ");
				rowNumber=sc.nextInt();
				System.out.println("First column");
				colNumber=sc.nextInt();
				System.out.println("Second row: ");
				rowNumber2=sc.nextInt();
				System.out.println("Second column");
				colNumber2=sc.nextInt(); 
				System.out.println("Target row: ");
				thirdRow=sc.nextInt();
				System.out.println("Target column");
				thirdCol=sc.nextInt();
				grid.add(rowNumber, colNumber, rowNumber2, colNumber2,thirdRow, thirdCol);
				break;

			case "s":
				System.out.println("First row: ");
				rowNumber=sc.nextInt();
				System.out.println("First column");
				colNumber=sc.nextInt();
				System.out.println("Second row: ");
				rowNumber2=sc.nextInt();
				System.out.println("Second column");
				colNumber2=sc.nextInt(); 
				System.out.println("Target row: ");
				thirdRow=sc.nextInt();
				System.out.println("Target column");
				thirdCol=sc.nextInt();
				grid.subtract(rowNumber, colNumber, rowNumber2, colNumber2,thirdRow, thirdCol);
				break;

			case "m":
				System.out.println("First row: ");
				rowNumber=sc.nextInt();
				System.out.println("First column");
				colNumber=sc.nextInt();
				System.out.println("Second row: ");
				rowNumber2=sc.nextInt();
				System.out.println("Second column");
				colNumber2=sc.nextInt(); 
				System.out.println("Target row: ");
				thirdRow=sc.nextInt();
				System.out.println("Target column");
				thirdCol=sc.nextInt();
				grid.multiply(rowNumber, colNumber, rowNumber2, colNumber2,thirdRow, thirdCol);
				break;


			case "d":
				System.out.println("First row: ");
				rowNumber=sc.nextInt();
				System.out.println("First column");
				colNumber=sc.nextInt();
				System.out.println("Second row: ");
				rowNumber2=sc.nextInt();
				System.out.println("Second column");
				colNumber2=sc.nextInt(); 
				System.out.println("Target row: ");
				thirdRow=sc.nextInt();
				System.out.println("Target column");
				thirdCol=sc.nextInt();
				grid.divide(rowNumber, colNumber, rowNumber2, colNumber2,thirdRow, thirdCol);
				break;

			case "ar":
				//int firstRow=0; int secondRow=0;int  targetRow=0;	
				System.out.println("First row: ");
				firstRow=sc.nextInt();
				System.out.println("Second row");
				secondRow=sc.nextInt();
				System.out.println("Target row: ");
				targetRow=sc.nextInt();	
				grid.addRows( firstRow, secondRow, targetRow);
				break;




			case "sr":
				System.out.println("First row: ");
				firstRow=sc.nextInt();
				System.out.println("Second row");
				secondRow=sc.nextInt();
				System.out.println("Target row: ");
				targetRow=sc.nextInt();	
				grid.subTractRows( firstRow, secondRow, targetRow);
				break;

			case "mr":
				System.out.println("First row: ");
				firstRow=sc.nextInt();
				System.out.println("Second row");
				secondRow=sc.nextInt();
				System.out.println("Target row: ");
				targetRow=sc.nextInt();	
				grid.multiplyRows( firstRow, secondRow, targetRow);
				break;

			case "dr":	
				System.out.println("First row: ");
				firstRow=sc.nextInt();
				System.out.println("Second row");
				secondRow=sc.nextInt();
				System.out.println("Target row: ");
				targetRow=sc.nextInt();	
				grid.divideRows( firstRow, secondRow, targetRow);
				break;

			case "ac":
				//int firstRow=0; int secondRow=0;int  targetRow=0;	
				System.out.println("First col: ");
				firstRow=sc.nextInt();
				System.out.println("Second col");
				secondRow=sc.nextInt();
				System.out.println("Target col: ");
				targetRow=sc.nextInt();	
				grid.addColumns( firstRow, secondRow, targetRow);
				break;




			case "sc":
				System.out.println("First col: ");
				firstRow=sc.nextInt();
				System.out.println("Second col");
				secondRow=sc.nextInt();
				System.out.println("Target col: ");
				targetRow=sc.nextInt();	
				grid.subTractColumns( firstRow, secondRow, targetRow);
				break;

			case "mc":
				System.out.println("First col: ");
				firstRow=sc.nextInt();
				System.out.println("Second col");
				secondRow=sc.nextInt();
				System.out.println("Target col: ");
				targetRow=sc.nextInt();	
				grid.multiplyColumns( firstRow, secondRow, targetRow);
				break;

			case "dc":	
				System.out.println("First col: ");
				firstRow=sc.nextInt();
				System.out.println("Second col");
				secondRow=sc.nextInt();
				System.out.println("Target col: ");
				targetRow=sc.nextInt();	
				grid.divideColumns( firstRow, secondRow, targetRow);
				break;

			case "ir":	
				System.out.println("Select the row");
				firstRow=sc.nextInt();
				grid.insertRow(firstRow );
				break;	
			case "ic":	
				System.out.println("Select the col");
				firstRow=sc.nextInt();
				grid.insertCol(firstRow );
				break;	



			}
		}




	}//end of main

















	public static String menu()
	{
		String x="";
		System.out.println(" Operations");
		System.out.println(" display           dis         assign cell       as");
		System.out.println(" fill              f           number            n");
		System.out.println(" add cells         a           subtract cells    s");
		System.out.println(" multiply cells    m           divide cells      d");
		System.out.println(" add rows          ar          subtract rows     sr");
		System.out.println(" multiply rows     mr          divide rows       dr");
		System.out.println(" add columns       ac          subtract columns  sc");
		System.out.println(" multiply columns  mc          divide columns    dc");
		System.out.println(" insert row        ir          insert column     ic");
		System.out.println(" delete row        delr        delete column     delc");
		System.out.println(" quit              q");
		return x;
	}



































}