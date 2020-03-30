public class Date {

	private int day;
	private String month;
	private int year;

// Constructor-1 (without parameters) initialise date to a default value (day, month and year)
	public Date() {
		day = 27;
		month = "June";
		year = 1990;
	}

// Constructor-2 (monthString, day, year) Validate and Initialise the properties (date) (day, month and year)- if validated
	public Date(String monthString, int day, int year) {
		setDate(monthString, day, year); // Validates and sets the properties
	}

// Constructor-3 (monthInt, day, year) Validate and Initialise the properties.
	public Date(int monthInt, int day, int year) {
		setDate(monthInt, day, year); // Convert monthInt to monthString, validate, and set the properties
	}

// Validate date (monthString, day, year)
	public boolean validateDate(String monthString, int day, int year) {
		if (day < 1 || day > 31)
			return false;
		if (year < 1000 || year > 9999)
			return false;
		if (month.equalsIgnoreCase("February") && (day > 29)) // 29 is true if it is leap year- Special method is dateOK
			return false;
		if (!validateMonthStr(monthString))
			return false;
		return true;
	}

// Validate date (montInt, day, year)
	public boolean validateDate(int monthInt, int day, int year) {
		boolean state = false;
		if (monthInt < 1 || monthInt > 12)
			return state;
		if (day < 1 || day > 31)
			return state;
		if (year < 1000 || year > 9999)
			return state;
		if (monthInt == 2 && day > 29) // 29 is true if it is leap year- Special method is dateOK
			return state;
		return !state;
	}

// Return true when other date has the same day, month and year. month is in string format.
	public boolean equals(Date otherDate) {
		boolean state = false;
		if (this.day != otherDate.day)
			return state;
		if (this.year != otherDate.year)
			return state;
		if (!this.month.equalsIgnoreCase(otherDate.month))
			return state;
		return !state;
	}

// Converts monthInt to monthString (example 1 to January, and so on)
	private String monthStr(int monthInt) {
		String monthString = "";
		switch (monthInt) {
		case 1:
			monthString = "January";
			break;
		case 2:
			monthString = "Feburary";
			break;
		case 3:
			monthString = "March";
			break;
		case 4:
			monthString = "April";
			break;
		case 5:
			monthString = "May";
			break;
		case 6:
			monthString = "June";
			break;
		case 7:
			monthString = "July";
			break;
		case 8:
			monthString = "August";
			break;
		case 9:
			monthString = "September";
			break;
		case 10:
			monthString = "October";
			break;
		case 11:
			monthString = "November";
			break;
		case 12:
			monthString = "December";
			break;
		}
		return monthString;
	}

// Converts monthString to monthInt
	private int iMonth(String monthString) {
		int monthInt = 0; // returns 0 in case of monthString is null or invalid
		if (monthString.equalsIgnoreCase("January"))
			monthInt = 1;
		if (monthString.equalsIgnoreCase("February"))
			monthInt = 2;
		if (monthString.equalsIgnoreCase("March"))
			monthInt = 3;
		if (monthString.equalsIgnoreCase("April"))
			monthInt = 4;
		if (monthString.equalsIgnoreCase("May"))
			monthInt = 5;
		if (monthString.equalsIgnoreCase("June"))
			monthInt = 6;
		if (monthString.equalsIgnoreCase("July"))
			monthInt = 7;
		if (monthString.equalsIgnoreCase("August"))
			monthInt = 8;
		if (monthString.equalsIgnoreCase("September"))
			monthInt = 9;
		if (monthString.equalsIgnoreCase("October"))
			monthInt = 10;
		if (monthString.equalsIgnoreCase("November"))
			monthInt = 11;
		if (monthString.equalsIgnoreCase("December"))
			monthInt = 12;
		return monthInt;
	}

// Validates date (monthString)- "validateDate" plus check for leap year (if day = 29, monthString = February, and leapYear- date is OK)
	private boolean dateOK(String monthString, int day, int year) {
		boolean valid = validateDate(monthString, day, year);
		if (valid && monthString.equalsIgnoreCase("February")) { // check for leap year if February
			boolean leapYear = false;
			if ((year % 4) == 0 && (year % 100) != 0)
				leapYear = true;
			if ((year % 100 == 0) && (year % 400 == 0))
				leapYear = true;
			if ((!leapYear) && (day == 29)) // return false- if its not a leap year and day is 29 in February
				valid = false;
		}
		return valid;
	}

// Validates date (monthInt)- "validateDate" plus check for leap year (if day = 29, monthInt = 2, and leapYear- date is OK)
	private boolean dateOK(int monthInt, int day, int year) {
		boolean valid = validateDate(monthInt, day, year);
		if (valid && (monthInt == 2)) { // check for leap year if monthInt = 2
			boolean leapYear = false;
			if ((year % 4) == 0 && (year % 100) != 0)
				leapYear = true;
			if ((year % 100 == 0) && (year % 400 == 0))
				leapYear = true;
			if ((!leapYear) && (day == 29)) // return false- if its not a leap year and day is 29 in February
				valid = false;
		}
		return valid;
	}

// Setter- Sets the date (monthInt, day, year)
	public void setDate(int monthInt, int day, int year) {
		boolean valid = validateDate(monthInt, day, year); // Validates date
		if (valid == true) { // If valid- initialise, else print error
			String monthString = monthStr(monthInt); // Convert monthInt to monthString
			this.month = monthString; // initialise
			this.day = day;
			this.year = year;
		} else
			System.out.println("Error in input data");
	}

// Setter- Sets the date (monthString, day, year)
	public void setDate(String monthString, int day, int year) {
		boolean valid = validateDate(monthString, day, year); // Validates date
		if (valid == true) { // If valid, else print error
			this.month = monthString;
			this.day = day;
			this.year = year;
		} else
			System.out.println("Error in input data");
	}

// 3 Getters - day, year, and monthInt
	public int getDay() {
		return this.day;
	}

	public int getYear() {
		return this.year;
	}

	public int getMonth() { // Returns monthInt and not monthString
		return iMonth(this.month);
	}

// 4 Setters - day, year, monthInt, monthString
	public void setDay(int day) {
		if (day >= 1 && day <= 31)
			this.day = day;
		else
			System.out.println("Error in input data");
	}

	public void setYear(int year) {
		if (year >= 1000 && year <= 9999)
			this.year = year;
		else
			System.out.println("Error in input data");
	}

	public void setMonth(int monthInt) {
		if (monthInt >= 1 && monthInt <= 12)
			this.month = monthStr(monthInt);
		else
			System.out.println("Error in input data");
	}

	public void setMonth(String monthString) {
		if (validateMonthStr(monthString))
			this.month = monthString;
		else
			System.out.println("Error in input data");
	}

//Validates monthString
	public boolean validateMonthStr(String monthString) {
		String[] validMonths = { "January", "February", "March", "April", "May", "June", "July", "August", "September",
				"October", "November", "December" };
		for (int i = 0; i < 12; i++) {
			if (monthString.equalsIgnoreCase(validMonths[i]))
				return true;
		}
		return false;
	}
}