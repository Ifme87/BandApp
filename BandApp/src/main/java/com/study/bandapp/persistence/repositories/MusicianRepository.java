package com.study.bandapp.persistence.repositories;

import org.springframework.data.repository.CrudRepository;

import com.study.bandapp.persistence.entities.MusicianEntity;

public interface MusicianRepository extends CrudRepository<MusicianEntity, Long> {

}
