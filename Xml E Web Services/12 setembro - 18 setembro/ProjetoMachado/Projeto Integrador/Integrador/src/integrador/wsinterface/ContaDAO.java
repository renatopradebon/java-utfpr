/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package integrador.wsinterface;

import integrador.log.Transacao;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Machado
 */
public class ContaDAO {
    
    List<Conta> contas;
    
    public ContaDAO() {
        contas = new ArrayList<Conta>();
        contas.add(new Conta(1, "Alexsandro", 2500));
        contas.add(new Conta(2, "Machado", 1500));
    }

    public List<Conta> getContas() {
        return contas;
    }

    public void setContas(List<Conta> contas) {
        this.contas = contas;
    }

    public double consultarSaldo(long num) {
        for (Conta c : contas) {
                if (c.getNumeroConta() == num) {
                        return c.getSaldo();
                }
        }
        return 0;
    }

    public Conta getConta(long num) {
        for (Conta c : contas) {
                if (c.getNumeroConta() == num) {
                return c;
                }
        }
        return new Conta();
    }

    public Conta criarConta(Conta conta) {
        conta.setNumeroConta(contas.size() + 1);
        contas.add(conta);
        //LOG DE TRANSACAO
        gerarLog(conta, 0, Transacao.CRIAR);
        return conta;
    }

    public String fechar(long num) {
        for (Conta c : contas) {
                if (c.getNumeroConta() == num) {
                    contas.remove(c);
                    //LOG DE TRANSACAO
                    gerarLog(c, 0, Transacao.FECHAR);
                    return "Conta " + num + " encerrada com sucesso!";
                }
        }
        return "conta nao encontrado";
    }

    public String efetuarSaque(long num, double valor) {
        String msg = "conta nao cadastrada!";
        for (Conta c : contas) {
                if (c.getNumeroConta() == num) {
                    c.setSaldo(c.getSaldo() - valor);
                    msg = "valor saque:" + valor;
                    //LOG DE TRANSACAO
                    gerarLog(c, valor,Transacao.SACAR);
                }
        }
        return msg;
    }

    public String efetuarDeposito(long num, double valor) {
        String msg = "conta nao cadastrada!";
        for (Conta c : contas) {
                if (c.getNumeroConta() == num) {
                    c.setSaldo(c.getSaldo() + valor);
                    msg = "Valor deposito:" + valor;

                    //LOG DE TRANSACAO
                    gerarLog(c, valor, Transacao.DEPOSITAR);

                }
        }
        return msg;
    }

    //Gerar Log de transacao
    private void gerarLog(Conta conta, double valor, String operacao) {
            Date data = new Date(System.currentTimeMillis());
            Transacao t = new Transacao();
            t.setData(data.toString());
            t.setDescricao(conta.toString() + " Operacao: " + operacao + "Valor: " + valor);
            t.setNumeroConta(conta.getNumeroConta());
            t.setDescricao(operacao);
            BancarioServiceLog log = new BancarioServiceLog();
            log.addLog(t);
    }
    
}
