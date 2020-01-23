package Banco;

import java.util.ArrayList;

public class ArrayListCartaoCredito{
	public ArrayList<CartaoCredito> cartoesCredito = new ArrayList<CartaoCredito>();
	/*
	public CartaoCredito retornaCartaoCredito(int i){
		for(int i = 0; i < cartoesCredito.size(); i++){
			return cartoesCredito.get(i);
		}	
		return null;
	}
	*/

	public CartaoCredito retornaCartaoCliente(int j, String cpf){
		if(cartoesCredito.get(j).cliente.cpf.equals(cpf)){
			return cartoesCredito.get(j);
		}	
		return null;	
	}
}