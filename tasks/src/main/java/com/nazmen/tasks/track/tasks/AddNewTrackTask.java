package com.nazmen.tasks.track.tasks;

import com.nazmen.tasks.artist.Artist;
import com.nazmen.tasks.taskmanagement.Task;
import com.nazmen.tasks.track.Track;

public class AddNewTrackTask implements Task {

    private final Track track;

    public AddNewTrackTask(Track track) {
        this.track = track;
    }

    @Override
    public boolean process() {

        for (Artist artist : track.getArtistList()) {
            artist.getTrackList().add(track);
        }

        return true;
    }

    @Override
    public boolean revert() {
        for (Artist artist : track.getArtistList()) {
            artist.getTrackList().removeIf(t -> t.equals(track));
        }

        return true;
    }
}
