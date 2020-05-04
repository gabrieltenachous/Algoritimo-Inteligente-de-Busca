package estruturas;

import grafocidades.Adjacente;
import grafocidades.Cidade;

public class VetorOrdenadoAdjacente {

	private Adjacente[] adjacentes;
	private int numElemento;

	public VetorOrdenadoAdjacente(int tamanho) {
		adjacentes = new Adjacente[tamanho];
		numElemento = 0;
	}

	public Cidade getPrimeiro() {
		return adjacentes[0].getCidade();
	}
	public void insercao(Adjacente adjacente) {
		int posicao;
		for (posicao = 0; posicao < numElemento; posicao++) {
			if (adjacentes[posicao].getDistanciaAEstrela() > adjacente.getDistanciaAEstrela()	) {
				break;
			}
		}
		for (int k = numElemento; k > posicao; k--) {
			adjacentes[k] = adjacentes[k - 1];

		}
		adjacentes[posicao] = adjacente;
		numElemento++;
	}

	public void mostrar() {
		for (int i = 0; i < numElemento; i++) {
			System.out.println(adjacentes[i].getCidade().getNome() + " - " + adjacentes[i].getDistanciaAEstrela());
		}
	}

	 
}
