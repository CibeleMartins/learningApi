package br.com.learning.learningapijava.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;

@Entity
public class  AnnotationUser {
    
    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="seq_eq_id_annotation")
	@SequenceGenerator(name="seq_eq_id_annotation", sequenceName="seq_eq_id_annotation", allocationSize=1)
    private Integer id;

    private String title;

    private String date;

    private String description;

    private String annotation;

    private String color;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getAnnotation() {
        return annotation;
    }

    public void setAnnotation(String annotation) {
        this.annotation = annotation;
    }

   
}
