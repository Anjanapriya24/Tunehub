package com.kodnest.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.kodnest.entity.PlayList;
import com.kodnest.repository.PlaylistRepository;
import com.kodnest.service.PlaylistService;

@Service
public class PlaylistServiceImpl implements PlaylistService{
	@Autowired
	PlaylistRepository playlistRepository;


	@Override
	public void addPlayList(PlayList playlist) {
		PlayList existplaylist=playlistRepository.findByName(playlist.getName());
		if(existplaylist==null) {
		playlistRepository.save(playlist);
	}
	else {
		System.out.println("playlist already exists");
	}
		
	}


	@Override
	public List<PlayList> fetchAllPlaylists() {
		List<PlayList>playlist=playlistRepository.findAll();
		return playlist;
	}
}