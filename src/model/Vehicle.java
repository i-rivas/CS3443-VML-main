package model;

public class Vehicle {
	private String vehicleMake;
	private int vehicleYear;
	private int totalMileage;
	private String lastMaintenanceDate;
	private int mileageSinceMT;
	
	public Vehicle(String vehicleMake, int vehYear, int totalMileage, String lastMaintenanceDate, int mileageSinceMT)
	{
		this.vehicleMake = vehicleMake;
		this.vehicleYear = vehYear;
		this.totalMileage = totalMileage;
		this.lastMaintenanceDate = lastMaintenanceDate;
		this.mileageSinceMT = mileageSinceMT;
	}
	

	public String getVehicleMake()
	{
		return vehicleMake;
	}
	
	public void setVehicleMake(String newMake)
	{
		this.vehicleMake = newMake;
	}
	
	public int getVehicleYear()
	{
		return vehicleYear;
	}
	
	public void setVehicleYear(int newYear)
	{
		this.vehicleYear = newYear;
	}
	
	public int getTotalMileage()
	{
		return totalMileage;
	}
	
	public void setTotalMileage(int newTotal)
	{
		this.totalMileage = newTotal;
	}
	
	public String getlastMaintenanceDate()
	{
		return lastMaintenanceDate;
	}
	
	public void setlastMaintenanceDate(String newDate)
	{
		this.lastMaintenanceDate = newDate;
	}
	
	public int getMileageSinceMT()
	{
		return mileageSinceMT;
	}
	
	public void setMileageSinceMT(int newMileage)
	{
		this.mileageSinceMT = newMileage;
	}
	
	
	
	
	
}
