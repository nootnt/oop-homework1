package scooter;

public class ScooterRentalTester {
    public static void main(String[] args) {
    	// Initialize class
        RentalCompany rentalCompany = new RentalCompany();


        //
        // Initial sanity test
        // 
        
        // Creating Scooter objects and asigning model names
		System.out.print("\nMaking scooters... \n\n");
        Scooter scooter1 = new Scooter();
        scooter1.setModel("sc_001");
        Scooter scooter2 = new Scooter();
        scooter2.setModel("sc_002");
        Scooter scooter3 = new Scooter();
        scooter3.setModel("sc_003");
        
        // Adding Scooter objects to the rental company
        rentalCompany.addScooter(scooter1);
        rentalCompany.addScooter(scooter2);
        rentalCompany.addScooter(scooter3);

		// Show all scooters to check
        rentalCompany.displayAllScooters();

		// Rent scooters test
		System.out.print("\nRenting scooters... \n\n");
        rentalCompany.rentScooter(0);
        rentalCompany.rentScooter(1);

		// Get info again to ckeck
        rentalCompany.displayAllScooters();

        // Return scooter at location
        System.out.print("\nReturning scooters... \n\n");
        rentalCompany.returnScooter(0, 2.0, 2.0);
        rentalCompany.returnScooter(1, 2.0, 2.0);

		// Get info to ckeck
        rentalCompany.displayAllScooters();



        //
        // Start of Main Test (Test requeted in the assignment)
        //
        
        System.out.print("\n\n\nStarting main test... (takes 1 hour+...) \n\n\n");

		// 1. Rent scooter and go to university
		rentalCompany.rentScooter(2);
		rentalCompany.returnScooter(2, 41.7121106, 44.7489232);

		rentalCompany.displayAllScooters();

		// 2. Wait for 1 hour (as requested)
		System.out.print("\nStarting 1 hour wait... \n");
		try {
        	// Sleep for 1 hour (in milliseconds)
			Thread.sleep(3600000);
		} 
		catch (InterruptedException e) {
        	// Handle interrupt exception
           	e.printStackTrace();
        }
		System.out.println("Wait finished...");

		// 3. Rent scooter and go home
		rentalCompany.rentScooter(2);
		rentalCompany.returnScooter(2, 41.689452, 44.796848);

		rentalCompany.displayAllScooters();

		// Finish
        System.out.println("System test finished...");
    }
}
