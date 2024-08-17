package com.pe.idat.dsi.dsaa2.demoproyectobackend.services;

import org.springframework.stereotype.Service;

import com.pe.idat.dsi.dsaa2.demoproyectobackend.repositories.ProductosRepository;

@Service
public class ProductoService {
    
    private ProductosRepository productRepository;

    public ProductoService(ProductosRepository productRepository){
        this.productRepository = productRepository;
    }

}
