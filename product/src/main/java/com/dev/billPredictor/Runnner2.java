package com.dev.billPredictor; /**
 * Created by dbatwada on 5/17/18.
 */

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScans;

@ComponentScan("com.dev.billPredictor")
@SpringBootApplication
public class Runnner2
{
    public static void main(String[] args) throws Exception
    {
        ApplicationContext applicationContext = SpringApplication.run(Runnner2.class, args);
    }

}
