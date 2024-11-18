package clientePoupanca;

import java.io.*;

public class ClientePoupancaController {

    // Caminho do arquivo onde os dados dos clientes poupança serão salvos
    private static final String CAMINHO_ARQUIVO = "clientes_poupanca.csv";

    // Método para salvar um cliente poupança no arquivo CSV (modo append)
    public static void salvarClientePoupanca(ClientePoupancaModel clientePoupanca) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(CAMINHO_ARQUIVO, true))) { // 'true' para modo append
            // Se for o primeiro cliente, escreve o cabeçalho
            File arquivo = new File(CAMINHO_ARQUIVO);
            if (arquivo.length() == 0) {
                writer.write("Nome,CPF,Agência,Conta,Saldo,DDD Telefone,Telefone,Estado,Cidade,Bairro,Logradouro,Casa,Complemento,CEP,Senha"); // Cabeçalho
                writer.newLine();
            }

            // Escreve as informações do cliente poupança no arquivo CSV
            writer.write(clientePoupanca.getNome() + "," +
                    clientePoupanca.getCpf() + "," +
                    clientePoupanca.getAgencia() + "," +
                    clientePoupanca.getConta() + "," +
                    clientePoupanca.getSaldo() + "," +
                    clientePoupanca.getDddTelefone() + "," +
                    clientePoupanca.getNumerotelefone() + "," +
                    clientePoupanca.getEstadoEndereco() + "," +
                    clientePoupanca.getCidadeEndereco() + "," +
                    clientePoupanca.getBairroEndereco() + "," +
                    clientePoupanca.getLogradouroEndereco() + "," +
                    clientePoupanca.getNumeroEndereco() + "," +
                    clientePoupanca.getComplementoEndereco() + "," +
                    clientePoupanca.getCepEndereco() + "," +
                    clientePoupanca.getSenha());
            writer.newLine();

            System.out.println("Cliente Poupança salvo com sucesso.");
        } catch (IOException e) {
            System.err.println("Erro ao salvar cliente poupança: " + e.getMessage());
        }
    }

    // Método para carregar e exibir todos os clientes poupança do arquivo CSV
    public static void carregarClientesPoupanca() {
        try (BufferedReader reader = new BufferedReader(new FileReader(CAMINHO_ARQUIVO))) {
            String linha;
            while ((linha = reader.readLine()) != null) {
                System.out.println(linha); // Exibe cada linha lida do arquivo
            }
        } catch (IOException e) {
            System.err.println("Erro ao carregar clientes poupança: " + e.getMessage());
        }
    }

}
