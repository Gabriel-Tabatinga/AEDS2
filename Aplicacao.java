
public class Aplicacao {
	public static void dobraVetor(int[] v) {
		for (int i = 0; i < v.length; i++) {
			v[i] *= 2;
		}
	}

	public static void imprimeVetor(int[] v) {
		for (int i = 0; i < v.length; i++) {
			System.out.println("Posicao [" + i + "] --> " + v[i]);
		}
	}

	public static void main(String[] args) {

		int[] vetor;
		int[] vetor2;

		vetor = new int[5];
		for (int i = 0; i < vetor.length; i++) {
			vetor[i] = i * i;
		}
		System.out.println("Conteúdo do vetor após preenchimento: ");
		imprimeVetor(vetor);
		vetor2 = new int[5];
		vetor2 = vetor;

		for (int i = 0; i < vetor.length; i++) {
			vetor2[i] = i * 2;
		}
		System.out.println("\nConteúdo do vetor após mudança pelo vetor2: ");
		imprimeVetor(vetor);
		dobraVetor(vetor);
		System.out.println("\nConteúdo do vetor após dobrar: ");
		imprimeVetor(vetor);
	}

}
