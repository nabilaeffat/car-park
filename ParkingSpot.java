
/**
 * There are two types of parking slots: slots for everyone and slots only for disabled persons.
 * A parking spot must have an identifier, which starts with a capital letter, followed by a two-digit number e.g. “D01”, “E27”.
 * A parking slot also should know if a car is parked in the spot
 * User must be able to add a car to the spot and remove a car from the spot.
 *
 * @author      Syeda Nabila Effath 4942787
 * @version     1.10 
 */
public class ParkingSpot
{
	/**
	 * ParkingSpot Entity data
	 */
	private String spotID;
	private boolean disableParking;
	private Car car;
	private boolean occupied;

	/**
	 * Constructor for objects of class ParkingSpot using the 
	 * @param spotID
	 * @param spotType
	 * @param car
	 * @param isOccupided
	 * return ParkingSpot object
	 */

	public ParkingSpot(String spotID, boolean disableParking, Car car, boolean occupied) 
	{
		this.spotID = spotID;
		this.disableParking = disableParking;
		this.car = car;
		this.occupied = occupied;
	}

	/**
	 * Getter setter method for the class
	 */

	/**
	 * @return String the spotID
	 */
	public String getSpotID() 
	{
		return spotID;
	}
	/**
	 * @param spotID the spotID to set
	 */
	public void setSpotID(String spotID) 
	{
		this.spotID = spotID;
	}

	/**
	 * @return boolean the disableParking
	 */
	public boolean isDisableParking() 
	{
		return disableParking;
	}
	/**
	 * @param isDisableParking the isDisableParking to set
	 */
	public void setDisableParking(boolean disableParking) 
	{
		this.disableParking = disableParking;
	}


	/**
	 * @return the car object
	 */
	public Car getCar() {
		return car;
	}

	/**
	 * @param car the car to set
	 */
	public void setCar(Car car) {
		this.car = car;
	}

	/**
	 * @return boolean the occupied 
	 */
	public boolean isIsoccupied() {
		return occupied;
	}
	/**
	 * @param isoccupied the occupied to set
	 */
	public void setIsoccupied(boolean occupied) {
		this.occupied = occupied;
	}

	/*
	 * isValidSpotID is validate spotID make sure it has 1 letter and 2 digit (A12) 
	 * @param String spotID
	 * @return String
	 * */

	public String isValidSpotID(String spotID)
	{
		if (spotID != null && spotID.length()==3 && Character.isLetter(spotID.charAt(0)) && Character.isDigit(spotID.charAt(1)) && Character.isDigit(spotID.charAt(2)) )
		{
			return spotID.toUpperCase();
		}
		else 
			return "Please Enter Spot ID again";
	}

}
