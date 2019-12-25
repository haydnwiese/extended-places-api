package com.newnight.extendedplaces.models;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "place_music_genre")
public class PlaceMusicGenre implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Column(name = "place_id")
    private String placeId;
    @Column(name = "music_genre")
    @Enumerated(EnumType.STRING)
    private MusicGenre musicGenre;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "place_id", insertable = false, updatable = false)
    private Place place;

    public PlaceMusicGenre() {
    }

    public PlaceMusicGenre(String placeId, MusicGenre musicGenre) {
        this.placeId = placeId;
        this.musicGenre = musicGenre;
    }

    public PlaceMusicGenre(int id, String placeId, MusicGenre musicGenre) {
        this.id = id;
        this.placeId = placeId;
        this.musicGenre = musicGenre;
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
}
