# CS3443-VML-main

Vehicle Maintenance Log

Group 15: Auto-Pilots

Team members:
Isai Rivas
James Le
Diego Zamora

The Vehicle Maintenance Log application keeps a record of the user's vehicles. It is used to check for necessary maintenenace, recal notifications, and scheduling appointments. A user can add any make or model of their choice and export their choice into a text file. Lastly, a user can view and sort their list as they wish.

Main.java: Start up the Menu.fxml to display to the user

MenuControl.java: The starting point of the program, where the user will be introduced to three buttons, all of which do three different tasks. The window has been modified to make it aesthetically pleasing to the user.

LogPageController.java: This class gives you the ability to check to make sure the vehicle list is up to date by clicking on the “Refresh Log” button, and it also allows for the export of a highlighted vehicle row when the “Export” button is clicked. Additionally, if a car needs to be added, clicking on the “Add Car” button takes you to the “AddPage” scene.

AddPageController: This class allows you to add a vehicle to your list, you would just need to include Make, Model, Year, Total Mileage, Date of Last Maintenance, and the Mileage of the last maintenance that was performed on the vehicle.

SuggestionController.java: This class will allow you to search for a vehicle so that the application can suggest to you some recommended maintenance to your vehicle such as oil change, transmission fluid change, and tire rotation. It will also notify you of any recalls a specific vehicle may have. You can also schedule an appointment by selecting a date by clicking on the caldendar button, and filling in the vehicle name, repair shop location, and time of appointment fields. After that you can export the appointment to a file where appointments will be kept.

VehicleListController.java: For this class, there is a drop down menu in the top left of the screen containing three buttons. Each button will display 'VehicleList2.txt' sorted in three different ways. The 'Most Recent' button will display the vehicles in entry order from oldest to most recent, 'Alphabetically' will display the vehicles in lexigraphical order, and 'Date' will sort the vehicles by date from oldest to newest.

Known Bugs: Visual bug error, the tabs and spaces are not uniform between parameters in the VehicleList2.txt, when displaying them in VehicleList and LogPage.

Login Information: No login required

Versions and other requirements: No special requirements
