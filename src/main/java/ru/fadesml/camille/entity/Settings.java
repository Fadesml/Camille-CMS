package ru.fadesml.camille.entity;

import lombok.AllArgsConstructor;
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
@AllArgsConstructor
@Entity
@Table(name = "cms_settings")
public class Settings {
    @Id
    private String id;

    private String styles;

    private String scripts;

    public Settings(Settings prototype) {
        this.id = prototype.getId();
        this.styles = prototype.getStyles();
        this.scripts = prototype.getScripts();
    }

    @Override
    public String toString() {
        return "Settings{" +
                "id='" + id + '\'' +
                ", styles='" + styles + '\'' +
                ", scripts='" + scripts + '\'' +
                '}';
    }
}
