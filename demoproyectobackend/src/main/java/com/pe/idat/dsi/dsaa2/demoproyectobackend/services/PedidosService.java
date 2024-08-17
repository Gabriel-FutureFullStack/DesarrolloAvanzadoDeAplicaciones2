package com.pe.idat.dsi.dsaa2.demoproyectobackend.services;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.pe.idat.dsi.dsaa2.demoproyectobackend.models.Pedidos;
import com.pe.idat.dsi.dsaa2.demoproyectobackend.repositories.PedidosRepository;

@Service
public class PedidosService {

    private PedidosRepository peRepository;
    
    public PedidosService(PedidosRepository peRepository){
        this.peRepository = peRepository;
    }
    public Pedidos getById(Long id) {
        Optional<Pedidos> response = peRepository.findById(id);
        if(!response.isPresent()){
            return null;
        }
        return response.get();
    }

}
