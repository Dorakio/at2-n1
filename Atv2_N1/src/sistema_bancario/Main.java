package sistema_bancario;

public class Main {
	public static void main(String[] args) {
        Conta[] contasClientes = new Conta[5];
        for (int i = 0; i < contasClientes.length; i++) {
            contasClientes[i] = new Conta(1000);
            new Cliente(contasClientes[i], new Loja[]{new Loja(new Conta(0), new Funcionario[]{new Funcionario(new Conta(0), new Conta(0)), new Funcionario(new Conta(0), new Conta(0))}),
                                                        new Loja(new Conta(0), new Funcionario[]{new Funcionario(new Conta(0), new Conta(0)), new Funcionario(new Conta(0), new Conta(0))})}).start();
        }

        Loja[] lojas = new Loja[]{new Loja(new Conta(0), new Funcionario[]{new Funcionario(new Conta(0), new Conta(0)), new Funcionario(new Conta(0), new Conta(0))}),
                                   new Loja(new Conta(0), new Funcionario[]{new Funcionario(new Conta(0), new Conta(0)), new Funcionario(new Conta(0), new Conta(0))})};

        for (Loja loja : lojas) {
            new Thread(() -> {
                while (true) {
                    loja.pagarSalarios();
                    try {
                        Thread.sleep(1000 * 60 * 60 * 24 * 30); //tempo mensal, caso contrário iria creditar a cada segundo a conta do funcionário
                    } catch (InterruptedException e) { //caso ocorra algum problema irá para o catch
                        e.printStackTrace(); //explica o erro que ocorreu
                    }
                }
            }).start();
        }
    }
}
