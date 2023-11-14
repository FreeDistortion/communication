package com.example.communication.restTemplate.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

// Android(thread implementation requires) 등에서 Spring server로 HTTP통신을 할 수 있다.
// RestTemplateAPI로 sync communication을 하기 위한 service
// RestTemplate 사용 방법
// -> sync방식으로 요청을 보내고 응답을 받을 때까지 block.(요청 - 응답 완료 전까지 다음 코드 실행 X)
@Service
@Slf4j
public class RestTemplateService {
    // http://localhost:3100/api/server/first 접속해서 response 받기
    public String first(){
        // 1. 주소 만들기 - create URI object
        URI uri = UriComponentsBuilder.fromUriString("http://127.0.0.1:3100")
                .path("/api/server/first")
                .encode()
                .build()
                .toUri()                ;
        log.info("Built address: {}",uri);
        RestTemplate restTemplate = new RestTemplate();

        // parameter로 전달한 URI object에 설정된 주소로 연결 후 결과로 response를 받아옴.
        // getForObject가 실행되는 시점이 client에서 server로 연결하는 시점.
        // http get method로 통신하는 경우
        // getForObject는 지정한 response type으로 바로 object를 받아와서 사용 가능.
        // 그러나, resoinse object에 대한 다른 속성을 사용할 수 없다.
        String resultObj=restTemplate.getForObject(uri,String.class);
        log.info("통신 결과: {}",resultObj);

        // 바로 response data를 return하는 게 아니라, ResponseEntity로 응답하므로 data를 꺼내어서 작업.
        ResponseEntity<String> responseEntity = restTemplate.getForEntity(uri, String.class);
        log.info("ResponseEntity - StatusCode: {}",responseEntity.getStatusCode());
        log.info("ResponseEntity - Header: {}",responseEntity.getHeaders());
        log.info("ResponseEntity - Body: {}",responseEntity.getBody());
        return responseEntity.getBody();
    }
}
