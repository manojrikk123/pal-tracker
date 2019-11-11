package io.pivotal.pal.tracker;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class EnvController {

    private Map<String, String> envValues;

    public EnvController(@Value("${port:NOT SET}") String port, @Value("${memory_limit:NOT SET}") String memoryLimit, @Value("${cf.instance.index:NOT SET}") String cfInstanceIndex, @Value("${cf.instance.addr:NOT SET}") String cfInstanceAddr) {
        envValues = new HashMap<>(4);
        envValues.put("PORT", port);
        envValues.put("MEMORY_LIMIT", memoryLimit);
        envValues.put("CF_INSTANCE_INDEX", cfInstanceIndex);
        envValues.put("CF_INSTANCE_ADDR", cfInstanceAddr);
    }

    @GetMapping("/env")
    public Map<String, String> getEnv() throws Exception {
        return envValues;
    }
}
