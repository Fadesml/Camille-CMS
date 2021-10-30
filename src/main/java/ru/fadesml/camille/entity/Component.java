package ru.fadesml.camille.entity;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.util.Comparator;

@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
@Entity
@Table(name = "components")
public class Component {
    /**
     * Identifier of component
     */
    @Id
    private Long id;

    /**
     * Position on page
     */
    private Integer position;

    /**
     * View template
     */
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="template_id", nullable=false)
    private Template template;

    /**
     * View template json model
     */
    private String model;

    /**
     * Core css >> Template css >> Component css >> Page css
     */
    private String css;

    public static final Comparator<Component> COMPARE_BY_POSITION = Comparator.comparingInt(Component::getPosition);

}
