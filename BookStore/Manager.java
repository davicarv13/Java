package BookStore;

public class Manager extends Employee{

	protected double salary;

	public Manager(String name, String cpf, String pass, double salary, String accountType){
		super(name, cpf, pass, salary, accountType);	
	}

	@Override
	public double getBonification(){

		return super.getBonification() + (this.salary * 0.1);
	}
}