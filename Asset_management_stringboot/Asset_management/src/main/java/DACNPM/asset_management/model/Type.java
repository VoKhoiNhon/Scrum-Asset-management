package model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Type {
    @Id
    @Column(name="id_type")
    private int idType;

    @Column(name="value")
    private String value;

    @Column(name="description")
    private String description;

}
