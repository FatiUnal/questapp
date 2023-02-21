package com.project.questapp.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Entity
@Table(name = "post")
@Data
public class Post {
    @Id
    Long id;

    @ManyToOne(fetch = FetchType.LAZY) //user objesini databaseden hemen çekme
    @JoinColumn(name = "user_id",nullable = false)
    @OnDelete(action = OnDeleteAction.NO_ACTION) // bir user silindiğinde postlarıda silinsin
    @JsonIgnore
    User user;


    String title;
    @Lob
    @Column(columnDefinition = "text")
    String text;
}
