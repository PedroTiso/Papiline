package br.inatel.cdg.service;
import org.junit.Test;
import org.junit.Assert;

public class CarrinhoDeComprasTest {

    // First test that verify the price of one product
    @Test
    public void givenOneItem_WhenTotalCalcule_SoReturnYourPrice(){
        CarrinhoDeCompras carrinho = new CarrinhoDeCompras();
        carrinho.addItem(10.0);
        Assert.assertEquals(10.0, carrinho.CalculeTotal(), 0.001);
    }

    // Second test that when have a lot of values, Calcule the sum off your price
    @Test
    public void givenSeveralItens_WhenCalculeTotal_SoReturnYourAdd(){
        CarrinhoDeCompras carrinho = new CarrinhoDeCompras();
        carrinho.addItem(10.0);
        carrinho.addItem(20.0);
        carrinho.addItem(30.0);
        Assert.assertEquals(60.0, carrinho.CalculeTotal(), 0.001);
    }

    // Third test show the case when the price is zero, and check the total value
    @Test
    public void givenTheZeroPrice_WhenAdd_SoTheTotalNotChange(){
        CarrinhoDeCompras carrinho = new CarrinhoDeCompras();
        carrinho.addItem(0.0);
        Assert.assertEquals(0.0, carrinho.CalculeTotal(), 0.001);
    }

    // Fourth test Given Negative Iten, and when add, so reflete the total valor
    @Test
    public void GiveNegativeIten_WhenAdd_SoReflectedTheVlor(){
        CarrinhoDeCompras carrinho = new CarrinhoDeCompras();
        carrinho.addItem(-10.0);
        Assert.assertEquals(-10.0, carrinho.CalculeTotal(), 0.001);
    }

    // Fifth test Given one car with itens, when remove one value, the total atualize
    @Test
    public void GiveACarWithItens_WhenRemoveValid_SoAtualizeTotal(){
        CarrinhoDeCompras carrinho = new CarrinhoDeCompras();
        carrinho.addItem(10.0);
        carrinho.addItem(20.0);
        carrinho.removeItem(0);
        Assert.assertEquals(20.0, carrinho.CalculeTotal(), 0.001);
    }

    // Sixth test, is happen when given a invalid index, and when remove this, don't crash the system
    @Test
    public void GivenInvalidIndex_WhenRemoveDontCrah(){
        CarrinhoDeCompras carrinho = new CarrinhoDeCompras();
        carrinho.addItem(10.0);
        carrinho.removeItem(5);
        Assert.assertEquals(1, carrinho.quantifyOfItens());
    }

    // Seventh test, is happen when one car is empty, when will calcule the total, return zero
    @Test
    public void GivenEmptyCar_WhenCalculeTotal_ReturnZero(){
        CarrinhoDeCompras carrinho = new CarrinhoDeCompras();
        Assert.assertEquals(0.0, carrinho.CalculeTotal(), 0.001);
    }

    // Eight test, consist in, remove itens, calcule the total and update corretly
    @Test
    public void GivenRemoteItens_WhenCalculeTotal_SoUpdate(){
        CarrinhoDeCompras carrinho = new CarrinhoDeCompras();
        carrinho.addItem(5.0);
        carrinho.addItem(15.0);
        carrinho.removeItem(1);
        Assert.assertEquals(5.0, carrinho.CalculeTotal(), 0.001);
    }

    // Ninth test, happen when you pass one empty car, verify the amount and return zero
    @Test
    public void GivenAEmptyCar_Verify_ReturnZero(){
        CarrinhoDeCompras carrinho = new CarrinhoDeCompras();
        Assert.assertEquals(0, carrinho.quantifyOfItens());
    }

    // Tenth test, happen when you give one add, and check the Amount correctly
    @Test
    public void GivenOneAdd_Check_Correctly_TheAmount(){
        CarrinhoDeCompras carrinho = new CarrinhoDeCompras();
        carrinho.addItem(10.0);
        carrinho.addItem(20.0);
        Assert.assertEquals(2, carrinho.quantifyOfItens());
    }

    // Eleventh test, happen when you remove the last iten and verify the amount
    @Test
    public void RemoveTheLastIten_And_VerifyTheAmount(){
        CarrinhoDeCompras carrinho = new CarrinhoDeCompras();
        carrinho.addItem(10.0);
        carrinho.addItem(20.0);
        carrinho.removeItem(0);
        Assert.assertEquals(1, carrinho.quantifyOfItens());
    }

    // Twelfth test, happen when you remove the last iten, and check the value zero
    @Test
    public void RemoveLastIten_CheckValueZero(){
        CarrinhoDeCompras carrinho = new CarrinhoDeCompras();
        carrinho.addItem(50.0);
        carrinho.removeItem(0);
        Assert.assertEquals(0, carrinho.quantifyOfItens());
    }

    // Thirteenth test, happen when Given One veru high value of one iten, then add in car, calcule correctly
    @Test
    public void GivenOneHighValue_Add_Correctly(){
        CarrinhoDeCompras carrinho = new CarrinhoDeCompras();
        carrinho.addItem(1_000_000.0);
        Assert.assertEquals(1_000_000.0, carrinho.CalculeTotal(), 0.001);
    }

    // Fourteenth Test, happen when given a lot of itens, when add the values, so add correctly
    @Test
    public void GivenTheLastItens_WhenAddValues_AddCorrectly(){
        CarrinhoDeCompras carrinho = new CarrinhoDeCompras();
        for(int i = 0; i < 100; i++) carrinho.addItem(1.0);
        Assert.assertEquals(100.0, carrinho.CalculeTotal(), 0.001);
    }
    
    // Fifteenth test, happen when calcule the total, don't change the amount
    @Test
    public void CalculeTheTotal_DontChangeAmount() {
        CarrinhoDeCompras carrinho = new CarrinhoDeCompras();
        carrinho.addItem(10.0);
        carrinho.CalculeTotal();
        Assert.assertEquals(1, carrinho.quantifyOfItens());
    }
    
    // Sixteenth test, happen when given a negative index, when will remove don't crash the system
    @Test
    public void GivenNegativeIndex_RemoveDontCrash(){
        CarrinhoDeCompras carrinho = new CarrinhoDeCompras();
        carrinho.addItem(10.0);
        carrinho.removeItem(-1);
        Assert.assertEquals(1, carrinho.quantifyOfItens());
    }

    // Seventeenth test, given Index Biggest Than Size, when remove dont crash the system
    @Test
    public void GivenIndexBiggestThanSize_Remove_TheSystemDontCry(){
        CarrinhoDeCompras carrinho = new CarrinhoDeCompras();
        carrinho.addItem(10.0);
        carrinho.removeItem(99);
        Assert.assertEquals(1, carrinho.quantifyOfItens());
    }

    // eighteenth test, given one duplicate iten, when make teh add,m check the correctly sum
    @Test
    public void GivenDuplicateIten_WhenAdd_CheckTheCorrectlyAdd(){
        CarrinhoDeCompras carrinho = new CarrinhoDeCompras();
        carrinho.addItem(5.0);
        carrinho.addItem(5.0);
        Assert.assertEquals(10, carrinho.CalculeTotal(), 0.001);
    }

    // nineteenth test, given Decimals Values When add and chech teh correctly sum
    @Test
    public void DeicimalValues_Add_CorrectlySum(){
        CarrinhoDeCompras carrinho = new CarrinhoDeCompras();
        carrinho.addItem(10.55);
        carrinho.addItem(5.45);
        Assert.assertEquals(16.0, carrinho.CalculeTotal(), 0.001);
    }
    
    // twentieth test, when will add a double negatives values, and check the coorectly Sum
    @Test
    public void GivenTwoNegativesValues_Add_CheckTheCorrectlySum(){
        CarrinhoDeCompras carrinho = new CarrinhoDeCompras();
        carrinho.addItem(-10);
        carrinho.addItem(-30);
        Assert.assertEquals(-40.0, carrinho.CalculeTotal(), 0.001);
    }

}
