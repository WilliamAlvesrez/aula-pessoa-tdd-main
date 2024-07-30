package org.iftm.aula_pessoa_tdd;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class FuncionarioTerceirizadoTest {
    private FuncionarioTerceirizado funcionarioTerceirizado;

    @BeforeEach
    public void setup() {
        funcionarioTerceirizado = new FuncionarioTerceirizado();
    }

    @Test
    @DisplayName("Validar construtor com dados válidos")
    public void testarConstrutorValido() {
        assertDoesNotThrow(() -> new FuncionarioTerceirizado("william", 40, 100, 600));
    }

    @Test
    @DisplayName("Validar construtor com nome nulo")
    public void testarConstrutorNomeNulo() {
        assertThrows(NullPointerException.class, () -> new FuncionarioTerceirizado(null, 40, 100, 300));
    }

    @Test
    @DisplayName("Validar construtor com nome vazio")
    public void testarConstrutorNomeVazio() {
        assertThrows(IllegalArgumentException.class, () -> new FuncionarioTerceirizado("", 40, 100, 300));
    }

    @Test
    @DisplayName("Validar construtor de despesas adicionais inválidos")
    public void testarConstrutorDespesasAdicionaisInvalidas() {
        assertThrows(IllegalArgumentException.class, () -> new FuncionarioTerceirizado("william", 40, 100, -600));
    }

    @Test
    @DisplayName("Validar despesasAdicionais com valor válido")
    public void testarSetDespesasAdicionaisValido() {
        assertDoesNotThrow(() -> funcionarioTerceirizado.setDespesasAdicionais(300));
    }

    @Test
    @DisplayName("Validar despesasAdicionais com valor inválido")
    public void testarSetDespesasAdicionaisInvalido() {
        assertThrows(IllegalArgumentException.class, () -> funcionarioTerceirizado.setDespesasAdicionais(-300));
    }

    @Test
    @DisplayName("Validar construtor com horas trabalhadas zero")
    public void testarConstrutorHorasTrabalhadasZero() {
        assertThrows(IllegalArgumentException.class, () -> new FuncionarioTerceirizado("william", 0, 100, 300));
    }

    @Test
    @DisplayName("Validar construtor com valor por hora zero")
    public void testarConstrutorValorPorHoraZero() {
        assertThrows(IllegalArgumentException.class, () -> new FuncionarioTerceirizado("william", 40, 0, 300));
    }

    @Test
    @DisplayName("Validar construtor com horas trabalhadas negativas")
    public void testarConstrutorHorasTrabalhadasNegativas() {
        assertThrows(IllegalArgumentException.class, () -> new FuncionarioTerceirizado("william", -40, 100, 300));
    }

    @Test
    @DisplayName("Validar construtor com valor por hora negativo")
    public void testarConstrutorValorPorHoraNegativo() {
        assertThrows(IllegalArgumentException.class, () -> new FuncionarioTerceirizado("william", 40, -101, 300));
    }

    @Test
    @DisplayName("Validar pagamento menor que o salário mínimo")
    public void testarCalcularPagamentoMenorSalarioMinimo() {
        funcionarioTerceirizado = new FuncionarioTerceirizado("william", 40, 100, 600);
        assertThrows(IllegalArgumentException.class, () -> funcionarioTerceirizado.calcularPagamento());
    }

    @Test
    @DisplayName("Calcular pagamento corretamente incluindo despesas adicionais")
    public void testarCalcularPagamento() {
    funcionarioTerceirizado = new FuncionarioTerceirizado("william", 40, 100, 300);
    double pagamentoEsperado = (40 * 100) + 300; // Horas trabalhadas * valor por hora + despesas adicionais
    assertEquals(pagamentoEsperado, funcionarioTerceirizado.calcularPagamento());
    }
}
