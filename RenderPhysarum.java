/*
    The Physarum graphical render
*/

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.image.BufferStrategy;
import java.util.HashMap;
import java.util.Map;

public class RenderPhysarum {
    private Frame frame;
    private Canvas canvas;
    private Image[] images = new Image[6];
    private Map<Point, Integer> imagePositions = new HashMap<>();
    private BufferStrategy bufferStrategy;
    private Integer width;
    private Integer height;

    public RenderPhysarum(Integer width, Integer height) {
        this.width = width;
        this.height = height;
    }

    public void render() {
        frame = new Frame("Environment Rendering");
        frame.setSize(this.width, this.height);
        frame.setBackground(Color.BLUE);
        frame.setLayout(new BorderLayout());

        canvas = new Canvas();
        frame.add(canvas, BorderLayout.CENTER);
        frame.setVisible(true);

        canvas.createBufferStrategy(2);
        bufferStrategy = canvas.getBufferStrategy();

        frame.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent we) {
                System.exit(0);
            }
        });
    }
}
