package com.venusville.apivenusville.entities;

import com.venusville.apivenusville.enums.Anexo;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@Entity
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Enumerated(EnumType.STRING)
    private Anexo anexo;
    private String textPost;

    public Post(Anexo anexo, String textPost) {
        this.anexo = anexo;
        this.textPost = textPost;
    }
}
