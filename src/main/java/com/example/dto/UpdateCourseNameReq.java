package com.example.dto;

public class UpdateCourseNameReq {
    private Long id;
    private String name;

    // Getter
    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    // Setter
    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }
}
