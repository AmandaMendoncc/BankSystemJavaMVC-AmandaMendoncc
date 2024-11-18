package clientePoupanca;
import cliente.ClienteModel;

public class ClientePoupancaModel extends ClienteModel {


    public ClientePoupancaModel(
        String nome, String cpf, String dataNascimento,
        String agencia, String conta, Double saldo,
        String dddTelefone, String numerotelefone,
        String logradouroEndereco, String numeroEndereco,
        String complementoEndereco, String bairroEndereco,
        String cidadeEndereco, String estadoEndereco,
        String cepEndereco, String senha) {


        super(nome, cpf, dataNascimento, agencia, conta, saldo, dddTelefone, numerotelefone, logradouroEndereco,
            numeroEndereco, complementoEndereco, bairroEndereco, cidadeEndereco, estadoEndereco,
            cepEndereco, senha);
    }


}
