package date;
import java.util.Calendar;

public class Date implements Comparable<Date>{	
	private static final int[] DAYS = {0, 31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
	protected final int month;
	protected final int day;
	protected final int year;
	

	/*
	 * Initialized a new date from the month, day and year.
	 * @param month the month (between 1 and 12)
	 * @param day the day (between 1 and 28-31, depending on the month)
	 * @param year the year
	 * @throws IllegalArgumentException if the date is invalid
	 */

	public Date(int month, int day, int year){
		this.year = year;
		this.month = month;
		this.day = day;
		if (!Date.isValid(this.month, this.day, this.year)){
			throw new IllegalArgumentException();
		}
	}

	/*
	 * @return month of that month
	 */
	public int getMonth(){
		return this.month;
	}

	/*
	 * @return day of that day
	 */
	public int getDay(){
		return this.day;
	}

	/*
	 * @return year of that year
	 */
	public int getYear(){
		return this.year;
	}

	/*
	 * Is the given date valid?
	 */
	public static boolean isValid(int m, int d, int y){
			if(m > 12 || m < 1){
				return false;
			}
			if(y < 1000 || y > 9999){
				return false;
			}
			
			switch(m){
			case 1:
				if (m > 31){
					return false;
				}
			case 2:
				if(isLeapYear(y)){
					if(m > 29){
						return false;
					}
				} else {
				if(m > 28){
					return false;
				}
				}
			case 3:
				if(m > 31){
					return false;
				}
			case 4:
				if(m > 30){
					return false;
				}
			case 5:
				if(m > 31){
					return false;
				}
			case 6:
				if(m > 30){
					return false;
				}
			case 7:
				if(m > 31){
					return false;
				}
			case 8:
				if(m > 31){
					return false;
				}
			case 9:
				if(m > 30){
					return false;
				}
			case 10:
				if(m > 31){
					return false;
				}
			case 11:
				if(m > 30){
					return false;
				}
			case 12:
				if(m > 31){
					return false;
				}
				
			}
			return true;
	}

	/*
	 * Is year 'year' a leap year?
	 * @return true if 'year'is a leap year false otherwise
	 */
	public static boolean isLeapYear(int year){
		int compare = year % 4;
		if (compare == 0){
			return true;
		}
		return false;
	}

	/*
	 * Compare this date to that day.
	 * @return {a negative integer or zero or a positive integer}, depending on whether this date is {before, equal to, after} that date
	 */

	public int compareTo(Date that) {
		if(that.day < this.day){
			if(that.month < this.month){
				if(that.year < this.year){
					return 1;
				} else {
					return -1;
				}
			} else {
				if(that.year < this.year){
					return 1;
				} else {
					return -1;
				}
			}
		}
		if (that.day == this.day && that.month == this.month && that.year == this.year){
			return 0;
		}
		return -1;
	}

	/*
	 * Return a string representation of this date.
	 * @return the string representation in the format MM/DD/YYYY
	 */
	public String toString(){
		
		return month + "/" + day + "/" + year;
	}

	private String numToWords(int num) {
		
		String[] place = {
				"","Ten ","Twenty ","Thirty ","Forty ","Fifty ","Sixty ","Seventy ","Eighty ",
				"Ninety " };
		String[] number = {
				"","One ","Two ","Three ","Four ","Five ","Six ","Seven ","Eight ",
				"Nine ","Ten ","Eleven ","Twelve ","Thirteen ","Fourteen ","Fifteen ","Sixteen ","Seventeen ",
				"Eighteen ","Ninteen "};
		if (num < 20) {
			return number[num];
		}
		else if ((num > 19) && (num < 100)) {
			return place[num/10] + number[num%10];
		}
		else if (num > 100 && ((num%1000) > 99)) {
			if(((num%1000)%100) > 19){
				return number[num/1000] + "Thousand " + number[(num%1000)/100] + "Hundred "
						+ place[((num%1000)%100)%10] + number[((num%1000)%100)%10];
			} else {
				return number[num/1000] + "Thousand " + number[(num%1000)/100] + "Hundred "
						+ number[((num%1000)%100)];
			}
		}
		else if (num > 100 && ((num%1000) < 100)){
			if(((num%1000)%100) > 19){
				return number[num/1000] + "Thousand " + number[(num%1000)/100] + place[((num%1000)%100)%10] + number[((num%1000)%100)%10];
			} else {
				return number[num/1000] + "Thousand " + number[(num%1000)/100] + number[((num%1000)%100)];
			}
		}
		else {
			return "";
		}

	}

	
	public String dateToWords(int month, int day, int year) {
		String monthToWords;
		switch (month) {
			case 1: 
				monthToWords = "January ";
				break;
			case 2:
				monthToWords = "February ";
				break;
			case 3:
				monthToWords = "March ";
				break;
			case 4:
				monthToWords = "April ";
				break;
			case 5:
				monthToWords = "May ";
				break;
			case 6:
				monthToWords = "June ";
				break;
			case 7:
				monthToWords = "July ";
				break;
			case 8:
				monthToWords = "August ";
				break;
			case 9:
				monthToWords = "September ";
				break;
			case 10:
				monthToWords = "October ";
				break;
			case 11:
				monthToWords = "November ";
				break;
			case 12:
				monthToWords = "December ";
				break;
			default:
				throw new IllegalArgumentException();	
		}
		return monthToWords + numToWords(day) + numToWords(year);
	}

	
	
	int nyear;
	public int age(Date birthdate){
		Date todayDate = new Date(6, 9, 2016);

		int pmonth = birthdate.getMonth();
		int pday = birthdate.getDay();
		int pyear = birthdate.getYear();
		
		if(pyear < todayDate.getYear()){
			if(pmonth > todayDate.getMonth()){
				nyear = todayDate.getYear() - pyear - 1;
				return nyear;
			} else if (pmonth < todayDate.getMonth()){
				nyear = todayDate.getYear() - pyear;
				return nyear;
			} else if (pmonth == todayDate.getMonth()){
				if(pday > todayDate.getDay()){
					nyear = todayDate.getYear() - pyear - 1;
					return nyear;
				} else if (pday <= todayDate.getDay()){
					nyear = todayDate.getYear() - pyear;
					return nyear;
				}
			}
		}
		if(pyear == todayDate.getYear()){
			if(pmonth > todayDate.getMonth()){
				nyear = todayDate.getYear() - pyear - 1;
				return nyear;
			} else if (pmonth < todayDate.getMonth()){
				nyear = todayDate.getYear() - pyear;
				return nyear;
			} else if (pmonth == todayDate.getMonth()){
				if(pday > todayDate.getDay()){
					nyear = todayDate.getYear() - pyear - 1;
					return nyear;
				} else if (pday <= todayDate.getDay()){
					nyear = todayDate.getYear() - pyear;
					return nyear;
				}
			}
		}
		return nyear;

	}
	

}
