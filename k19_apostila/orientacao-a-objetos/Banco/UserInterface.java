package Banco;

public class UserInterface{
	public void sair(){
		System.out.println("0 - Sair");
	}

	public void menuPrincipal(){	
		System.out.println("1 - Cadastrar cliente");
		System.out.println("2 - Cadastrar cartao");	
		System.out.println("3 - Retorna clientes");	
		System.out.println("4 - Retorna cartoes de credito");	
		System.out.println("5 - Apagar cliente");	
		sair();
	}

	public void menuCadastroCliente(){
		System.out.println("Informe nome:");

	}
	public void menuCadastroCartaoCredito(){
		System.out.println("1 - Cadastrar cartao");	
		sair();
	}

}