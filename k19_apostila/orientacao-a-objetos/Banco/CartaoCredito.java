package Banco;

public class CartaoCredito{
	public int numero;
	public double limite;
	public Cliente cliente;

	public CartaoCredito(int numero, double limite, Cliente cliente){
		this.numero = numero;
		this.limite = limite;
		this.cliente = cliente;
	}
}