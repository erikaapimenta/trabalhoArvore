package trabalhoArvore;

public class ArvoreBanco {
	private No raiz;
	private int quantNos;

	public ArvoreBanco() {
		this.quantNos = 0;
		this.raiz = null;
	}

	public boolean eVazia() {
		return (this.raiz == null);
	}

	public No getRaiz() {
		return this.raiz;
	}

	public int getQuantNos() {
		return this.quantNos;
	}

	public boolean cadastrarCliente(ClienteBanco x) {
		if ((this.pesquisarNome(x)) && (this.pesquisarCPF(x))) {
			return false;//n foi possivel cadastrar o cliente
		} else {
			this.raiz = cadastrarCliente(x, this.raiz);
			this.quantNos++;
			return true;
		}
	}

	public No cadastrarCliente(ClienteBanco x, No no) {
		if (no == null) {
			No novoNo = new No(x);
			return novoNo;
		} else {
			if (x.getNome().compareToIgnoreCase(no.getCliente().getNome()) < 0) { //verificar
				no.setEsq(cadastrarCliente(x, no.getEsq()));
				return no;
			} else {
				no.setDir(cadastrarCliente(x, no.getDir()));
				return no;
			}
		}
	}

	public boolean pesquisarNome(ClienteBanco x) {
		if (pesquisarNome(x, this.raiz) != null) {
			return true;
		} else {
			return false;
		}
	}
	
//colocar uma mensagem no menu
	private No pesquisarNome(ClienteBanco x, No no) {
		if (no != null) {
			if (x.getNome().compareToIgnoreCase(no.getCliente().getNome()) < 0) {//verificar
				no = pesquisarNome(x, no.getEsq());
			} else {
				if (x.getNome().compareToIgnoreCase(no.getCliente().getNome()) > 0) {//verificar
					no = pesquisarNome(x, no.getDir());
				}
			}
		}
		return no;
	}
	
	public boolean pesquisarCPF(ClienteBanco x) {
		if (pesquisarCPF(x, this.raiz) != null) {
			return true;
		} else {
			return false;
		}
	}
	
	private No pesquisarCPF(ClienteBanco x, No no) {
		if (no != null) {
			if (x.getCpf().compareToIgnoreCase(no.getCliente().getCpf()) < 0) {//verificar
				no = pesquisarCPF(x, no.getEsq());
			} else {
				if (x.getCpf().compareToIgnoreCase(no.getCliente().getCpf()) > 0) {//verificar
					no = pesquisarCPF(x, no.getDir());
				}
			}
		}
		return no;
	}
	
	
	public String consultarDadosPessoais(ClienteBanco x) {
		No clienteEncontrado = this.consultarDadosGerais(x, this.raiz);
		if (clienteEncontrado != null) {
			return clienteEncontrado.getCliente().toString() ;
		} else {
			return " ";
		}
	}
	
	
	private No consultarDadosGerais(ClienteBanco x, No no) {
		if (no != null) {
			if (x.getNome().compareToIgnoreCase(no.getCliente().getNome()) < 0) {//verificar
				return pesquisarNome(x, no.getEsq());
			} else {
				if (x.getNome().compareToIgnoreCase(no.getCliente().getNome()) > 0) {//verificar
					return  pesquisarNome(x, no.getDir());
				}
			}
		}
		return no;
	}
	
	
	public String[] listarClientesFeminino() {
		int [] n = new int[1];
		n[0] = 0;
		String[] vet = new String[this.quantNos];
		return (listarClientesFeminino(this.raiz, vet, n));
	}

	private String[] listarClientesFeminino(No no, String[] vet, int[] n) {
		if (no != null) {
			vet = listarClientesFeminino(no.getEsq(), vet, n);
			if(no.getCliente().getSexo() == 'F') {
				vet[n[0]] = no.getCliente().getNome();
				n[0]++;
			}
			vet = listarClientesFeminino(no.getDir(), vet, n);
		}
		return vet;
	}
	

	public boolean remover(ClienteBanco x) {
		if (pesquisarNome(x, this.raiz) != null) {
			this.raiz = remover(x, this.raiz);
			this.quantNos--;
			return true;
		} else {
			return false;
		}
	}

	public No remover(ClienteBanco x, No no) {
		if (x == no.getCliente()) {//verificar
			no.setEsq(remover(x, no.getEsq()));
		} else {
			if (x == no.getCliente()) {//verificar
				no.setDir(remover(x, no.getDir()));
			} else {
				if (no.getDir() == null) {
					return no.getEsq();
				} else {
					if (no.getEsq() == null) {
						return no.getDir();
					} else {
						no.setEsq(arrumar(no, no.getEsq()));
					}
				}
			}
		}
		return no;
	}

	private No arrumar(No arv, No maior) {
		if (maior.getDir() != null) {
			maior.setDir(arrumar(arv, maior.getDir()));
		} else {
			arv.setCliente(maior.getCliente());
			maior = maior.getEsq();
		}
		return maior;
	}

	public int[] CamCentral() {
		int[] n = new int[1];
		n[0] = 0;
		int[] vet = new int[this.quantNos];
		return (CamCentral(this.raiz, vet, n));
	}

	private int[] CamCentral(No no, int[] vet, int[] n) {
		if (no != null) {
			vet = CamCentral(no.getEsq(), vet, n);
			vet[n[0]] = no.getInfo();
			n[0]++;
			vet = CamCentral(no.getDir(), vet, n);
		}
		return vet;
	}

	public int[] CamPreFixado() {
		int[] n = new int[1];
		n[0] = 0;
		int[] vet = new int[this.quantNos];
		return (CamPreFixado(this.raiz, vet, n));
	}

	private int[] CamPreFixado(No no, int[] vet, int[] n) {
		if (no != null) {
			vet[n[0]] = no.getInfo();
			n[0]++;
			vet = CamPreFixado(no.getEsq(), vet, n);
			vet = CamPreFixado(no.getDir(), vet, n);
		}
		return vet;
	}

	public int[] CamPosFixado() {
		int[] n = new int[1];
		n[0] = 0;
		int[] vet = new int[this.quantNos];
		return (CamPosFixado(this.raiz, vet, n));
	}

	private int[] CamPosFixado(No no, int[] vet, int[] n) {
		if (no != null) {
			vet = CamPosFixado(no.getEsq(), vet, n);
			vet = CamPosFixado(no.getDir(), vet, n);
			vet[n[0]] = no.getInfo();
			n[0]++;
		}
		return vet;
	}
}
