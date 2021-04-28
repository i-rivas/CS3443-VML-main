package model;

public class Vehicle {
	private String vehicleMake;
	private String lastCheckedDate;
	private String currentIssue;
	
	public Vehicle(String vehicleMake, String lastCheckedDate, String currentIssue)
	{
		this.vehicleMake = vehicleMake;
		this.lastCheckedDate = lastCheckedDate;
		this.currentIssue = currentIssue;
	}
	
	public String getVehicleMake()
	{
		return vehicleMake;
	}
	
	public void setVehicleMake(String newMake)
	{
		this.vehicleMake = newMake;
	}
	
	public String getlastCheckedDate()
	{
		return lastCheckedDate;
	}
	
	public void setlastCheckedDate(String newDate)
	{
		this.lastCheckedDate = newDate;
	}
	
	public String getCurrentIssue()
	{
		return currentIssue;
	}
	
	public void setCurrentIssue(String newIssue)
	{
		this.currentIssue = newIssue;
	}
	
	
	
}