package labshopeventsourcing.policy;

import org.axonframework.config.ProcessingGroup;
import org.axonframework.eventhandling.EventHandler;
import org.axonframework.eventhandling.ReplayStatus;
import org.axonframework.queryhandling.QueryHandler;
import org.axonframework.eventhandling.AllowReplay;
import org.axonframework.eventhandling.DisallowReplay;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.axonframework.commandhandling.gateway.CommandGateway;

import labshopeventsourcing.command.*;
import labshopeventsourcing.event.*;
import labshopeventsourcing.aggregate.*;


@Service
@ProcessingGroup("delivery")
public class PolicyHandler{

    @Autowired
    CommandGateway commandGateway;

    @EventHandler  //@StreamListener
    //@DisallowReplay  //if not, --from-beginning
    //@AllowReplay(false)
    public void wheneverOrderPlaced_AddToDeliveryList(OrderPlacedEvent orderPlaced, ReplayStatus status){
        System.out.println(orderPlaced.toString());

        AddToDeliveryListCommand command = new AddToDeliveryListCommand();
        command.setId(System.currentTimeMillis());
        command.setOrderId(orderPlaced.getId());
        commandGateway.send(command);
    }
    @EventHandler
    @DisallowReplay
    public void wheneverOrderCancelled_ReturnDelivery(OrderCancelledEvent orderCancelled){
        System.out.println(orderCancelled.toString());

        ReturnDeliveryCommand command = new ReturnDeliveryCommand();
        commandGateway.send(command);
    }

}
