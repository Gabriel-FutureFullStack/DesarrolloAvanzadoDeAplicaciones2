package com.pe.idat.dsi.dsaa2.demoproyectobackend.repositories;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.pe.idat.dsi.dsaa2.demoproyectobackend.models.DetallePedidos;

@Repository
public interface DetallePedidosRepository extends JpaRepository<DetallePedidos, Long>{
    @Query(value = " SELECT d FROM DetallePedidos  d WHERE d.estado = '1' ")
    List<DetallePedidos> findAllActiveDetalles(Sort sorting);

}
