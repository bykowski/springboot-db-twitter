package pl.bykowski.springbootdbtwitter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class Start {

    private PigeonRepo pigeonRepo;

    @Autowired
    public Start(PigeonRepo pigeonRepo) {
        this.pigeonRepo = pigeonRepo;
    }

    @EventListener(ApplicationReadyEvent.class)
    public void get() {
        Pigeon pigeon = new Pigeon("Beksa", "Red", "PL232WF");
        pigeonRepo.save(pigeon);
    }
}
