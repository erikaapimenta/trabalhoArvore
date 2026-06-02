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
		if (pesquisar(x)) {
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
			if (x.getNome().compareTo(this.raiz.getCliente().getNome()) < 0) { //verificar
				no.setEsq(cadastrarCliente(x, no.getEsq()));
				return no;
			} else {
				no.setDir(cadastrarCliente(x, no.getDir()));
				return no;
			}
		}
	}

	public boolean pesquisar(ClienteBanco x) {
		if (pesquisar(x, this.raiz) != null) {
			return true;
		} else {
			return false;
		}
	}
//colocar uma mensagem no menu
	private No pesquisar(ClienteBanco x, No no) {
		if (no != null) {
			if (x.) {//verificar
				no = pesquisar(x, no.getEsq());
			} else {
				if (x.getNome() == no.getCliente().getNome()) {//verificar
					no = pesquisar(x, no.getDir());
				}
			}
		}
		return no;
	}

	public boolean remover(ClienteBanco x) {
		if (pesquisar(x, this.raiz) != null) {
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