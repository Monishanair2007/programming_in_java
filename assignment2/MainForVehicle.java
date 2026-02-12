public class MainForVehicle {
    public static void main(String[] args) {
        Vehicle defV = new Vehicle();
        printVehicleDetails(defV);

        Vehicle v2 = new Vehicle("honda", "city", 400000.99, "HONDA1234");
        printVehicleDetails(v2);

        v2.start(20);
        v2.drive(0, 20, 120);
        double mileage = v2.calcTripMileage(140, 20);
        System.out.println("Mileage: " + mileage);
        v2.stop();

        Vehicle v3 = v2; // reference copy
        v3.setMfgCode("HON00765");
        v3.color = "Orange";
        printVehicleDetails(v3);

        // Correct array initialization
        Vehicle[] myFloat = new Vehicle[] { defV, v2, v3 };

        //  Correct loop (removed semicolon)
        for (Vehicle myV : myFloat) {
            printVehicleDetails(myV);
            myV.start(30);
            myV.drive(3, 30, 100);
            double tripMileage = myV.calcTripMileage(20, 25);
            System.out.println("Trip Mileage: " + tripMileage);
            myV.stop(); 
        }
    }

    public static void printVehicleDetails(Vehicle v) {
        System.out.println("========================== Vehicle Details ==========================");
        System.out.println("Brand Name: " + v.brandName);
        System.out.println("Model Name: " + v.modelName);
        System.out.println("Price: " + v.price);
        System.out.println("Color: " + v.color);
        System.out.println("Mfg Code: " + v.getMfgCode());
        System.out.println("Reg No: " + v.getRegNo());
        System.out.println("Mfg Year: " + v.mfgYear);
        System.out.println("Fuel Type: " + v.fuelType);
        System.out.println("======================= End of Vehicle Details =======================");
    }

}

