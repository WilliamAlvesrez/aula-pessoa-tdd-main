package org.iftm;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.iftm.aula_pessoa_tdd.Pessoa;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class PessoaTest {
    private Pessoa pessoa;

    @BeforeEach
    public void instanciarObjetos() {
        pessoa = new Pessoa();
    }

    // etapa 1 : casos de teste para validar o nome da Pessoa
    @Test
    @DisplayName("Caso de teste que verifica o nome válido e que não esteja nos limites de 2 e 200 caracteres.")
    public void testarConstrutorComNomeMinusculoValidoForaLimite() {
        // Arrange
        String entradaValida = "bruno";
        String resultadoEsperado = "BRUNO";

        // act
        pessoa = new Pessoa(entradaValida);
        String resultadoObtido = pessoa.getNome();

        // assign
        assertEquals(resultadoEsperado, resultadoObtido);
    }

    @Test
    @DisplayName("Caso de teste que verifica o nome válido e que não esteja nos limites de 2 e 200 caracteres.")
    public void testarConstrutorComNomeMaiusculoValidoForaLimite() {
        // Arrange
        String entradaValida = "BRUNO";
        String resultadoEsperado = "BRUNO";

        // act
        pessoa = new Pessoa(entradaValida);
        String resultadoObtido = pessoa.getNome();

        // assign
        assertEquals(resultadoEsperado, resultadoObtido);
    }

    @Test
    @DisplayName("Caso de teste que verifica o nome válido e que não esteja nos limites de 2 e 200 caracteres.")
    public void testarConstrutorComNomeValidoNoLimiteInferior() {
        // Arrange
        String entradaValida = "Ed";
        String resultadoEsperado = "ED";

        // act
        pessoa = new Pessoa(entradaValida);
        String resultadoObtido = pessoa.getNome();

        // assign
        assertEquals(resultadoEsperado, resultadoObtido);
    }

    @Test
    @DisplayName("Caso de teste que verifica o nome válido e que não esteja nos limites de 2 e 200 caracteres.")
    public void testarConstrutorComNomeValidoNoLimiteSuperior() {
        // Arrange
        String entradaValida = "Bruno Queiroz 12345678901234567890123456789012345678901234567890123456789012345678901234567890123456";
        String resultadoEsperado = "BRUNO QUEIROZ 12345678901234567890123456789012345678901234567890123456789012345678901234567890123456";

        // act
        pessoa = new Pessoa(entradaValida);
        String resultadoObtido = pessoa.getNome();

        // assign
        assertEquals(resultadoEsperado, resultadoObtido);
    }

    @Test    
    public void testarConstrutorComNomeiNValidoAbaixoLimiteInferior() {
        // Arrange
        String entradaInvalida = "a";

        //act and assign
        assertThrows(IllegalArgumentException.class,
                () -> {
                    pessoa = new Pessoa(entradaInvalida);
                });
    }

    @Test    
    public void testarConstrutorComNomeiNValidoAcimaLimiteSuperior() {
        // Arrange
        String entradaInvalida = "Bruno Queiroz 12345678901234567890123456789012345678901234567890123456789012345678901234567890123456453";

        //act and assign
        assertThrows(IllegalArgumentException.class,
                () -> {
                    pessoa = new Pessoa(entradaInvalida);
                });
    }

    @Test
    @DisplayName("Caso de teste que verifica o nome válido e que não esteja nos limites de 2 e 200 caracteres.")
    public void testarModificarNomeMinusculoValidoForaLimite() {
        // Arrange
        String entradaValida = "bruno";
        String resultadoEsperado = "BRUNO";

        // act
        pessoa.setNome(entradaValida);
        String resultadoObtido = pessoa.getNome();

        // assign
        assertEquals(resultadoEsperado, resultadoObtido);
    }

    @Test
    @DisplayName("Caso de teste que verifica o nome válido e que não esteja nos limites de 2 e 200 caracteres.")
    public void testarModificarNomeMaiusculoValidoForaLimite() {
        // Arrange
        String entradaValida = "BRUNO";
        String resultadoEsperado = "BRUNO";

        // act
        pessoa.setNome(entradaValida);
        String resultadoObtido = pessoa.getNome();

        // assign
        assertEquals(resultadoEsperado, resultadoObtido);
    }

    @Test
    @DisplayName("Caso de teste que verifica o nome válido e que não esteja nos limites de 2 e 200 caracteres.")
    public void testarModificarNomeValidoNoLimiteInferior() {
        // Arrange
        String entradaValida = "Ed";
        String resultadoEsperado = "ED";

        // act
        pessoa.setNome(entradaValida);
        String resultadoObtido = pessoa.getNome();

        // assign
        assertEquals(resultadoEsperado, resultadoObtido);
    }

    @Test
    @DisplayName("Caso de teste que verifica o nome válido e que não esteja nos limites de 2 e 200 caracteres.")
    public void testarModificarNomeValidoNoLimiteSuperior() {
        // Arrange
        String entradaValida = "Bruno Queiroz 12345678901234567890123456789012345678901234567890123456789012345678901234567890123456";
        String resultadoEsperado = "BRUNO QUEIROZ 12345678901234567890123456789012345678901234567890123456789012345678901234567890123456";

        // act
        pessoa.setNome(entradaValida);
        String resultadoObtido = pessoa.getNome();

        // assign
        assertEquals(resultadoEsperado, resultadoObtido);
    }

    @Test    
    public void testarModificarNomeiNValidoAbaixoLimiteInferior() {
        // Arrange
        String entradaInvalida = "a";

        //act and assign
        assertThrows(IllegalArgumentException.class,
                () -> {
                    pessoa.setNome(entradaInvalida);
                });
    }

    @Test    
    public void testarModificarNomeiNValidoAcimaLimiteSuperior() {
        // Arrange
        String entradaInvalida = "Bruno Queiroz 12345678901234567890123456789012345678901234567890123456789012345678901234567890123456453";

        //act and assign
        assertThrows(IllegalArgumentException.class,
                () -> {
                    pessoa.setNome(entradaInvalida);
                });
    }

    @Test
    @DisplayName("Caso de teste que verifica o salário válido e que tenha o valor do limite inferior, ou seja, 1100.")
    public void testarModificarSalarioNoLimiteInferior() {
        // Arrange
        double entradaValida = 1100.00;
        double resultadoEsperado = 1100.00;

        // act
        pessoa.setSalario(entradaValida);
        double resultadoObtido = pessoa.getSalario();

        // assign
        assertEquals(resultadoEsperado, resultadoObtido);
    }

    @Test
    @DisplayName("Caso de teste que verifica o salário válido e que tenha o valor do limite inferior, ou seja, 1000000.")
    public void testarModificarSalarioNoLimiteSuperior() {
        // Arrange
        double entradaValida = 1000000.00;
        double resultadoEsperado = 1000000.00;

        // act
        pessoa.setSalario(entradaValida);
        double resultadoObtido = pessoa.getSalario();

        // assign
        assertEquals(resultadoEsperado, resultadoObtido);
    }

    @Test    
    @DisplayName("Caso de teste que verifica o salário inválido e que tenha o valor acima do limite superior, ou seja, >1000000.")
    public void testarModificarSalarioiNValidoAcimaLimiteSuperior() {
        // Arrange
        double entradaInvalida = 1000001.00;

        //act and assign
        assertThrows(IllegalArgumentException.class,
                () -> {
                    pessoa.setSalario(entradaInvalida);
                });
    }

    @Test    
    @DisplayName("Caso de teste que verifica o salário inválido e que tenha o valor abaixo do limite inferior, ou seja, <1000.")
    public void testarModificarSalarioiNValidoAbaixoLimiteSuperior() {
        // Arrange
        double entradaInvalida = 1099.00;

        //act and assign
        assertThrows(IllegalArgumentException.class,
                () -> {
                    pessoa.setSalario(entradaInvalida);
                });
    }

    @Test
    @DisplayName("Caso de teste que verifica se o reajuste é valido, com o valor limite inferior 1.")
    public void testarReajusteSalarioValidoNoLimiteInferior() {
        // Arrange
        double entradaValida = 1.00;
        double salarioInicial = 2000.00;
        double resultadoEsperado = 2020.00;

        // act
        pessoa.setSalario(salarioInicial);
        pessoa.reajustarSalario(entradaValida);
        double resultadoObtido = pessoa.getSalario();

        // assign
        assertEquals(resultadoEsperado, resultadoObtido);
    }

    @Test
    @DisplayName("Caso de teste que verifica se o reajuste é valido, com o valor limite inferior 100.")
    public void testarReajusteSalarioValidoNoLimiteSuperior() {
        // Arrange
        double entradaValida = 100.00;
        double salarioInicial = 2000.00;
        double resultadoEsperado = 4000.00;

        // act
        pessoa.setSalario(salarioInicial);
        pessoa.reajustarSalario(entradaValida);
        double resultadoObtido = pessoa.getSalario();

        // assign
        assertEquals(resultadoEsperado, resultadoObtido);
    }

    @Test    
    @DisplayName("Caso de teste que verifica o salário inválido e que tenha o valor abaixo do limite inferior, ou seja, <1000.")
    public void testarReajusteInvalidoSalarioAbaixoLimiteInferior() {
        // Arrange
        double entradaInvalida = 0;
        double salarioInicial = 2000.00;

        //act and assign
        assertDoesNotThrow(() -> {
            pessoa.setSalario(salarioInicial);
        });
        assertThrows(IllegalArgumentException.class,
                () -> {
                    pessoa.reajustarSalario(entradaInvalida);
                });
    }

    @Test    
    @DisplayName("Caso de teste que verifica o salário inválido e que tenha o valor abaixo do limite inferior, ou seja, <1000.")
    public void testarReajusteInvalidoSalarioAcimaLimiteSuperior() {
        // Arrange
        double entradaInvalida = 101;
        double salarioInicial = 2000.00;

        //act and assign
        assertDoesNotThrow(() -> {
            pessoa.setSalario(salarioInicial);
        });
        assertThrows(IllegalArgumentException.class,
                () -> {
                    pessoa.reajustarSalario(entradaInvalida);
                });
    }

    @Test    
    @DisplayName("Caso de teste que verifica o salário inválido após vários reajustes.")
    public void testarReajusteInvalidoSalarioSuperandoLimiteSuperiorDoSalario() {
        // Arrange
        double entradaInvalida = 100;
        double salarioInicial = 200000.00;

        //act and assign
        assertDoesNotThrow(() -> {
            pessoa.setSalario(salarioInicial);
            pessoa.reajustarSalario(entradaInvalida);
            pessoa.reajustarSalario(entradaInvalida);
        });                
        assertThrows(IllegalArgumentException.class,
                () -> {
                    pessoa.reajustarSalario(entradaInvalida);
                });
    }

}
