
public class Employee {

// Properties
	String aName;;
	Date aDate;

// Constructor1- initialise properties to default value
	public Employee() {
		aName = "Jack";
		aDate = new Date();
	}

// Constructor2- initialise properties to passed parameters
	public Employee(String aName, Date aDate) {
		this.aName = aName;
		this.aDate = aDate;
	}

// Compares the seniority of this employee and the employee e
// returns 0 if equal, returns -1 if this.employee is senior, and 1 if not senior
	public int seniority(Employee e) {
		if (this.aDate.equals(e.aDate))
			return 0;
		else if (this.aDate.isSenior(e.aDate))
			return -1;
		return 1;
	}

// Checks only for this employee hiring date and name is same as employee e
	public boolean equals(Employee e) {
		if (this.aDate.equals(e.aDate) && this.aName.equalsIgnoreCase(e.aName))
			return true;
		return false;
	}

// Getters- Accessor of properties
	public String getName() {
		return this.aName;
	}

	public Date getHireDate() {
		return this.aDate;
	}

// Setters- Mutators of properties.
	public void setName(String aName) {
		this.aName = aName;
	}

	public void setHireDate(Date aDate) {
		this.aDate = aDate;
	}
}
