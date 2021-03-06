package com.artgallery.auto;

import org.apache.cayenne.CayenneDataObject;

import com.artgallery.Work;

/**
 * Class _Image was generated by Cayenne.
 * It is probably a good idea to avoid changing this class manually,
 * since it may be overwritten next time code is regenerated.
 * If you need to make any customizations, please use subclass.
 */
public abstract class _Image extends CayenneDataObject {

    public static final String FILE_NAME_PROPERTY = "fileName";
    public static final String HD_SRC_PROPERTY = "hdSrc";
    public static final String SRC_PROPERTY = "src";
    public static final String WORK_PROPERTY = "work";

    public static final String IMAGE_ID_PK_COLUMN = "image_id";

    public void setFileName(String fileName) {
        writeProperty("fileName", fileName);
    }
    public String getFileName() {
        return (String)readProperty("fileName");
    }

    public void setHdSrc(String hdSrc) {
        writeProperty("hdSrc", hdSrc);
    }
    public String getHdSrc() {
        return (String)readProperty("hdSrc");
    }

    public void setSrc(String src) {
        writeProperty("src", src);
    }
    public String getSrc() {
        return (String)readProperty("src");
    }

    public void setWork(Work work) {
        setToOneTarget("work", work, true);
    }

    public Work getWork() {
        return (Work)readProperty("work");
    }


}
