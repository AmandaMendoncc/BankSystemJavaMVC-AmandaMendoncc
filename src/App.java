import javax.swing.SwingUtilities;

import clienteCorrente.ClienteCorrenteView;

public class App {
    public static void main(String[] args) {
        //new MainMenu().MenuPrincipal();
         SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new ClienteCorrenteView();
            }
        });
    }
}
