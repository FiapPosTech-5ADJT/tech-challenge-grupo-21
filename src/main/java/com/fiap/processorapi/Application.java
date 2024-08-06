package com.fiap.processorapi;

import com.fiap.processorapi.application.dto.RegistroDTO;
import com.fiap.processorapi.application.services.RegistroService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
public class Application {

  public static void main(String[] args) {
    SpringApplication.run(Application.class, args);
  }

}
