package cz.engeto.crypto.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CryptoDTO {

    private String name;
    private Integer id;
    private String symbol;
    private Double price;
    private Double quantity;
}
