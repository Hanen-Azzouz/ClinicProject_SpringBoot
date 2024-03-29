package tn.esprit._3cinfogl1.clinicproject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@EnableAspectJAutoProxy
@SpringBootApplication
public class ClinicProjectApplication {

    public static void main(String[] args) {
        SpringApplication.run(ClinicProjectApplication.class, args);
    }

}
