package org.iftm.aula_pessoa_tdd;

public class Funcionario {
    private String nome;
    private int horasTrabalhadas;
    private double valorHora;
    private static final double SALARIO_MINIMO = 1320.00;

    public Funcionario() {
    }

    public Funcionario(String nome, int horasTrabalhadas, double valorHora) {
        this.nome = validaNome(nome);
        setHorasTrabalhadas(horasTrabalhadas);
        setValorHora(valorHora);
    }
    
    private String validaNome(String nome) {
        if (nome.length() < 2 || nome.length() > 100) {
            throw new IllegalArgumentException("Nome inválido");
        }
        return nome;
    }

    public String getNome() {
        return nome;
    }

    public void setHorasTrabalhadas(int horasTrabalhadas) {
        if (horasTrabalhadas < 0 || horasTrabalhadas > 40) {
            throw new IllegalArgumentException("Horas trabalhadas inválidas");
        }
        this.horasTrabalhadas = horasTrabalhadas;
    }

    public void setValorHora(double valorHora) {
           double horaMinimo = SALARIO_MINIMO * 0.04;
           double horaMaxima = SALARIO_MINIMO * 0.10;

           if (valorHora <horaMinimo || valorHora > horaMaxima) {
               throw new IllegalArgumentException("Valor da hora inválido");
           }
           this.valorHora=valorHora;
        }

    public double calcularPagamento() {
        double pagamento = horasTrabalhadas * valorHora;
        if(pagamento < SALARIO_MINIMO){
            throw new IllegalArgumentException("Pagamento menor que o salário mínimo");
        }
        return pagamento;
    }
}


