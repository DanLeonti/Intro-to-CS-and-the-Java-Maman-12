/**
 * Matala 12 - Question 3
 * 
 * @author Daniel Leonti
 * @version 2023a
 */
public class Rent
{
    // declering constant values
    public static final int DEF_DAY = 1;
    public static final int DEF_MONTH = 1;
    public static final int DEF_YEAR = 2000;
    public static final int PRICE_A = 100;
    public static final int PRICE_B = 150;
    public static final int PRICE_C = 180;
    public static final int PRICE_D = 240;
    public static final int WEEK_DAYS = 7;
    public static final double DIS_10 = 0.9;
    
    private String _name;
    private Car _car;
    private Date _pickDate;
    private Date _returnDate;
    
    //constructors:
    /**
    * Creates a new Rent object
    * The return date must be at least one day after the pickup date, otherwise set it to one day after the pick up date.
    * @param name - the client's name
    * @param car - the rented car
    * @param pick - the pickup date
    * @param ret - the return date
    */
    public Rent(String name, Car car, Date pick, Date ret)
    {
        _name = name;
        _car = car;
        _pickDate = pick;
        if(pick.after(ret)) {
            _returnDate = pick.tomorrow();
        }
        else {
            _returnDate = ret;
        }
    }

    /**
    * Copy Constructor
    * @param other - the rent to be copied
    */
    public Rent(Rent other)
    {
        _name = other._name;
        _car = other._car;
        _pickDate = other._pickDate;
        _returnDate = other._returnDate;
    }
    
    /** 
    * Gets the name
    * @return the name
    */
    public String getName(){
        return _name;
    }
    
    /** 
    * Gets the car
    * @return the car
    */
    public Car getCar(){
        return _car;
    }
    
    /** 
    * Gets the pick up date
    * @return the pick up date
    */
    public Date getPickDate(){
        return _pickDate;
    }
    
    /** 
    * Gets the return date
    * @return the return date
    */
    public Date getReturnDate(){
        return _returnDate;
    }
    
    /** 
    * Sets the client name
    * @param nameToSet - the client name (You can assume that the name is a valid name)
    */
    public void setName(String nameToSet){
        _name = nameToSet;
    }
    
    /** set the car
     * @param car the value to be set
     */
    public void setCar(Car car){
        _car = car;
    }
    
    /** 
    * Sets the pick up date
    * The pick up date must be at least one day before the return date, otherwise - don't change the pick up date
    * @param setPickDate - the pick up date (You can assume that pick up date is not null)
    */
    public void  setPickDate(Date setPickDate){
        _pickDate = setPickDate;
        }
        
    /** 
    * Sets the return date
    * The return date must be at least one day after the pick up date, otherwise - don't change the return date
    * @param setReturnDate - the return date (You can assume that return date is not null)
    */
    public void  setReturnDate(Date setReturnDate){
        _returnDate = setReturnDate;
        }
        
    // computes the day number since the beginning of the Christian counting of years
    private int calculateDate ( int day, int month, int year)
    {
        if (month < 3) {
            year--;
            month = month + 12;
        }
        return 365 * year + year/4 - year/100 + year/400 + ((month+1) * 306)/10 + (day - 62);
    }
    
    /**
    * Check if 2 rents are the same
    * @param other - the rent to compare this rent to
    * @return true if the rents are the same
    */    
    public boolean equals(Rent other) {
        if (_name == other._name && _pickDate.equals(other._pickDate) && _returnDate.equals(other._returnDate)&& _car.equals(other._car)) {
            return true;
        }
        else{
            return false;
        }
    }
    
    /**
    * Returns a String that represents this rent
    * @override toString in class java.lang.Object
    * @return String that represents this rent in the following format: Name:Rama From:30/10/2022 To:12/11/2022 Type:B Days:13 Price:1845
    */   
    public String toString() {
        return "Name:" + _name + " From:" + _pickDate + " To:" + _returnDate + " Type:" + _car.getType() + " Days:" + howManyDays() + " Price:" + getPrice();
    }
    
    /** 
    * Returns the number of rent days
    * @return the number of rent days
    */
    public int howManyDays() {
        return _pickDate.difference(_returnDate);
    }
    
    /** 
    * Returns the rent total price
    * @return the rent total price
    */
    public int getPrice() {
        switch(_car.getType()) {
          case 'A':
            if(howManyDays() < WEEK_DAYS) {
                return howManyDays() * PRICE_A;
            }
            if(howManyDays() == WEEK_DAYS) {
                return (int)Math.round(howManyDays() * PRICE_A * DIS_10);
            }
            if(howManyDays() > WEEK_DAYS) {
                return (int)Math.round( (WEEK_DAYS * PRICE_A * DIS_10 * Math.round(howManyDays() / WEEK_DAYS)) + (howManyDays() - Math.round(howManyDays() / WEEK_DAYS)*WEEK_DAYS) * PRICE_A );
            }
            break;
          case 'B':
            if(howManyDays() < WEEK_DAYS) {
                return howManyDays() * PRICE_B;
            }
            if(howManyDays() == WEEK_DAYS) {
                return (int)Math.round(howManyDays() * PRICE_B * DIS_10);
            }
            if(howManyDays() > WEEK_DAYS) {
                return (int)Math.round( (WEEK_DAYS * PRICE_B * DIS_10 * Math.round(howManyDays() / WEEK_DAYS)) + (howManyDays() - Math.round(howManyDays() / WEEK_DAYS)*WEEK_DAYS) * PRICE_B );
            }
            break;
          case 'C':
            if(howManyDays() < WEEK_DAYS) {
                return howManyDays() * PRICE_C;
            }
            if(howManyDays() == WEEK_DAYS) {
                return (int)Math.round(howManyDays() * PRICE_C * DIS_10);
            }
            if(howManyDays() > WEEK_DAYS) {
                return (int)Math.round( (WEEK_DAYS * PRICE_C * DIS_10 * Math.round(howManyDays() / WEEK_DAYS)) + (howManyDays() - Math.round(howManyDays() / WEEK_DAYS)*WEEK_DAYS) * PRICE_C );
            }
            break;
          case 'D':
            if(howManyDays() < WEEK_DAYS) {
                return howManyDays() * PRICE_D;
            }
            if(howManyDays() == WEEK_DAYS) {
                return (int)Math.round(howManyDays() * PRICE_D * DIS_10);
            }
            if(howManyDays() > WEEK_DAYS) {
                return (int)Math.round( (WEEK_DAYS * PRICE_D * DIS_10 * Math.round(howManyDays() / WEEK_DAYS)) + (howManyDays() - Math.round(howManyDays() / WEEK_DAYS)*WEEK_DAYS) * PRICE_D );
            }
            break;
          default:
            return 0;
        }
        return 0;
        }
        
    /** 
    * Try to upgrade the car to a better car
    * If the given car is better than the current car of the rent, upgrade it and return the upgrade additional cost, otherwise - don't upgrade
    * @param newCar - the car to upgrade to
    * @return the upgrade cost
    */
    public int upgrade(Car newCar) {
        Rent updatedRent = new Rent(_name, newCar, _pickDate, _returnDate);  
        if(_car.worse(newCar)) {
            int changeInPrice = Math.abs(getPrice() - updatedRent.getPrice());
            _car = newCar;
            return changeInPrice;
        }
        else {
            return 0;
        }
    }
    
    /** 
    * Check if there is a double listing of a rent for the same person and car with an overlap in the rental days
    * If there is - return a new rent object with the unified dates, otherwise - return null
    * @param other - the other rent
    * @return the unified rent or null
    */
    public Rent overlap (Rent other) {
        if (_name == other._name && _car.equals(other._car)) {
            Date s1 = _pickDate;
            Date e1 = _returnDate;
            Date s2 = other._pickDate;
            Date e2 = other._returnDate;
            if (s1.before(s2) && e1.after(e2)) {
                return new Rent(_name,_car,s1,e1);
            }
            if (s1.after(s2) && e1.before(e2)) {
                return new Rent(_name,_car,s2,e2);
            }
            if(s1.before(s2) && e1.after(s2)) {
                return new Rent(_name,_car,s1,e2);
            }
            if (s1.before(e2) && e1.after(e2)) {
                return new Rent(_name,_car,s2,e1);
            }
        }
        return null;
    }
}
