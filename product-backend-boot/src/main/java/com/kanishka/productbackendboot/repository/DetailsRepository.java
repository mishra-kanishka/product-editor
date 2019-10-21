package com.kanishka.productbackendboot.repository;

import com.kanishka.productbackendboot.domain.Detail;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DetailsRepository extends CrudRepository<Detail, String> {

    public List<Detail> findByProductId(String productId);

}
