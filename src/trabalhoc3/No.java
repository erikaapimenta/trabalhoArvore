package trabalhoc3;

import trabalhoc3.ClienteBanco;

public class No {
	private ClienteBanco cliente; // o tipo de dado pode ser outro qualquer
	private No esq, dir;
	
	public No(ClienteBanco cliente){
		this.cliente = cliente;
		this.esq = null;
		this.dir = null;
	}
	public No getEsq(){
		return this.esq;
	}
	public No getDir(){
		return this.dir;
	}
	public ClienteBanco getCliente(){
		return this.cliente;
	}
	public void setEsq(No no){
		this.esq = no;
	}
	public void setDir(No no){
		this.dir = no;
	}
	public void setCliente(ClienteBanco cliente){
		this.cliente = cliente;
	}
}
