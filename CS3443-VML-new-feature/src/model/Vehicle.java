package model;

public class Vehicle {
	private String vehicleMake;
	private String vehicleModel;
	private String vehicleName;
	private int vehicleYear;
	private int totalMileage;
	private String lastMaintenanceDate;
	private int mileageSinceMT;
	
	public Vehicle(String vehicleMake, String vehicleModel, int vehYear, int totalMileage, String lastMaintenanceDate, int mileageSinceMT)
	{
		this.vehicleMake = vehicleMake;
		this.vehicleModel = vehicleModel;
		setVehicleName(vehicleMake, vehicleModel);
		this.vehicleYear = vehYear;
		this.totalMileage = totalMileage;
		this.lastMaintenanceDate = lastMaintenanceDate;
		this.mileageSinceMT = mileageSinceMT;
	}

	public String getVehicleName()
	{
		return vehicleName;
	}
	
	public void setVehicleName(String vehicleMake, String vehicleModel)
	{
		this.vehicleName = vehicleMake + " " + vehicleModel;
	}

	public String getVehicleMake()
	{
		return vehicleMake;
	}
	
	public void setVehicleModel(String newModel)
	{
		this.vehicleModel = newModel;
	}
	
	public String getVehicleModel()
	{
		return vehicleModel;
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