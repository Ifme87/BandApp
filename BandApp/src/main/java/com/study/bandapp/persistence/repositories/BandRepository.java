package com.study.bandapp.persistence.repositories;

import org.springframework.data.repository.CrudRepository;

import com.study.bandapp.persistence.entities.BandEntity;

public interface BandRepository extends CrudRepository<BandEntity, Long> {

}
