package quickstart.emitter;

import org.eclipse.microprofile.reactive.messaging.Channel;
import org.eclipse.microprofile.reactive.messaging.Emitter;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

@ApplicationScoped
public class MyImperativeBean {

    @Inject @Channel("source") Emitter<String> emitter;

    // ...

    public void send(String str) {
        emitter.send(str);
    }
}