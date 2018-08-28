import java.io.*;
public class CSX_358_HW1_16103042 {

	public static void main(String[] args)  {
		// TODO Auto-generated method stub
		BufferedReader br = null;
		int z=0;
		try {
			br = new BufferedReader(new FileReader("C:\\Users\\ACER\\Desktop\\HW1\\HW1-data.txt"));
			String contentLine = br.readLine();
			 FileWriter writer = new FileWriter("HW1_output_16103042.txt ", true);
	            BufferedWriter bw = new BufferedWriter(writer);
	            String[]arr=new String[15];
	            bw.write(" Stdnt Id      Ex   --------- Assignments ---------------      Tot   Mi  Fin CL         Pts   Pct   Gr\r\n");
	            bw.write(" ----------       --    -------------------------------------------      ---    --   ---    --          ---     ---     --\r\n ");
	            bw.newLine();
	            int count_A=0;
	            int count_B=0;
	            int count_C=0;
	            int count_D=0;
	            int count_E=0;
	           float avgTotal=0;
	           int maxPnts=0;
	        while(contentLine!=null){
	        	System.out.println(contentLine);
	        	arr=contentLine.split(" ");
	        	int studentId=Integer.parseInt(arr[0]);
	        	int labEx=Integer.parseInt(arr[1]);
	        	int assgnPnts[]=new int[10];
	        	for(int j=0;j<10;j++)
	        	{
	        		for(int k =2 ; k<=11;k++)
	        		{
	        			assgnPnts[j]=Integer.parseInt(arr[k]);
	        		}
	        	}
	        	int midterms=Integer.parseInt(arr[12]);
	        	int finalPnts=Integer.parseInt(arr[13]);
	        	int codeLabPnts=Integer.parseInt(arr[14]);
	        	int totalAssgnPnts=0;
	        	int totalPnts=0;
	        	
	       float percentage;
	       String grade ;
	        	contentLine = br.readLine();
	        	for(int j=2;j<12;j++)
	        	{ 
	        		
	        		totalAssgnPnts+=Integer.parseInt(arr[j]);
	        	}
	        	
	        	totalPnts=labEx+totalAssgnPnts+midterms+finalPnts+codeLabPnts;
	        	if(totalPnts>maxPnts)
	        	{
	        		maxPnts=totalPnts;
	        	}
	        	percentage= (float)((totalPnts*100)/420) ;
	        	for(int p=0;p<15;p++)
	            {
	            	if(p!=11)
	        		   
	            		bw.write("  "+arr[p]);
	            	else
	            		bw.write("\t"+totalAssgnPnts);	
	                    	
	           }
	        	
	        	bw.write("\t"+totalPnts);	
	        	avgTotal+=totalPnts;
	        	bw.write("  "+percentage+"  ");
	        	if(percentage>=90) {
	        		bw.write(grade="A");
	        	    count_A++;}
	        	else if (78<=percentage|| percentage>=89) {
	        		bw.write(grade="B");
	        		count_B++;
	        	}
	        	else if (62<=percentage||percentage>=77) {
	        		bw.write(grade="C");
	        		count_C++;
	        	}
	        	else if (46<=percentage|| percentage>=61) {
	        		
	        		bw.write(grade="D");
	        		count_D++;
	        	}
	        	else if (45<=percentage)
	        	{
	        		bw.write(grade="E");
	        		count_E++;
	        	}
	        	
	        	
	        	bw.newLine();
	        	
	        
	        }
	       avgTotal = (float)((avgTotal*100)/21000) ;
	    	bw.newLine();
	    	bw.newLine();
	    	bw.write("Average total points of all students :"+avgTotal+"%");
	    	bw.newLine();
	    	bw.newLine();
	        bw.write("Number of A's :"+count_A);
	        bw.newLine();
	        bw.write("Number of B's :"+count_B);
	        bw.newLine();
	        bw.write("Number of C's :"+count_C);
	        bw.newLine();
	        bw.write("Number of D's :"+count_D);
	        bw.newLine();
	        bw.write("Number of E's :"+count_E);
	        bw.newLine();
	        bw.newLine();
	        bw.write("Maximum points :"+maxPnts);
	       
            bw.close();
           
          
 
		}
		catch(Exception e )
		{
			e.printStackTrace();
		}
		finally
		{
			try{
			     if(br != null)
					br.close();
			}
			catch(Exception e)
			{
				System.out.println("Errr in closing the buffer");
			}
			
		}
		
	}

}
