

/**
 * CarPark is responsible for maintaining a list of available parking spots.
 * User should able to 
 * add to this list
 * delete from the list
 * provide a set of available spots for parking
 * park,find and remove a car.
 * 
 * @author      Syeda Nabila Effath 4942787
 * @version     1.10 
 */

import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class CarPark 
{

	/**
	 * Local variable
	 */ 
	Scanner sc = new Scanner(System.in);

	/**
	 * isDuplicate method check if there is duplicate any value for car spot
	 * @param String spotID
	 * @param List List
	 * @return boolean value
	 */
	public boolean isDuplicateSpot(String spotID,List<ParkingSpot> list )
	{
		for (ParkingSpot spot : list) 
		{
			if(spot !=null && spot.getSpotID().equalsIgnoreCase(spotID)) 
			{
				return true;
			}
		}
		return false;
	}

	/**
	 * isDuplicate method check if there is any duplicate car
	 * @param String regNo
	 * @param List List
	 * @return boolean value
	 */
	public boolean isDuplicateCar(String regNo,List<ParkingSpot> list )
	{
		for (ParkingSpot spot : list) 
		{
			if(spot.getCar()!=null && spot.getCar().getRegistrationNo().equalsIgnoreCase(regNo)) 
			{
				return true;
			}
		}
		return false;
	} 

	/*
	 * isValidSpotID is validate spotID make sure it has 1 letter and 2 digit (A123) 
	 * @param String spotID
	 * @return String
	 * */

	public boolean isValidSpotID(String spotID)
	{
		if (spotID != null && spotID.length()==3 && Character.isLetter(spotID.charAt(0)) && Character.isUpperCase(spotID.charAt(0)) && Character.isDigit(spotID.charAt(1)) && Character.isDigit(spotID.charAt(2)) )
		{
			return true;
		}
		return false;    
	}

	/*
	 * isValidRegNo is validate RegNo make sure it has 1 letter and 4 digit (A123) 
	 * @param String spotID
	 * @return String
	 * */

	public boolean isValidRegNo(String registrationNo)
	{
		if (registrationNo != null && registrationNo.length()==5 && Character.isLetter(registrationNo.charAt(0))&& Character.isUpperCase(registrationNo.charAt(0)) && Character.isDigit(registrationNo.charAt(1)) && Character.isDigit(registrationNo.charAt(2)) && Character.isDigit(registrationNo.charAt(3)) && Character.isDigit(registrationNo.charAt(4)) )
		{
			return true;
		}
		return false;
	}

	/** 
	 * booleanToString method print boolean value to yes or no
	 * @param boolean booleanParameter
	 * @return String
	 */
	public String booleanToString(boolean booleanParameter)
	{
		return booleanParameter==true? "Yes":"No";
	}


	/** 
	 * addParkingSpot method add parking spot to a list 
	 * @param List
	 * @return void
	 */  
	public void addParkingSpot( List<ParkingSpot> list) 
	{
		String spotID;
		String confirm;// confirm user input
		String userInput;
		boolean isDisable;

		do {
			do {
				System.out.println("Enter car spot ID (Must starts with capital letter, followed by a two-digit number e.g. “D01”, “E27”)");
				spotID = sc.nextLine();
				//validating user input for spotID
			} while (!(isValidSpotID(spotID)==true  && isDuplicateSpot(spotID,list)==false )) ;

			System.out.println("Is the car spot for disable parking? please answer Y or N");
			userInput = sc.nextLine();
			if (userInput.equalsIgnoreCase("y")) 
			{
				isDisable= true;
			}
			else 
				isDisable = false;

			list.add(new ParkingSpot(spotID.toUpperCase(),isDisable,null,false));
			System.out.println("Spot added");

			System.out.println("Enter 'Y' to add another car spot, anything else to discontinue");
			confirm = sc.nextLine();

		} while (confirm.equalsIgnoreCase("y")); 
	}

	/** 
	 * displayParkingSpot method Display all parking spot of the list 
	 * @param List
	 * @return void
	 */
	public void displayParkingSpot( List<ParkingSpot> list) 
	{

		System.out.println("Diplay car park");

		list.forEach(parkingSpot -> 
		{
			String isDisable =booleanToString( parkingSpot.isDisableParking());
			String isOccupied =booleanToString(parkingSpot.isIsoccupied());
			
			// for loop to display Car parking spot details
			if(parkingSpot.getCar() ==null) 
			{
				System.out.println("Spot ID : "+ parkingSpot.getSpotID().toUpperCase() +" Disable Parking: "+ isDisable +" Isoccupied "+ isOccupied);
			}
			else
			{
				System.out.println("Spot ID : "+ parkingSpot.getSpotID().toUpperCase()+" Disable Parking: "+ isDisable +" Isoccupied "+ isOccupied +
						" Car Reg: "+parkingSpot.getCar().getRegistrationNo().toUpperCase()+" Owner Name: "+parkingSpot.getCar().getOwnerFirstName()+" "+parkingSpot.getCar().getOwnerLastName());

			}
		});  
	}

	/** 
	 * fillListWithSpot method to fill the list with empty car spot 
	 * @param List
	 * @return void
	 */
	public void fillListWithSpot(List<ParkingSpot> list)
	{
		list.add(new ParkingSpot("Z12",false,null,false));
		list.add(new ParkingSpot("R45",false,null,false));
		list.add(new ParkingSpot("I87",false,null,false));
		list.add(new ParkingSpot("L33",false,null,false));
		list.add(new ParkingSpot("K67",false,null,false));
		list.add(new ParkingSpot("J33",false,null,false));
		list.add(new ParkingSpot("M24",false,null,false));
		list.add(new ParkingSpot("W84",true,null,false));
		list.add(new ParkingSpot("T28",true,null,false));
		list.add(new ParkingSpot("B89",true,null,false));

	}

	/** 
	 * deleteParkingSpot method delete parking spot by spotID (user input)
	 * @param List
	 * @return void
	 */
	public void deleteParkingSpot(List<ParkingSpot> list)
	{
		String spotID;
		boolean isDeleted= false;//to give user confirmation message 
		boolean  occupied= false;// to check if spot is still occupied
		System.out.println("Enter car spot ID you want to delete");
		spotID = sc.nextLine();

		//Iterator to delete car spot by SpotID
		Iterator<ParkingSpot> it = list.iterator();
		while(it.hasNext()) 
		{
			ParkingSpot parkingSpot = it.next();
			String deleteSpot = parkingSpot.getSpotID();
			occupied =parkingSpot.isIsoccupied();
			if(deleteSpot !=null && deleteSpot.equalsIgnoreCase(spotID) && parkingSpot.isIsoccupied()== false) 
			{
				it.remove();
				isDeleted = true;
			}
		}
		if(isDeleted == true)
		{
			System.out.println("Spot Deleted");
		}
		else if(occupied == true)
		{
			System.out.println("Parking spot is still occupied ");
		}
		else System.out.println("Spot ID not found");

	}

	/** 
	 * displayEmptySpot method display All the empty parking spot 
	 * @param List
	 * @return void
	 */

	public void displayEmptySpot(List<ParkingSpot> list,boolean isDisableParking)
	{
		Iterator<ParkingSpot> it = list.iterator();
		while(it.hasNext()) 
		{
			ParkingSpot parkingSpot = it.next();
			if (parkingSpot.isIsoccupied()==false && parkingSpot.isDisableParking()== isDisableParking)
			{
				String message =booleanToString(parkingSpot.isDisableParking());
				System.out.println("Spot ID : "+ parkingSpot.getSpotID() +" Disable Parking: "+ message);
			}
		}

	} 


	/** 
	 * parkCar method park a car in empty spot 
	 * @param List
	 * @return void
	 */
	public void parkCar(List<ParkingSpot> list)
	{
		String spotID;
		String registrationNo;
		String firstName;
		String lastName;
		boolean isDisableRegistered;
		boolean isOccupided= false;// to check if spot occupied
		String answer;
		System.out.println("Is the car for disable registered? please answer Y or N");
		answer = sc.nextLine();
		if (answer.equalsIgnoreCase("y")) 
		{
			isDisableRegistered= true;
		}
		else 
			isDisableRegistered = false;

		//display empty spot to user
		displayEmptySpot(list, isDisableRegistered);


		//validate and add car registration no
		do {

			System.out.println("Enter Car Registration No.Must starts with capital letter, followed by a four-digit number e.g. T2345(No Duplicate)");
			registrationNo = sc.nextLine();
		} while (!( isDuplicateCar(registrationNo, list)==false &&  isValidRegNo( registrationNo)==true)) ;
		
		System.out.println("Enter First Name");
		firstName = sc.nextLine();
		
		System.out.println("Enter Last Name");
		lastName = sc.nextLine();

		System.out.println("Enter a parking spot ID from above");
		spotID = sc.nextLine();

		// removing the old parking spot object by spot id
		Iterator<ParkingSpot> it = list.iterator();
		while(it.hasNext()) 
		{
			ParkingSpot parkingSpot = it.next();
			if(parkingSpot.getSpotID()!=null && parkingSpot.getSpotID().equalsIgnoreCase(spotID) && isOccupided== false) 
			{
				if(parkingSpot.isDisableParking() == isDisableRegistered)
				{
					it.remove();
					isOccupided = true;
				}
			}
		}   

		if(isOccupided == true)
		{
			//adding new object using same spot id
			list.add(new ParkingSpot(spotID.toLowerCase(),isDisableRegistered,new Car(registrationNo.toUpperCase(),firstName,lastName,isDisableRegistered),isOccupided));
			System.out.println("Car parked in Parking Spot: "+spotID.toUpperCase()+" Car Registration No : "+registrationNo.toUpperCase()+" Owner Name "+firstName+" "+lastName+ " isDisable "+booleanToString(isDisableRegistered)+" isoccupid  "+booleanToString(isOccupided));
		}
		else  
		{
			System.out.println("Parking spot and Car registration type mismatch or Invalid Spot ID");
		}
	}



	/** 
	 * findCarAndParkingSpot method for Find A Car and Spot Details by car registration no
	 * @param List
	 * @return void
	 */
	public void findCarAndParkingSpot(List<ParkingSpot> list)
	{
		System.out.println("Enter Car Registration No");
		String carRegNo = sc.nextLine();
		boolean flag = false; //to user proper message
		//
		Iterator<ParkingSpot> it = list.iterator();
		while(it.hasNext()) 
		{
			ParkingSpot parkingSpot = it.next();
			if(parkingSpot.getCar() !=null &&parkingSpot.getCar().getRegistrationNo().equalsIgnoreCase(carRegNo)) 
			{
				flag = true;
				System.out.println("Car parked in Parking Spot: "+parkingSpot.getSpotID()+" Car Registration No : "+carRegNo+" Owner Name "
						+parkingSpot.getCar().getOwnerFirstName()+" "+parkingSpot.getCar().getOwnerLastName()+ " isDisable "+booleanToString(parkingSpot.isDisableParking()));
			}
		}
		
		if (flag == false)
		{
			System.out.println("Car not found!!");
		}
		
	}

	/** 
	 * parkCar method for remove a car from parking spot by registration no
	 * @param List
	 * @return void
	 */
	public void removeCar(List<ParkingSpot> list)
	{
		String regNo;
		String spotID;
		boolean isDisable=false;
		boolean isRemoved=false;
		System.out.println("Enter car registration no you want to remove");
		regNo = sc.nextLine();
		spotID = null;

		Iterator<ParkingSpot> it = list.iterator();
		while(it.hasNext()) 
		{
			ParkingSpot parkingSpot = it.next();
			if(parkingSpot.getCar() !=null && parkingSpot.getCar().getRegistrationNo().equalsIgnoreCase(regNo)) 
			{
				spotID = parkingSpot.getSpotID();
				isDisable = parkingSpot.isDisableParking();

				it.remove();
				isRemoved = true;
			}
		}
		
		list.add(new ParkingSpot(spotID, isDisable, null, false));

		if(isRemoved == true)
		{
			System.out.println("Car removed");
		}
		else System.out.println("Car ID not found ");

	}

}
