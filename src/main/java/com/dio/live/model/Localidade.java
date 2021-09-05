package com.dio.live.model;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Builder
@Entity
public class Localidade {

    @Id
    @GeneratedValue
    private  long id;

    @NotNull
    @Enumerated(EnumType.STRING)
    private NivelAcesso nivelAcesso;

    private String descricao;

}
