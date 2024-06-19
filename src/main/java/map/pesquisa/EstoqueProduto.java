package main.java.map.pesquisa;

import java.util.HashMap;
import java.util.Map;

public class EstoqueProduto {
    //atributos
    private Map<Long, Produto> estoqueProdutoMap;

    public EstoqueProduto() {
        this.estoqueProdutoMap = new HashMap<>();
    }

    public void adicionarProduto(long cod, String nome, int quantidade, double preco){
        estoqueProdutoMap.put(cod, new Produto(nome,preco,quantidade));
    }

    public void exibirProduto(){
        System.out.println(estoqueProdutoMap);
    }

    public double calcularValorTotalEstoque(){
        double valorTotalEstoque = 0D;
        if (!estoqueProdutoMap.isEmpty()){
            for (Produto p: estoqueProdutoMap.values()){
                valorTotalEstoque += p.getQuantidade() * p.getPreco();
            }
        }
        return valorTotalEstoque;
    }

    public Produto obterProdutoMaisCaro(){
        Produto produtoMaisCaro = null;
        double maiorPreco = Double.MIN_VALUE;
        if (!estoqueProdutoMap.isEmpty()){
            for (Produto p: estoqueProdutoMap.values()){
                if (p.getPreco() > maiorPreco){
                    produtoMaisCaro = p;
                }
            }
        }
        return produtoMaisCaro;
    }

    public static void main(String[] args) {
        EstoqueProduto estoqueProduto = new EstoqueProduto();

        estoqueProduto.exibirProduto();

        estoqueProduto.adicionarProduto(1L,"produto A", 10, 5.0);
        estoqueProduto.adicionarProduto(2L,"produto B", 5, 10.0);
        estoqueProduto.adicionarProduto(3L,"produto C", 2, 15.0);
        estoqueProduto.adicionarProduto(4L,"produto D", 4, 25.0);

        estoqueProduto.exibirProduto();
        System.out.println("Valor total do estoque: R$ " + estoqueProduto.calcularValorTotalEstoque());
        System.out.println("Produto mais caro: " + estoqueProduto.obterProdutoMaisCaro());
    }
}
