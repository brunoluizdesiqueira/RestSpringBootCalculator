package br.com.blsdev.data.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

@Entity
@Table(name="books")
@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Book implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private long id;

    @Column(length = 180)
    private String author;

    @Column(name = "launch_date", nullable = false, length = 80)
    @Temporal(TemporalType.DATE)
    private Date launchDate;

    @Column(nullable = false)
    private Double price;

    @NotNull(message = "O título é obrigatório")
    @Column(nullable = false, length = 250)
    private String Title;
}
