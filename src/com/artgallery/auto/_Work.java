package com.artgallery.auto;

import org.apache.cayenne.CayenneDataObject;

import com.artgallery.Author;
import com.artgallery.AuthorWorks;
import com.artgallery.Favoriates;
import com.artgallery.Image;

/**
 * Class _Work was generated by Cayenne.
 * It is probably a good idea to avoid changing this class manually,
 * since it may be overwritten next time code is regenerated.
 * If you need to make any customizations, please use subclass.
 */
public abstract class _Work extends CayenneDataObject {

    public static final String DESCRIPTION_PROPERTY = "description";
    public static final String FAVORTATE_NUM_PROPERTY = "favortateNum";
    public static final String G_NUM_PROPERTY = "gNum";
    public static final String SHARE_NUM_PROPERTY = "shareNum";
    public static final String TITLE_PROPERTY = "title";
    public static final String TYPE_PROPERTY = "type";
    public static final String AUTHOR_PROPERTY = "author";
    public static final String AUTHOR_WORKS_PROPERTY = "authorWorks";
    public static final String FAVORIATES_PROPERTY = "favoriates";
    public static final String IMAGE_PROPERTY = "image";

    public static final String WORK_ID_PK_COLUMN = "work_id";

    public void setDescription(String description) {
        writeProperty("description", description);
    }
    public String getDescription() {
        return (String)readProperty("description");
    }

    public void setFavortateNum(Long favortateNum) {
        writeProperty("favortateNum", favortateNum);
    }
    public Long getFavortateNum() {
        return (Long)readProperty("favortateNum");
    }

    public void setGNum(Long gNum) {
        writeProperty("gNum", gNum);
    }
    public Long getGNum() {
        return (Long)readProperty("gNum");
    }

    public void setShareNum(Long shareNum) {
        writeProperty("shareNum", shareNum);
    }
    public Long getShareNum() {
        return (Long)readProperty("shareNum");
    }

    public void setTitle(String title) {
        writeProperty("title", title);
    }
    public String getTitle() {
        return (String)readProperty("title");
    }

    public void setType(String type) {
        writeProperty("type", type);
    }
    public String getType() {
        return (String)readProperty("type");
    }

    public void setAuthor(Author author) {
        setToOneTarget("author", author, true);
    }

    public Author getAuthor() {
        return (Author)readProperty("author");
    }


    public void setAuthorWorks(AuthorWorks authorWorks) {
        setToOneTarget("authorWorks", authorWorks, true);
    }

    public AuthorWorks getAuthorWorks() {
        return (AuthorWorks)readProperty("authorWorks");
    }


    public void setFavoriates(Favoriates favoriates) {
        setToOneTarget("favoriates", favoriates, true);
    }

    public Favoriates getFavoriates() {
        return (Favoriates)readProperty("favoriates");
    }


    public void setImage(Image image) {
        setToOneTarget("image", image, true);
    }

    public Image getImage() {
        return (Image)readProperty("image");
    }


}
