package ru.fadesml.camille.entity;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
@Entity
@Table(name = "templates")
public class Template {
    /**
     * Identifier of template
     */
    @Id
    private Long id;

    /**
     * Template short name
     */
    private String name;

    /**
     * Template html
     */
    private String html;

    /**
     * Example of model
     */
    private String model;

    /**
     * Core css >> Template css >> Component css >> Page css
     */
    private String css;
}
