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
@Table(name="events") //anotasi berisi nama table
public class Events implements Serializable {
    
    private static final long serialVersionUID = 1L;

    // atribut berisi nama field/column pada tabel
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
    private Long description;

    public Events(int id, @NotEmpty(message = "Title is required") String title,
            @NotEmpty(message = "Organizer is required") String organizer, String tag,
            @NotEmpty(message = "Organizer is required") String type,
            @NotEmpty(message = "type is required") String category,
            @NotEmpty(message = "Location is required") String location,
            @NotEmpty(message = "Datestart is required") String datestart,
            @NotEmpty(message = "Timestart is required") String timestart,
            @NotEmpty(message = "Dateend is required") String dateend,
            @NotEmpty(message = "Timeend is required") String timeend,
            @NotEmpty(message = "Description is required") Long description) {
        this.id = id;
        this.title = title;
        this.organizer = organizer;
        this.tag = tag;
        this.type = type;
        Category = category;
        this.location = location;
        this.datestart = datestart;
        this.timestart = timestart;
        this.dateend = dateend;
        this.timeend = timeend;
        this.description = description;
    }

    public int getId() {
        return 0;
    }

}