Acrescente um atributo na classe CONTA anotado com @VERSION.

@Entity
public class Conta {
@Id
@GeneratedValue
private Long id;
private double saldo;
@Version
private Long versao;
// GETTERS AND SETTERS
}

Apague a tabela Conta através do MySQL Query Browser.
Execute a classe AdicionaConta e verifique a tabela Conta através do MySQL Query Browser.
Execute a classe TestaAcessoConcorrente e observe a exception gerada pelo segundo Entity Manager.
