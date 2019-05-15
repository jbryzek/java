package lab10_.demo;

import nu.pattern.OpenCV;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoApplication {

    public static void main(String[] args) {
        OpenCV.loadLocally();
        SpringApplication.run(DemoApplication.class, args);
    }

}
