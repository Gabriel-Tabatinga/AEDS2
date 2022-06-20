
public class HashAberto {

		private int M;
		private Series tabelaHash[];
		private int comparacoes;
		private int posicao;
		
		public HashAberto(int tamanho) {
			
			this.M = tamanho;
			
			tabelaHash = new Series[this.M];
			for (int i = 0; i < this.M; i++)
				tabelaHash[i] = null;
		}
		
		public int getPosicao() {
			return this.posicao;
		}
		
		public int getComparacoes() {
			return comparacoes;
		}
		
		private int funcaoHash(String chave, int i) {
			int soma=0;
			for (int j = 0; j < chave.length(); j++) {
		           soma += (int)(chave.charAt(j));
		    }

			return (((soma % this.M) + i) % this.M);
		}
		
		public void inserir(Series novo) throws Exception {
			
			int posicao, tentativa;
			boolean inseriu = false;
			
			tentativa = 0;
			
			while ((!inseriu) && (tentativa < this.M)) {
				posicao = funcaoHash(novo.getName(), tentativa);
			
				if (tabelaHash[posicao] == null) {
					tabelaHash[posicao] = novo;
					inseriu = true;
				} else if (tabelaHash[posicao].getName() == novo.getName())
					throw new Exception("Erro ao tentar inserir o novo elemento na tabela hash: o elemento já foi inserido anteriormente!");
				else
					// colisão
					tentativa++;
			}
		}
		
		public Series pesquisar(String chave) {
			
			int posicao, tentativa;
			
			tentativa = 0;
			
			while (tentativa < this.M) {
				posicao = funcaoHash(chave, tentativa);
				this.posicao = posicao;
				if ((tabelaHash[posicao] == null) || (tabelaHash[posicao].getName() == chave))
					return tabelaHash[posicao];
				else
					// colisão
					tentativa++;
			}
			
			return null;
		}
		

	
}
