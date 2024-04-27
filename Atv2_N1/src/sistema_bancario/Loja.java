package sistema_bancario;

public class Loja {
	private Conta conta;
    private Funcionario[] funcionarios;

    public Loja(Conta conta, Funcionario[] funcionarios) {
        this.conta = conta;
        this.funcionarios = funcionarios;
    }

    public void efetuarCompra(Conta contaCliente, double valorCompra) {
        Banco banco = Banco.getInstance();
        banco.transferir(contaCliente, conta, valorCompra);
    }

    public void pagarSalarios() {
        double totalSalarios = funcionarios.length * 1400.0;
        for (Funcionario funcionario : funcionarios) {
            Banco banco = Banco.getInstance();
            banco.transferir(conta, funcionario.getContaSalario(), 1400);
        }
    }
}
