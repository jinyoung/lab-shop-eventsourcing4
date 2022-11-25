package labshopeventsourcing;

import org.axonframework.common.jpa.EntityManagerProvider;
import org.axonframework.config.EventProcessingConfigurer;
import org.axonframework.eventhandling.tokenstore.TokenStore;
import org.axonframework.eventhandling.tokenstore.jpa.JpaTokenStore;
import org.axonframework.serialization.Serializer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
//import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;


@SpringBootApplication
//@EnableFeignClients
public class DeliveryApplication {
    protected static ApplicationContext applicationContext;
    public static void main(String[] args) {
        applicationContext = SpringApplication.run(DeliveryApplication.class, args);
    }


    // @Bean
    // public TokenStore tokenStore(Serializer serializer, EntityManagerProvider entityManagerProvider) {
    //   return JpaTokenStore.builder()
    //             .entityManagerProvider(entityManagerProvider)
    //             .serializer(serializer)
    //             .build();
    // }

    @Autowired
    public void configure(EventProcessingConfigurer config) {
        config.usingSubscribingEventProcessors();
    }
}
