import java.time.Year;

public class Vehicle
{
    public String brandName;
    public String modelName;
    public double price;
    public String color;
    public String mfgCode;
    public String regNo;
    public Year mfgYear;
    public String fuelType;

    public void setMfgCode(String mfgCode) {
        this.mfgCode = mfgCode;
    }
    public String getMfgCode() {
        return this.mfgCode;
    }
    public void setRegNo(String regNo) {
        this.regNo = regNo;
    }
    public String getRegNo() {
        return this.regNo;
    }
    public void setMfgYear(Year mfgYear) {
        this.mfgYear = mfgYear;
    }
    public Year getMfgYear() {
        return this.mfgYear;
    }
    public void setFuelType(String fuelType) {
        this.fuelType = fuelType;
    }
    public String getFuelType() {
        return this.fuelType;
    }
    // Parameterised Constructors
    public Vehicle() {
        brandName = "Hyndai";
        modelName = "i10";
        price = 5000000.0;
        color = "White";
        mfgCode = "HYN12345";
        regNo = "HYN123CD";
        mfgYear = Year.of(2020);
        fuelType = "Petrol";
    }
    public Vehicle(String brandName, String modelName, double price, String color) {
        this.brandName = brandName;
        this.modelName = modelName;
        this.price = price;
        this.color = color;
    }
    public Vehicle(String modelName, double price, String regNo) {
        this.modelName = modelName;
        this.price = price;
        this.regNo = regNo;
    }
    
    public Vehicle(String brandName, String modelName, double price, String color, String mfgCode, String regNo, Year mfgYear, String fuelType) {
        this.brandName = brandName;
        this.modelName = modelName;
        this.price = price;
        this.color = color;
        this.mfgCode = mfgCode;
        this.regNo = regNo;
        this.mfgYear = mfgYear;
        this.fuelType = fuelType;
    }

    // Copy Constructor
    public Vehicle(Vehicle v) {
        this.brandName = v.brandName;
        this.modelName = v.modelName;
        this.price = v.price;
        this.color = v.color;
        this.mfgCode = v.mfgCode;
        this.regNo = v.regNo;
        this.mfgYear = v.mfgYear;
        this.fuelType = v.fuelType;
    }

    public void start(int initSp) {
        System.out.println("I've started the vehicle at speed: " + initSp + " km/h");
    }
    public void stop() {
        System.out.println("That was a nice ride!");
    }
    public void drive(int initGear, int initSp, int tgtSp) {
        if (initGear == 0)
            System.out.println("I need to change the gear to 1");
        if (initSp < 20)
            System.out.println("That is the ideal speed to start with.");
        else
            System.out.println("Be careful!");
        if (tgtSp > 200)
            System.out.println("Look out for the cops!");
        else
            System.out.println("You are within the ideal speed range.");
    }
    public double calcTripMileage(double noOfKms, double fuelUsed) {
        double mileage = noOfKms / fuelUsed;
        if ("Diesel".equalsIgnoreCase(fuelType)) {
            System.out.println("Diesel engines generally provide better mileage.");
            return mileage * 1.15; // Assuming 15% better efficiency for Diesel
        } else if ("Electric".equalsIgnoreCase(fuelType)) {
            System.out.println("Electric vehicle efficiency calculated in km/kWh.");
            return mileage; 
        } else {
            System.out.println("Standard Petrol mileage calculated.");
            return mileage;
        }
    }
}
