package main.java.list.pesquisa;

import java.util.ArrayList;
import java.util.List;

public class CataloLivros {
    //atributos
    private List<Livro> livroList;

    public CataloLivros() {this.livroList = new ArrayList<>();}

    public void adicionarLivro(String titulo, String autor, int anoPublicacao){
        livroList.add( new Livro(titulo,autor,anoPublicacao));
    }

    public List<Livro> pesquisarPorAutor(String autor){
        List<Livro> livrosPorAutor = new ArrayList<>();
        if (!livroList.isEmpty()) {
            for (Livro l : livroList) {
                if (l.getAutor().equalsIgnoreCase(autor)){
                    livrosPorAutor.add(l);
                }
            }
        }
        return livrosPorAutor;
    }

    public List<Livro> pesquisarPorIntervaloAnos(int anoInicial, int anoFinal){
        List<Livro> livrosPorIntervaloAnos = new ArrayList<>();
        if (!livroList.isEmpty()){
            for (Livro l: livroList){
                if (l.getAnoPublicacao() >= anoInicial
                        && l.getAnoPublicacao() <= anoFinal){
                    livrosPorIntervaloAnos.add(l);
                }
            }
        }
        return livrosPorIntervaloAnos;
    }

    public Livro pesquisarPorTitulo(String titulo){
        Livro livroPorTitulo = null;
        if (!livroList.isEmpty()){
            for (Livro l : livroList) {
                if (l.getTitulo().equalsIgnoreCase(titulo)){
                    livroPorTitulo = l;
                    break;
                }
            }
        }
        return livroPorTitulo;
    }

    public static void main(String[] args) {
        CataloLivros cataloLivros = new CataloLivros();

        cataloLivros.adicionarLivro("Livro 1","autor 1", 2020);
        cataloLivros.adicionarLivro("Livro 1","autor 2", 2021);
        cataloLivros.adicionarLivro("Livro 2","autor 2", 2022);
        cataloLivros.adicionarLivro("Livro 3","autor 3", 2023);
        cataloLivros.adicionarLivro("Livro 4","autor 4", 1994);

        System.out.println(cataloLivros.pesquisarPorAutor("autor 2"));
        System.out.println(cataloLivros.pesquisarPorIntervaloAnos(2020,2021));
        System.out.println(cataloLivros.pesquisarPorTitulo("Livro 1"));
    }
}
