import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.atomic.AtomicInteger;

public class ColorPicker extends JPanel {


    public ColorPicker() {
        this.setSize(800, 1200);
        this.setLayout(null);
        this.setBackground(Color.darkGray);
//        JColorChooser c = new JColorChooser();
//
//        c.setBounds(10, 50, 600, 400);
//        this.add(c);

        AtomicInteger r = new AtomicInteger();
        int g;
        int b;
        ScheduledExecutorService ses = Executors.newScheduledThreadPool(1);
        JPanel p = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);

                for (int i = 0; i < 256; i++) {
                    for (int j = 255; j > 0; j--) {
                        g.setColor(new Color(r.get(), i, j));
                        g.drawRect(i, 255-j , 1,1);
                    }
                }
            }

        };
        p.setBackground(Color.blue);
        p.setBounds(10, 10, 256, 256);
        p.updateUI();
        p.setBorder(new LineBorder(Color.black, 2));
        this.add(p);

        JPanel p2 = new JPanel(){
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                for (int i = 0; i < 256; i++) {
                    g.setColor(new Color(i,0,0));
                    g.drawLine(0, 256-i, 40, 256-i+1);
                }
                g.setColor(Color.white);
                g.fillRect(0, r.get() -2 , 45, 5);
            }

        };
        p2.setBackground(Color.red);
        p2.setBounds(280, 10, 40, 256);
        p2.setBorder(new LineBorder(Color.black, 2));
        this.add(p2);
        JLabel labelRed = new JLabel();
        JSlider s1 = new JSlider();
        s1.setBackground(Color.darkGray);
        s1.setBounds(350, 10, 270, 40);
        s1.setValue(0);
        s1.setMaximum(255);
        s1.addChangeListener((l) -> {
            r.set(s1.getValue());
            labelRed.setText(String.valueOf(r.get()));
            p.updateUI();
            p2.updateUI();
        });
        this.add(s1);


        labelRed.setText(String.valueOf(r.get()));
        labelRed.setBounds(640, 10 , 60, 40);
        labelRed.setForeground(Color.white);
        this.add(labelRed);
        updateUI();

    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

    }
}
