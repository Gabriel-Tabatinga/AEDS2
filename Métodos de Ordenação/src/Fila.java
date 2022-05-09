
public class Fila {
	private Series[] fila;
	private int frente;
	private int tras;
	private int tamanho;
	
	public Fila(int tamanho) {
		
		fila = new Series[tamanho];
		frente = 0;
		tras = 0;
		this.tamanho = tamanho;
	}
	
	public boolean filaVazia() {
	
		boolean resp;
		
		if (frente == tras)
			resp = true;
		else
			resp = false;
		
		return resp;
	}
	
	public boolean filaCheia() {
	
		boolean resp;
		
		if (((tras + 1) % tamanho) == (frente % tamanho))
			resp = true;
		else
			resp = false;
		
		return resp;
	}
	
	public void enfileirar(Series novo) throws Exception{
		
		int posicao;
		
		if (! filaCheia()) {
			posicao = tras % tamanho;
			fila[posicao] = novo;
			tras++;
		} else
			throw new Exception("N�o foi poss�vel enfileirar o novo elemento: a fila est� cheia!");
	}
	
	public Series desenfileirar() throws Exception{
		
		Series desenfileirado;
		int posicao;
		
		if (! filaVazia()) {
			posicao = frente % tamanho;
			desenfileirado = fila[posicao];
			frente++;
			return desenfileirado;
		} else
			throw new Exception("N�o foi poss�vel desenfileirar nenhum elemento: a fila est� vazia!");
	}
	
	public void imprimir() throws Exception{
		
		int posicao;
		if (! filaVazia()) {
			System.out.println("Conte�do da fila:");
			for (int i = frente; i < tras; i++) {
				posicao = i % tamanho;
				//System.out.print("Posi��o: " + posicao + ": ");
				fila[posicao].printClass();
			}
		} else
			throw new Exception ("N�o foi poss�vel mostrar o conte�do da fila: a fila est� vazia!");
	}
}

