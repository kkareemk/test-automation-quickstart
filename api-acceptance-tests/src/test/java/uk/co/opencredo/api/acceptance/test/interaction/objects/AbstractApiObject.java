package uk.co.opencredo.api.acceptance.test.interaction.objects;

import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;
import uk.co.opencredo.api.acceptance.test.common.ServiceStatusResponse;

import java.io.IOException;
import java.util.Arrays;

public abstract class AbstractApiObject {
    protected String path;

    @Autowired
    RestTemplate restTemplate;

    public AbstractApiObject (String path) {
        this.path = path;
    }

    public ResponseEntity<String> httpRequest (HttpMethod method, String url) {

        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        HttpEntity<String> entity = new HttpEntity<>("parameters", headers);

        return restTemplate.exchange(url, HttpMethod.GET, entity, String.class);
    }
}