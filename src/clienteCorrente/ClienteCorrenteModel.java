package clienteCorrente;

import cliente.ClienteModel;
import java.time.LocalDate;

public class ClienteCorrenteModel extends ClienteModel {

    private double limite; 
    private LocalDate dataVencimento; 

    public ClienteCorrenteModel(String nome, String cpf, String dataNascimento, String agencia, String conta, Double saldo, String dddTelefone, String numerotelefone, String logradouroEndereco, String numeroEndereco, String complementoEndereco, String bairroEndereco, String cidadeEndereco, String estadoEndereco, String cepEndereco, String senha, double limite, String dataVencimento) {
     

        super(nome, cpf, dataNascimento, agencia, conta, saldo, dddTelefone, numerotelefone, logradouroEndereco,
                numeroEndereco, complementoEndereco, bairroEndereco, cidadeEndereco, estadoEndereco,
                cepEndereco, senha);

        this.limite = limite;
        this.dataVencimento = parseDataVencimento(dataVencimento);
    }

 
    private LocalDate parseDataVencimento(String dataVencimento) {
        return LocalDate.parse(dataVencimento);
    }

  
    public double getLimite() {
        return limite;
    }

    public void setLimite(double limite) {
        this.limite = limite;
    }

    public LocalDate getDataVencimento() {
        return dataVencimento;
    }

    public void setDataVencimento(LocalDate dataVencimento) {
        this.dataVencimento = dataVencimento;
    }
}
