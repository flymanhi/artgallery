package com.artgallery;

import com.artgallery.auto._ArtGalleryMap;

public class ArtGalleryMap extends _ArtGalleryMap {

    private static ArtGalleryMap instance;

    private ArtGalleryMap() {}

    public static ArtGalleryMap getInstance() {
        if(instance == null) {
            instance = new ArtGalleryMap();
        }

        return instance;
    }
}
