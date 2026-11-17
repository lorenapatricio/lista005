
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        ArrayList<Produto> produtos = new ArrayList<>();

        produtos.add(new Produto("Caderno", 1, 25.00));
        produtos.add(new Produto("Caneta", 2, 3.50));
        produtos.add(new Produto("Mochila", 3, 120.00));

        Fatura fatura = new Fatura();

        int opcao;

        do {
            System.out.println("\n===== LOJA DE SUPRIMENTOS =====");
            System.out.println("1 - Comprar");
            System.out.println("2 - Ver Fatura");
            System.out.println("3 - Encerrar Programa");
            System.out.print("Escolha uma opcao: ");

            opcao = entrada.nextInt();

            switch (opcao) {

                case 1:

                    System.out.println("\n===== PRODUTOS DISPONIVEIS =====");

                    for (int i = 0; i < produtos.size(); i++) {
                        produtos.get(i).exibirProduto();
                        System.out.println("-------------------------");
                    }

                    System.out.print("Digite o codigo do produto: ");
                    int codigo = entrada.nextInt();

                    Produto produtoEncontrado = null;

                    for (int i = 0; i < produtos.size(); i++) {

                        if (produtos.get(i).getCodigo() == codigo) {
                            produtoEncontrado = produtos.get(i);
                            break;
                        }
                    }

                    if (produtoEncontrado != null) {

                        System.out.print("Digite a quantidade: ");
                        int quantidade = entrada.nextInt();

                        if (quantidade > 0) {

                            Item item = new Item(
                                produtoEncontrado, quantidade
                            );

                            fatura.adicionarItem(item);

                            System.out.println("Produto adicionado a fatura!");

                        } else {
                            System.out.println("Quantidade invalida!");
                        }

                    } else {
                        System.out.println("Produto nao encontrado!");
                    }

                    break;

                case 2:

                    fatura.exibirFatura();

                    break;

                case 3:

                    System.out.println("Programa encerrado!");

                    break;

                default:

                    System.out.println("Opcao invalida!");

                    break;
            }

        } while (opcao != 3);

        scanner.close();
    }
}
