package funcionario;


import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class FuncionarioController {

    private static final String ARQUIVO_FUNCIONARIOS = "funcionarios.csv";

    // Método para salvar um funcionário no arquivo CSV
    public void salvarFuncionario(FuncionarioModel funcionario) {
        // Verifica se o arquivo existe, caso não, cria o arquivo e escreve o cabeçalho
        try {
            File file = new File(ARQUIVO_FUNCIONARIOS);

            // Se o arquivo não existe, cria o arquivo e adiciona o cabeçalho
            if (!file.exists()) {
                file.createNewFile();
                escreverCabecalho();
            }

            // Escreve os dados do funcionário no arquivo
            escreverFuncionario(funcionario);
        } catch (IOException e) {
            System.out.println("Erro ao salvar funcionário: " + e.getMessage());
        }
    }

    // Método para escrever o cabeçalho no arquivo CSV
    private void escreverCabecalho() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(ARQUIVO_FUNCIONARIOS, true))) {
            writer.write("codigoFuncionario,cargo,nomeFuncionario,cpfFuncionario,dataNascimento,telefoneContato,enderecoFuncionario,cep,local,numeroCasa,bairro,cidade,estado,senhaFuncionario");
            writer.newLine();
        } catch (IOException e) {
            System.out.println("Erro ao escrever cabeçalho no arquivo: " + e.getMessage());
        }
    }

    // Método para escrever os dados de um funcionário no arquivo CSV
    private void escreverFuncionario(FuncionarioModel funcionario) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(ARQUIVO_FUNCIONARIOS, true))) {
            // Converte os dados do funcionário para o formato CSV
            String linha = funcionario.getCodigoFuncionario() + "," +
                    funcionario.getCargo() + "," +
                    funcionario.getNomeFuncionario() + "," +
                    funcionario.getCpfFuncionario() + "," +
                    funcionario.getDataNascimento() + "," +
                    funcionario.getTelefoneContato() + "," +
                    funcionario.getEnderecoFuncionario() + "," +
                    funcionario.getCep() + "," +
                    funcionario.getLocal() + "," +
                    funcionario.getNumeroCasa() + "," +
                    funcionario.getBairro() + "," +
                    funcionario.getCidade() + "," +
                    funcionario.getEstado() + "," +
                    funcionario.getSenhaFuncionario();
            
            // Escreve a linha no arquivo
            writer.write(linha);
            writer.newLine();
        } catch (IOException e) {
            System.out.println("Erro ao escrever funcionário no arquivo: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        FuncionarioController controller = new FuncionarioController();

        // Exemplo de como criar e salvar um funcionário
        FuncionarioModel funcionario = new FuncionarioModel(
                "001",             // Código do Funcionário
                "Gerente",         // Cargo
                "Carlos Silva",    // Nome do Funcionário
                "123.456.789-00",  // CPF do Funcionário
                "10/12/1980",      // Data de Nascimento
                "11 91234-5678",   // Telefone de Contato
                "Rua das Flores",  // Endereço do Funcionário
                "12345-678",       // CEP
                "Centro",          // Local
                "100",             // Número da Casa
                "Jardim",          // Bairro
                "São Paulo",       // Cidade
                "SP",              // Estado
                "senha123"         // Senha
        );

        // Salva o funcionário no arquivo CSV
        controller.salvarFuncionario(funcionario);
    }
}

