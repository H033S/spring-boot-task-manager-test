package com.nazmen.tasks.artist;

import com.nazmen.tasks.track.Track;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.stream.Collectors;

import static java.lang.StringTemplate.STR;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Artist {

    private String name;
    private List<Track> trackList;

    @Override
    public String toString() {

        var artists = trackList
                .stream()
                .map(Track::getAlbum)
                .collect(Collectors.joining(","));

        return STR."Artist {\{name}, trackList= {\{trackList}}";
    }
}
