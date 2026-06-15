package trabalhoc3;

import java.util.Scanner;

public class MenuArvore {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		ArvoreBanco banco = new ArvoreBanco();

		System.out.println("=====================");
		System.out.println("   SISTEMA DE LOGIN     ");
		System.out.println("=====================");

		boolean acessoLiberado = false;
		ClienteBanco c1 = new ClienteBanco("Gabriela Nascimento", "12345678901", 20, 'F', 1500.00);
		ClienteBanco c2 = new ClienteBanco("Ana Souza", "12345678902", 25, 'F', 3200.50);
		ClienteBanco c3 = new ClienteBanco("Bruno Lima", "12345678903", 30, 'M', 2800.75);
		ClienteBanco c4 = new ClienteBanco("Carlos Mendes", "12345678904", 40, 'M', 5000.00);
		ClienteBanco c5 = new ClienteBanco("Fernanda Rocha", "12345678905", 35, 'F', 4200.00);
		ClienteBanco c6 = new ClienteBanco("Juliana Alves", "12345678906", 28, 'F', 2100.00);
		banco.cadastrarCliente(c1); 
		banco.cadastrarCliente(c2); 
		banco.cadastrarCliente(c3);
		banco.cadastrarCliente(c4); 
		banco.cadastrarCliente(c5); 
		banco.cadastrarCliente(c6);

		while(!acessoLiberado) {
			System.out.println("Informe o número de acesso: ");
			String numeroAcesso = scan.nextLine();

			System.out.println("Informe a senha de acesso: ");
			String senha = scan.nextLine();


			if(numeroAcesso.equals("101010") && senha.equals("admin")){
				acessoLiberado = true;
				System.out.println("Acesso liberado!");
				int opcao = 1;
				while(opcao != 0) {
					System.out.println("\n===========================================");
					System.out.println("           MENU DE GERENCIAMENTO           ");
					System.out.println("===========================================");
					System.out.println(" 1 Cadastrar Cliente");
					System.out.println(" 2 Consultar Dados Pessoais");
					System.out.println(" 3 Listar Clientes do Sexo Feminino em Ordem Alfabética");
					System.out.println(" 4 Consultar Média de Idades dos Clientes");
					System.out.println(" 5 Listar Clientes com o Saldo maior que a média de saldos");
					System.out.println(" 6 Excluir Cliente");
					System.out.println(" 7 Atualizar Dados do Cliente");
					System.out.println(" 0 Sair do Sistema");
					System.out.println("===========================================");
					System.out.print("Escolha uma opção: ");
					opcao = scan.nextInt();
					switch (opcao) {
					case 1:
						System.out.println("\n===========================================");
						System.out.println("           CADASTRO DE CLIENTES          ");
						System.out.println("===========================================");
						System.out.print("Nome completo: ");
						scan.nextLine();
						String nome = scan.nextLine();


						System.out.print("CPF: ");
						String cpf = scan.nextLine();

						while(cpf.length() != 11) {
							System.out.println("O CPF deve ter 11 dígitos!");
							System.out.print("CPF: ");
							cpf = scan.nextLine();	
						}

						System.out.print("Idade: ");
						int idade = scan.nextInt();

						while(idade <= 0) {
							System.out.println("Idade inválida!");
							System.out.print("Idade: ");
							idade = scan.nextInt();
						}

						scan.nextLine();
						System.out.println("Sexo: ");
						char sexo = scan.nextLine().toUpperCase().charAt(0);
						System.out.println("Saldo: ");
						double saldo = scan.nextDouble();

						while(saldo < 0) {
							System.out.println("Saldo negativo! Digite um saldo válido: ");
							saldo = scan.nextDouble();
						}

						ClienteBanco novoCliente = new ClienteBanco(nome,cpf,idade,sexo,saldo);
						boolean cadastrou = banco.cadastrarCliente(novoCliente);
						if(cadastrou) {
							System.out.println("Cliente " + novoCliente.getNome() + " cadastrado");
						}else {
							System.out.println("Erro! Não foi possível cadastrar o cliente.");
						}
						break;
					case 2:
						System.out.println("\n===========================================");
						System.out.println("           CONSULTAR DADOS GERAIS          ");
						System.out.println("===========================================");
						System.out.println("Digite o nome do cliente para busca: ");
						scan.nextLine();
						String nomeBusca = scan.nextLine();
						String dadosClienteBusca = banco.consultarDadosPessoais(nomeBusca);
						if(dadosClienteBusca.isEmpty()) {
							System.out.println("Cliente não encontrado");
						}else {
							System.out.println(dadosClienteBusca);
						}
						break;
					case 3:
						System.out.println("\n===========================================");
						System.out.println("           CLIENTES DO SEXO FEMININO       ");
						System.out.println("===========================================");
						String [] clientesFeminino = new String [banco.getQuantNos()];
						clientesFeminino = banco.listarClientesFeminino(); 
						for(int i = 0; i < clientesFeminino.length;i++) {
							if(clientesFeminino[i] != null) {
								System.out.println(clientesFeminino[i]);
							}
						}

						break;
					case 4:
						System.out.println("\n===========================================");
						System.out.println("      MÉDIA DE IDADES DOS CLIENTES");
						System.out.println("===========================================");
						double mediaIdades = banco.mediaIdades();
						if(mediaIdades != 0) {
							System.out.printf("Média das idades: %.2f anos%n",mediaIdades);
						}else {
							System.out.println("Não foi possível realizar a média das idadas.");
						}
						break;
					case 5:
						System.out.println("\n===========================================");
						System.out.println("      CLIENTES COM SALDO ACIMA DA MÉDIA");
						System.out.println("===========================================");

						double media = banco.mediaSaldos();
						if(media != 0) {
							System.out.printf("Média dos saldos: R$ %.2f%n", media);
							String[]clientesSaldoMaior = banco.saldosMaiorMedia();
							System.out.println("\nClientes com saldo acima da média: ");
							for (int i = 0; i < clientesSaldoMaior.length; i++) {

								if (clientesSaldoMaior[i] != null) {

									System.out.println(clientesSaldoMaior[i]);
								}
							}

						}else {
							System.out.println("Não foi possível calcular a média de saldos");
						}



						break;
					case 6:
						System.out.println("\n===========================================");
						System.out.println("      		EXCLUIR CLIENTES             ");
						System.out.println("===========================================");
						scan.nextLine();
						System.out.print("Digite o nome do cliente para remoção: ");
						String nomeRemocao = scan.nextLine();

						boolean remocao = banco.remover(nomeRemocao);

						if(remocao) {
							System.out.println("Cliente removido!");
						} else {
							System.out.println("Cliente não encontrado.");
						}


						break;

					case 7:
						System.out.println("\n===========================================");
						System.out.println("      		ATUALIZAR DADOS DO CLIENTES             ");
						System.out.println("===========================================");
						scan.nextLine();

						System.out.println("Digite o nome do cliente: ");
						String nomeAtualizado = scan.nextLine();

						System.out.print("Atualize sua idade: ");
						int idadeAtualizada = scan.nextInt();

						while(idadeAtualizada <= 0) {
							System.out.println("Idade inválida!");
							System.out.print("Atualize sua idade: ");
							idadeAtualizada = scan.nextInt();
							scan.nextLine();
						}
						System.out.print("Informe seu sexo: ");
						char novoSexo = scan.nextLine().toUpperCase().charAt(0);

						System.out.print("Novo saldo: ");
						double novoSaldo = scan.nextDouble();

						boolean atualizar = banco.atualizarCliente(nomeAtualizado, idadeAtualizada, novoSexo, novoSaldo);

						if(atualizar) {
							System.out.println("Dados atualizados!");
						}else {
							System.out.println("Cliente não encontrado.");
						}
						break;


					case 0:
						System.out.println("Saindo do sistema... Até logo!");
						break;
					default:
						System.out.println("Opção inválida. Tente novamente.");
					}
				}

				scan.close();
			}else {
				System.out.println("Acesso negado!Credenciais incorretas. Tente novamente \n");
			}

		}


	}
}








