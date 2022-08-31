package com.demo.accion.demorendicioncuentas.api;

import com.demo.accion.demorendicioncuentas.entities.AdmResultadosRendicionEntity;
import com.demo.accion.demorendicioncuentas.entities.AdmTemplatesRendicionCuenEntity;
import com.demo.accion.demorendicioncuentas.repository.AdmResultadosRendicionRepo;
import com.demo.accion.demorendicioncuentas.repository.AdmTemplatesRendicionCuenRepo;
import com.demo.accion.demorendicioncuentas.services.interfaces.RendicionTemplateInterfaces;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.ByteArrayInputStream;
import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/demo-rendicion")
public class RendicionTemplatesController {

    Logger logger = LoggerFactory.getLogger(RendicionTemplatesController.class);

    final AdmTemplatesRendicionCuenRepo admTemplatesRendicionCuenRepo;
    final AdmResultadosRendicionRepo admResultadosRendicionRepo;
    final RendicionTemplateInterfaces rendicionTemplateInterfaces;

    public RendicionTemplatesController(AdmTemplatesRendicionCuenRepo admTemplatesRendicionCuenRepo, AdmResultadosRendicionRepo admResultadosRendicionRepo, RendicionTemplateInterfaces rendicionTemplateInterfaces) {
        this.admTemplatesRendicionCuenRepo = admTemplatesRendicionCuenRepo;
        this.admResultadosRendicionRepo = admResultadosRendicionRepo;
        this.rendicionTemplateInterfaces = rendicionTemplateInterfaces;
    }

    @PostMapping(value = "guardar", produces = "application/json" )
    public ResponseEntity sincronizarCliente(@RequestBody AdmTemplatesRendicionCuenEntity admTemplatesRendicionCuenEntity) {
        ObjectMapper mapper = new ObjectMapper();

        admTemplatesRendicionCuenRepo.save(admTemplatesRendicionCuenEntity);

        return new ResponseEntity(admTemplatesRendicionCuenEntity, HttpStatus.OK);
    }

    @GetMapping(value = "consultarTemplates")
    public ResponseEntity consultarTemplates() {
        ObjectMapper mapper = new ObjectMapper();

        List<AdmTemplatesRendicionCuenEntity> admTemplatesRendicionCuenEntity = admTemplatesRendicionCuenRepo.findAll();

        return new ResponseEntity(admTemplatesRendicionCuenEntity, HttpStatus.OK);
    }


    @GetMapping(value = "consultarRespuestas")
    public ResponseEntity consultarRespuestas(@RequestParam Long id_rendicion ) {
        ObjectMapper mapper = new ObjectMapper();

        AdmResultadosRendicionEntity AdmResultadosRendicionEntity = admResultadosRendicionRepo.findById(id_rendicion).orElse(null);

        return new ResponseEntity(AdmResultadosRendicionEntity, HttpStatus.OK);
    }


    @PostMapping(value = "guardarRespuestas")
    public ResponseEntity guardarRespuestas(@RequestBody AdmResultadosRendicionEntity AdmResultadosRendicionEntity ) {
        ObjectMapper mapper = new ObjectMapper();

        AdmResultadosRendicionEntity = admResultadosRendicionRepo.save(AdmResultadosRendicionEntity);

        return new ResponseEntity(AdmResultadosRendicionEntity, HttpStatus.OK);
    }

    @PostMapping(value = "generarProvicional")
    public ResponseEntity<Object> generacionTxtRenciciones(){
        //19908-Fa-989_FIDEICOMISO_BACATA_AREAS_COMERCIALES_BA_0001200102966_900396542.docx
        byte[] archivo = this.rendicionTemplateInterfaces.generateProvisionalRendicion();

        return new ResponseEntity(archivo, HttpStatus.OK);
    }



    @GetMapping(value = "generarPdfRendicon")
    public ResponseEntity<Object> geenerarPDFrendicion(){
        byte[] byteArrayInputStream = this.rendicionTemplateInterfaces.geenerarPDFrendicion();
        return new ResponseEntity(byteArrayInputStream, HttpStatus.OK);
    }

}
