package ru.fadesml.camille.entity;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import java.util.Set;

@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
@Entity
@Table(name = "pages")
public class Page {
    /**
     * Identifier of page
     */
    @Id
    private Long id;

    /**
     * Page title
     */
    private String title;

    /**
     * Http route
     */
    @Column(unique = true, nullable = false)
    private String path;

    /**
     * Core css >> Template css >> Component css >> Page css
     */
    private String css;
    /**
     * Set of components
     */
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "page_components",
            joinColumns = @JoinColumn(name = "page_id"),
            inverseJoinColumns = @JoinColumn(name = "component_id"))
    private Set<Component> components;

    public String getFullCSS() {
        String css = "";

        if (!this.components.isEmpty()) {
            for (Component component : components) {
                if (component.getTemplate() != null && component.getTemplate().getCss() != null) {
                    css = css.concat(component.getTemplate().getCss());
                }

                if (component.getCss() != null) {
                    css = css.concat(component.getCss());
                }
            }
        }

        if (this.css != null) {
            css = css.concat(this.css);
        }
        return css;
    }
}
