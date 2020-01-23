package Banco;

import java.util.ArrayList;

public class PermanenciaCliente{
	public String insere(Cliente cliente, ArrayListCliente arrayListCliente){
		for(int i = 0; i < arrayListCliente.clientes.size(); i++){
			if(cliente.cpf.equals(arrayListCliente.clientes.get(i).cpf)){
				return "CPF já existe. Cliente nao cadastrado";
			}	
		}
		arrayListCliente.clientes.add(cliente);
		return "Cliente cadastrado com sucesso";	
	}

	public Cliente retorna(String cpf, ArrayListCliente arrayListCliente){
		if(arrayListCliente.clientes.size() != 0){
			for(int i = 0; i < arrayListCliente.clientes.size(); i++){
				if(arrayListCliente.clientes.get(i).cpf.equals(cpf)){
					return arrayListCliente.clientes.get(i);
				}
			}
		}
		return null;	
	}

	public Cliente retorna(int i, ArrayListCliente arrayListCliente){
		return arrayListCliente.clientes.get(i);
	}

	public boolean apagar(ArrayListCliente arrayListCliente, ArrayListCartaoCredito arrayListCartaoCredito, String cpf){
		int i, j;
		boolean teste = false;
		if(arrayListCliente.clientes.size() != 0){
			for(i = 0; i < arrayListCliente.clientes.size(); i++){
				if(cpf.equals(arrayListCliente.clientes.get(i).cpf)){
					arrayListCliente.clientes.remove(i);
					teste = true;
				}
				for(j = 0; j < arrayListCartaoCredito.cartoesCredito.size(); j++){
					if(arrayListCartaoCredito.cartoesCredito.get(j).cliente.cpf.equals(cpf)){
						arrayListCartaoCredito.cartoesCredito.remove(j);
					}
				}
			}
		}
		return teste;
	}
}