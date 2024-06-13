package main.java.set.ordenacao;

import java.util.Comparator;
import java.util.Objects;

public class Produto implements Comparable<Produto> {
    //atributos
    private long codigoPproduto;
    private String nome;
    private double preco;
    private int quantidade;

    public Produto(long codigoPproduto, String nome, double preco, int quantidade) {
        this.codigoPproduto = codigoPproduto;
        this.nome = nome;
        this.preco = preco;
        this.quantidade = quantidade;
    }

    @Override
    public int compareTo(Produto p) {
        return nome.compareToIgnoreCase(p.getNome());
    }

    public long getCodigoPproduto() {
        return codigoPproduto;
    }

    public String getNome() {
        return nome;
    }

    public double getPreco() {
        return preco;
    }

    public int getQuantidade() {
        return quantidade;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Produto produto)) return false;
        return getCodigoPproduto() == produto.getCodigoPproduto();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getCodigoPproduto());
    }

    @Override
    public String toString() {
        return "Produto{" +
                "codigoPproduto=" + codigoPproduto +
                ", nome='" + nome + '\'' +
                ", preco=" + preco +
                ", quantidade=" + quantidade +
                '}';
    }
}

class ComparatorPorPreco implements Comparator<Produto>{
    @Override
    public int compare(Produto p1, Produto p2) {
        return Double.compare(p1.getPreco(), p2.getPreco());
    }
}
