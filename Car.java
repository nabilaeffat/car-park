

/**
 * A car will be identified by its registration number.
 * A registration number always starts with a capital letter, followed by a four-digit number e.g. “T2345”.
 * A car should have an owner and knows if it has been registered for a disabled driver.
 * 
 * @author      Syeda Nabila Effath 4942787
 * @version     1.10 
 */
public class Car
{
	/**
	 * Car Entity data
	 */
	private String registrationNo;
	private String ownerFirstName;
	private String ownerLastName;
	private boolean disableRegistered;


	/**
	 * Constructor for objects of class Car using the 
	 * @param registrationNo
	 * @param ownerFirstName
	 * @param ownerLastName
	 * @param isDisableRegistered
	 */

	public Car(String registrationNo, String ownerFirstName, String ownerLastName, boolean disableRegistered) 
	{
		this.registrationNo = registrationNo;
		this.ownerFirstName = ownerFirstName;
		this.ownerLastName = ownerLastName;
		this.disableRegistered = disableRegistered;
	}


	/**
	 * Getter setter method for the class
	 */

	/**
	 * @return the registrationNo
	 */
	public String getRegistrationNo() 
	{
		return registrationNo;
	}


	/**
	 * @param registrationNo the registrationNo to set
	 */
	public void setRegistrationNo(String registrationNo) 
	{
		this.registrationNo = registrationNo;
	}


	/**
	 * @return the ownerFirstName
	 */
	public String getOwnerFirstName() 
	{
		return ownerFirstName;
	}


	/**
	 * @param ownerFirstName the ownerFirstName to set
	 */
	public void setOwnerFirstName(String ownerFirstName) 
	{
		this.ownerFirstName = ownerFirstName;
	}


	/**
	 * @return the ownerLastName
	 */
	public String getOwnerLastName() 
	{
		return ownerLastName;
	}


	/**
	 * @param ownerLastName the ownerLastName to set
	 */
	public void setOwnerLastName(String ownerLastName) 
	{
		this.ownerLastName = ownerLastName;
	}


	/**
	 * @return the isDisableRegistered
	 */
	public boolean isDisableRegistered() 
	{
		return disableRegistered;
	}


	/**
	 * @param isDisableRegistered the isDisableRegistered to set
	 */
	public void setDisableRegistered(boolean disableRegistered) 
	{
		this.disableRegistered = disableRegistered;
	}

}
