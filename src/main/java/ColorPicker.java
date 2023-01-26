import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.util.ArrayList;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.atomic.AtomicInteger;

public class ColorPicker extends JPanel {

    private JPanel p;

    public ColorPicker() {
        this.setSize(800, 1200);
        this.setLayout(null);
        this.setBackground(Color.darkGray);
//        JColorChooser c = new JColorChooser();
//
//        c.setBounds(10, 50, 600, 400);
//        this.add(c);

        AtomicInteger r = new AtomicInteger();
        AtomicInteger green = new AtomicInteger();
        AtomicInteger b = new AtomicInteger();
        p = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);

                for (int i = 0; i < 256; i++) {
                    for (int j = 255; j != 0; j--) {
                        g.setColor(new Color(r.get(), i, j));
                        g.drawRect(i+2, 255-j+2 , 1,1);
                    }
                }

                g.setColor(Color.white);
                g.drawLine(0, 255-b.get()+2, 255,  255-b.get()+2);
                g.drawLine(green.get()+2,2, green.get()+2, 258);
                g.setColor(new Color(r.get(), green.get(), b.get()));
                g.fillRect(green.get() +1 , 255-b.get() +1, 3,3);
                g.setColor(Color.white);
                g.drawRect(green.get(), 255-b.get(), 4, 4);
            }

        };
        p.setBackground(Color.blue);
        p.setBounds(10, 10, 260, 260);
        p.updateUI();
        p.setBorder(new LineBorder(Color.black, 2));
        this.add(p);

        JPanel colorRecht = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.setColor(Color.BLACK);
                g.drawRect(10,10, 61, 21);
                g.fillRect(10,35, 61, 21);
                g.setColor(new Color(r.get(), green.get(), b.get()));
                g.fillRect(11,11, 60, 20);
                g.drawString("Text", 15, 45);
            }
        };
        colorRecht.setBackground(Color.gray);
        colorRecht.setBounds(350, 120, 300, 200);
        colorRecht.updateUI();
        colorRecht.setBorder(new LineBorder(Color.black, 2));
        this.add(colorRecht);


        JPanel p2 = new JPanel(){
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                for (int i = 0; i < 256; i++) {
                    g.setColor(new Color(i,0,0));
                    g.drawLine(0, i, 40, i+1);
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
            colorRecht.updateUI();
            p2.updateUI();
        });
        this.add(s1);


        labelRed.setText(String.valueOf(r.get()));
        labelRed.setBounds(640, 10 , 60, 40);
        labelRed.setForeground(Color.white);
        this.add(labelRed);


        JLabel labelGreen = new JLabel();
        JSlider  s2 = new JSlider();
        s2.setBackground(Color.darkGray);
        s2.setBounds(350, 40, 270, 40);
        s2.setValue(0);
        s2.setMaximum(255);
        s2.addChangeListener((l) -> {
            green.set(s2.getValue());
            labelGreen.setText(String.valueOf(green.get()));
            p.updateUI();
            colorRecht.updateUI();
            p2.updateUI();
        });
        this.add(s2);


        labelGreen.setText(String.valueOf(r.get()));
        labelGreen.setBounds(640, 40 , 60, 40);
        labelGreen.setForeground(Color.white);
        this.add(labelGreen);
        updateUI();

        JLabel labelBlue= new JLabel();
        JSlider  s3 = new JSlider();
        s3.setBackground(Color.darkGray);
        s3.setBounds(350, 70, 270, 40);
        s3.setValue(0);
        s3.setMaximum(255);
        s3.addChangeListener((l) -> {
            b.set(s3.getValue());
            labelBlue.setText(String.valueOf(b.get()));
            p.updateUI();
            colorRecht.updateUI();
            p2.updateUI();
        });
        this.add(s3);


        labelBlue.setText(String.valueOf(b.get()));
        labelBlue.setBounds(640, 70 , 60, 40);
        labelBlue.setForeground(Color.white);
        this.add(labelBlue);
        updateUI();

    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

    }
}
