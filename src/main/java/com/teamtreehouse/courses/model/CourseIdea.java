package com.teamtreehouse.courses.model;

import java.util.Objects;

//class to store data structues
public class CourseIdea {
    private String title;
    private String creator;

    public CourseIdea(String creator, String title) {
        this.creator = creator;
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public String getCreator() {
        return creator;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;

        CourseIdea that = (CourseIdea) o;
        return Objects.equals(title, that.title) && Objects.equals(creator, that.creator);
    }

    @Override
    public int hashCode() {
        int result = Objects.hashCode(title);
        result = 31 * result + Objects.hashCode(creator);
        return result;
    }
}
