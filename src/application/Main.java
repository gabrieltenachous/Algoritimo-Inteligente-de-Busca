package application;

import estruturas.Pilha;
import grafocidades.Mapa;

public class Main {

	public static void main(String[] args) {
		Pilha pilha = new Pilha(5);
		Mapa mapa = new Mapa();

		pilha.empilhar(mapa.getPortoUniao());
		pilha.empilhar(mapa.getCampoLargo());
		pilha.empilhar(mapa.getCanoinhas());
		
		System.out.println(pilha.getTopo().getName());
		
		pilha.desempilhar();
		
		System.out.println(pilha.getTopo().getName());
		
	}

}
