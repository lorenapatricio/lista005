
import java.util.ArrayList;

public class Fatura {
    private ArrayList<Item> itens;
    private double valorTotal;

    public Fatura() {
        itens = new ArrayList<>();
        valorTotal = 0;
    }

    public void adicionarItem(Item item) {
        itens.add(item);
        calcularValorTotal();
    }

    public void calcularValorTotal() {
        valorTotal = 0;

        for (int i = 0; i < itens.size(); i++) {
            valorTotal += itens.get(i).getValorTotal();
        }
    }

    public double getValorTotal() {
        return valorTotal;
    }

    public ArrayList<Item> getItens() {
        return itens;
    }

    public void exibirFatura() {
        if (itens.size() == 0) {
            System.out.println("Nenhum produto foi comprado.");
            return;
        }

        System.out.println("\n======= FATURA =======");

        for (int i = 0; i < itens.size(); i++) {
            itens.get(i).exibirItem();
        }

        System.out.printf("VALOR FINAL: R$ %.2f%n",
                valorTotal);

        System.out.println("======================");
    }
}
