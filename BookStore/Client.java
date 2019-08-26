package BookStore;

public class Client extends User{

	private String shipName;
	private String shipAddress;

	public Client(String name, String cpf, String pass, String shipName, String shipAddress, String accountType){
		this.name = name;
		this.cpf = cpf;
		this.pass = pass;
		this.accountType = accountType;
		this.shipName = shipName;
		this.shipAddress = shipAddress;
	}

	public String getShipName(){
		return this.shipName;
	}

	public void setShipName(String shipName){
		this.shipName = shipName;
	}

	public String getShipAddress(){
		return this.shipAddress;
	}

	public void setShipAddress(String shipAddress){
		this.shipAddress = shipAddress;
	}
}