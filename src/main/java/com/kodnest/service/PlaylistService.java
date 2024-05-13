package com.kodnest.service;

import java.util.List;

import com.kodnest.entity.PlayList;

public interface PlaylistService {

	
void addPlayList(PlayList playlist);

List<PlayList> fetchAllPlaylists();

}
