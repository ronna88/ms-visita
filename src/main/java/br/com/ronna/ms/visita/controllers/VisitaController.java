package br.com.ronna.ms.visita.controllers;

import br.com.ronna.ms.visita.dtos.VisitaDto;
import br.com.ronna.ms.visita.models.VisitaModel;
import br.com.ronna.ms.visita.services.VisitaService;
import br.com.ronna.ms.visita.vo.ResponseTemplateVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.time.LocalDateTime;
import java.util.List;


@RestController
public class VisitaController {

    @Autowired
    private VisitaService visitaService;

    @PostMapping("/visita/create-visita")
    public ResponseEntity<VisitaModel> createVisita(@RequestBody @Valid VisitaDto visitaDto) {
        VisitaModel visitaModel = new VisitaModel();
        BeanUtils.copyProperties(visitaDto, visitaModel);
        visitaService.createVisita(visitaModel);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PutMapping("/visita/edit-visita/{id}")
    public VisitaModel editVisita(@RequestBody VisitaModel visitaModel){
        return visitaService.saveVisita(visitaModel);
    }

    @GetMapping("/visita/all")
    public ResponseEntity<List<VisitaModel>> getAllVisita(
            @RequestParam(defaultValue = "0") Integer pageNo,
            @RequestParam(defaultValue = "1") Integer pageSize,
            @RequestParam(defaultValue = "visitaId") String sortBy){
        List<VisitaModel> visitaList = visitaService.getAllVisita(pageNo,pageSize,sortBy);

        return new ResponseEntity<List<VisitaModel>>(visitaList, new HttpHeaders(), HttpStatus.OK);
    }

    @GetMapping("/visita/{id}/full")
    public ResponseTemplateVO getFullVisita(@PathVariable("id") Long visitaId){
        return visitaService.getFullVisita(visitaId);
    }

}
