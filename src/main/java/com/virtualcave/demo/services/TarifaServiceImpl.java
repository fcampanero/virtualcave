package com.virtualcave.demo.services;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.virtualcave.demo.entities.Tarifa;
import com.virtualcave.demo.model.TarifaRequest;
import com.virtualcave.demo.repositories.TarifaRepository;

import java.sql.Timestamp;
import java.util.List;
import java.util.Optional;

@Service
public class TarifaServiceImpl implements TarifaService {


    private final TarifaRepository tarifaRepository;

    public TarifaServiceImpl(TarifaRepository tarifaRepository) {
        this.tarifaRepository = tarifaRepository;
    }

    @Override
    public List<Tarifa> findAll() {
        return tarifaRepository.findAll();
    }

    @Override
    public Optional<Tarifa> findById(Long id) {
        return tarifaRepository.findById(id);
    }

   
    @Override
    public Long create(TarifaRequest newTarifa) {
        Tarifa tarifaEntity = new Tarifa(newTarifa.getId(), newTarifa.getBrand_id(), newTarifa.getProductId(), 
        		newTarifa.getStart_date(), newTarifa.getEnd_date(), newTarifa.getPrice(), newTarifa.getCurrency_code());
        return tarifaRepository.save(tarifaEntity).getId();
    }
    
    private String id;

	private String brand_id;
	
	private Long productId;
	
	private Timestamp start_date;
	
	private Timestamp end_date;
	
	private Long price;
	
	private String currency_code;
	
    @Override
    @Transactional
    public boolean update(Long id, TarifaRequest tarifaRequest) {
        return tarifaRepository.findById(id)
                .map(tarifa -> {
                    copy(tarifaRequest, tarifa);
                    return true;
                })
                .orElse(false);
    }

    private void copy(TarifaRequest tarifaRequest, Tarifa tarifa) {
        tarifa.setBrand_id(tarifaRequest.getBrand_id());
        tarifa.setCurrency_code(tarifaRequest.getCurrency_code());
        tarifa.setEnd_date(tarifaRequest.getEnd_date());
        tarifa.setId(tarifaRequest.getId());
        tarifa.setPrice(tarifaRequest.getPrice());
        tarifa.setProductId(tarifaRequest.getProductId());
        tarifa.setStart_date(tarifaRequest.getStart_date());
        
        
    }

    @Override
    public void delete(Long id) {
        if (tarifaRepository.existsById(id)) {
        	tarifaRepository.deleteById(id);
        }
    }
	
}
