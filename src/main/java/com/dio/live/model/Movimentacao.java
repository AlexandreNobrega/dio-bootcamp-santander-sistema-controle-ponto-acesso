package com.dio.live.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Builder
@Entity
public class Movimentacao {

        @Id
        @GeneratedValue
        private Long id;

        @ManyToOne
        @NotNull
        private Usuario usuario;

        @JsonSerialize(using = LocalDateTimeSerializer.class)
        @JsonFormat(pattern = "dd-MM-yyyy HH:mm:ss")
        private LocalDateTime dataEntrada;

        @JsonSerialize(using = LocalDateTimeSerializer.class)
        @JsonFormat(pattern = "dd-MM-yyyy HH:mm:ss")
        private LocalDateTime dataSaida;

        private BigDecimal periodo;

        @ManyToOne
        private Ocorrencia ocorrencia;

        @ManyToOne
        private Calendario calendario;
}