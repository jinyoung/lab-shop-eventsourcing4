package labshopeventsourcing.query;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;

import java.util.Date;
import lombok.Data;

@Data
@Entity
public class OrderStatus {

        @Id
        private Long id;
        private String status;
        private Double amount;
        private Long qty;
        private String productId;


}