package com.pe.idat.dsi.dsaa2.demoproyectobackend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pe.idat.dsi.dsaa2.demoproyectobackend.models.Pedidos;

@Repository
public interface PedidosRepository extends JpaRepository<Pedidos, Long>{

}
