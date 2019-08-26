package BookStore;

import java.util.ArrayList;

public class UserList{

	private ArrayList <User> userList = new ArrayList <User>();

	public boolean addUser(User newUser){
		for(int j = 0; j < userList.size(); j++){
			if(userList.get(j).getCpf().equals(newUser.getCpf())){
				return false;
			}
		}

		userList.add(newUser);

		return true;
	}

	public boolean removeUser(String cpf){
		for(int j = 0; j < userList.size(); j++){
			if(userList.get(j).getCpf().equals(cpf)){
				userList.remove(j);
				return true;
			}
		}

		return false;	
	}

	public int getSize(){
		return this.userList.size();
	}

	public User getUser(int i){
		return this.userList.get(i);
	}
} 