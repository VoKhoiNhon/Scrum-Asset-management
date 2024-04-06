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
public class Warehouse {
    @Id
    @Column(name="id_asset")
    private int idAsset;

    @Column(name="stock_quantity")
    private String stockQuantity;

    @Column(name="unavailable_quantity")
    private String unavailableQuantity;

}
