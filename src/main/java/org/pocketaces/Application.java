package org.pocketaces;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author swatish.s
 */

@SpringBootApplication(scanBasePackages = { "org.pocketaces"})
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
        System.out.println("------------------Server started------------------");
    }
}
