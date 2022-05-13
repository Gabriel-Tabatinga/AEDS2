public class Application {

	public static void main(String[] args) {
		String input;
		Series serie;
		Fila fila = new Fila(40);
		
		Bubblesort bolha;
		/*Heapsort heap;
		Insertion insert;
		Mergesort merge;
		Quicksort quick;
		Selection select;*/
		long startTime = System.nanoTime();
        int comparacoes = 0, movimentacoes = 0	;
        
		
		ArquivoTextoLeitura bancoDeDados;
		bancoDeDados = new ArquivoTextoLeitura("/tmp/data.txt");
		input = bancoDeDados.ler();
		input = bancoDeDados.ler();
		
		while(input != null) {
			
			String[] r = input.split (";");
			serie = new Series();
			if(r[0] != null)
				serie.setName(r[0]);
			if(r[1] != null)
				serie.setFormat(r[1]);
			if(r[2] != null)
				serie.setDuration(r[2]);
			if(r[3] != null)
				serie.setCountry(r[3]);
			if(r[4] != null)
				serie.setLanguage(r[4]);
			if(r[5] != null)
				serie.setBroadcaster(r[5]);
			if(r[6] != null)
				serie.setDateBeggin(r[6]);
			if(r[7] != null)
				serie.setNumberSeasons(Integer.parseInt(r[7]));
			if(r[8] != null)
				serie.setNumberEpisodes(Integer.parseInt(r[8]));
			try {
				fila.enfileirar(serie);
			} catch (Exception e) {;}
			input = bancoDeDados.ler();
		}
		bancoDeDados.fecharArquivo();
		
		String primeiraLinha;
		primeiraLinha = MyIO.readLine();
		String entrada;
		Fila sort = new Fila(Integer.parseInt(primeiraLinha));
		Series aux;
		
		entrada = MyIO.readLine();
		for(int i=0;i<=Integer.parseInt(primeiraLinha);i++) {
			aux  = fila.searchSerie(entrada);
			
			sort.enfileirar(aux);
			
			entrada = MyIO.readLine();
		}

		bolha = new Bubblesort(sort.getFila(), Integer.parseInt(primeiraLinha));
		bolha.sort();
		
		
		long endTime = System.nanoTime();
		long duration = (endTime-startTime);
		bolha.imprimir();
		
		ArquivoTextoEscrita saidaBolha;

		saidaBolha = new ArquivoTextoEscrita("729636_bolha.txt");

		int comp = bolha.getComparar();
		int mov = bolha.getMovimentar();

		saidaBolha.escrever("729636" + "\t" + duration + "\t" + comp + "\t" + mov);
        saidaBolha.fecharArquivo();
        
	}

}
