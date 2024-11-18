package clienteCorrente;


import java.io.*;

public class ClienteCorrenteController {

    // Caminho do arquivo onde os dados dos clientes correntes serão salvos
    private static final String CAMINHO_ARQUIVO = "clientes_corrente.csv";

    // Método para salvar um cliente corrente no arquivo CSV (modo append)
    public static void salvarClienteCorrente(ClienteCorrenteModel clienteCorrente) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(CAMINHO_ARQUIVO, true))) { // 'true' para modo append
            // Se for o primeiro cliente, escreve o cabeçalho
            File arquivo = new File(CAMINHO_ARQUIVO);
            if (arquivo.length() == 0) {
                writer.write("Nome,CPF,Agência,Conta,Saldo,DDD Telefone,Telefone,Limite,Data Vencimento,Estado,Cidade,Bairro,Logradouro,Casa, Complemento,CEP,senha "); // Cabeçalho
                writer.newLine();
            }

            // Escreve as informações do cliente corrente no arquivo CSV
            writer.write(clienteCorrente.getNome() + "," +
                    clienteCorrente.getCpf() + "," +
                    clienteCorrente.getAgencia() + "," +
                    clienteCorrente.getConta() + "," +
                    clienteCorrente.getSaldo() + "," +
                    clienteCorrente.getDddTelefone() + "," +
                    clienteCorrente.getNumerotelefone() + "," +
                    clienteCorrente.getLimite() + "," +
                    clienteCorrente.getDataVencimento() + ',' +
                    clienteCorrente.getEstadoEndereco() + ',' +
                    clienteCorrente.getCidadeEndereco() + ',' +
                    clienteCorrente.getBairroEndereco() + ',' +
                    clienteCorrente.getLogradouroEndereco() + ',' +
                    clienteCorrente.getNumeroEndereco() + ',' +
                    clienteCorrente.getComplementoEndereco() + ',' +
                    clienteCorrente.getCepEndereco() + ',' +
                    clienteCorrente.getSenha() + ',');
                    
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

}
