package br.inatel.cdg.service;

import org.junit.Test;
import org.junit.Assert;

public class CarrinhoDeComprasTest {

    @Test
    public void givenOneItem_WhenTotalCalcule_ShouldReturnItsPrice(){
        CarrinhoDeCompras carrinho = new CarrinhoDeCompras();
        carrinho.addItem("Produto1", 10.0, 1, "Categoria1");
        Assert.assertEquals(10.0, carrinho.CalculeTotal(), 0.001);
    }

    @Test
    public void givenSeveralItems_WhenCalculeTotal_ShouldReturnSum(){
        CarrinhoDeCompras carrinho = new CarrinhoDeCompras();
        carrinho.addItem("Produto1", 10.0, 1, "Cat1");
        carrinho.addItem("Produto2", 20.0, 2, "Cat2"); // quantidade 2
        carrinho.addItem("Produto3", 5.0, 3, "Cat3");  // quantidade 3
        // Total = 10*1 + 20*2 + 5*3 = 10 + 40 + 15 = 65
        Assert.assertEquals(65.0, carrinho.CalculeTotal(), 0.001);
    }

    @Test
    public void givenZeroPriceItem_WhenAdded_TotalNotChange(){
        CarrinhoDeCompras carrinho = new CarrinhoDeCompras();
        carrinho.addItem("Grátis", 0.0, 1, "CatX");
        Assert.assertEquals(0.0, carrinho.CalculeTotal(), 0.001);
    }

    @Test(expected = IllegalArgumentException.class)
    public void givenNegativePrice_WhenAdd_ShouldThrowException(){
        CarrinhoDeCompras carrinho = new CarrinhoDeCompras();
        carrinho.addItem("ProdutoNegativo", -10.0, 1, "CatX");
    }

    @Test
    public void givenCartWithItems_WhenRemoveOne_TotalUpdates(){
        CarrinhoDeCompras carrinho = new CarrinhoDeCompras();
        carrinho.addItem("P1", 10.0, 1, "Cat1");
        carrinho.addItem("P2", 20.0, 1, "Cat2");
        carrinho.removeItem(0);
        Assert.assertEquals(20.0, carrinho.CalculeTotal(), 0.001);
    }

    @Test
    public void givenInvalidIndex_WhenRemove_DontCrash(){
        CarrinhoDeCompras carrinho = new CarrinhoDeCompras();
        carrinho.addItem("P1", 10.0, 1, "Cat1");
        carrinho.removeItem(5); // índice inválido
        Assert.assertEquals(1, carrinho.quantifyOfItens());
    }

    @Test
    public void givenEmptyCart_WhenCalculeTotal_ReturnZero(){
        CarrinhoDeCompras carrinho = new CarrinhoDeCompras();
        Assert.assertEquals(0.0, carrinho.CalculeTotal(), 0.001);
    }

    @Test
    public void givenCartWithMultipleQuantities_WhenCalculeTotal_ShouldUpdateCorrectly(){
        CarrinhoDeCompras carrinho = new CarrinhoDeCompras();
        carrinho.addItem("P1", 5.0, 2, "Cat1");
        carrinho.addItem("P2", 15.0, 1, "Cat2");
        carrinho.removeItem(1);
        // só resta P1 com quantidade 2 => total = 5*2 = 10
        Assert.assertEquals(10.0, carrinho.CalculeTotal(), 0.001);
    }

    @Test
    public void givenCartWithHighValueItem_ShouldCalculateCorrectly(){
        CarrinhoDeCompras carrinho = new CarrinhoDeCompras();
        carrinho.addItem("SuperProduto", 1_000_000.0, 1, "Luxo");
        Assert.assertEquals(1_000_000.0, carrinho.CalculeTotal(), 0.001);
    }

    @Test
    public void givenDuplicateItems_ShouldSumCorrectly(){
        CarrinhoDeCompras carrinho = new CarrinhoDeCompras();
        carrinho.addItem("ProdutoX", 5.0, 1, "Cat1");
        carrinho.addItem("ProdutoX", 5.0, 2, "Cat1"); // mesma categoria e nome diferente objeto
        // total = 5*1 + 5*2 = 15
        Assert.assertEquals(15.0, carrinho.CalculeTotal(), 0.001);
    }

    @Test
    public void givenCartWithDecimals_ShouldSumCorrectly(){
        CarrinhoDeCompras carrinho = new CarrinhoDeCompras();
        carrinho.addItem("Produto1", 10.55, 1, "Cat1");
        carrinho.addItem("Produto2", 5.45, 1, "Cat2");
        Assert.assertEquals(16.0, carrinho.CalculeTotal(), 0.001);
    }

    @Test
    public void givenCart_WhenApplyDiscount_ShouldCalculateCorrectly(){
        CarrinhoDeCompras carrinho = new CarrinhoDeCompras();
        carrinho.addItem("Produto1", 100.0, 1, "Cat1");
        double discounted = carrinho.applyDiscount(10); // 10% desconto
        Assert.assertEquals(90.0 * 1.1, discounted, 0.001); // calcula total com imposto 10% depois aplica desconto
    }

    @Test
    public void givenCategorySearch_ShouldReturnCorrectItems(){
        CarrinhoDeCompras carrinho = new CarrinhoDeCompras();
        carrinho.addItem("A1", 10.0, 1, "CatA");
        carrinho.addItem("B1", 20.0, 2, "CatB");
        carrinho.addItem("A2", 5.0, 3, "CatA");
        Assert.assertEquals(2, carrinho.searchByCategory("CatA").size());
    }

    @Test
    public void givenNameSearch_ShouldReturnCorrectItem(){
        CarrinhoDeCompras carrinho = new CarrinhoDeCompras();
        carrinho.addItem("ProdutoX", 10.0, 1, "Cat1");
        Assert.assertNotNull(carrinho.searchByName("ProdutoX"));
        Assert.assertNull(carrinho.searchByName("ProdutoY"));
    }

    @Test
    public void givenUpdateQuantity_WhenValidIndex_ShouldChangeSubtotal() {
        CarrinhoDeCompras carrinho = new CarrinhoDeCompras();
        carrinho.addItem("P1", 10.0, 1, "Cat1");
        carrinho.updateQuantity(0, 5);
        Assert.assertEquals(50.0, carrinho.CalculeTotal(), 0.001);
    }

    @Test
    public void givenUpdateQuantity_WhenInvalidIndex_ShouldNotCrash() {
        CarrinhoDeCompras carrinho = new CarrinhoDeCompras();
        carrinho.addItem("P1", 10.0, 1, "Cat1");
        carrinho.updateQuantity(5, 3); // índice inválido
        Assert.assertEquals(10.0, carrinho.CalculeTotal(), 0.001);
    }

    @Test(expected = IllegalArgumentException.class)
    public void givenInvalidDiscount_WhenApply_ShouldThrowException() {
        CarrinhoDeCompras carrinho = new CarrinhoDeCompras();
        carrinho.addItem("P1", 50.0, 1, "Cat1");
        carrinho.applyDiscount(150); // desconto inválido > 100
    }

    @Test
    public void givenCartWithDifferentCategories_WhenSearchByCategory_ShouldBeCaseInsensitive() {
        CarrinhoDeCompras carrinho = new CarrinhoDeCompras();
        carrinho.addItem("A1", 10.0, 1, "catA");
        carrinho.addItem("B1", 20.0, 1, "CATA");
        Assert.assertEquals(2, carrinho.searchByCategory("Cata").size());
    }

    @Test
    public void givenEmptyCart_WhenSearchByName_ShouldReturnNull() {
        CarrinhoDeCompras carrinho = new CarrinhoDeCompras();
        Assert.assertNull(carrinho.searchByName("Inexistente"));
    }

    @Test
    public void givenCartWithZeroValueItems_ShouldNotAffectTotal() {
        CarrinhoDeCompras carrinho = new CarrinhoDeCompras();
        carrinho.addItem("P1", 0.0, 10, "CatZ");
        carrinho.addItem("P2", 5.0, 2, "CatZ");
        Assert.assertEquals(10.0, carrinho.CalculeTotal(), 0.001);
    }

}