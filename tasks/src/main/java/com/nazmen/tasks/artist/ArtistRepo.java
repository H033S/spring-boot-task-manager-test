package com.nazmen.tasks.artist;

import com.nazmen.tasks.artist.tasks.AddNewArtistTask;
import com.nazmen.tasks.taskmanagement.TaskManager;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class ArtistRepo {

    private final List<Artist> artistList;
    private final TaskManager taskManager;

    public ArtistRepo(TaskManager taskManager) {
        this.taskManager = taskManager;
        this.artistList = new ArrayList<>();
    }

    public void addArtist(Artist artist){
        artistList.add(artist);
        //taskManager.addTask(new AddNewArtistTask(artist));
    }

    public List<Artist> getAllArtists(){
        return artistList;
    }
}
