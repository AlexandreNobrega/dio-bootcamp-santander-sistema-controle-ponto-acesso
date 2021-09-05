package com.dio.live.model;

import lombok.*;
import org.hibernate.envers.Audited;

import javax.persistence.Entity;

@Getter
@Audited
public enum NivelAcesso {

    ADMINISTRADOR,
    USUARIO,
    CONSULTA

}
