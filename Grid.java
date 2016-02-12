import java.util.Scanner;

//Will have  field for the number of fields and the number of columns
public class Grid {
	Node head=new Node();
	private  int row=7;
	private  int col=6;

	Node[][] grid=new Node[row][col];

	public Grid()                                           //Defult ctr, Create instance of Grid
	{
		for( int i=0;i<row;i++){
			for( int j=0;j<col;j++){                                // 1. Fill array with nodes
				grid[i][j]=new Node();}}

		grid[0][0]=head;                                            // 2. Assign head to [0][0]
		Node position=head;

		for( int i=0;i<row;i++)                                     // 3. Changes col 0,1 0,2 0,3 1,0
		{
			for( int j=0;j<col;j++)//--                             // 4. Changes column __0,1,2
			{
				if(i+j !=0)                                         // 5. Make sure I dont move head yet
				{
					position.setRight(grid[i][j]);                  // 6. ASSIGNS RIGHT to position Node
					position=grid[i][j];                            // 7. Moves Position to the next cell
					if(j==col-1)                                    // 8. Only if position is at the end of the row grid
					{
                        position.setRight(grid[i][0]);              // 9. Link last cell to beginning of the row
                        if(i+1<row)  								// 10. Before moving pos. check if there is a grid under 1+1<3
                            position=grid[i+1][0]; }				// 10. Move position down a row
				}
            }
			position=head;

			for( int I=0;I<col;I++)									// 11. Changes row 1,0 2,0 0,3 1,0 
			{
				for( int j=0;j<row;j++)//--							// 4. Changes column __0,1,2
				{
					if(I+j != 0)
					{                                               //5. If grid[i][j] is empty
						position.setDown(grid[j][I]);       		// 6. ASSIGNS RIGHT to position Node
						position=grid[j][I];                           // 7. Moves Position
						if(j==row-1)//2=2                           // 8. Only if position is at the end of the row grid
						{position.setDown(grid[0][I]);              // 9. Link last cell to beginning of the row
						if(I+1<col) 								// 10. Before moving pos. check if there is a grid u
							position=grid[0][I+1]; }				// 10. Move position down a row
					}
				}// End for: if (Line 5)  ForLoop(j)(i)
			}
		} //** DONT DELETE helpful counter for Debuggin.
		//		int x=0;
		//		for(int k=0;k<row; k++)
		//		{
		//			for(int q=0;q<col; q++){
		//				grid[k][q].setThevalue(""+ x);
		//				x++;
		//			}
		//		}//end loop
	}//end ctr

	public void display()
	{
		Node position=head;							//Make pointer
		int currentRowCount=rowListLenght(head);
		int colListLenght= colListLenght(head);
		//int currentRowCount=rowListLenght(head);
		System.out.print("     ");
		
        for(int i=0;i<colListLenght;i++)							//Col. Title generator + counter
		{
			System.out.print(String.format("%10s", "col "+i));
		}
		
		System.out.println("\n");
		
		
		
		for(int i=0; i< currentRowCount; i++)//Count row             
		{
			System.out.print("row "+ i);
			for(int j=0; j<colListLenght; j++)
			{
				if(position !=null){
					System.out.print(String.format("%10s",position.toString()));
				}

				position=position.getRight();
			}
			System.out.println("\n");
			position=position.getDown();
		}//END loop

		position=head;
		//		System.out.println(position.toString());
	}

	public int rowListLenght(Node headNode){
		int rowLength=0;
		Node position=head;
		while(position !=null){
			rowLength++;
			position=position.getDown();
			if(position==headNode)
				break;
		}
		return rowLength;
	}
	public int colListLenght(Node headNode){
		int colLength=0;
		Node position=head;
		while(position !=null){
			colLength++;
			position=position.getRight();
			if(position==headNode)
				break;
		}
		return colLength;
	}
	
	
	public void assign_cell(int numRow, int numCol, String q)//        
	{
		if(withinRange(numRow, numCol)==true)
		{
			Node position=head;

			if(numRow+numCol > 0)                                //Cond: prevents changing head
			{										
				if(numCol>0)
				{
					for(int i=0;i<numCol;i++)                       *Move right*/
					{	
						position=position.getRight();
						//					System.out.println("You are here i: " + i);
					}	
				}

				if(numRow>0)
				{
					for(int j=0;j<numRow;j++)                   /*Move down*/
					{
						position=position.getDown();
					}
				}
				position.toString();
				position.setThevalue(q);
			}															//end of everything else but head
			position.setThevalue(q);
			
        }
	}//end method

	public Node movePointer (int numRow, int numCol)
	{
		Node position=head;
		if(numRow+numCol > 0)                                       // to make sure I avoid changing head
		{										
			if(numCol>0)
			{
				for(int i=0;i<numCol;i++)                           /*Move right*/
				{	
					position=position.getRight();
					//					System.out.println("You are here i: " + i);
				}	
			}

			if(numRow>0)
			{
				for(int j=0;j<numRow;j++)                           /*Move down*/
				{
					position=position.getDown();
				}
			}
			return position;
		}
		return position;                    //end of movePointer method
	}

	public void number(int rowLU, int colLU, int rowRD, int colRD)
	{
		Node leftUpNode=movePointer(rowLU, colLU);
		Node position=leftUpNode;
		Node levelTracker=leftUpNode;
		int counter=0;
		//		System.out.println("You are here");

		for(int k=0;k<=rowRD-rowLU;k++){
			for(int i=0;i<=colRD-colLU;i++)
			{
				position.setThevalue(counter+"");
				position=position.getRight();
				counter++;
				if(colLU-colRD==i)
				{
					leftUpNode.setThevalue(counter+"");
				}
			}
			position=levelTracker.getDown();
			levelTracker=levelTracker.getDown();
		}
	}
	public boolean withinRange(int numberRow, int numberCol)
	{
		if(numberRow<row && numberCol<col){
			return true;
		}
		System.out.println("Out of range!");
		return false;
	}

    //Functions availabe in Grid object
    
    
	public void fill (int rowLU, int colLU, int rowRD, int colRD, String input)
	{

		Node leftUpNode=movePointer(rowLU, colLU);
		Node position=leftUpNode;
		Node levelTracker=leftUpNode;
		//		System.out.println("You are here");

		for(int k=0;k<=rowRD-rowLU;k++){
			for(int i=0;i<=colRD-colLU;i++)
			{
				position.setThevalue(input);
				position=position.getRight();
				if(colLU-colRD==i)
				{
					leftUpNode.setThevalue(input);
				}
			}
			position=levelTracker.getDown();
			levelTracker=levelTracker.getDown();
		}

	}

	public void add  (int fR, int fC, int sR, int sC, int tR, int tC)
	{
		Node position=head;
		double sum=0;
		if(fR+fC > 0)				// to make sure I avoid changing head
		{										
			if(fC>0)
			{
				for(int i=0;i<fC;i++)            /*Move right*/
				{	
					position=position.getRight();
					//					System.out.println("You are here i: " + i);
				}	
			}

			if(fR>0)
			{
				for(int j=0;j<fR;j++)            /*Move down*/
				{
					position=position.getDown();
				}
			}
		}
		//		System.out.println("Position one is:"+ position.toString());
		/*END OF FINDING THE FIRST position
		 * 
		 */
		Node position2=head;
		if(sR+sC > 0)				// to make sure I avoid changing head
		{										
			if(sC>0)
			{
				for(int i=0;i<sC;i++)            /*Move right*/
				{	
					position2=position2.getRight();
					//					System.out.println("You are here i: " + i);
				}	
			}

			if(sR>0)
			{
				for(int j=0;j<sR;j++)            /*Move down*/
				{
					position2=position2.getDown();
				}
			}
		}
		//		System.out.println("Position two is:"+ position2.toString());

		if(position.getThevalue().getTag().equals(position2.getThevalue().getTag()))
		{

			double x=position.getThevalue().getdVal();
			double y=position2.getThevalue().getdVal();
			sum=x+y;
		}
		//		System.out.println("sum is: "+ sum);
		/*Move pointer to target cell*/

		Node targetNode=head;//tR

		if(tR+tC > 0)				// to make sure I avoid changing head
		{										
			if(tC>0)
			{
				for(int i=0;i<tC;i++)            /*Move right*/
				{	
					targetNode=targetNode.getRight();
					//					System.out.println("You are here i: " + i);
				}	
			}

			if(tR>0)
			{
				for(int j=0;j<tR;j++)            /*Move down*/
				{
					targetNode=targetNode.getDown();
				}
			}
		}
		
		String sumasString=String.valueOf(sum);
		
		targetNode.setThevalue(sumasString);	
		
	}
	public void subtract  (int fR, int fC, int sR, int sC, int tR, int tC){
		Node position=head;
		double sum=0;
		if(fR+fC > 0)						{
			if(fC>0)
			{
				for(int i=0;i<fC;i++)            /*Move right*/
				{	
					position=position.getRight();
					//					System.out.println("You are here i: " + i);
				}	
			}

			if(fR>0)
			{
				for(int j=0;j<fR;j++)            /*Move down*/
				{
					position=position.getDown();
				}
			}
		}
		System.out.println("Position one is:"+ position.toString());
		/*END OF FINDING THE FIRST position
		 * 
		 */
		Node position2=head;
		if(sR+sC > 0)				// to make sure I avoid changing head
		{										
			if(sC>0)
			{
				for(int i=0;i<sC;i++)            /*Move right*/
				{	
					position2=position2.getRight();
					//					System.out.println("You are here i: " + i);
				}	
			}

			if(sR>0)
			{
				for(int j=0;j<sR;j++)            /*Move down*/
				{
					position2=position2.getDown();
				}
			}
		}
		System.out.println("Position two is:"+ position2.toString());

		if(position.getThevalue().getTag().equals(position2.getThevalue().getTag()))
		{

			double x=position.getThevalue().getdVal();
			double y=position2.getThevalue().getdVal();
			sum=x-y;

		}
		System.out.println("subtract is: "+ sum);
		/*Move pointer to target cell*/

		Node targetNode=head;//tR

		if(tR+tC > 0)				// to make sure I avoid changing head
		{										
			if(tC>0)
			{
				for(int i=0;i<tC;i++)            /*Move right*/
				{	
					targetNode=targetNode.getRight();
					//					System.out.println("You are here i: " + i);
				}	
			}

			if(tR>0)
			{
				for(int j=0;j<tR;j++)            /*Move down*/
				{
					targetNode=targetNode.getDown();
				}
			}
		}
		System.out.println("targe cell is : "+ targetNode.toString());
		String sumasString=String.valueOf(sum);
		System.out.println("Sum as a string is : "+ sumasString);
		targetNode.setThevalue(sumasString);	
		System.out.println(targetNode.toString());

	}

	public void multiply  (int fR, int fC, int sR, int sC, int tR, int tC){

		Node firstNode = movePointer(fR, fC);	
		Node secondNode = movePointer(sR, sC);	
		Node destinationNode =	movePointer(tR, tC);
		String result;

		if(firstNode.getThevalue().getTag().equals(firstNode.getThevalue().getTag()))
		{
			double x= firstNode.getThevalue().getdVal();
			double y= secondNode.getThevalue().getdVal();
			double z=x*y;
			result=String.valueOf(z);
			destinationNode.setThevalue(result);	
		}	

	}

	public void divide (int fR, int fC, int sR, int sC, int tR, int tC){

		Node firstNode = movePointer(fR, fC);	
		Node secondNode = movePointer(sR, sC);	
		Node destinationNode =	movePointer(tR, tC);
		String result;

		if(firstNode.getThevalue().getTag().equals(firstNode.getThevalue().getTag()))
		{
			double x= firstNode.getThevalue().getdVal();
			double y= secondNode.getThevalue().getdVal();
			double z=x/y;
			result=String.valueOf(z);
			destinationNode.setThevalue(result);	
		}
		else
			System.out.println("Invalid division");

	}
	public void addRows( int firstRow, int secondRow, int targetRow)
	{
		Node position=head;
		Node position2=head;
		Node position3=head;
		Value sumCellindividually;

		for(int i=0; i<firstRow; i++)   // 0<1
		{
			System.out.println("Hello---");
			position=position.getDown();	
		}


		for(int j=0; j<secondRow; j++) 
		{
			position2=position2.getDown();	
		}

		for(int w=0; w<targetRow; w++)
		{
			position3=position3.getDown();	
		}

		for(int k=0; k<col;k++)// move right
		{
			sumCellindividually=position.getThevalue().sum(position2.getThevalue());
			position3.setThevalue(sumCellindividually.toString());	
			position=position.getRight();
			position2=position2.getRight();
			position3=position3.getRight();
		}
	}

	public void subTractRows( int firstRow, int secondRow, int targetRow)
	{
		Node position=head;
		Node position2=head;
		Node position3=head;
		Value sumCellindividually;

		for(int i=0; i<firstRow; i++)   // 0<1
		{
			System.out.println("Hello---");
			position=position.getDown();	
		}

		for(int j=0; j<secondRow; j++) 
		{
			position2=position2.getDown();	
		}

		for(int w=0; w<targetRow; w++)
		{
			position3=position3.getDown();	
		}

		for(int k=0; k<col;k++)// move right
		{
			sumCellindividually=position.getThevalue().subtract(position2.getThevalue());
			position3.setThevalue(sumCellindividually.toString());	
			position=position.getRight();
			position2=position2.getRight();
			position3=position3.getRight();
		}
	}
	public void multiplyRows( int firstRow, int secondRow, int targetRow)
	{
		Node position=head;
		Node position2=head;
		Node position3=head;
		Value sumCellindividually;

		for(int i=0; i<firstRow; i++)   // 0<1
		{
			System.out.println("Hello---");
			position=position.getDown();	
		}

		for(int j=0; j<secondRow; j++) 
		{
			position2=position2.getDown();	
		}


		for(int w=0; w<targetRow; w++)
		{
			position3=position3.getDown();	
		}

		for(int k=0; k<col;k++)// move right
		{
			sumCellindividually=position.getThevalue().multiply(position2.getThevalue());
			position3.setThevalue(sumCellindividually.toString());	
			position=position.getRight();
			position2=position2.getRight();
			position3=position3.getRight();
		}
	}

	public void divideRows( int firstRow, int secondRow, int targetRow)
	{
		Node position=head;
		Node position2=head;
		Node position3=head;
		Value sumCellindividually;

		for(int i=0; i<firstRow; i++)   // 0<1
		{
			System.out.println("Hello---");
			position=position.getDown();	
		}

		for(int j=0; j<secondRow; j++) 
		{
			position2=position2.getDown();	
		}


		for(int w=0; w<targetRow; w++)
		{
			position3=position3.getDown();	
		}

		for(int k=0; k<col;k++)// move right
		{
			sumCellindividually=position.getThevalue().slash(position2.getThevalue());
			position3.setThevalue(sumCellindividually.toString());	
			position=position.getRight();
			position2=position2.getRight();
			position3=position3.getRight();
		}
	}

	public void addColumns( int firstCol, int secondCol, int targetCol)
	{
		Node position=head;
		Node position2=head;
		Node position3=head;
		Value sumCellindividually;

		for(int i=0; i<firstCol; i++)   // 0<1
		{
			System.out.println("Hello---");
			position=position.getRight();	
		}

		for(int j=0; j<secondCol; j++) 
		{
			position2=position2.getRight();	
		}


		for(int w=0; w<targetCol; w++)
		{
			position3=position3.getRight();	
		}

		for(int k=0; k<col;k++)// move right
		{
			sumCellindividually=position.getThevalue().sum(position2.getThevalue());
			position3.setThevalue(sumCellindividually.toString());	
			position=position.getDown();
			position2=position2.getDown();
			position3=position3.getDown();
		}
	}

	public void subTractColumns( int firstCol, int secondCol, int targetCol)
	{
		Node position=head;
		Node position2=head;
		Node position3=head;
		Value sumCellindividually;

		for(int i=0; i<firstCol; i++)   // 0<1
		{
			System.out.println("Hello---");
			position=position.getRight();	
		}

		for(int j=0; j<secondCol; j++) 
		{
			position2=position2.getRight();	
		}


		for(int w=0; w<targetCol; w++)
		{
			position3=position3.getRight();	
		}

		for(int k=0; k<col;k++)// move right
		{
			sumCellindividually=position.getThevalue().subtract(position2.getThevalue());
			position3.setThevalue(sumCellindividually.toString());	
			position=position.getDown();
			position2=position2.getDown();
			position3=position3.getDown();
		}
	}
	public void multiplyColumns( int firstCol, int secondCol, int targetCol)
	{
		Node position=head;
		Node position2=head;
		Node position3=head;
		Value sumCellindividually;

		for(int i=0; i<firstCol; i++)   // 0<1
		{
			System.out.println("Hello---");
			position=position.getRight();	
		}

		for(int j=0; j<secondCol; j++) 
		{
			position2=position2.getRight();	
		}


		for(int w=0; w<targetCol; w++)
		{
			position3=position3.getRight();	
		}

		for(int k=0; k<col;k++)// move right
		{
			sumCellindividually=position.getThevalue().multiply(position2.getThevalue());
			position3.setThevalue(sumCellindividually.toString());	
			position=position.getDown();
			position2=position2.getDown();
			position3=position3.getDown();
		}
	}
	public void divideColumns( int firstCol, int secondCol, int targetCol)
	{
		Node position=head;
		Node position2=head;
		Node position3=head;
		Value sumCellindividually;
		for(int i=0; i<firstCol; i++)   // 0<1
		{
			System.out.println("Hello---");
			position=position.getRight();	
		}

		for(int j=0; j<secondCol; j++) 
		{
			position2=position2.getRight();	
		}


		for(int w=0; w<targetCol; w++)
		{
			position3=position3.getRight();	
		}

		for(int k=0; k<col;k++)// move right
		{
			sumCellindividually=position.getThevalue().slash(position2.getThevalue());
			position3.setThevalue(sumCellindividually.toString());	
			position=position.getDown();
			position2=position2.getDown();
			position3=position3.getDown();

		}
	}

	public void insertRow(int rowAdded) //insert 2
	{
		int colListLenght=colListLenght(head);
		Node n10=head;   // used to move in grid
		Node n15;
		//This for loop is for moving the references to the row
		for(int r=0;r<rowAdded;r++)
		{
		//	System.out.println(rowAdded);
			n10=n10.getDown();
		}
		
		n15=n10.getDown();
//		n16=n15.getRight();
		//		[10][11][7]
		//		[new][null][null]
		//		[15][16][7]
		//		[][][]   ???????????????????col por

		//create new row connecter right in circle
		Node[] miniarr=new Node[colListLenght];// should I change to????--
		for(int i=0;i<colListLenght;i++)//------ERASE?
		{
			miniarr[i]=new Node();
//			miniarr[i].setThevalue(""+i);
//			System.out.println(miniarr[i].toString());
		}
	
		Node minihead=miniarr[0];

		for(int i=0;i<colListLenght;i++)///????
		{
			if(i<col-1)
			{
				miniarr[i].setRight(miniarr[i+1]);
			}
			else{
				miniarr[i].setRight(minihead);
			}
		}

		for(int c=0;c<colListLenght;c++) //ERASE??
		{	
			n10.setDown(miniarr[c]);
			//	miniarr[c].setRight(miniarr[c+1]);--already linked right
			miniarr[c].setDown(n15);
			if(c != colListLenght-1)
			{	
				n10=n10.getRight();
				n15=n15.getRight();
			}
		}
		//		this.setCol(row+1);
	}
	//Insert Col
	
	public void insertCol(int colAdded) //insert 2
	{
		int rowListLenght= rowListLenght(head);
		Node n2=head;   // used to move in grid
		Node n3;
		
		//This for loop is for moving the references to the col
		for(int r=0;r<colAdded;r++)
		{
		//	System.out.println(rowAdded);
			n2=n2.getRight();
		}
		
		n3=n2.getRight();
//		n16=n15.getRight();
		//		[2][3][4]  rowListLenght
		//		[7][8][9]
		//		[12][13][14]
		//create new row connecter right in circle
		Node[] miniarr=new Node[rowListLenght];// should I change to????--
		for(int i=0;i<rowListLenght;i++)
		{
			miniarr[i]=new Node();
//			miniarr[i].setThevalue(""+i);
//			System.out.println(miniarr[i].toString());
		}
	
		Node minihead=miniarr[0];

		for(int i=0;i<rowListLenght;i++)
		{
			if(i<rowListLenght-1)
			{
				miniarr[i].setDown(miniarr[i+1]);
			}
			else{
				miniarr[i].setDown(minihead);
			}
		}

		for(int c=0;c<rowListLenght;c++) // cambiar a solo row
		{	
			n2.setRight(miniarr[c]);
			//	miniarr[c].setRight(miniarr[c+1]);--already linked right
			miniarr[c].setRight(n3);
			if(c != rowListLenght-1) //7			{	
			{
				n2=n2.getDown();
				n3=n3.getDown();
			}
		}
		//		this.setCol(row+1);
	}
	
	
	

	
	
	

	

	public  void newRowinGrid()
	{
		//this.setRow(row+1);

		Node[]newRow=new Node[col];
		Node head=new Node();
		newRow[0]=head;
		head.setThevalue("23");

		Node positionNode=head;
		System.out.println("temp head is"+ head);

		for(int i=1;i<col;i++)     // col=7
		{
			newRow[i]=new Node();  //a1,a2
			positionNode.setThevalue(""+i );
			positionNode.setRight(newRow[i]); //h.righta1.righta2,
			positionNode=positionNode.getRight();  ///pos=a1,
			if(i==row-1) 
			{
				positionNode.setRight(head);
			}

		}
		System.out.println("1 "+ head.getRight().getRight().getRight());

		/*Created new unique nodes*/
		System.out.println("temp head is"+ head);
		System.out.println("1 "+ head.getRight());




	}


	public void emptyRow(int row){
		Node pos=head;
		for(int r=0;r<row;r++)
		{
			pos=pos.getDown();
		}


		for(int i=0;i<col;i++)
		{
			pos.getThevalue().resetValue();
			pos=pos.getRight();

			if(col-1==i)  ///col      5=5
			{
				pos.setThevalue("");
			}

		}
	}

	public static void main(String[] args) {
		//		Scanner sc=  x  new Scanner(System.in);
		Grid t= new Grid();
		
		t.number(0,0, 6, 4);
		t.display();
		t.assign_cell(6, 0, "33");
		System.out.println("Current row list "+ t.rowListLenght(t.head));
		t.insertRow(0);
		t.number(1, 0, 1, 5);
		t.display();
		t.assign_cell(0, 5, "43");
		t.display();
		System.out.println("Current row list "+ t.rowListLenght(t.head));
		System.out.println("Current col list "+ t.colListLenght(t.head));
		t.display();
	
		System.out.println(t.head.getRight().getDown().getDown());
		
		System.out.println(t.head.getRight().getRight().getRight().getRight().getRight().getRight());
		System.out.println(t.head.getDown().getDown());
		
		
		t.insertCol(2);
		t.display();
		
	
		//		t.insertCol(3);
//		System.out.println("Current col list2 "+ t.colListLenght(t.head));
//		t.display();
//		
		
		
//		t.insertRow(1);
//		t.display();
//		t.assign_cell(2, 0, "20");
//		t.display();
//		t.insertRow(2);
//		t.display();



		//		t.addRows(2,3,4);
		//		t.display();
		//		t.addRows(3,4,5);
		//		t.display();
		//		t.subTractRows(5,4,0);
		//		t.display();
		//		t.addColumns(3,4,5);
		//		t.display();
		//
		//		t.multiplyRows(1,2,5);
		//		t.display();
		//		t.divideColumns(1,0,2);
		//		t.display();

		//		t.assign_cell(0, 0, "40");
		//		t.assign_cell(0, 1, "41");
		//		t.assign_cell(0, 2, "42");
		//		t.assign_cell(0, 3, "43");
		//		t.assign_cell(0, 4, "44");
		//		t.assign_cell(0, 5, "45");
		//		t.assign_cell(1, 0, "46");
		//		t.assign_cell(1, 1, "47");
		//		t.assign_cell(5, 5, "789");
		//		t.display();
		//		//		t.fill(1, 1, 2 , 3);
		//		//		t.fill(1, 1, 2 , 4);
		//		t.number(2, 1, 3 , 3);
		//		Scanner sc= new Scanner(System.in);
		//		t.display();
		//		//		System.out.println("Enter a fill String");
		//		//		String j=sc.nextLine();
		//		//		t.fill(2, 1, 3, 3, j);
		//		t.display();
		//		System.out.println("This is the test for add method");
		//		t.add(2, 2, 2, 3, 2, 4);
		//
		//		t.display();
		//		t.add(2, 3, 2, 4, 2, 5);
		//		t.display();
		//
		//		t.subtract(2, 4, 2, 3, 2, 5);
		//		t.display();
		//		System.out.println("multiplication worked?");
		//		t.multiply(2, 4, 2, 3, 2, 5);
		//		t.display();
		//		t.multiply(2, 4, 2, 5,0,0);
		//		t.display();
		//
		//		t.divide(0,0,2,5,0,5);
		//		System.out.println("div worked?");
		//		t.display();

		//		t.divide(1,1,2,5,0,0);
		//		t.display();
		//		t.fill(1, 1, 3, 3, "23");
		//		t.display();

	}

	public Node getHead() {
		return head;
	}

	public void setHead(Node head) {
		this.head = head;
	}

	public int getRow() {
		return row;
	}

	public void setRow(int row) {
		this.row = row;
	}

	public int getCol() {
		return col;
	}

	public void setCol(int col) {
		this.col = col;
	}

	public Node[][] getGrid() {
		return grid;
	}

	public void setGrid(Node[][] grid) {
		this.grid = grid;
	}



}
