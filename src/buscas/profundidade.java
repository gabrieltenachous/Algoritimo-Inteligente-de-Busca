package buscas;

import estruturas.Pilha;
import grafocidades.Adjacente;
import grafocidades.Cidade;
import grafocidades.Mapa;

public class profundidade {
	
	private Pilha fronteira;
	private Cidade inicio;
	private Cidade objetivo;
	
	public profundidade(Cidade inicio,Cidade objetivo) {
		this.inicio = inicio;
		this.inicio.setVisitado(true);
		this.objetivo = objetivo;
		
		fronteira = new Pilha(20);
		fronteira.empilhar(inicio);
		
	}
	
	public void buscar() {
		Cidade topo = fronteira.getTopo();
		System.out.println("Topo: "+ topo.getName());
	
		for(Adjacente a:topo.getAdjacentes()) {
			System.out.println("Verificando se já visitado: " + a.getCidade().getName());
			if(!a.getCidade().isVisitado()) {
				a.getCidade().setVisitado(true);
				fronteira.empilhar(a.getCidade());
				buscar();
			}
		}
		System.out.println("Desempilhous: "+fronteira.desempilhar().getName());
	}
	
	//TESTE
	public static void main(String args[]) {
		Mapa mapa = new Mapa();
		
		profundidade p = new profundidade(mapa.getPortoUniao(), mapa.getCuritiba());
		p.buscar();
	}
}
