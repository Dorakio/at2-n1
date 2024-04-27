package sistema_bancario;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Banco {
	private static Banco instance = new Banco();
    private Lock lock = new ReentrantLock();

    public static Banco getInstance() {
        return instance;
    }

    public void transferir(Conta origem, Conta destino, double valor) {
        lock.lock(); //bloqueia a instância lock
        try {
            origem.debitar(valor);
            destino.creditar(valor);
            System.out.println("Transferência de R$" + valor + " realizada de " + origem + " para " + destino);
        } finally {
            lock.unlock(); //desbloqueia a instância lock
        }
    }
}
