package com.artgallery.auto;

import org.apache.cayenne.CayenneDataObject;

import com.artgallery.AuthorWorks;
import com.artgallery.Member;
import com.artgallery.Work;

/**
 * Class _Author was generated by Cayenne.
 * It is probably a good idea to avoid changing this class manually,
 * since it may be overwritten next time code is regenerated.
 * If you need to make any customizations, please use subclass.
 */
public abstract class _Author extends CayenneDataObject {

    public static final String AUTHOR_INTRODUCE_PROPERTY = "authorIntroduce";
    public static final String AUTHOR_WORKS_PROPERTY = "authorWorks";
    public static final String MEMBER_PROPERTY = "member";
    public static final String WORK_PROPERTY = "work";

    public static final String AUTHOR_ID_PK_COLUMN = "author_id";

    public void setAuthorIntroduce(String authorIntroduce) {
        writeProperty("authorIntroduce", authorIntroduce);
    }
    public String getAuthorIntroduce() {
        return (String)readProperty("authorIntroduce");
    }

    public void setAuthorWorks(AuthorWorks authorWorks) {
        setToOneTarget("authorWorks", authorWorks, true);
    }

    public AuthorWorks getAuthorWorks() {
        return (AuthorWorks)readProperty("authorWorks");
    }


    public void setMember(Member member) {
        setToOneTarget("member", member, true);
    }

    public Member getMember() {
        return (Member)readProperty("member");
    }


    public void setWork(Work work) {
        setToOneTarget("work", work, true);
    }

    public Work getWork() {
        return (Work)readProperty("work");
    }


}
