package com.kodnest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.kodnest.entity.Song;
import com.kodnest.service.SongService;

@Controller
public class SongController{
@Autowired
SongService songservice;

@PostMapping("/addsongs")
public String addsong(@ModelAttribute Song song) {
	String name=song.getName();
	boolean songExists=songservice.songExists(name);
	if(songExists==false)
	{
		songservice.saveSong(song);
	}
	else {
		System.out.println("duplicate entry");
	}
	return "adminhome";
	
}



@GetMapping("/viewsongs")
public String viewSongs(Model model) {
  
	List<Song> songslist=songservice.fetchAllSongs();
	model.addAttribute("songs",songslist);
	//System.out.println(songslist);
	return "viewsong";
}


@GetMapping("/playsongs")
public String playSongs(Model model) {
	boolean premium =true;
	if(premium) {
		List<Song> songslist=songservice.fetchAllSongs();
		model.addAttribute("songs",songslist);
		//System.out.println(songslist);
		return "viewsong";
	}else {
		return "pay";
	}
	
}
}


