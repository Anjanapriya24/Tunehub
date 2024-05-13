package com.kodnest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.kodnest.entity.Song;
import com.kodnest.entity.User;


	@Repository
	public interface SongRepository extends JpaRepository <Song,Integer>{

		Song findByName(String name);

	}
