//import javax.swing.JFrame;

public class Application {
	

	public static void main(String[] args) {
		String input;
		Series serie;
		Series[] fila = new Series[99];
		
		/*JFrame janela = new JFrame("Series");
		Painel meuPainel = new Painel();
		  
		janela.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
		janela.add(meuPainel);
		janela.setSize(600,400);
		janela.setVisible(true);*/
		
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
		
		
		HashAberto hash = new HashAberto(35);
		
		String entrada = MyIO.readLine();
		while(!entrada.equals("FIM")) {
			
			for(int j =0;j<u;j++) {
		    	if(entrada.equals(fila[j].getName()))
		    		{
			    			try {
								hash.inserir(fila[j]);
							} catch (Exception e) {
						}
		    			j=u;
		    		}
		    }
			
			entrada = MyIO.readLine();
		}
		
		//ENTRADA DAS SERIES PARA PESQUISA, RETORNANDO SIM, NAO
		entrada = MyIO.readLine();
		long startTime = System.nanoTime();//INICIALIZANDO TEMPO EXECUCAO PESQUISA
		
		while(!entrada.equals("FIM")) {
			
			for(int j =0;j<u;j++) {
				Series pesquisa = new Series();
				pesquisa = hash.pesquisar(entrada);
		    	if(pesquisa==null) {
		    		System.out.println("NAO");
		    	}else {
		    		System.out.println(hash.getPosicao() + "SIM");
		    	}
		    }
			entrada = MyIO.readLine();
		}
		//FINALIZANDO TEMPO EXECUCAO PESQUISA
		long endTime = System.nanoTime();
		long duration = (endTime-startTime);
		
		//SAIDA ARQUIVO .TXT
		ArquivoTextoEscrita saida;

		saida = new ArquivoTextoEscrita("729636_hashRehashing.txt");


		saida.escrever("729636" + "\t" + duration + "\t" + hash.getComparacoes());
        saida.fecharArquivo();
		
	}

}
