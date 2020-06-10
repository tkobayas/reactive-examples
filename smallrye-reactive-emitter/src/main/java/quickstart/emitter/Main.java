package quickstart.emitter;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.se.SeContainerInitializer;
import javax.enterprise.inject.spi.CDI;

@ApplicationScoped
public class Main {

    public static void main(String[] args) {
        SeContainerInitializer.newInstance().initialize();
        
        MyImperativeBean myImperativeBean = CDI.current().select(MyImperativeBean.class).get();
        
        myImperativeBean.send("Hello");
        myImperativeBean.send("John");
        myImperativeBean.send("Good Bye");
    }

}