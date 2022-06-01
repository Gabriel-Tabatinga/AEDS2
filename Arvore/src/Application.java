public class Application {

	public static void main(String[] args) throws Exception {
		String input;
		Series serie;
		Series[] fila = new Series[99];
		
        int u = 0;
		
		ArquivoTextoLeitura bancoDeDados = null;
		try {
			bancoDeDados = new ArquivoTextoLeitura/*("/tmp/data.txt");*/("data.txt");
		} catch (Exception e) {;}
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
			serie.setNumberDuration();
			fila[u] = serie;
			u++;
			input = bancoDeDados.ler();
		}
		bancoDeDados.fecharArquivo();
		MyIO.setCharset("UTF-8");
		
		//CRIACAO ARVORE
		ArvoreBinaria arvore = new ArvoreBinaria();
		
		
		//ENTRADA DA SERIE NA ARVORE
		String entrada = MyIO.readLine();
		while(!entrada.equals("FIM")) {
			
			for(int j =0;j<u;j++) {
		    	if(entrada.equals(fila[j].getName()))
		    		{
		    			arvore.inserir(fila[j]);
		    			j=u;
		    		}
		    }
			
			entrada = MyIO.readLine();
		}
		
		
		//ENTRADA DAS SERIES PARA PESQUISA, RETORNANDO SIM, NAO
		entrada = MyIO.readLine();
		long startTime = System.nanoTime();
		while(!entrada.equals("FIM")) {
			
			if(arvore.pesquisar(entrada) == null) {
				System.out.print("NAO\n");
			}else {
				System.out.print("SIM\n");
			}
			entrada = MyIO.readLine();
		}
		
		
		//FINALIZANDO TEMPO EXECUCAO PESQUISA
		long endTime = System.nanoTime();
		long duration = (endTime-startTime);
		
		
		
		
		
		//SAIDA ARQUIVO .TXT
		ArquivoTextoEscrita saida;

		saida = new ArquivoTextoEscrita("729636_arvoreBinaria.txt");


		saida.escrever("729636" + "\t" + duration + "\t" + arvore.getComparacoes() + "\t" + arvore.getMovimentacoes());
        saida.fecharArquivo();
		
	}

}
