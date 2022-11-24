package labshopeventsourcing.command;

import org.axonframework.modelling.command.TargetAggregateIdentifier;


import lombok.Data;
import lombok.ToString;

@ToString
@Data
public class OrderCommand {

    @TargetAggregateIdentifier
    private Long id;
    private String productId;
    private Integer qty;
    private String customerId;
    private String status;
    private String address;

}
