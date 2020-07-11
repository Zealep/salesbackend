package com.zealep.api.salesbackend.repository;

import com.zealep.api.salesbackend.model.entity.Compra;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CompraRepository extends JpaRepository<Compra,Long> {

    @Query("select c from Compra c where c.estado=?1")
    List<Compra> findAllActives(String estado);

    @Modifying
    @Query("update Compra c set c.estado=?2 where c.idCompra=?1")
    void deleteLogic(Long id,String estado);


}
