package org.iftm.aula_pessoa_tdd;

public class FuncionarioTerceirizado extends Funcionario {
   private double despesasAdicionais;
   private static final double VALOR_MAXIMO_DESPESAS_ADICIONAIS = 1000.00;

   public FuncionarioTerceirizado() {}

public FuncionarioTerceirizado(String nome, int horasTrabalhadas, double valorHora, double despesasAdicionais) {
   super(nome, horasTrabalhadas, valorHora);
   setDespesasAdicionais(despesasAdicionais);
}

   public void setDespesasAdicionais(double despesasAdicionais){
    if (despesasAdicionais < 0 || despesasAdicionais > VALOR_MAXIMO_DESPESAS_ADICIONAIS) {
        throw new IllegalArgumentException("Despesas adicionais inválidas");
    }
    this.despesasAdicionais = despesasAdicionais;
   }

   @Override
   public double calcularPagamento() {
      double pagamento = super.calcularPagamento() + despesasAdicionais;
      double extra = despesasAdicionais * 1.10;
        pagamento += extra;
        if (pagamento < 1320) {
            throw new IllegalArgumentException("Pagamento abaixo do salário mínimo!");
        }
        return pagamento;
    }
   
}
