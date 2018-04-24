package com.ilabservice.intelab.model;

import javax.persistence.*;

@Entity
@Table(name = "rent_clause")
public class RentClause {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String content;

    public RentClause() {
    }


    public RentClause(Long id, String content) {
        this.id = id;
        this.content = content;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
