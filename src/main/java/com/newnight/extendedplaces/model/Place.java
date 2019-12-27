package com.newnight.extendedplaces.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "places")
public class Place implements Serializable {
    @Id
    @Column(name = "google_id")
    private String googleId;
    private String name;
    @Enumerated(EnumType.STRING)
    private VenueSize size;
    @Column(name = "dress_code")
    @Enumerated(EnumType.STRING)
    private DressCode dressCode;

    @OneToMany(mappedBy = "place")
    private List<PlaceMusicGenre> musicGenres;

    public Place() {
    }

    public Place(String googleId, String name, VenueSize size, DressCode dressCode, List<PlaceMusicGenre> musicGenres) {
        this.googleId = googleId;
        this.name = name;
        this.size = size;
        this.dressCode = dressCode;
        this.musicGenres = musicGenres;
    }

    public String getGoogleId() {
        return googleId;
    }

    public void setGoogleId(String googleId) {
        this.googleId = googleId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public VenueSize getSize() {
        return size;
    }

    public void setSize(VenueSize size) {
        this.size = size;
    }

    public DressCode getDressCode() {
        return dressCode;
    }

    public void setDressCode(DressCode dressCode) {
        this.dressCode = dressCode;
    }

    public List<PlaceMusicGenre> getMusicGenres() {
        return musicGenres;
    }

    public void setMusicGenres(List<PlaceMusicGenre> musicGenres) {
        this.musicGenres = musicGenres;
    }
}
