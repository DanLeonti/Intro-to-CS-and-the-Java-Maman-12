
/**
 * Matala 12 - Question 1
 * This class represents a Car object
 * @author Daniel Leonti
 * @version 2023a
 */

public class Car
{
    public static final int DEF_ID = 9999999;
    public static final int ID_LENGTH = 7;
    public static final char DEF_TYPE = 'A';
    
    private int _id;
    private char _type;
    private String _brand;
    private boolean _isManual;
    
    /**
    * creates a new Car object
    * id should be a 7 digits number, otherwise set it to 9999999
    * type should be 'A','B','C' or 'D', otherwise set it to 'A'
    * @param _id - the id of the car (7 digits number)
    * @param _type - the type of the car ('A','B','C' or 'D')
    * @param _brand - the car's brand
    * @param _isManual - flag indicating if the car is manual
    */

    public Car(int id, char type, String brand, boolean isManual)
    {
        _brand = brand;
        _isManual = isManual;
        _id = DEF_ID;
        if (id >=1000000 && id < 10000000) {
            _id = id;
        }
        _type = DEF_TYPE;
        if (type == 'A' || type == 'B' || type == 'C' || type == 'D') {
            _type = type;
        }
        
    }
    
    /**
    * Copy Constructor
    * @param other - the car to be copied
    */
    public Car(Car other)
    {
        _id = other._id;
        _type = other._type;
        _brand = other._brand;
        _isManual = other._isManual;
    }
    
    /**
    * Gets the id
    * @return the id
    */
    public int getId()
    {
        return _id;
    }
    
    /**
    * Gets the type
    * @return the type
    */ 
    public char getType()
    {
        return _type;
    }
    
    /**
    * Gets the brand
    * @return the brand
    */
    public String getBrand()
    {
        return _brand;
    }
    
    /**
    * Gets the isManual flag
    * @return the isManual flag
    */
    public boolean isManual()
    {
        return _isManual;
    }
    
    /** Sets the id (only if the given id is valid)
    * @param id - the id value to be set
    */
    public void setId(int id){
        if (_id >=1000000 && id < 10000000) {
         _id = id;
     }
    }
    
     /** Sets the type (only if the given type is valid)
    * @param type - the type value to be set
    */
    public void setType(char type){
     if (type == 'A' || type == 'B' || type == 'C' || type == 'D') {
         _type = type;
     }
    }
    
    /** Sets the brand
    * @param brand the value to be set
    */
    public void setBrand(String brand){
     _brand = brand;
    }
     
     /** Sets the isManual flag of the car
    * @param isManual - the isManual flag to be set
    */
    public void setIsManual(boolean manual){
     _isManual = manual;
    }
     
    /**
    * Returns a String object that represents this car
    * @override toString in class java.lang.Object
    * @return String that represents this car in the following format: id:1234567 type:B brand:Toyota gear:manual (or auto)
    */
    public String toString() {
        if (_isManual == true) {
            String gear = "manual";
            return ("id:" + _id + " type:" + _type + " brand:" + _brand + " gear:manual");
        } 
        if (_isManual == false) {
            return ("id:" + _id + " type:" + _type + " brand:" + _brand + " gear:auto");
        }
        else {return ("Invalid Gear Input");}
    }
    
    /**
    * Check if two cars are the same
    * Cars are considered the same if they have the same type, brand and gear
    * @param other - the car to compare this car to
    * @return true if the cars are the same, otherwise false
    */    
    public boolean equals(Car other) {
        if (this._type == other._type && this._brand == other._brand && this._isManual == other._isManual) {
            return true;
        } 
        else {
            return false;
        }
    }
    
    /**
    * Check if this car is better than the other car
    * A car is considered better than another car if its type is higher.
    * If both cars have the same type, an automated car is better than a manual car.
    * @param other - car to compare this car to
    * @return true if this car is better than the other car, otherwise false
    */ 
    public boolean better(Car other) {
        if (this._type > other._type) {
            return true;
        }
        if (this._type == other._type && this._isManual == true && other._isManual == false) {
            return false;
        }
        if (this._type == other._type && this._isManual == false && other._isManual == true) {
            return true;
        }
        else {
            return false;
        }
    }
    
    /**
    * Check if this car is worse than the other car
    * @param other - car to compare this car to
    * @return true if this car is worse than the other car, otherwise false
    */ 
    public boolean worse(Car other) {
        if (this.better(other)) {
            return false;
        }
        else {
            return true;
        }
    }
}