package org.example.project_02_jsp_servlets.model;

import lombok.Data;

@Data
public class Task {
    private int id;
    private String title;
    private String description;
    private boolean completed;
    private int userId;
}
