
public class ArvoreBinaria {

	private No raiz;
	private int comparacoes;
	private int movimentacoes;
	/*private String[] passouPesquisa = new String[30];
	private int contador;*/
	
	public ArvoreBinaria() {
		
		raiz = null;
		comparacoes = 0;
		movimentacoes = 0;
		//contador = 0;
	}
	
	public int getMovimentacoes() {
		return movimentacoes;
	}

	public int getComparacoes() {
		return comparacoes;
	}
	
	/*public void printPassouPesquisa() {
		//IMPRIMIR MODELO [The 100] - [Game of Thrones] - [Anne] - [12 Monkeys]
		for(int i=0;i<contador;i++) {
			System.out.print("[" + this.passouPesquisa[i] +"] ");
			if(!(i<contador-1)) {
				System.out.print("- ");
			}
		}
		passouPesquisa = null;
		this.contador = 0;
	}*/

	public Series pesquisar(String chave) {
		return pesquisar(this.raiz, chave);
	}
	
	private Series pesquisar(No raizSubarvore, String chave) {
		String nome;
		if (raizSubarvore == null)
			return null;
		else if (chave.compareTo(raizSubarvore.getItem().getName()) == 0) 
		{
			nome = raizSubarvore.getItem().getName();
			System.out.print("[" + nome +"] - ");
			this.comparacoes++;
			return raizSubarvore.getItem();
		}
		else if (chave.compareTo(raizSubarvore.getItem().getName()) > 0) {
			nome = raizSubarvore.getItem().getName();
			System.out.print("[" + nome +"] - ");
			this.comparacoes++;
			return pesquisar(raizSubarvore.getDireita(), chave);
		}
		else {
			nome = raizSubarvore.getItem().getName();
			System.out.print("[" + nome +"] - ");
			this.comparacoes++;
			return pesquisar(raizSubarvore.getEsquerda(), chave);
		}
	}
	
	public void inserirAVL(Series novo) throws Exception {
		this.raiz = inserirAVL(this.raiz, novo);
	}
	
	private No inserirAVL(No raizSubarvore, Series novo) throws Exception{
		
		if (raizSubarvore == null)
			raizSubarvore = new No(novo);
		else if (novo.getName().compareTo(raizSubarvore.getItem().getName()) == 0)
			throw new Exception("Não foi possível inserir o item na árvore: chave já inseriada anteriormente!");
		else if (novo.getName().compareTo(raizSubarvore.getItem().getName()) < 0) {
			raizSubarvore.setEsquerda(inserirAVL(raizSubarvore.getEsquerda(), novo));
		}
		else {
			raizSubarvore.setDireita(inserirAVL(raizSubarvore.getDireita(), novo));
		}
			
		return balancear(raizSubarvore);
	}
	
	public void inserir(Series novo) throws Exception {
		this.raiz = inserir(this.raiz, novo);
	}
	
	private No inserir(No raizSubarvore, Series novo) throws Exception{
		
		if (raizSubarvore == null)
			raizSubarvore = new No(novo);
		else if (novo.getName().compareTo(raizSubarvore.getItem().getName()) == 0)
			throw new Exception("Não foi possível inserir o item na árvore: chave já inseriada anteriormente!");
		else if (novo.getName().compareTo(raizSubarvore.getItem().getName()) < 0) {
			raizSubarvore.setEsquerda(inserir(raizSubarvore.getEsquerda(), novo));
		}
		else {
			raizSubarvore.setDireita(inserir(raizSubarvore.getDireita(), novo));
		}
			
		return raizSubarvore;
	}
	
	public void remover(String chaveRemover) throws Exception {
		this.raiz = remover(this.raiz, chaveRemover);
	}
	
	private No remover(No raizSubarvore, String chaveRemover) throws Exception {
		
		if (raizSubarvore == null)
			throw new Exception("Não foi possível remover o item da árvore: chave não encontrada!");
		else if (chaveRemover.compareTo(raizSubarvore.getItem().getName()) == 0) {
			if (raizSubarvore.getEsquerda() == null)
				raizSubarvore = raizSubarvore.getDireita();
			else if (raizSubarvore.getDireita() == null)
				raizSubarvore = raizSubarvore.getEsquerda();
			else
				raizSubarvore.setEsquerda(antecessor(raizSubarvore, raizSubarvore.getEsquerda()));
		} else if (chaveRemover.compareTo(raizSubarvore.getItem().getName()) > 0)
			raizSubarvore.setDireita(remover(raizSubarvore.getDireita(), chaveRemover));
		else
			raizSubarvore.setEsquerda(remover(raizSubarvore.getEsquerda(), chaveRemover));
			
		return raizSubarvore;
	}
	
	private No antecessor(No noRetirar, No raizSubarvore) {
		
		if (raizSubarvore.getDireita() != null)
			raizSubarvore.setDireita(antecessor(noRetirar, raizSubarvore.getDireita()));
		else {
			noRetirar.setItem(raizSubarvore.getItem());
			raizSubarvore = raizSubarvore.getEsquerda();
		}	
		
		return raizSubarvore;
	}
	
	public void caminhamentoEmOrdem() {
		caminhamentoEmOrdem(this.raiz);
	}

	private void caminhamentoEmOrdem(No raizSubarvore) {
		
		if (raizSubarvore != null) {
			caminhamentoEmOrdem(raizSubarvore.getEsquerda());
			raizSubarvore.getItem().printClass();
			caminhamentoEmOrdem(raizSubarvore.getDireita());
		}
	}
	
	public int getAltura(){
	      return getAltura(raiz, 0);
	   }


   public int getAltura(No no, int altura){
      if(no == null){
         altura--;
      } else {
         int alturaEsq = getAltura(no.getEsquerda(), altura + 1);
         int alturaDir = getAltura(no.getDireita(), altura + 1);
         altura = (alturaEsq > alturaDir) ? alturaEsq : alturaDir;
      }
      return altura;
   }
   
   public static No balancear(No no) {
        if (no != null) {
            int fator = no.getNivel(no.getDireita()) - no.getNivel(no.getEsquerda());
            if (Math.abs(fator) <= 1) {
                no.setNivel();
            } else if (fator == 2) {
                int fatorFilhoDir = no.getNivel(no.getDireita().getDireita()) - no.getNivel(no.getDireita().getEsquerda());
                if (fatorFilhoDir == -1) {
                    no.setDireita(rotacionarDir(no.getDireita()));
                }
                no = rotacionarEsq(no);
            } else if (fator == -2) {
                int fatorFilhoEsq = no.getNivel(no.getEsquerda().getDireita()) - no.getNivel(no.getEsquerda().getEsquerda());
                if (fatorFilhoEsq == 1) {
                    no.setEsquerda(rotacionarEsq(no.getEsquerda()));
                }
                no = rotacionarDir(no);
            } 
        }
        return no;
    }

    public static No rotacionarDir(No no) {
        No noEsq = no.getEsquerda();
        No noEsqDir = noEsq.getDireita();

        noEsq.setDireita(no);
        no.setEsquerda(noEsqDir);
        no.setNivel(); // Atualizar o nivel do no
        noEsq.setNivel(); // Atualizar o nivel do noEsq

        return noEsq;
    }

    public static No rotacionarEsq(No no) {
        No noDir = no.getDireita();
        No noDirEsq = noDir.getEsquerda();

        noDir.setEsquerda(no);
        no.setDireita(noDirEsq);

        no.setNivel(); // Atualizar o nivel do no
        noDir.setNivel(); // Atualizar o nivel do noDir
        return noDir;
    }  
}

