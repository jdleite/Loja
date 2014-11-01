import java.util.Scanner;

public class Treino {
	static Scanner e = new Scanner(System.in);

	public static void main(String args[]) {
		int i = 0;
		String[] produto = new String[] { "Notebook", "Computadores",
				"Tablets", "Servidores" };
		double[] meta = new double[4];

		for (i = 0; i < 4; i++) {
			System.out.println("Digite a meta de venda para o produto: "
					+ produto[i]);
			meta[i] = e.nextDouble();

		}

		double[][] vendaP = venda(produto);
		double[] totalPlinha = totLinha(vendaP);
		double[] trimestre = vendaTri(vendaP);
		String[] metas = metaVenda(meta, totalPlinha);
		ranking(totalPlinha, produto);

	}

	public static double[][] venda(String[] produto) {
		double[][] vendas = new double[4][4];

		for (int linha = 0; linha < 4; linha++) {
			for (int coluna = 0; coluna < 4; coluna++) {
				System.out.println("Digite as vendas do produto:"
						+ produto[coluna]);
				vendas[linha][coluna] = e.nextDouble();

			}

		}
		return vendas;

	}

	public static double[] totLinha(double[][] vendaP) {
		double[] total = new double[4];
		for (int linha = 0; linha < 4; linha++) {
			for (int coluna = 0; coluna < 4; coluna++) {
				total[coluna] += vendaP[linha][coluna];
			}
		}

		return total;
	}

	public static double[] vendaTri(double[][] vendaP) {
		double[] vendaTri = new double[4];
		for (int linha = 0; linha < 4; linha++) {
			for (int coluna = 0; coluna < 4; coluna++) {
				vendaTri[coluna] += vendaP[coluna][linha];
			}
		}

		return vendaTri;
	}

	public static String[] metaVenda(double[] meta, double[] totalPlinha) {
		String[] metaProduto = new String[4];
		for (int linha = 0; linha < 4; linha++) {

			if (meta[linha] <= totalPlinha[linha]) {
				metaProduto[linha] = "Atingiu Meta";
			} else {
				metaProduto[linha] = "Não atingiu Meta";
			}

		}

		return metaProduto;

	}

	public static void ranking(double[] totalPlinha, String[] produto) {
		String auxP = null;
		double auxL = 0;
		for (int linha = 0; linha < 4; linha++) {
			for (int compara = 0; compara < 3; compara++) {
				if (totalPlinha[compara] < totalPlinha[compara + 1]) {
					auxL = totalPlinha[compara];
					auxP = produto[compara];

					totalPlinha[compara] = totalPlinha[compara + 1];
					produto[compara] = produto[compara + 1];

					totalPlinha[compara + 1] = auxL;
					produto[compara + 1] = auxP;

				}

			}
		}

		for (int i = 0; i < 4; i++) {

			System.out.println("Ranking" + totalPlinha[i] + "" + produto[i]);

		}
	}
}
