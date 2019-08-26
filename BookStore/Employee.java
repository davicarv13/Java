package BookStore;

public class Employee extends User{

	protected double salary;
	protected String shift;

	public Employee(String name, String cpf, String pass, double salary, String accountType){

		this.name = name;
		this.cpf = cpf;
		this.pass = pass;
		this.accountType = accountType;
		this.salary = salary;
	}

	public double getSalary(){

		return this.salary;
	}

	public double getBonification(){

		return this.salary + (this.salary * 0.1);
	}
}