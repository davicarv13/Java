package Banco;

import java.io.IOException;
import java.io.InputStream;
import java.util.Scanner;

class Main{
	public static void main(String[] args){
		UserInterface ui = new UserInterface();
		Scanner scanner = new Scanner(System.in);
		ArrayListCliente arrayListClientes = new ArrayListCliente();
		ArrayListCartaoCredito arrayListCartoesCredito = new ArrayListCartaoCredito();
		int resp;
		int numero;
		double limite;
		String nome;
		String escape;
		String cpf;
		boolean teste;
		CartaoCredito cartaoCredito;
		PermanenciaCliente permCliente = new PermanenciaCliente();
		PermanenciaCartaoCredito permCartaoCredito = new PermanenciaCartaoCredito();
		do{
			ui.menuPrincipal();
			resp = scanner.nextInt();
			scanner.nextLine();

			switch (resp){
				case 1:
					System.out.println("Informe nome:");
					nome = scanner.nextLine();
					System.out.println("Informe cpf:");
					cpf = scanner.nextLine();
					Cliente cliente = new Cliente(nome, cpf);
					System.out.println(permCliente.insere(cliente, arrayListClientes));
				break;
				case 2:
					System.out.println("Informe o numero:");
					numero = scanner.nextInt();
					scanner.nextLine();
					System.out.println("Informe o limite:");
					limite = scanner.nextDouble();
					scanner.nextLine();
					System.out.println("Informe o cpf do cliente:");
					cpf = scanner.nextLine();
					cliente = permCliente.retorna(cpf, arrayListClientes);
					if(cliente == null){
						System.out.println("Cliente nao encontrado");
					}
					else{
						cartaoCredito = new CartaoCredito(numero, limite, cliente);
						if(permCartaoCredito.insere(cartaoCredito, arrayListCartoesCredito, arrayListClientes) == true){
							System.out.println("Cartao inserido");	
						}
						else{
							System.out.println("Cartao nao inserido. Numero já existente ou CPF de cliente invalido");		
						}
					}
				break;
				case 3:
					if(arrayListClientes.clientes.size() == 0){
						System.out.println("Nenhum cliente cadastrado");
					}
					else{
						for(int i = 0; i < arrayListClientes.clientes.size(); i++){
							System.out.println("-------------");
							cliente = permCliente.retorna(i, arrayListClientes);
							System.out.println("Nome:" + cliente.nome);
							System.out.println("CPF:" + cliente.cpf);
							System.out.println("Cartoes de credito:");
							if(arrayListCartoesCredito.cartoesCredito.size() == 0){
								System.out.println("Nenhum cartao inserido no sistema");
							}
							else{
								teste = false;
								for(int j = 0; j < arrayListCartoesCredito.cartoesCredito.size(); j++){
									cartaoCredito = permCartaoCredito.retorna(arrayListCartoesCredito, cliente.cpf, j);
									if(cartaoCredito != null){
										System.out.println("Numero:"+cartaoCredito.numero);
										System.out.println("Limite:"+cartaoCredito.limite);
										teste = true;
									}
								}
								if(teste == false){
									System.out.println("Cliente nao possui cartoes");
								}
							}
						}
					}
				break;

				case 4:
					if(arrayListCartoesCredito.cartoesCredito.size() != 0){
						for(int i = 0; i < arrayListCartoesCredito.cartoesCredito.size(); i++){
							System.out.println("-------------");
							cartaoCredito = permCartaoCredito.retorna(arrayListCartoesCredito, i);
							System.out.println("Numero:"+cartaoCredito.numero);
							System.out.println("Limite:"+cartaoCredito.limite);
							System.out.println("Nome cliente:"+cartaoCredito.cliente.nome);
							System.out.println("CPF cliente:"+cartaoCredito.cliente.cpf);
						}
					}
					else{
						System.out.println("Nenhum cartao inserido no sistema");
					}
				break;

				case 5:
					System.out.println("Informe o CPF:");
					cpf = scanner.nextLine();
					if(permCliente.apagar(arrayListClientes, arrayListCartoesCredito, cpf) == true){
						System.out.println("Cliente apagado com sucesso");
					}
					else{
						System.out.println("CPF nao cadastrado");	
					}
				break;
			}
		}while(resp != 0);
	}
}