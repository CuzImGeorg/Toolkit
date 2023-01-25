import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;

public class MainPanel extends JPanel {

    public MainPanel() {
        this.setSize(900, 1200);
        this.setBackground(Color.DARK_GRAY);
        this.setLayout(null);
        JButton colorPicker = new JButton("Color Picker");
        colorPicker.setBackground(Color.gray);
        colorPicker.setBorder(new LineBorder(Color.black,2 ));
        colorPicker.setBounds(0,0,200,60);
        this.add(colorPicker);

        ColorPicker p = new ColorPicker();
        p.setBounds(205, 0,  900, 1200);
        p.setBorder(new LineBorder(Color.black,2));
        this.add(p);
        colorPicker.addActionListener((l) -> {



        });

    }
}
