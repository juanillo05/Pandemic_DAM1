

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

class MapPanel extends JPanel implements CureListener {

    private HashMap<String, JButton> cityButtons;
    private Image worldMap;

    public MapPanel() {
        cityButtons = new HashMap<>();
        // Agregar las coordenadas de las ciudades
        addCity("Yakarta", 1150, 525);
        addCity("El Cairo", 820, 350);
        addCity("Hong Kong", 1165, 370);
        addCity("Tokio", 1280, 290);
        addCity("Mexico DF", 300, 385);
        addCity("Taipei", 1205, 375);
        addCity("Lagos", 710, 450);
        addCity("Manila", 1200, 420);
        addCity("Essen", 755, 190);
        addCity("Pekin", 1175, 300);
        addCity("Washington", 360, 330);
        addCity("Moscu", 890, 230);
        addCity("Argel", 730, 330);
        addCity("Atlanta", 320, 320);
        addCity("Lima", 395, 520);
        addCity("Bombay", 1005, 395);
        addCity("Santiago de Chile", 430, 620);
        addCity("Buenos Aires", 453, 670);
        addCity("Nueva Delhi", 1025, 330);
        addCity("Riad", 895, 385);
        addCity("Teheran", 920, 310);
        addCity("Madras", 1035, 410);
        addCity("Johannesburgo", 815, 630);
        addCity("Jartum", 815, 450);
        addCity("Chicago", 300, 280);
        addCity("Calcuta", 1070, 370);
        addCity("Shanghai", 1195, 355);
        addCity("Londres", 700, 230);
        addCity("Kinsasa", 770, 540);
        addCity("Ho Chi Minh", 1148, 429);
        addCity("Sidney", 1320, 645);
        addCity("Sao Paulo", 520, 570);
        addCity("Bogota", 400, 460);
        addCity("Seul", 1225, 297);
        addCity("Miami", 380, 360);
        addCity("San Francisco", 235, 315);
        addCity("Bangkok", 1120, 415);
        addCity("Karachi", 980, 355);
        addCity("Milan", 755, 235);
        addCity("Nueva York", 380, 290);
        addCity("Madrid", 687, 290);
        addCity("San Petersburgo", 815, 210);
        addCity("Bagdad", 880, 320);
        addCity("Los Angeles", 275, 355);
        addCity("Osaka", 1255, 320);
        addCity("Montreal", 350, 280);
        addCity("Paris", 727, 250);
        addCity("Estambul", 830, 294);

        // Cargar la imagen del mapa del mundo
        worldMap = new ImageIcon("C:\\Users\\alumnat\\Documents\\GitHub\\Pandemic_DAM1\\Pandemic\\mapa_mundo_color.png").getImage();

        setLayout(new BorderLayout());
        setPreferredSize(new Dimension(1366, 768)); // Tamaño de la pantalla estándar

     

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(4, 1)); // 4 filas, 1 columna

        JButton button1 = new JButton("");
        JButton button2 = new JButton("");
        JButton button3 = new JButton("");
        JButton button4 = new JButton("");

        // Establecer el tamaño de los botones
        int buttonWidth = 76; // Ancho deseado
        int buttonHeight = 44; // Alto deseado
        button1.setPreferredSize(new Dimension(buttonWidth, buttonHeight));
        button2.setPreferredSize(new Dimension(buttonWidth, buttonHeight));
        button3.setPreferredSize(new Dimension(buttonWidth, buttonHeight));
        button4.setPreferredSize(new Dimension(buttonWidth, buttonHeight));

        Font buttonFont = button1.getFont().deriveFont(Font.PLAIN, 1); // Tamaño de fuente más pequeño
        button1.setFont(buttonFont);
        button2.setFont(buttonFont);
        button3.setFont(buttonFont);
        button4.setFont(buttonFont);

        // Establecer imágenes para los botones
        button1.setIcon(new ImageIcon("C:\\Users\\alumnat\\Documents\\GitHub\\Pandemic_DAM1\\Pandemic\\vacuna amarilla.png"));
        button2.setIcon(new ImageIcon("C:\\Users\\alumnat\\Documents\\GitHub\\Pandemic_DAM1\\Pandemic\\vacuna roja.png"));
        button3.setIcon(new ImageIcon("C:\\Users\\alumnat\\Documents\\GitHub\\Pandemic_DAM1\\Pandemic\\vacuna azul.png"));
        button4.setIcon(new ImageIcon("C:\\Users\\alumnat\\Documents\\GitHub\\Pandemic_DAM1\\Pandemic\\vacuna negra.png"));

        buttonPanel.add(button1);
        buttonPanel.add(button2);
        buttonPanel.add(button3);
        buttonPanel.add(button4);

        // Agregar el panel de botones al lado derecho del mapa
        add(new JScrollPane(buttonPanel), BorderLayout.EAST);


    }

    private void addCity(String name, int x, int y) {
        int adjustedX = x - 65;
        int adjustedY = y - 39;

        JButton button = new JButton(name);
        button.setBounds(adjustedX - 10, adjustedY - 10, 20, 20);

        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    new CityWindow(name, MapPanel.this); // Pasar una referencia de MapPanel como CureListener
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        });

        add(button);
        cityButtons.put(name, button);

        Random random = new Random();
        double infectionProbability = random.nextDouble();
        Color buttonColor;
        if (infectionProbability < 0.2) {
            buttonColor = Color.YELLOW; // Fase leve
        } else if (infectionProbability < 0.4) {
            buttonColor = Color.RED; // Fase un poco más leve
        } else if (infectionProbability < 0.6) {
            buttonColor = Color.BLUE; // Fase normal
        } else {
            buttonColor = Color.BLACK; // Fase super infectado
        }

        button.setBackground(buttonColor);
        button.setOpaque(true);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(worldMap, 0, 0, getWidth(), getHeight(), this);
    }

    public void onCure(String cityName) {
        JButton button = cityButtons.get(cityName);
        if (button != null) {
            button.setBackground(null); // Eliminar el color del botón
        }
    }
}