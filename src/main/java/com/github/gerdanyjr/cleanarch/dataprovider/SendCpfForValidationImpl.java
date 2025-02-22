package com.github.gerdanyjr.cleanarch.dataprovider;

import com.github.gerdanyjr.cleanarch.core.dataprovider.SendCpfForValidation;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
public class SendCpfForValidationImpl implements SendCpfForValidation {

    private final KafkaTemplate<String, String> kafkaTemplate;

    public SendCpfForValidationImpl(KafkaTemplate<String, String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    @Override
    public void send(String cpf) {
        kafkaTemplate.send("tp-cpf-validation", cpf);
    }

}
