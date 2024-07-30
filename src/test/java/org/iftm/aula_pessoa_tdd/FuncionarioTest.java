package org.iftm.aula_pessoa_tdd;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class FuncionarioTest {
    private Funcionario funcionario;

    @BeforeEach
    public void setup() {
        funcionario = new Funcionario();
    }

    @Test
    @DisplayName("Validar construtor com dados válidos")
    public void testarConstrutorValido() {
        assertDoesNotThrow(() -> new Funcionario("Luccas", 40, 100));
    }

    @Test
    @DisplayName("Validar construtor com horas inválidas")
    public void testarConstrutorHorasInvalidas() {
        assertThrows(IllegalArgumentException.class, () -> new Funcionario("Luccas", 50, 100));
    }

    @Test
    @DisplayName("Validar construtor com valor por hora inválido")
    public void testarConstrutorValorHoraInvalido() {
        assertThrows(IllegalArgumentException.class, () -> new Funcionario("Luccas", 40, 500));
    }

    @Test
    @DisplayName("Validar setHorasTrabalhadas com valor válido")
    public void testarSetHorasTrabalhadasValido() {
        assertDoesNotThrow(() -> funcionario.setHorasTrabalhadas(30));
    }

    @Test
    @DisplayName("Validar setHorasTrabalhadas com valor inválido")
    public void testarSetHorasTrabalhadasInvalido() {
        assertThrows(IllegalArgumentException.class, () -> funcionario.setHorasTrabalhadas(50));
    }

    @Test
    @DisplayName("Validar setValorHora com valor válido")
    public void testarSetValorHoraValido() {
        assertDoesNotThrow(() -> funcionario.setValorHora(70));
    }

    @Test
    @DisplayName("Validar setValorHora com valor inválido")
    public void testarSetValorHoraInvalido() {
        assertThrows(IllegalArgumentException.class, () -> funcionario.setValorHora(500));
    }

    @Test
    @DisplayName("Calcular pagamento válido")
    public void testarCalcularPagamento() {
        funcionario = new Funcionario("Luccas", 40, 33);
        assertEquals(1320, funcionario.calcularPagamento());
    }

    @Test
    @DisplayName("Calcular pagamento menor que salário mínimo")
    public void testarCalcularPagamentoMenorQueSalarioMinimo() {
        funcionario = new Funcionario("Luccas", 10, 100);
        assertThrows(IllegalArgumentException.class, () -> funcionario.calcularPagamento());
    }

    @Test
@DisplayName("Validar construtor com nome nulo")
public void testarConstrutorNomeNulo() {
    assertThrows(NullPointerException.class, () -> new Funcionario(null, 40, 100));
}

@Test
@DisplayName("Validar construtor com nome vazio")
public void testarConstrutorNomeVazio() {
    assertThrows(IllegalArgumentException.class, () -> new Funcionario("", 40, 100));
}

@Test
@DisplayName("Validar setHorasTrabalhadas com valor zero")
public void testarSetHorasTrabalhadasZero() {
    assertThrows(IllegalArgumentException.class, () -> funcionario.setHorasTrabalhadas(0));
}

@Test
@DisplayName("Validar setHorasTrabalhadas com valor negativo")
public void testarSetHorasTrabalhadasNegativo() {
    assertThrows(IllegalArgumentException.class, () -> funcionario.setHorasTrabalhadas(-1));
}

@Test
@DisplayName("Validar setValorHora com valor zero")
public void testarSetValorHoraZero() {
    assertThrows(IllegalArgumentException.class, () -> funcionario.setValorHora(0));
}

@Test
@DisplayName("Validar setValorHora com valor negativo")
public void testarSetValorHoraNegativo() {
    assertThrows(IllegalArgumentException.class, () -> funcionario.setValorHora(-1));
}

@Test
@DisplayName("Calcular pagamento com valor exato")
public void testarCalcularPagamentoValorExato() {
    funcionario = new Funcionario("Luccas", 20, 50);
    assertEquals(1000, funcionario.calcularPagamento());
}
}
