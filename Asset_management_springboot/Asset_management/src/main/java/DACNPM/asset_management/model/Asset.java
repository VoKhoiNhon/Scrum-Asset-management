package DACNPM.asset_management.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Table(name="asset")
public class Asset {
    @Id
    @Column(name="id_asset")
    private int idAsset;

    @Column(name="asset_name")
    private String assetName;

    @Column(name="description")
    private String description;

    @Column(name="status")
    private int status;

    @Column(name="purchase_price")
    private int purchasePrice;


    @DateTimeFormat(pattern = "yyyy-mm-dd")
    @Column(name="date_purchase")
    private Date datePurchase;

    @Column(name="type_id")
    private int type;

}
