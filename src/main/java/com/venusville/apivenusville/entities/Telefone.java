package com.venusville.apivenusville.entities;

import com.venusville.apivenusville.enums.TipoFone;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@Entity
public class Telefone {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Enumerated(EnumType.STRING)
    private TipoFone tipo;
    private String telefone;

    public Telefone(TipoFone tipo, String telefone) {
        this.tipo = tipo;
        this.telefone = telefone;
    }
}
