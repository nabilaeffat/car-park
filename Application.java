import java.util.Scanner;
import java.util.ArrayList;
import java.util.InputMismatchException;

/**
 * Application is the interface class including the main method and handling all inputs and outputs for CarParking Application
 * 
 * 1. Add a car spot
 * 2. Delete a car spot (only if not occupied)
 * 3. List all spots in a well-defined format with related information such as whether occupied, and if occupied, show the car registration.
 * 4. Park a car to a specified slot
 * 5. Find a car and show the spot if the car is in)
 * 6. Remove a car
 * 7. Exit
 * 
 * @author      Syeda Nabila Effath 4942787
 * @version     1.10 
 */
public class Application
{
	/**
	 * @param args
	 */
	public static void main(String[] args) 
	{
		int menu;
		char confirm ; 		// Confirmation to run program
		ArrayList<ParkingSpot> list=new ArrayList<>();

		Scanner sc = new Scanner(System.in);
		CarPark carPark = new CarPark();
		carPark.fillListWithSpot(list);
		try 
		{
			do {
				System.out.println("===== Parking Spot System =====");
				System.out.println("Please Select an Option");
				System.out.println("Select 1 for Menu 1: Add A Parking Spot");
				System.out.println("Select 2 for Menu 2: Delete a parking spot");
				System.out.println("Select 3 for Menu 3: Display Parking Spot Details");
				System.out.println("Select 4 for Menu 4: Park A Car");
				System.out.println("Select 5 for Menu 5: Find A Car and Spot Details");
				System.out.println("Select 6 for Menu 6: Remove A Car");
				System.out.println("Select 7 for Menu 7: Exit");

				try 
				{
					menu = sc.nextInt();

					switch(menu) 
					{
					case 1 :
						System.out.println("Menu 1: Add A Parking Spot");
						carPark.addParkingSpot( list);
						break;
					case 2 :
						System.out.println("Menu 2: Delete a parking spot");
						carPark.deleteParkingSpot(list);
						break;
					case 3 :
						System.out.println("Menu 3: Display Parking Spot Details");
						carPark.displayParkingSpot(list);
						break;
					case 4 :
						System.out.println("Menu 4: Park A Car");
						carPark.parkCar(list);
						break;
					case 5 :
						System.out.println("Menu 5: Find A Car and Spot Details");
						carPark.findCarAndParkingSpot(list);
						break;
					case 6 :
						System.out.println("Menu 6: Remove A Car");
						carPark.removeCar(list);
						break;
					case 7 :
						System.out.println("Menu 7: Exit");
						break;  
					default :
						System.out.println("Invalid option");
					}
				} 
				catch (InputMismatchException e) 
				{
					System.out.println("Invalid value!");
				}

				System.out.println("Type 'Y' to go back to Main Menu, anything else to exit the program.");
				sc.nextLine();
				confirm = sc.next().charAt(0);

			} while (confirm == 'Y' || confirm == 'y'); 
		} 

		catch (InputMismatchException e)
		{
			System.out.println("Invalid value!");
		}

		System.out.println("Program ended!!");
	}

}
