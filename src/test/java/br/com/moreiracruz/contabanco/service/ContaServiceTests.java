package br.com.moreiracruz.contabanco.service;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class ContaServiceTests {

    @Test
    public void testContaServiceCreation() {
        ContaService contaService = new ContaService("MARIO ANDRADE", "067-8", 1021, 237.48);

        assertEquals("MARIO ANDRADE", contaService.getCustomerName());
        assertEquals("067-8", contaService.getAgency());
        assertEquals(1021, contaService.getAccountNumber());
        assertEquals(237.48, contaService.getBalance(), 0.001);
    }

    @Test
    public void testDeposit() {
        ContaService contaService = new ContaService("MARIO ANDRADE", "067-8", 1021, 237.48);
        contaService.deposit(1262.52);

        assertEquals(1500.0, contaService.getBalance(), 0.001);
    }

    @Test
    public void testWithdraw() {
        ContaService contaService = new ContaService("MARIO ANDRADE", "067-8", 1021, 237.48);
        contaService.withdraw(100.0);

        assertEquals(137.48, contaService.getBalance(), 0.001);
    }

    @Test
    public void testWithdrawInsufficientFunds() {
        ContaService contaService = new ContaService("MARIO ANDRADE", "067-8", 1021, 237.48);
        contaService.withdraw(300.0);

        assertEquals(237.48, contaService.getBalance(), 0.001); // Balance should not change
    }

    @Test
    public void testCreateWelcomeMessage() {
        ContaService contaService = new ContaService("MARIO ANDRADE", "067-8", 1021, 237.48);

        String expected = "Hello MARIO ANDRADE, thank you for creating an account at our bank, your agency is 067-8, account 1021 and your balance 237,48 is now available for withdrawal.";
        assertEquals(expected, contaService.createWelcomeMessage());
    }

}
