package estruturas;

import grafocidades.Cidade;
import grafocidades.Mapa;

public class VetorOrdenado {

	private Cidade[] cidades;
	private int numElemento;

	public VetorOrdenado(int tamanho) {
		cidades = new Cidade[tamanho];
		numElemento = 0;
	}

	public Cidade getPrimeiro() {
		return cidades[0];
	}
	public void insercao(Cidade cidade) {
		int posicao;
		for (posicao = 0; posicao < numElemento; posicao++) {
			if (cidades[posicao].getDistanciaObjetivo() > cidade.getDistanciaObjetivo()) {
				break;
			}
		}
		for (int k = numElemento; k > posicao; k--) {
			cidades[k] = cidades[k - 1];

		}
		cidades[posicao] = cidade;
		numElemento++;
	}

	public void mostrar() {
		for (int i = 0; i < numElemento; i++) {
			System.out.println(cidades[i].getNome() + " - " + cidades[i].getDistanciaObjetivo());
		}
	}

	public static void main(String[] args) {
		Mapa mapa = new Mapa();
		VetorOrdenado vetor = new VetorOrdenado(5);
		vetor.insercao(mapa.getPortoUniao());
		vetor.insercao(mapa.getPauloFrontin());
		vetor.insercao(mapa.getBalsaNova());
		vetor.mostrar();
		
	}
}
