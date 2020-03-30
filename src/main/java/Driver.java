// Class to test classes- Date and Employee
public class Driver {

	public static void main(String[] args) {
		Date hrDate2 = new Date("December", 3, 2008);
		Employee e1 = new Employee(); // Constructs employee with default name and default date
		Employee e2 = new Employee("Peter", hrDate2);
		Employee e3 = new Employee(); // Again constructs employee with default name and default date

// Prints the status of e1 and e2
		System.out.println("The first employee (e1): ");
		System.out.println(
				e1.getName() + " " + e1.aDate.getmonthString() + " " + e1.aDate.getDay() + ", " + e1.aDate.getYear() + "\n");
		System.out.println("The second employee (e2): ");
		System.out.println(
				e2.getName() + " " + e2.aDate.getmonthString() + " " + e2.aDate.getDay() + ", " + e2.aDate.getYear() + "\n");

// Compare the seniority of e1 and e2
		if (e1.seniority(e2) == 0)
			System.out.println(e1.getName() + " has same senioirty as " + e2.getName() + "\n");
		if (e1.seniority(e2) == -1)
			System.out.println(e1.getName() + " is more senior than " + e2.getName() + "\n");
		if (e1.seniority(e2) == 1)
			System.out.println(e2.getName() + " is more senior than " + e1.getName() + "\n");

// Prints the status of e3
		System.out.println("The duplicated employee (e3): ");
		System.out.println(
				e3.getName() + " " + e3.aDate.getmonthString() + " " + e3.aDate.getDay() + ", " + e3.aDate.getYear() + "\n");

// Using equals(method in Employee class) to compare. This methods compare only hiring date
		System.out.println("e1.equals(e2) => " + e1.equals(e2));
		System.out.println("e1.equals(e3) => " + e1.equals(e3));

// Using == to compare employee 
		System.out.println("(e1 == e2) => " + equalsOperator(e1, e2));
		System.out.println("(e1 == e3) => " + equalsOperator(e1, e3));
	}

// Compares employees using equal to operator
	public static boolean equalsOperator(Employee emp1, Employee emp2) {
		if (emp1 == emp2)
			return true;
		return false;
	}
}
