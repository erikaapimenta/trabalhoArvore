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
		
		
		while(!acessoLiberado) {
		System.out.println("Informe o número de acesso: ");
		String numeroAcesso = scan.nextLine();
		
		System.out.println("Informe a senha de acesso: ");
		String senha = scan.nextLine();
		
		
		if(numeroAcesso.equals("101010") && senha.equals("admin")){
			acessoLiberado = true;
			System.out.println("Acesso liberado!");
			
			System.out.println("\n===========================================");
            System.out.println("           MENU DE GERENCIAMENTO           ");
            System.out.println("===========================================");
            System.out.println(" 1 Cadastrar Cliente");
            System.out.println(" 2 Consultar Dados Pessoais");
            System.out.println(" 3 Listar Clientes do Sexo Femino em Ordem Alfabética");
            System.out.println(" 4 Consultar Média de Idades dos Clientes");
            System.out.println(" 5 Listar Clientes (Saldo > Média)");
            System.out.println(" 6 Excluir Cliente");
            System.out.println(" 7 Atualizar Dados do Cliente");
			System.out.println(" 8 Quantidade de Clientes Cadastrados");
            System.out.println(" 0 Sair do Sistema");
            System.out.println("===========================================");
            System.out.print("Escolha uma opção: ");
            int opcao = scan.nextInt();
            
            
            while(opcao != 0) {
            switch (opcao) {
            case 1:
            	System.out.println("\n===========================================");
                System.out.println("           CADASTRO DE CLIENTES          ");
                System.out.println("===========================================");
                System.out.print("Nome completo: ");
                String nome = scan.nextLine();
                System.out.print("CPF: ");
                String cpf = scan.nextLine();
                System.out.print("Idade: ");
                int idade = scan.nextInt();
                System.out.println("Sexo: ");
                char sexo = scan.nextLine().toUpperCase().charAt(0);
                System.out.println("Saldo: ");
                double saldo = scan.nextDouble();
                ClienteBanco novoCliente = new ClienteBanco(nome,cpf,idade,sexo,saldo);
                boolean cadastrou = banco.cadastrarCliente(novoCliente);
                if(cadastrou) {
                	System.out.println("Cliente " + novoCliente.getNome() + "cadastrado");
                }else {
                	System.out.println("Erro! Não foi possível cadastrar o cliente.");
                }
                break;
            case 2:
            	System.out.println("\n===========================================");
                System.out.println("           CONSULTAR DADOS GERAIS          ");
                System.out.println("===========================================");
                System.out.print("Digite o nome do cliente para busca: ");
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

            	System.out.printf("Média das idades: %.2f anos%n",
            			banco.mediaIdades());

                break;
            case 5:
               
            case 6:
                
                break;
            case 7:
               
                break;
		    case 8:
                System.out.println("\n===========================================");
                System.out.println("      QUANTIDADE DE CLIENTES");
                System.out.println("===========================================");
                System.out.println("Total de clientes cadastrados: "
                        + banco.getQuantNos());
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





