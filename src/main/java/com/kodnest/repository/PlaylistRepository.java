package com.kodnest.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import com.kodnest.entity.PlayList;


	@Repository
	public interface PlaylistRepository extends JpaRepository <PlayList,Integer>{

		PlayList findByName(String name);


	}
