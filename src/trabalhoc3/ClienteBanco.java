package trabalhoc3;

public class ClienteBanco {
	private String nome;
	private String cpf;
	private int idade;
	private char sexo;
	private double saldo;
	
	
	public ClienteBanco(String nome, String cpf, int idade, char sexo, double saldo) {
		this.nome = nome;
		this.cpf = cpf;
		this.idade = idade;
		this.sexo = Character.toUpperCase(sexo);
		this.saldo = saldo;
	}
	
	public String getNome() {
		return nome;
	}


	public String getCpf() {
		return cpf;
	}


	public int getIdade() {
		return idade;
	}


	public void setIdade(int idade) {
		this.idade = idade;
	}


	public char getSexo() {
		return sexo;
	}


	public void setSexo(char sexo) {
		this.sexo = sexo;
	}


	public double getSaldo() {
		return saldo;
	}


	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}
	
	@Override
	public String toString() {
		return "===================================================\n"+
				"Nome:" + nome + "/n" +
				"CPF:" + cpf + "/n" +
				"Idade:" + idade + "/n" +
				"Sexo:" + sexo + "/n" +
				"Saldo: R$ " + String.format("%2.f", saldo) + "/n" +
				"===================================================";
	}
	
	
	
	
	
	

}
