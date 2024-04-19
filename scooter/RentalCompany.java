package scooter;

import java.util.ArrayList;
import java.util.List;

public class RentalCompany {

    private int uid = 0;

    List<Scooter> scooters = new ArrayList<>();

    public List<Scooter> availableScooters() {
        List<Scooter> result = new ArrayList<>();
        for (Scooter scooter: scooters) {
            if (scooter.isAvailable()) {
                result.add(scooter);
            }
        }
        return result;
    }

    public void addScooter(Scooter scooter) {
    	// add a scooter and initialize it with starting values
        scooter.setId(uid++);
        scooter.setBatteryLevel(100);
        scooter.setAvailable(true);
        scooters.add(scooter);
        System.out.println("Scooter Added...");
    }

    public boolean removeScooter(int id) {
        boolean removed = false;
        for (Scooter scooter: scooters) {
            if (scooter.getId() == id) {
                scooters.remove(scooter);
                removed = true;
                break;
            }
        }
        return removed;
    }

    public void rentScooter(int id) {
    	// checking every schooter for the specified one
    	for (Scooter scooter: scooters) {
    		if (scooter.getId() == id) {
    			// check if its available
    			if(scooter.isAvailable()) {
    				// set it's availability
    				scooter.setAvailable(false);
    				System.out.println("Scooter Rented...");
    			}
    			else {
    				System.out.println("Scooter Unavailble...");
    			}
    		}
    	}
    }

    public void returnScooter(int id, double x, double y) {
    	// check every scooter in db for specified one
	    for (Scooter scooter: scooters) {
    		if (scooter.getId() == id) {
    			// check if its available
    			if(!scooter.isAvailable()) {
    				// set it's availability
    				scooter.setAvailable(true);
    				// set the coordinates
    				scooter.setX(x);
    				scooter.setY(y);
    				System.out.println("Scooter Returned...");
    			}
    			else {
    				System.out.println("Scooter already available...");
    			}
    		}
    	}
    }
	
    public void displayAllScooters() {
            System.out.println("All Scooters:");
            for (Scooter scooter : scooters) {
            	// print all scooters with detailed information
            	System.out.println("ID: " + scooter.getId());
            	System.out.println("Model: " + scooter.getModel());
            	System.out.println("Available: " + scooter.isAvailable());
            	System.out.println("Battery: " + scooter.getBatteryLevel() + "%");
            	System.out.println("X-Y: X-" + scooter.getX() + " Y-" + scooter.getY());
            }
        }
}
