package BookStore;

public abstract class User{
	protected String name;
	protected String cpf;
	protected String pass;
	protected String accountType;

	public String getName(){
		return this.name;
	}

	public String getCpf(){
		return this.cpf;
	}

	public String getPass(){
		return this.pass;
	}

	public String getAccountType(){
		return this.accountType;
	}

	public boolean setPass(String oldPass, String newPass){
		if(oldPass.equals(this.pass)){
			this.pass = newPass;
			return true;
		}
		else{
			return false;
		}
	}

	

}