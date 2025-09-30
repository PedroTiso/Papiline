package br.inatel.cdg.service;

import java.util.ArrayList;
import java.util.List;

public class CarrinhoDeCompras {

    // Arraylist de itens.
    private List <Double> itens = new ArrayList<>();

    // Adicionando um item no carrinho
    public void addItem(double preco){
        itens.add(preco);
    }

    // Removendo um item, porem pelo seu indice
    public void removeItem(int index){
        if(index >= 0 && index < itens.size()){
            itens.remove(index);
        }
    }

    // Calculando o total
    public double CalculeTotal(){
        double total = 0;
        for(double preco : itens){
            total = total + preco;
        }
        return total;
    }

    // Retornando a quantidade de Itens
    public int quantifyOfItens(){
        return itens.size();
    }

}
