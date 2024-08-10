package com.pe.idat.dsi.dsaa2.demoproyectobackend.repositories;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.pe.idat.dsi.dsaa2.demoproyectobackend.models.Clientes;


@Repository
public interface ClientesRepository extends JpaRepository<Clientes, Long> {
    @Query(value = " SELECT c FROM Clientes c WHERE c.estado = '1' ")
    List<Clientes> findAllActiveClientes(Sort sorting);

    @Query(value = "SELECT * FROM Clientes WHERE estado = '1'", nativeQuery = true)
    Page<Clientes> findAllPageableActiveClientes(Pageable pageable);

    
    @Query(value = " SELECT * FROM Clientes c WHERE c.estado = '0' ", nativeQuery = true)
    List<Clientes> findAllActiveClientesNative();
}
