package io.quarkus.it.opentelemetry;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

import org.eclipse.microprofile.reactive.messaging.Incoming;
import org.eclipse.microprofile.reactive.messaging.Outgoing;

@ApplicationScoped
public class TracedKafkaProcessor {

    @Inject
    TracedService tracedService;

    @Incoming("traces-in2")
    @Outgoing("traces-processed")
    String process(String msg) {
        return tracedService.call() + msg;
    }

}
