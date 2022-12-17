package com.acarainservices.acarainservices.events;

import java.io.Serializable;
// import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
// import javax.persistence.JoinColumn;
// import javax.persistence.JoinTable;
// import javax.persistence.ManyToMany;
// import javax.persistence.ManyToOne;
// import javax.validation.constraints.Min;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name = "events") 
public class Events implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(length = 20)
    @NotEmpty(message = "Title is required")
    private String title;

    @Column(length = 20)
    @NotEmpty(message = "Organizer is required")
    private String organizer;

    @Column(length = 20)
    private String tag;

    @Column(length = 20)
    @NotEmpty(message = "Organizer is required")
    private String type;

    @Column(length = 20)
    @NotEmpty(message = "type is required")
    private String Category;

    @Column(length = 50)
    @NotEmpty(message = "Location is required")
    private String location;

    @Column(columnDefinition = "DATE")
    @NotEmpty(message = "Datestart is required")
    private String datestart;

    @Column(columnDefinition = "TIME")
    @NotEmpty(message = "Timestart is required")
    private String timestart;

    @Column(columnDefinition = "DATE")
    @NotEmpty(message = "Dateend is required")
    private String dateend;

    @Column(columnDefinition = "TIME")
    @NotEmpty(message = "Timeend is required")
    private String timeend;

    @Column(length = 100)
    @NotEmpty(message = "Description is required")
    private String description;

    public Events() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getOrganizer() {
        return organizer;
    }

    public void setOrganizer(String organizer) {
        this.organizer = organizer;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getCategory() {
        return Category;
    }

    public void setCategory(String category) {
        Category = category;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getDatestart() {
        return datestart;
    }

    public void setDatestart(String datestart) {
        this.datestart = datestart;
    }

    public String getTimestart() {
        return timestart;
    }

    public void setTimestart(String timestart) {
        this.timestart = timestart;
    }

    public String getDateend() {
        return dateend;
    }

    public void setDateend(String dateend) {
        this.dateend = dateend;
    }

    public String getTimeend() {
        return timeend;
    }

    public void setTimeend(String timeend) {
        this.timeend = timeend;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

}