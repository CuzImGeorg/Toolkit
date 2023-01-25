import javax.swing.*;

public class MainFrame extends JFrame {

    public MainFrame() {
        this.setSize(900, 1200);
        this.setVisible(true);
        this.setResizable(false);
        this.setContentPane(new MainPanel());
    }

}
