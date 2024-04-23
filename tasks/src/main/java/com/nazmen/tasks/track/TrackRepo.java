package com.nazmen.tasks.track;

import com.nazmen.tasks.artist.Artist;
import com.nazmen.tasks.artist.tasks.AddNewArtistTask;
import com.nazmen.tasks.taskmanagement.TaskManager;
import com.nazmen.tasks.track.tasks.AddNewTrackTask;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Repository
public class TrackRepo {

    private final List<Track> trackList;
    private final TaskManager taskManager;

    public TrackRepo(TaskManager taskManager) {
        this.taskManager = taskManager;
        this.trackList = new ArrayList<>();
    }

    public void addArtist(Track track){
        trackList.add(track);
        taskManager.addTask(new AddNewTrackTask(track));
        System.out.println("Task: " + taskManager.processTasks());
    }

    public List<Track> getAll() {
        return trackList;
    }
}
