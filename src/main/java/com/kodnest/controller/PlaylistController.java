package com.kodnest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.kodnest.entity.PlayList;
import com.kodnest.entity.Song;
import com.kodnest.service.PlaylistService;
import com.kodnest.service.SongService;

import jakarta.servlet.http.HttpSession;



@Controller
public class PlaylistController {
	@Autowired
	SongService songservice;
	
@Autowired
PlaylistService playlistService;

@GetMapping("/createplaylists")
public String createPlaylist(Model model) {
   List<Song> songList= songservice.fetchAllSongs();
   model.addAttribute("songs",songList);
   return "createplaylist";
}
@PostMapping("/addplaylist")
	public String addPlayList(@ModelAttribute PlayList playlist) {
	System.out.println(playlist);
	playlistService.addPlayList(playlist);
	List<Song> songs=playlist.getSongs();
	for(Song song:songs) {
		song.getPlaylists().add(playlist);	
		songservice.UpdateSongs(song);
	}
		return "adminhome";
	}

@GetMapping("/viewplaylist")
public String viewplaylist(Model model) {
	List<PlayList> playlist=playlistService.fetchAllPlaylists();
	model.addAttribute("playlist",playlist);
	return "viewplaylist";
}



}

