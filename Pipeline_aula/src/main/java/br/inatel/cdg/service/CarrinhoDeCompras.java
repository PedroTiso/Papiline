package br.inatel.cdg.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class CarrinhoDeCompras {

    // Classe interna para representar um item
    public static class Item {
        private String nome;
        private double preco;
        private int quantidade;
        private String categoria;

        public Item(String nome, double preco, int quantidade, String categoria) {
            this.nome = nome;
            this.preco = preco;
            this.quantidade = quantidade;
            this.categoria = categoria;
        }

        public double subtotal() {
            return preco * quantidade;
        }

        @Override
        public String toString() {
            return nome + " (" + categoria + ") - Preço: " + preco +
                    " x " + quantidade + " = " + subtotal();
        }

        // Getters
        public String getNome() { return nome; }
        public double getPreco() { return preco; }
        public int getQuantidade() { return quantidade; }
        public String getCategoria() { return categoria; }

        // Setters
        public void setQuantidade(int quantidade) {
            this.quantidade = quantidade;
        }
    }

    private List<Item> itens = new ArrayList<>();

    // Adicionando um item ao carrinho
    public void addItem(String nome, double preco, int quantidade, String categoria){
        if(preco < 0 || quantidade <= 0){
            throw new IllegalArgumentException("Preço e quantidade devem ser positivos.");
        }
        itens.add(new Item(nome, preco, quantidade, categoria));
    }

    // Removendo item pelo índice
    public void removeItem(int index){
        if(index >= 0 && index < itens.size()){
            itens.remove(index);
        }
    }

    // Atualizar quantidade de um item
    public void updateQuantity(int index, int novaQuantidade){
        if(index >= 0 && index < itens.size() && novaQuantidade > 0){
            itens.get(index).setQuantidade(novaQuantidade);
        }
    }

    // Calcular total do carrinho
    public double CalculeTotal(){
        double total = 0;
        for(Item item : itens){
            total += item.subtotal();
        }
        return total;
    }

    // Aplicar desconto percentual no total (com imposto antes)
    public double applyDiscount(double percentual){
        if(percentual < 0 || percentual > 100){
            throw new IllegalArgumentException("Percentual inválido.");
        }
        double totalComImposto = CalculeTotal() * 1.1; // aplica 10% de imposto
        return totalComImposto * (1 - percentual / 100.0);
    }

    // Retornar quantidade de itens (somando quantidades)
    public int quantifyOfItens(){
        int quantidadeTotal = 0;
        for(Item item : itens){
            quantidadeTotal += item.getQuantidade();
        }
        return quantidadeTotal;
    }

    // Mostrar detalhes do carrinho
    public void showCart(){
        System.out.println("Carrinho de Compras:");
        for(Item item : itens){
            System.out.println(item);
        }
        System.out.println("Total: " + CalculeTotal());
    }

    // Buscar por categoria
    public List<Item> searchByCategory(String categoria) {
        return itens.stream()
                .filter(i -> i.getCategoria().equalsIgnoreCase(categoria))
                .collect(Collectors.toList());
    }

    // Buscar por nome
    public Item searchByName(String nome) {
        return itens.stream()
                .filter(i -> i.getNome().equalsIgnoreCase(nome))
                .findFirst()
                .orElse(null);
    }
}
