package com.teamtreehouse.courses.model;

import java.util.Objects;

//class to store data structues
public class CourseIdeas {
    private String title;
    private String creator;

    public CourseIdeas(String creator, String title) {
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

        CourseIdeas that = (CourseIdeas) o;
        return Objects.equals(title, that.title) && Objects.equals(creator, that.creator);
    }

    @Override
    public int hashCode() {
        int result = Objects.hashCode(title);
        result = 31 * result + Objects.hashCode(creator);
        return result;
    }
}
