package ru.study.study.entity;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;
import org.hibernate.annotations.UpdateTimestamp;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDateTime;

import static org.hibernate.id.enhanced.SequenceStyleGenerator.CONFIG_SEQUENCE_PER_ENTITY_SUFFIX;

@Getter
@Setter
@Accessors(chain = true)
@ToString(onlyExplicitlyIncluded = true)
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@NoArgsConstructor
@MappedSuperclass
public abstract class BaseEntity implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqGenerator")
    @GenericGenerator(name = "seqGenerator",
            parameters = {
            @Parameter(name = CONFIG_SEQUENCE_PER_ENTITY_SUFFIX, value = "_SEQ")
            })
    @ToString.Include
    @EqualsAndHashCode.Include
    protected Long id;


    @Column(name = "CREATED", nullable = false, updatable = false)
    @CreationTimestamp
    protected LocalDateTime created;

    @Column(name = "MODIFIED", nullable = false)
    @UpdateTimestamp
    protected LocalDateTime modified;



}
