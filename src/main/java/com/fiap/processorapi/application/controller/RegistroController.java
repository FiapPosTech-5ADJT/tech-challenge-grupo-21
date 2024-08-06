package com.fiap.processorapi.application.controller;

import com.fiap.processorapi.application.dto.RegistroDTO;
import com.fiap.processorapi.application.services.RegistroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
@RequestMapping("/registros")
public class RegistroController {
    @Autowired
    private RegistroService registroService;

    @GetMapping
    public ResponseEntity<Collection<RegistroDTO>> findAll(){
        Collection<RegistroDTO> registros = registroService.findPendentRecords();
        return ResponseEntity.ok(registros);
    }
}
