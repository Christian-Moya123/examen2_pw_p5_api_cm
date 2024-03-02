package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.modelo.to.EstudainteTO;
import com.example.demo.service.IEstudianteService;

@RestController
@RequestMapping("/estudiantes")
@CrossOrigin(origins = "http://localhost:8080/") 
public class EstudianteControllerRestFull {
	
	@Autowired
	private IEstudianteService estudainteService;
	
	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> guardar(@RequestBody EstudainteTO estudiante) {
        this.estudainteService.inscripcionEstudiante(estudiante);
        return ResponseEntity.status(HttpStatus.OK).body("Estudiante guardado");
    }
	
	

}
