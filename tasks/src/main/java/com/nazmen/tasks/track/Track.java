package com.nazmen.tasks.track;

import com.nazmen.tasks.artist.Artist;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class Track {

    private double duration;
    private String album;
    List<Artist> artistList;

    @Override
    public String toString(){

        var artists = artistList
                .stream()
                .map(Artist::getName)
                .collect(Collectors.joining(", "));

        return STR."Track {\{album}, \{duration} artistList = {\{artists}}";
    }
}
