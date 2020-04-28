package estruturas;

import grafocidades.Cidade;

public class Pilha {

	private int tamanho;
	private Cidade[] cidades;
	private int topo;

	public Pilha(int tamanho) {
		this.tamanho = tamanho;
		cidades = new Cidade[this.tamanho];
		topo = -1;
	}

	public void empilhar(Cidade cidade) {
		if (!pilhaCheia()) {
			this.cidades[++topo] = cidade;
		} else {
			System.out.println("A pilha j� est� cheia");
		}
	}

	public Cidade desempilhar() {
		if(!pilhaVazia()) {

			return cidades[topo--];
			
		}else{
			System.out.println("A p�lha j� esta vazia");
		}
		}

	public Cidade getTopo() {
		return cidades[topo];
	}

	protected boolean pilhaVazia() {
		return (topo == -1);
	}

	public boolean pilhaCheia() {
		return (topo == tamanho - 1);
	}

}
