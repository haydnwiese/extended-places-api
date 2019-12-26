package com.newnight.extendedplaces.models;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "place_music_genre")
public class PlaceMusicGenre implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @JsonIgnore
    private int id;
    @Column(name = "place_id")
    @JsonIgnore
    private String placeId;
    @Column(name = "music_genre")
    @Enumerated(EnumType.STRING)
    private MusicGenre musicGenre;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "place_id", referencedColumnName = "google_id", insertable = false, updatable = false)
    private Place place;

    public PlaceMusicGenre() {
    }

    public PlaceMusicGenre(String placeId, MusicGenre musicGenre, Place place) {
        this.placeId = placeId;
        this.musicGenre = musicGenre;
        this.place = place;
    }

    public PlaceMusicGenre(int id, String placeId, MusicGenre musicGenre, Place place) {
        this.id = id;
        this.placeId = placeId;
        this.musicGenre = musicGenre;
        this.place = place;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPlaceId() {
        return placeId;
    }

    public void setPlaceId(String placeId) {
        this.placeId = placeId;
    }

    public MusicGenre getMusicGenre() {
        return musicGenre;
    }

    public void setMusicGenre(MusicGenre musicGenre) {
        this.musicGenre = musicGenre;
    }

    public Place getPlace() {
        return place;
    }

    public void setPlace(Place place) {
        this.place = place;
    }
}
