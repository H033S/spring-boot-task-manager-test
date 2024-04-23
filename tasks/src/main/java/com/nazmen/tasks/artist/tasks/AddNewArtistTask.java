package com.nazmen.tasks.artist.tasks;

import com.nazmen.tasks.artist.Artist;
import com.nazmen.tasks.taskmanagement.Task;

public class AddNewArtistTask implements Task {

    private final Artist artist;

    public AddNewArtistTask(Artist artist) {
        this.artist = artist;
    }

    @Override
    public boolean process() {
        return false;
    }

    @Override
    public boolean revert() {
        return false;
    }
}
