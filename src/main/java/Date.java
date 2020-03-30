public class Date {

	private int day;
	private String month;
	private int year;

	// Constructors
// Constructor-1 (without parameters) initialise date to a default value (day, month and year)
	public Date() {
		day = 5;
		month = "October";
		year = 2019;
	}

// Constructor-2 (monthString, day, year) Validate and Initialise the properties (date) (day, month and year)- if validated
	public Date(String monthString, int day, int year) {
		if (dateOK(monthString, day, year)) // Validates and prints error
			setDateWOValidation(monthString, day, year); // sets the properties (without validation)
	}

// Constructor-3 (monthInt, day, year) Validate and Initialise the properties.
	public Date(int monthInt, int day, int year) {
		if (dateOK(monthInt, day, year)) // Validates and prints error
			setDate(monthInt, day, year); // Convert month to String, and set the properties (without validation)
	}

	// Validators
// Validate date (monthString, day, year)
	public boolean validateDate(String monthString, int day, int year) {
		if (day < 1 || day > 31)
			return false;
		if (year < 1000 || year > 9999)
			return false;
		if (!validateMonthStr(monthString))
			return false;
		if (monthString.equalsIgnoreCase("February") && (day > 29))
			return false;
		return true;
	}

// Validate date (montInt, day, year)
	public boolean validateDate(int monthInt, int day, int year) {
		if (monthInt < 1 || monthInt > 12)
			return false;
		if (day < 1 || day > 31)
			return false;
		if (year < 1000 || year > 9999)
			return false;
		if (monthInt == 2 && day > 29)
			return false;
		return true;
	}

// Validates date (monthString)- "validateDate" plus check for leap year (if day = 29, monthString = February, and leapYear- date is OK)
	private boolean dateOK(String monthString, int day, int year) {
		boolean valid = validateDate(monthString, day, year);
		boolean leapY = leapYear(year);
		boolean errorFlag = !valid || (valid && monthString.equalsIgnoreCase("February") && day == 29 && !leapY);
		if (errorFlag) {
			inputError(); // Printing error (and exit) when validation fails
		}
		return true;

		// if (valid && leapY && monthString.equalsIgnoreCase("February") && day == 29)
		// return true;

	}

// Validates date (monthInt)- "validateDate" + error print + check for leap year 
	private boolean dateOK(int monthInt, int day, int year) {
		boolean valid = validateDate(monthInt, day, year);
		boolean leapY = leapYear(year);
		boolean errorFlag = !valid || (valid && monthInt == 2 && day == 29 && !leapY);
		if (valid && leapY && monthInt == 2 && day == 29)
			return true;
		if (errorFlag)
			inputError(); // Printing error (and exit) when validation fails
		return valid;
	}

// Getters
	// 4 Getters - day, year, monthInt, and monthString
	public int getDay() {
		return this.day;
	}

	public int getYear() {
		return this.year;
	}

	public int getMonth() { // Returns monthInt and not monthString
		return iMonth(this.month);
	}

	public String getmonthString() { // Returns monthString
		return this.month;
	}

	// Setters or Mutators
// Setter- Sets the date (monthInt, day, year)
	public void setDate(int monthInt, int day, int year) {
		if (dateOK(monthInt, day, year)) // Validates date and prints error
			setDateWOValidation(monthInt, day, year); // Sets properties without validation
	}

// Setter- Sets the date (monthString, day, year)
	public void setDate(String monthString, int day, int year) {
		if (dateOK(monthString, day, year)) // Validates date and prints error
			setDateWOValidation(monthString, day, year); // Sets properties without validation
	}

// 4 Setters - one for each: day, year, monthInt, and  monthString
	public void setDay(int day) {
		if (day >= 1 && day <= 31)
			this.day = day;
		else
			inputError();
	}

	public void setYear(int year) {
		if (year >= 1000 && year <= 9999)
			this.year = year;
		else
			inputError();
	}

	public void setMonth(int monthInt) {
		if (monthInt >= 1 && monthInt <= 12)
			this.month = monthString(monthInt);
		else
			inputError();
	}

	public void setMonth(String monthString) {
		if (validateMonthStr(monthString))
			this.month = monthString;
		else
			inputError();
	}

	// Other functions required in Assignment
// Return true when other date has the same day, month and year. month is in string format.
	public boolean equals(Date otherDate) {
		if (this.day != otherDate.day)
			return false;
		if (this.year != otherDate.year)
			return false;
		if (!this.month.equalsIgnoreCase(otherDate.month))
			return false;
		return true;
	}

// Return true when this date is more senior than other date
	public boolean isSenior(Date otherDate) {
		if (this.getYear() < otherDate.getYear())
			return true;
		if (this.getYear() == otherDate.getYear()) {
			if (this.getMonth() < otherDate.getMonth())
				return true;
			else if (this.getMonth() == otherDate.getMonth() && this.getDay() < otherDate.getDay())
				return true;
		}
		return false;
	}

// Converts monthInt to monthString (example 1 to January, and so on)
	private String monthString(int monthInt) {
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

	// Helping functions (made locally- not needed for assignment)
// Sets date- without validation
	private void setDateWOValidation(String monthString, int day, int year) {
		this.month = monthString;
		this.day = day;
		this.year = year;
	}

	private void setDateWOValidation(int monthInt, int day, int year) {
		String monthString = monthString(monthInt); // Convert monthInt to monthString
		this.month = monthString; // initialise
		this.day = day;
		this.year = year;
	}

// Print error and exit system
	private void inputError() {
		System.out.println("Error in input data");
		System.exit(0);
	}

// Check for leap year (monthInt)
	private boolean leapYear(int year) {
		if ((year % 4) == 0 && (year % 100) != 0)
			return true;
		if ((year % 100 == 0) && (year % 400 == 0))
			return true;
		return false;
	}

// Validates monthString
	private boolean validateMonthStr(String monthString) {
		String[] validMonths = { "January", "February", "March", "April", "May", "June", "July", "August", "September",
				"October", "November", "December" };
		for (int i = 0; i < 12; i++) {
			if (monthString.equalsIgnoreCase(validMonths[i]))
				return true;
		}
		return false;
	}
}