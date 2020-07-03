import java.util.*;
class PrepareResult{
	public int generateResult(int[] arr) {
		int sum = 0;
		
		for(int num:arr) {
			sum+=num;
		}
		return sum;
	}
	public int generateMax(int[] arr) {
		int max = arr[0];
		for(int i=1;i<arr.length;i++) {
			if(max<arr[i]) {
				max = arr[i];
			}
		}
//		System.out.println(max);
		// get max val index
		int len = arr.length; 
        int i = 0; 

        while (i < len) { 

            if (arr[i] == max) { 
                return i; 
            } 
            else { 
                i = i + 1; 
            } 
        } 
        return -1;
	}
}

public class StudentMarks {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner s = new Scanner(System.in);
        System.out.println("please follow the proper instruction!");
		System.out.println("enter number of students: ");
		int N = s.nextInt();
		int[][] database = new int[N][7];
		for(int i=0;i<N;i++) {
			System.out.println("Student "+i+" \tSubject code:\nMath:1, Phy:2, Chem:3, Bio:4, Comp:5, Sports:6, English:7 ");
			for(int j=0;j<7;j++) {
				System.out.println("enter marks of subject code: "+(j+1));

				database[i][j] = s.nextInt();
			}
		}



        // *******  TO TEST THE FOLLOWING CODE    *******//
        // *******  FOLLOW THE INSTRUCTIONS    *******//

        // ******* to test ******* comment from line 43 to 53 and un-comment the statement below
        
        int database[][] = {{65,76,87,98,90,89,78},{56,47,38,69,89,76,56},{98,76,87,98,67,56,87}}; // to test un-comment this
        




        // System.out.println("enter the quary: 1/2/3 and 0 to quit");
        System.out.println("please follow the proper instruction!");
        System.out.println("Quary 1: Result should be able to answer who are first second third all together?\nQuary 2: Who are first second third in a specific subject? \nQuary 3: Who are first second third in a specific subject combination of any number ");
		while(true) {
			System.out.println("enter the quary: 1/2/3 and 0 to quit");
			int quary = s.nextInt();
			switch(quary) {
				case 1:
					int[] results = new int[database.length];
					PrepareResult obj1 = new PrepareResult();
					for(int i=0;i<database.length;i++) {
//						System.out.println("Sum: "+obj1.generateResult(database[i]));
						results[i] = obj1.generateResult(database[i]);
					}

					for(int i=0;i<3;i++) {
						int idx = obj1.generateMax(results);
						
						System.out.println((idx+1)+"th student pos: "+(i+1)+" marks:"+results[idx]);
						results[idx] = -1;
					}
					System.out.println("Thank you for using my small app");
					break;
				case 2:
					
					
                    PrepareResult obj2 = new PrepareResult();
                    System.out.println("Enter the subject code: ");
                    int sCode = s.nextInt();
					int[] newDb = new int[database.length];
//					int max = database[0][sCode-1];
					
					for(int i=0;i<database.length;i++) {
						newDb[i] = database[i][sCode-1];;
					}
					for(int i=0;i<3;i++) {
						int idx = obj2.generateMax(newDb);
						
						System.out.println((idx+1)+"th student pos: "+(i+1)+" marks:"+newDb[idx]);
						newDb[idx] = -1;
					}
					System.out.println("Thank you for using my small app");
					break;
					
				
				
				case 3:
					
					
					System.out.println("Enter number of subject combination: ");
					int N1 = s.nextInt();
					System.out.println("Enter the subject codes");
					int[][] newArrCase3 = new int[database.length][N1];
					int[] codeArr = new int[N1];
					
					for(int i=0;i<N1;i++) {
						codeArr[i] = s.nextInt();
					}
					for(int i=0;i<database.length;i++) {
						int j=0;
						for(int element : codeArr){
                            newArrCase3[i][j] = database[i][element-1];
                            j++;
                        }
								
					}
					int[] resultsCase3 = new int[database.length];
					PrepareResult obj3 = new PrepareResult();
					for(int i=0;i<database.length;i++) {
//						System.out.println("Sum: "+obj1.generateResult(database[i]));
                        resultsCase3[i] = obj3.generateResult(newArrCase3[i]);
                        System.out.println(resultsCase3[i]);
					}

					for(int i=0;i<3;i++) {
						int idx = obj3.generateMax(resultsCase3);
						
						System.out.println((idx+1)+"th student pos: "+(i+1)+" marks:"+resultsCase3[idx]);
						resultsCase3[idx] = -1;
					}
					System.out.println("Thank you for using my small app");
					break;
				case 0:
					System.out.println("Thank you for using my small app");
					return;
				default:
					System.out.println("Wrong input");
			}
		
		}

	}

}
