package clienteCorrente;


import java.io.*;
import java.util.List;

public class ClienteCorrenteController {

    // Caminho do arquivo onde os dados dos clientes correntes serão salvos
    private static final String CAMINHO_ARQUIVO = "clientes_corrente.csv";

    // Método para salvar um cliente corrente no arquivo CSV (modo append)
    public static void salvarClienteCorrente(ClienteCorrenteModel clienteCorrente) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(CAMINHO_ARQUIVO, true))) { // 'true' para modo append
            // Se for o primeiro cliente, escreve o cabeçalho
            File arquivo = new File(CAMINHO_ARQUIVO);
            if (arquivo.length() == 0) {
                writer.write("Nome,CPF,Agência,Conta,DDD Telefone,Telefone,Limite,Data Vencimento"); // Cabeçalho
                writer.newLine();
            }

            // Escreve as informações do cliente corrente no arquivo CSV
            writer.write(clienteCorrente.getNome() + "," +
                    clienteCorrente.getCpf() + "," +
                    clienteCorrente.getAgencia() + "," +
                    clienteCorrente.getConta() + "," +
                    clienteCorrente.getDddTelefone() + "," +
                    clienteCorrente.getNumerotelefone() + "," +
                    clienteCorrente.getLimite() + "," +
                    clienteCorrente.getDataVencimento());
            writer.newLine();

            System.out.println("Cliente Corrente salvo com sucesso.");
        } catch (IOException e) {
            System.err.println("Erro ao salvar cliente corrente: " + e.getMessage());
        }
    }

    // Método para carregar e exibir todos os clientes correntes do arquivo CSV
    public static void carregarClientesCorrente() {
        try (BufferedReader reader = new BufferedReader(new FileReader(CAMINHO_ARQUIVO))) {
            String linha;
            while ((linha = reader.readLine()) != null) {
                System.out.println(linha); // Exibe cada linha lida do arquivo
            }
        } catch (IOException e) {
            System.err.println("Erro ao carregar clientes corrente: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        // Exemplo de clientes correntes
        ClienteCorrenteModel cliente1 = new ClienteCorrenteModel("pedro Silva", "123.3434.789-00", "01/11/1980", "001", "3454", "11", "34344-8888",
                "Rua A", "123", "Apto 101", "Centro", "São Paulo", "SP", "01001-000", "senha123", 5000.0, "2025-12-31");

        // Salva o cliente corrente no arquivo
        salvarClienteCorrente(cliente1);

        // Carrega os clientes correntes do arquivo (apenas para demonstração)
        carregarClientesCorrente();
    }
}
