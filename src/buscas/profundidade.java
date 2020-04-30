package buscas;

import estruturas.Pilha;
import grafocidades.Adjacente;
import grafocidades.Cidade;
import grafocidades.Mapa;

public class profundidade {

	private Pilha fronteira;
	private Cidade inicio;
	private Cidade objetivo;
	private boolean achou;

	public profundidade(Cidade inicio, Cidade objetivo) {
		this.inicio = inicio;
		this.inicio.setVisitado(true);
		this.objetivo = objetivo;

		fronteira = new Pilha(20);
		fronteira.empilhar(inicio);
		achou = false;
	}

	public void buscar() {
		Cidade topo = fronteira.getTopo();
		System.out.println("Topo: " + topo.getName());

		if (topo == objetivo) {
			achou = true;
		} else {

			for (Adjacente a : topo.getAdjacentes()) {
				if (!achou) {
					System.out.println("Verificando se j� visitado: " + a.getCidade().getName());
					if (!a.getCidade().isVisitado()) {
						a.getCidade().setVisitado(true);
						fronteira.empilhar(a.getCidade());
						buscar();
					}
				}
			}
		}
		System.out.println("Desempilhous: " + fronteira.desempilhar().getName());
	}

	// TESTE
	public static void main(String args[]) {
		Mapa mapa = new Mapa();

		profundidade p = new profundidade(mapa.getPortoUniao(), mapa.getCuritiba());
		p.buscar();
	}
}