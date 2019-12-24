package com.newnight.extendedplaces.models;

import javax.persistence.*;

@Entity
@Table(name = "places")
public class Place {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Column(name = "google_id")
    private String googleId;
    private String name;
    @Enumerated(EnumType.STRING)
    private VenueSize size;
    @Column(name = "music_genre")
    @Enumerated(EnumType.STRING)
    private MusicGenre musicGenre;
    @Column(name = "dress_code")
    @Enumerated(EnumType.STRING)
    private DressCode dressCode;

    public Place() {
    }

    public Place(String googleId, String name, VenueSize size, MusicGenre musicGenre, DressCode dressCode) {
        this.googleId = googleId;
        this.name = name;
        this.size = size;
        this.musicGenre = musicGenre;
        this.dressCode = dressCode;
    }

    public Place(int id, String googleId, String name, VenueSize size, MusicGenre musicGenre, DressCode dressCode) {
        this.id  = id;
        this.googleId = googleId;
        this.name = name;
        this.size = size;
        this.musicGenre = musicGenre;
        this.dressCode = dressCode;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public MusicGenre getMusicGenre() {
        return musicGenre;
    }

    public void setMusicGenre(MusicGenre musicGenre) {
        this.musicGenre = musicGenre;
    }

    public DressCode getDressCode() {
        return dressCode;
    }

    public void setDressCode(DressCode dressCode) {
        this.dressCode = dressCode;
    }

    @Override
    public String toString() {
        return "Place{" +
                "id=" + id +
                ", googleId='" + googleId + '\'' +
                ", name='" + name + '\'' +
                ", size=" + size +
                ", musicGenre=" + musicGenre +
                ", dressCode=" + dressCode +
                '}';
    }
}
