package buscas;

import estruturas.VetorOrdenado;
import grafocidades.Adjacente;
import grafocidades.Cidade;
import grafocidades.Mapa;

public class Gulosa {
	private VetorOrdenado fronteira;
	private Cidade objetivo;
	private boolean achou;

	public Gulosa(Cidade objetivo) {
		this.objetivo = objetivo;
		achou = false;
	}

	public void buscar(Cidade atual) {
		System.out.println("\n Atual: " + atual.getNome());
		atual.setVisitado(true);

		if (atual == objetivo) {
			achou = true;
		} else {
			fronteira = new VetorOrdenado(atual.getAdjacentes().size());
			for (Adjacente a : atual.getAdjacentes()) {
				if (!a.getCidade().isVisitado()) {
					a.getCidade().setVisitado(true);
					fronteira.insercao(a.getCidade());
				}
			}
			fronteira.mostrar();
			if (fronteira.getPrimeiro() != null) {

				buscar(fronteira.getPrimeiro());
			}
		}
	}
	public static void main(String []args) {
		Mapa mapa= new Mapa();
		Gulosa g = new Gulosa(mapa.getCuritiba());
		g.buscar(mapa.getPortoUniao());
	}
	
}
