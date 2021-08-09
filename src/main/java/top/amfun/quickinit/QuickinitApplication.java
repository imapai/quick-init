package top.amfun.quickinit;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

@MapperScan({"top.amfun.quickinit.mapper"})
@SpringBootApplication
public class QuickinitApplication {

    public static void main(String[] args) {
        new SpringApplicationBuilder(QuickinitApplication.class).run(args);
    }

}
