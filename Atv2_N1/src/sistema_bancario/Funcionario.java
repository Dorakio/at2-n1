package sistema_bancario;

public class Funcionario extends Thread {
	private Conta contaSalario;
    private Conta contaInvestimento;

    public Funcionario(Conta contaSalario, Conta contaInvestimento) {
        this.contaSalario = contaSalario;
        this.contaInvestimento = contaInvestimento;
    }

    public Conta getContaSalario() {
        return contaSalario;
    }

    public void run() {
        while (true) {
            Banco banco = Banco.getInstance();
            banco.transferir(contaSalario, contaInvestimento, 1400 * 0.2);
            try {
                Thread.sleep(1000 * 60 * 60 * 24 * 30); //investimento mensal, caso contrário ocorreria o mesmo problema da main
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
