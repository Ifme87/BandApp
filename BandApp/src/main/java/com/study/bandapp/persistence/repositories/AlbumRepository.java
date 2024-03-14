package com.study.bandapp.persistence.repositories;

import org.springframework.data.repository.CrudRepository;

import com.study.bandapp.persistence.entities.AlbumEntity;

public interface AlbumRepository extends CrudRepository<AlbumEntity, Long> {
	
}
