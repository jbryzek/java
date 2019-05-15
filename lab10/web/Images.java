package lab10_.demo.web;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.opencv.core.Mat;
import org.opencv.core.MatOfByte;
import org.opencv.imgcodecs.Imgcodecs;
import org.opencv.imgproc.Imgproc;

import javax.imageio.ImageIO;
import javax.servlet.ServletInputStream;
import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Images {
    private static Map<Integer, BufferedImage> map = new HashMap<>();
    static int number =0;

    public static String setImage(ServletInputStream inputStream) throws IOException {
        number++;
        BufferedImage bufferedImage = ImageIO.read(inputStream);
        map.put(number, bufferedImage);
        Size size = new Size(bufferedImage.getWidth(),bufferedImage.getHeight());
        Image image = new Image(number,size);
        ObjectMapper objectMapper = new ObjectMapper();
        String jsonString = objectMapper.writeValueAsString(image);
        return jsonString;
    }

    public static Mat bufferedImageToMat(BufferedImage bufferedImage) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        ImageIO.write(bufferedImage, "jpg", byteArrayOutputStream);
        byteArrayOutputStream.flush();
        Mat mat = Imgcodecs.imdecode(new MatOfByte(byteArrayOutputStream.toByteArray()), Imgcodecs.IMWRITE_JPEG_QUALITY);
        return mat;
    }

    public static byte[] getGrayImage(int id) throws IOException{
        if(!map.containsKey(id)){
            throw new Error404();
        }
        BufferedImage bufferedImage = map.get(id);
        for(int i=0;i<bufferedImage.getHeight();i++){
            for(int j=0;j<bufferedImage.getWidth();j++){
                Color c = new Color(bufferedImage.getRGB(j,i));
                int red = (int)(c.getRed()*0.299);
                int green = (int)(c.getGreen()*0.587);
                int blue = (int)(c.getBlue() *0.114);
                Color newColor = new Color(red+green+blue,red+green+blue,red+green+blue);
                bufferedImage.setRGB(j,i,newColor.getRGB());
            }
        }
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        ImageIO.write( bufferedImage, "jpg", baos );
        baos.flush();
        byte[] imageInByte = baos.toByteArray();
        baos.close();
        return imageInByte;
    }

    public static byte[] getGaussImage(int id, int radius) throws IOException {
        if(!map.containsKey(id)){
            throw new Error404();
        }
        BufferedImage bufferedImage = map.get(id);
        //BufferedImage to Mat
        Mat mat = bufferedImageToMat(bufferedImage);
        //GaussianBlur
        Mat destination = new Mat(mat.rows(),mat.cols(),mat.type());
        Imgproc.GaussianBlur(mat,destination,new org.opencv.core.Size(bufferedImage.getWidth()+1,bufferedImage.getHeight()+1),radius);
        //Mat to byte[]
        int length = (int) (mat.total() * mat.elemSize());
        byte buffer[] = new byte[length];
        mat.get(0, 0, buffer);
        System.out.println(buffer);
        return buffer;
    }

    public static void delete(int id) {
        if(!map.containsKey(id)){
            throw new Error404();
        }
        map.remove(id);
        number--;
    }

    public String getSize(int id){
        if(!map.containsKey(id)){
            throw new Error404();
        }
        BufferedImage bufferedImage = map.get(id);
        ObjectMapper objectMapper = new ObjectMapper();
        Size size = new Size(bufferedImage.getWidth(),bufferedImage.getHeight());
        String jsonString = null;
        try {
            jsonString = objectMapper.writeValueAsString(size);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return jsonString;
    }

    public byte[] imageScale(int id, double percent) throws IOException{
        if(!map.containsKey(id)){
            throw new Error404();
        }

        percent/=100;
        BufferedImage bufferedImage = map.get(id);
        //BufferedImage to Mat
        Mat mat = bufferedImageToMat(bufferedImage);
        Mat destination = new Mat(mat.rows(),mat.cols(),mat.type());
        org.opencv.core.Size size = new org.opencv.core.Size(mat.width()*percent,mat.height()*percent);
        Imgproc.resize(mat,destination,size);
        //Mat to byte[]
        ByteArrayOutputStream bao = new ByteArrayOutputStream();
        MatOfByte mob=new MatOfByte();
        Imgcodecs.imencode(".jpg", destination, mob);

        ImageIO.write(ImageIO.read(new ByteArrayInputStream(mob.toArray())), "jpg",bao);
        bao.close();
        return bao.toByteArray();
    }

    public String getHistogram(int id) {
        if(!map.containsKey(id)){
            throw new Error404();
        }
        BufferedImage bufferedImage = map.get(id);
        RGB rgb = new RGB();
        double[] d1 = new double[256];
        double[] d2 = new double[256];
        double[] d3 = new double[256];
        int r=0,g=0,b=0;
        for(int i=0;i<bufferedImage.getHeight();i++){
            for(int j=0;j<bufferedImage.getWidth();j++){
                Color c = new Color(bufferedImage.getRGB(j,i));
                int red = c.getRed();
                int green = c.getGreen();
                int blue = c.getBlue();
                rgb.R[red]++;
                rgb.G[green]++;
                rgb.B[blue]++;
            }
        }
        for(int i=0;i<256;i++){
            r += rgb.R[i];
            d1[i] = (double) r/(bufferedImage.getWidth()*bufferedImage.getHeight());
            g += rgb.G[i];
            d2[i] = (double)g/(bufferedImage.getWidth()*bufferedImage.getHeight());
            b += rgb.B[i];
            d3[i] = (double) b/(bufferedImage.getWidth()*bufferedImage.getHeight());
        }
        double[] lut1 = new double[256];
        double[] lut2 = new double[256];
        double[] lut3 = new double[256];
        for(int i=0;i<256;i++){
            lut1[i] = (d1[i]-d1[0])*(256-1)/(1-d1[0]);
            lut2[i] = (d2[i]-d2[0])*(256-1)/(1-d2[0]);
            lut3[i] = (d3[i]-d3[0])*(256-1)/(1-d3[0]);
        }
        for(int i=0;i<256;i++){
            lut1[i]*=100;
            lut1[i] = Math.round(lut1[i]);
            lut1[i]/=100;
            lut2[i]*=100;
            lut2[i] = Math.round(lut1[i]);
            lut2[i]/=100;
            lut3[i]*=100;
            lut3[i] = Math.round(lut1[i]);
            lut3[i]/=100;
        }
        RGB rgb1 = new RGB(lut1,lut2,lut3);
        ObjectMapper objectMapper = new ObjectMapper();
        String jsonString = null;
        try {
            jsonString = objectMapper.writeValueAsString(rgb1);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return jsonString;
    }

    public byte[] getPartOfImage(int id, int start, int stop, int width, int height) throws IOException {
        if(!map.containsKey(id)){
            throw new Error404();
        }
        BufferedImage bufferedImage = map.get(id);
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        ImageIO.write( bufferedImage.getSubimage(start,stop,width,height), "jpg", baos );
        baos.flush();
        byte[] imageInByte = baos.toByteArray();
        baos.close();
        return imageInByte;
    }
}

