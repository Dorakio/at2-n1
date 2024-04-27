package sistema_bancario;

public class Cliente extends Thread {
	private Conta conta;
    private Loja[] lojas;

    public Cliente(Conta conta, Loja[] lojas) {
        this.conta = conta;
        this.lojas = lojas;
    }

    public void run() {
        while (conta.getSaldo() > 0) {
            double valorCompra = Math.random() < 0.5 ? 100 : 200; //estabelece 100 e 200 como valores míunimos e máximos
            Loja loja = lojas[(int) (Math.random() * lojas.length)];
            loja.efetuarCompra(conta, valorCompra);
            try {
                Thread.sleep(100); // espera entre compras
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
