package com.javaexample.kafka_procuder.controller;

import com.javaexample.kafka_procuder.dto.Product;
import com.javaexample.kafka_procuder.service.ProducerService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/producer")
public class ProducerController {

    private final ProducerService producerService;

    public ProducerController(ProducerService producerService) {
        this.producerService = producerService;
    }

    @GetMapping
    public String healtCheck(@RequestBody String message)
    {

            producerService.sendMessage(message,1);
            producerService.sendMessage(message,2);

        return "Mesaj İletilmesi Başarılı.";
    }

    @PostMapping
    public Product sendProductMessage(@RequestBody Product product)
    {
        producerService.sendMessage(product,1);
        return product;
    }

    @PostMapping("/elasticsearch")
    public Product sendElasticProductMessage(@RequestBody Product product)
    {
        producerService.sendElasticMessage(product);
        return product;
    }
}
