package io.pivotal.pal.tracker;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Config {

    @Bean
    public TimeEntryRepository timeEntryRepository () {
        return new InMemoryTimeEntryRepository();
    }
}
