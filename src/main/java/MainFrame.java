import javax.swing.*;

public class MainFrame extends JFrame {

    public MainFrame() {
        this.setSize(900, 1200);
        this.setVisible(true);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setContentPane(new MainPanel());
    }

}
