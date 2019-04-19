package sample;

import javafx.concurrent.Task;
import javafx.embed.swing.SwingFXUtils;
import javafx.scene.canvas.GraphicsContext;
import java.awt.*;

import java.awt.image.BufferedImage;
import java.util.Random;

public class MonteCarlo extends Task {
    private int amountOfPoints;
    private GraphicsContext gc;

    public MonteCarlo(GraphicsContext gc, int amountOfPoints) {
        this.amountOfPoints=amountOfPoints;
        this.gc=gc;
    }

    @Override
    protected Object call() throws Exception {
        double k=0;
        double p=16*16;

        BufferedImage bi= new BufferedImage(366, 366, BufferedImage.TYPE_INT_RGB);

        Random random = new Random();
        for(int j=0;j<amountOfPoints;j++) {
            updateProgress(j,amountOfPoints);
            double x = -8 + (16) * random.nextDouble();
            double y = -8 + (16) * random.nextDouble();

            double newX = (x+8)*22;
            double newY = ((y*(-1))+8)*22;

            Equation equation = new Equation();
            if(equation.calc(x, y)){
                k++;
                bi.setRGB((int)newX, (int)newY,Color.yellow.getRGB());
            }
            else{
                bi.setRGB((int)newX, (int)newY,Color.blue.getRGB());
            }

            if(j%1000==0){
                gc.drawImage(SwingFXUtils.toFXImage(bi, null), 0,0 );
            }

            if (Thread.currentThread().isInterrupted()) {
                return null;}
        }

        double result= p*(k/amountOfPoints);
        return result;
    }
}
