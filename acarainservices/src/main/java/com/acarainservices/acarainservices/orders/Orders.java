package com.acarainservices.acarainservices.orders;

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
@Table(name="orders") //anotasi berisi nama table
public class Orders implements Serializable {
    
    private static final long serialVersionUID = 1L;

    // atribut berisi nama field/column pada tabel
    @Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY) 
    private int id;

    public Orders(int id, @NotEmpty(message = "Title is required") String title,
            @NotEmpty(message = "Organizer is required") String organizer, String tipe, String category,
            @NotEmpty(message = "Price is required") Integer price,
            @NotEmpty(message = "Datestart is required") String datestart,
            @NotEmpty(message = "Timestart is required") String timestart,
            @NotEmpty(message = "Dateend is required") String dateend,
            @NotEmpty(message = "Timeend is required") String timeend) {
        this.id = id;
        this.title = title;
        this.organizer = organizer;
        this.tipe = tipe;
        this.category = category;
        this.price = price;
        this.datestart = datestart;
        this.timestart = timestart;
        this.dateend = dateend;
        this.timeend = timeend;
    }

    @Column(length = 20)
    @NotEmpty(message = "Title is required")
    private String title;

    @Column(length = 20)
    @NotEmpty(message = "Organizer is required")
    private String organizer;

    @Column(length = 20)
    private String tipe;

    @Column(length = 20)
    private String category;

    @Column(length = 50)
    @NotEmpty(message = "Price is required")
    private Integer price;

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

    public int getId() {
        return 0;
    }

}

