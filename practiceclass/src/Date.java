import java.util.Scanner;

public class Date {

	private int day;
	private String month;
	private int year;

// Constructor-1 (without parameters) initialize date to a default value (day, month and year)
	public Date() {
		day = 27;
		month = "June";
		year = 1990;
	}

// Constructor-2 (with parameters) validates date and assign the date (day, month and year)- if validated
	public Date(int cDay, String cMonth, int cYear) {
		// Validate Date (day, month and year) using setDate
		setDate(cMonth, cDay, cYear);
	}

// Constructor-3 (with parameters) validates the parameters and initialize the properties.
	public Date(int iMonth, int iDay, int iYear) {
		// Validate Date (day, month and year) using setDate
		setDate(iMonth, iDay, iYear);
	}

	Scanner in = new Scanner(System.in);

	// Validate date (day, month and year)
	public boolean validateDate(int vDay, String vMonth, int vYear) {
		boolean state = false;
		String[] validMonths = { "January", "Feburary", "March", "April", "May", "June", "July", "August", "September",
				"October", "November", "December" };
		if (vDay >= 1 && vDay <= 31) {
			state = true;
		} else {
			state = false;
		}
		if (vYear >= 1000 && vYear <= 9999) {
			state = true;
		} else {
			state = false;
		}
		for (int i = 0; i < 12; i++) {
			if (vMonth.equalsIgnoreCase(validMonths[i])) {
				state = true;
				break;
			} else {
				state = false;
			}
		}

		return state;
	}

	// Return true when other date has the same day, month and year
	public boolean equals(Date d, Date e) {
		boolean state = true;

		if (d.day != e.day) {
			state = false;
			return state;
		}
		if (d.year != e.year) {
			state = false;
			return state;
		}
		if (!d.month.equalsIgnoreCase(e.month)) {
			state = false;
			return state;
		}
		return state;
	}

	// Convert an integer month to its corresponding name
	private String monthString(int iMonth) {
		String a_Month = "";
		if (iMonth < 0 || iMonth > 13) {
			System.out.println("Enter data is not as per required parameters");
			System.exit(0);
		} else {
			switch (iMonth) {
			case 1:
				a_Month = "January";
				break;
			case 2:
				a_Month = "Feburary";
				break;
			case 3:
				a_Month = "March";
				break;
			case 4:
				a_Month = "April";
				break;
			case 5:
				a_Month = "May";
				break;
			case 6:
				a_Month = "June";
				break;
			case 7:
				a_Month = "July";
				break;
			case 8:
				a_Month = "August";
				break;
			case 9:
				a_Month = "September";
				break;
			case 10:
				a_Month = "October";
				break;
			case 11:
				a_Month = "November";
				break;
			case 12:
				a_Month = "December";
				break;
			}

		}
		return a_Month;
	}

	// Validate if the actual parameters represent a valid date

	private boolean dateOK(String aMonth, int aDay, int aYear) {
		boolean state = false;
		String[] validMonths = { "January", "Feburary", "March", "April", "May", "June", "July", "August", "September",
				"October", "November", "December" };
		if (aDay >= 1 && aDay <= 31) {
			state = true;
		}
		if (aYear >= 1000 && aYear <= 9999) {
			state = true;
		}
		for (int i = 0; i < 12; i++) {
			if (aMonth.equalsIgnoreCase(validMonths[i])) {
				state = true;
				break;
			}
		}
		// Check for Leap year
		// if(aMonth.equalsIgnoreCase("February") && aYear%4 == 0)
		return state;
	}

	// Validate the actual parameters and set the values of the properties- like
	// Constructor-3 (int, int, int)
	public void setDate(int iMonth, int iDay, int iYear) {
		String s_Month = monthString(iMonth); // Converts integer month to string month, example- 1 to January, 2 to
												// February and so on
		boolean valid = dateOK(s_Month, iDay, iYear); // Validates the data
		if (valid) { // Initialize the properties, if validated
			day = iDay;
			month = s_Month;
			year = iYear;
		} else {
			System.out.println("Enter data is not as per required parameters or with in the date range");
			System.exit(0);
		}

	}

	// Validate the actual parameters and set the values of the properties- like
	// Constructor-2 (String, int, int)
	public void setDate(String cMonth, int cDay, int cYear) {
		// validate Date (day, month and year)
		boolean valid = validateDate(cDay, cMonth, cYear);
		if (valid) {
			day = cDay;
			month = cMonth;
			year = cYear;
		} else {
			System.out.println("Enter data is not as per required parameters or with in the date range");
			System.exit(0);
		}

	}

	// Getters
	public int getDay() {
		return day;
	}

	public int getYear() {
		return year;
	}

	public int getMonth() {
		int iMonth = 0;
		if (month.equalsIgnoreCase("January")) {
			iMonth = 1;
		}
		if (month.equalsIgnoreCase("February")) {
			iMonth = 2;
		}
		if (month.equalsIgnoreCase("March")) {
			iMonth = 3;
		}
		if (month.equalsIgnoreCase("April")) {
			iMonth = 4;
		}
		if (month.equalsIgnoreCase("May")) {
			iMonth = 5;
		}
		if (month.equalsIgnoreCase("June")) {
			iMonth = 6;
		}
		if (month.equalsIgnoreCase("July")) {
			iMonth = 7;
		}
		if (month.equalsIgnoreCase("August")) {
			iMonth = 8;
		}
		if (month.equalsIgnoreCase("September")) {
			iMonth = 9;
		}
		if (month.equalsIgnoreCase("October")) {
			iMonth = 10;
		}
		if (month.equalsIgnoreCase("November")) {
			iMonth = 11;
		}
		if (month.equalsIgnoreCase("December")) {
			iMonth = 12;
		}

		if (iMonth == 0) {
			System.out.println("Enter data is not as per required parameters or with in the date range");// month is not
																											// initiated
			System.exit(0);
		}
		return iMonth;
	}

	// Setters
	public void setDay(int aday) {
		day = aday;
	}

	public void setYear(int aYear) {
		year = aYear;
	}

	public void setMonth(int iMonth) {
		if (iMonth < 1 || iMonth > 12) {
			System.out.println("Enter data is not with in the date range");
			System.exit(0);
		} else {
			switch (iMonth) {
			case 1:
				month = "January";
				break;
			case 2:
				month = "Februrary";
				break;
			case 3:
				month = "March";
				break;
			case 4:
				month = "April";
				break;
			case 5:
				month = "May";
				break;
			case 6:
				month = "June";
				break;
			case 7:
				month = "July";
				break;
			case 8:
				month = "August";
				break;
			case 9:
				month = "September";
				break;
			case 10:
				month = "October";
				break;
			case 11:
				month = "November";
				break;
			case 12:
				month = "December";
				break;
			}

		}

	}
}
/*
 * // Method to validate date public int inputDateOK() {
 * 
 * boolean dayCheck = in.hasNextInt(); if (!dayCheck) {
 * System.out.println("Entered date is not an integer"); System.exit(0); } else
 * { day = in.nextInt(); if (day >= 1 && day <= 31) { dayCheck = false; } else {
 * System.out.println("Entered date is not an integer between 1 and 31");
 * System.exit(0); } } return day; }
 * 
 * // Method to validate month public String inputMonthOK() {
 * 
 * String[] validMonths = { "January", "Feburary", "March", "April", "May",
 * "June", "July", "August", "September", "October", "November", "December" };
 * boolean monthCheck = in.hasNext(); boolean flag = false; if (!monthCheck) {
 * System.out.println("Entered month is not a string"); System.exit(0); } else {
 * month = in.next(); for (int i = 0; i < 12; i++) { if
 * (month.equalsIgnoreCase(validMonths[i])) { monthCheck = false; flag = true;
 * break; } } if (!flag) { System.out.
 * println("Entered month is not a string between months January and Feburary");
 * System.exit(0); } } return month; }
 * 
 * // Method to validate year public int inputYearOK() { boolean yearCheck =
 * in.hasNextInt(); if (!yearCheck) {
 * System.out.println("Entered year is not an integer"); System.exit(0); } else
 * { year = in.nextInt(); if (year >= 1000 && day <= 9999) { yearCheck = false;
 * } else {
 * System.out.println("Entered year is not an integer between 1000 and 9999");
 * System.exit(0); } } return year; }
 */
