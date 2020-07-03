import java.util.*;
class Video{
	//member variable
	String videoName;
	boolean checkout;
	int rating;
	Video(String name){
		this.videoName = name;
		System.out.println("Video "+videoName+" added successfully");
	}
	String getName() {
		return this.videoName;
	}
	void doCheckout() {
		checkout = true;
		System.out.println("Video "+videoName+" checkout successfully");
	}
	void doReturn() {
		checkout = false;
		System.out.println("Video "+videoName+" return successfully");
	}
	void receiveRating(int rating) {
		this.rating = rating;
	}
	int getRating() {
		return rating;
	}
	boolean getCheckout() {
		return checkout;
	}
}
class VideoStore{
	Video[] store  = new Video[10];
	
	void addVideo(String name,int i) {
		store[i] = new Video(name);
		
	}
	void doCheckout(String name) {
		
		for(int i=0;i<store.length;i++) {

			if(store[i]!=null && name.equals(store[i].getName())) {
				store[i].doCheckout();
			}
		}		
	}
	void doReturn(String name) {
		for(int i=0;i<store.length;i++) {
			if(store[i]!=null && name.equals(store[i].getName())) {
				store[i].doReturn();
			}
		}		
	}
	void receiveRating(String name,int rating) {
		for(int i=0;i<store.length;i++) {
			if(store[i]!=null && name.equals(store[i].getName())) {
				store[i].receiveRating(rating);
			}		
		}		
	}
	void listInventory() {
		System.out.println("------------------------------------------------------");
		for(int i=0;i<store.length;i++) {
			
			if(store[i]!=null) {
				System.out.println("Video name: \tCheckout Status: \tRating");
				System.out.println(store[i].getName()+"\t\t\t"+store[i].getCheckout()+"\t\t\t"+store[i].getRating());
			}
		}
		System.out.println("------------------------------------------------------");
	}
	
}

public class VideoInventoryMiniProj {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		VideoStore VS1 = new VideoStore();
		int i=0;
		// **** TO TEST ***** //
//		VS1.addVideo("MATRIX",i);
//		i++;
//		VS1.addVideo("Pikachu",i);
//		i++;
//		VS1.addVideo("book1",i);
//		VS1.listInventory();
//		VS1.receiveRating("MATRIX", 9);
//		VS1.doCheckout("MATRIX");
//		VS1.listInventory();
//		VS1.receiveRating("Pikachu", 8);
//		VS1.doCheckout("Pikachu");
//		VS1.doReturn("Pikachu");
//		VS1.listInventory();
//		VS1.receiveRating("book1", 7);
//		VS1.doCheckout("book1");		
//		VS1.listInventory();
		
		Scanner integerS = new Scanner(System.in);
		Scanner s = new Scanner(System.in);
		while(true) {
			System.out.println("MAIN MENU");
			System.out.println("=========");
			System.out.println("1: Add video: \n2: Checkout video: \n3: Return video: \n4: Receive rating: \n5: List Inventory: \n6: Exit: ");
			System.out.print("Enter your choice (1..6): ");
			int quary = integerS.nextInt();
			switch(quary) {
			case 1:
				System.out.println("Enter the name of video that you want to add: ");
				String addVidName = s.nextLine();
				VS1.addVideo(addVidName, i);
				i++;
				break;
			case 2:
				System.out.println("Enter the name of video that you want to checkout: ");
				String coutVidName = s.nextLine();
				VS1.doCheckout(coutVidName);
				break;
			case 3:
				System.out.println("Enter the name of video that you want to return: ");
				String retVidName = s.nextLine();
				VS1.doReturn(retVidName);
				break;
			case 4:
				System.out.println("Enter the name of video that you want to receive rating: ");
				String resVidName = s.nextLine();
				System.out.println("enter the rating(0-10) you want yo give: ");
				int ratingVid = integerS.nextInt();
				VS1.receiveRating(resVidName, ratingVid);
				break;
			case 5:
				VS1.listInventory();
				break;
			case 6:
				System.out.println("Thank you for using my small app!");
				return;
			}	
		}
		
		
	}

}
