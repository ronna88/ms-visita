package br.com.ronna.ms.visita.services;

import br.com.ronna.ms.visita.models.VisitaModel;
import br.com.ronna.ms.visita.repositories.VisitaRepository;
import br.com.ronna.ms.visita.vo.ClienteModel;
import br.com.ronna.ms.visita.vo.FuncionarioModel;
import br.com.ronna.ms.visita.vo.FuncionarioWrapper;
import br.com.ronna.ms.visita.vo.ResponseTemplateVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

@Service
public class VisitaService {

    @Autowired
    private VisitaRepository visitaRepository;

    @Autowired
    private RestTemplate restTemplate;

    public VisitaModel createVisita(VisitaModel visitaModel){
        visitaModel.setVisitaCreated(LocalDateTime.now());
        visitaModel.setVisitaUpdated(visitaModel.getVisitaCreated());
        return visitaRepository.save(visitaModel);
    }

    public VisitaModel saveVisita(VisitaModel visitaModel){
        VisitaModel editVisitaModel = visitaRepository.findById(visitaModel.getVisitaId()).get();
        BeanUtils.copyProperties(visitaModel, editVisitaModel);
        visitaModel.setVisitaUpdated(LocalDateTime.now());
        return visitaRepository.save(editVisitaModel);
    }


    public List<VisitaModel> getAllVisita(Integer pageNo, Integer pageSize, String sortBy) {
        Pageable paging = PageRequest.of(pageNo, pageSize, Sort.by(sortBy));

        Page<VisitaModel> pagedResult = visitaRepository.findAll(paging);

        if(pagedResult.hasContent()){
            return pagedResult.getContent();
        } else {
            return new ArrayList<VisitaModel>();
        }
    }

    public ResponseTemplateVO getFullVisita(Long visitaId){
        ResponseTemplateVO vo = new ResponseTemplateVO();

        VisitaModel visitaModel = visitaRepository.findById(visitaId).get();
        ClienteModel clienteModel = restTemplate.getForObject("http://localhost:7001/cliente/" +
                visitaModel.getVisitaClienteId(), ClienteModel.class);
        //TODO: ajustar solicitação REST para classe wrapper

        List<FuncionarioModel> funcionario = new ArrayList<>();
        for(String id : visitaModel.getVisitaFuncionarioId().split(",")) {
            funcionario.add(restTemplate.getForObject("http://localhost:7003/funcionario/" +
                    Long.parseLong(id), FuncionarioModel.class));
        }

        vo.setClienteModel(clienteModel);
        vo.setFuncionarioModel(funcionario);
        vo.setVisitaModel(visitaModel);

        return vo;
    }



}
