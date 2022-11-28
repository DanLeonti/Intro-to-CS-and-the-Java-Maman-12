/**
 * Matala 12 - Question 2
 * This class represents a Date object
 * @author Daniel Leonti
 * @version 2023a
 */
public class Date
{
    // declering constant values
    public static final char DEF_MONTH = 1, DEF_YEAR = 2000;
    private final int TWO_DIGITS=10, MAX_YEAR=9999, DAY31=31, DAY30=30, DAY29=29, DAY1=1, DEF_DAY = 1;
    private final int JAN=1, FEB=2, MARCH=3, APRIL=4, MAY=5, JUN=6, JUL=7, AUG=8, SEP=9, OCT=10, NOV=11, DEC=12;
    
    private int _day;
    private int _month;
    private int _year;
    
    //constructors:
    /**
    * If the given date is valid - creates a new Date object, otherwise creates the date 1/1/2000
    * @param day - the day in the month (1-31)
    * @param month - the month in the year (1-12)
    * @param year - the year (4 digits)
    */
    public Date (int day, int month, int year) {
    if(dateRight(day, month, year)) {
        _day = day;
        _month = month;
        _year = year;
    }
    else { // default values
        _day = DEF_DAY;
        _month = DEF_MONTH;
        _year = DEF_YEAR;
    }
    }
    
    /**
    * Copy Constructor
    * @param other - the date to be copied
    */
    public Date(Date other)
    {
        _day = other._day;
        _month = other._month;
        _year = other._year;
    }
    
    /** 
    * Gets the year
    * @return the year
    */
    public int getYear(){
        return _year;
    }
    
    /** 
    * Gets the month
    * @return the month
    */
    public int getMonth(){
        return _month;
    }
    
    /** 
    * Gets the day
    * @return the day
    */
    public int getDay(){
        return _day;
    }
    
    /** 
    * Set the day (only if date remains valid)
    * @param dayToSet - the day value to be set
    */
    public void setDay(int dayToSet) {
        if(dateRight(dayToSet, _month, _year)) 
            _day = dayToSet;
    }
    
    /** 
    * Set the month (only if date remains valid)
    * @param monthToSet - the month value to be set
    */
    public void setMonth(int monthToSet) {
        if(dateRight(_day, monthToSet, _year))
            _month = monthToSet;
    }
    
    /** 
    * Sets the year (only if date remains valid)
    * @param yearToSet - the year value to be set
    */
    public void setYear(int yearToSet) {
        if(dateRight(_day, _month, yearToSet))
            _year = yearToSet;
    }
    
    /**
    * Check if 2 dates are the same
    * @param other - the date to compare this date to
    * @return true if the dates are the same, otherwise false
    */    
    public boolean equals (Date other) {
        if (other.getDay() == _day && other.getMonth() == _month && other.getYear() == _year)
            return true;
        return false;
    }
    
    /**
    * Check if this date is before other date
    * @param other - date to compare this date to
    * @retun true if this date is before other date, otherwise false
    */
    public boolean before (Date other) {
    if (other.getYear() > _year)
        return true;
    else if (other.getYear() == _year) { // compare the years
        if (other.getMonth() > _month)
            return true;
        else if (other.getMonth() == _month) { // compare the months
            if (other.getDay() > _day)
                return true;
            return false;
        }
        return false;
    }
    return false;
    }
    
    /**
    * Check if this date is after other date
    * @param other - date to compare this date to
    * @retun true if this date is after other date, otherwise false
    */
    public boolean after(Date other) {
        if (!this.before(other))
            return true;
        else
            return false;
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
    * Calculates the difference in days between two dates
    * @param other - the date to calculate the difference between
    * @retun the number of days between the dates (non negative value)
    */
    public int difference(Date other) {
        return (Math.abs(calculateDate(_day, _month, _year) - calculateDate(other._day, other._month, other._year)));
    }
    
    private boolean dateRight(int day, int month, int year) {
        if(day < DAY1 || day > DAY31 || month < JAN || month > DEC || year < 1000 || year > MAX_YEAR)
		return false;
	else if(month == FEB && day == DAY29) {
		if(year % 4 == 0) {
			if(year % 100 == 0) {
				if(year % 400 == 0)
					return true; // divide in 4 and in 100 and in 400
				return false; // divide in 4 and in 100 but not in 400
			}
			return true; // divide in 4 and not in 100
		}
		return false; // not divide in 4
	}
	else if(day == DAY30) {
		if(month == APRIL || month == JUN || month == SEP || month == NOV) 
			return true;
		return false;
	}
	else if(day == DAY31) {
		if(month == JAN || month == MARCH || month == MAY || month == JUL || month == AUG || month == OCT || month == DEC) 
			return true;
		return false;
	}
	return true;
    }
    
    /**
    * Returns a String that represents this date
    * @override toString in class java.lang.Object
    * @return String that represents this date in the following format: day (2 digits) / month(2 digits) / year (4 digits) for example: 02/03/1998
    */
    public String toString() {
        if(_day < TWO_DIGITS || _month < TWO_DIGITS) {
            if(_month >= TWO_DIGITS)
                return "0" + _day + "/" + _month + "/" + _year; // all 0 to the day if missing 
            else if(_day >= TWO_DIGITS)
                return _day + "/0" + _month + "/" + _year; // all 0 to the month if missing 
            return "0" + _day + "/0" + _month + "/" + _year; // all 0 to the year if missing 
            }
        return _day + "/" + _month + "/" + _year; // else
    }
    
    /**
    * Calculate the date of tomorrow
    * @return the date of tomorrow
    */
    public Date tomorrow() {
        if(_day == 31 && _month == 12 && _year == MAX_YEAR)
            return new Date (01, 01, 2000);
        else if(dateRight(_day+1, _month, _year))
            return new Date(_day+1, _month, _year); // if the date+1 is right return the date+1
        else {
            if(_month == 12)
                return new Date (01, 01, _year+1); // if the date is the last one in the year return the first in the new year
            else
                return new Date(1, _month+1, _year); // else return the first in the next month 
        }
    }
}
