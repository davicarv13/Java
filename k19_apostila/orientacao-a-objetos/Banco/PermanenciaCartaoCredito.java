package Banco;

import java.util.ArrayList;

public class PermanenciaCartaoCredito{
	public boolean insere(CartaoCredito cartaoCredito, ArrayListCartaoCredito arrayListCartaoCredito, ArrayListCliente arrayListCliente){
		int i;
		boolean teste = false;
		for(i = 0; i < arrayListCartaoCredito.cartoesCredito.size(); i++){
			if(cartaoCredito.numero == arrayListCartaoCredito.cartoesCredito.get(i).numero){
				return false;
			}
		}

		for(i = 0; i < arrayListCliente.clientes.size(); i++){
			if(cartaoCredito.cliente.cpf.equals(arrayListCliente.clientes.get(i).cpf)){
				teste = true;
			}
		}
		if(teste == true){
			arrayListCartaoCredito.cartoesCredito.add(cartaoCredito);
			return true;
		}
		else{
			return false;
		}	
	}

	public CartaoCredito retorna(ArrayListCartaoCredito arrayListCartaoCredito, int i){
		return arrayListCartaoCredito.cartoesCredito.get(i);
	}

	public CartaoCredito retorna(ArrayListCartaoCredito arrayListCartaoCredito, String cpf, int i){
		if(arrayListCartaoCredito.cartoesCredito.get(i).cliente.cpf.equals(cpf)){
			return arrayListCartaoCredito.cartoesCredito.get(i);
		}
		return null;
	}
	/*
	public boolean apagar(ArrayListCartaoCredito arrayListCartaoCredito, ){

	}
	*/
 }