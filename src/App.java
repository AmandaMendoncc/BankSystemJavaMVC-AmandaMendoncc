import funcionario.FuncionarioView;
import javax.swing.SwingUtilities;

public class App {
    public static void main(String[] args) {
        //new MainMenu().MenuPrincipal();
       SwingUtilities.invokeLater(FuncionarioView::new);
    }
}
