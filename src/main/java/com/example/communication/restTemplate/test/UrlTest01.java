package com.example.communication.restTemplate.test;

import lombok.extern.slf4j.Slf4j;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;

// URL class
// web의 주소를 나타내느 class, 이를 통해 식별 또는 네트워크 연결 가능.
// web의 resource를 가져올 수 있다.
@Slf4j
public class UrlTest01 {
    public static void main(String[] args) {
        try {
            URI url = new URI("https://www.naver.com");
            log.info(url.toString());
            log.info(url.getPath());

            // protocol에 등록된 기본 port로 접속했다는 의미
            // http protocol은 default port=80, 사용자가 접속하는 url은 port 80을 씀.
            log.info("{}", url.getPort());

            // 넷 상 자원 읽어오기.
            BufferedReader br = new BufferedReader(new InputStreamReader(
                    url.toURL().openStream()));
            while (true){
                String line = br.readLine();
                if(line==null){
                    break;
                }
                log.info(line);
            }
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (URISyntaxException e) {
            throw new RuntimeException(e);
        }

    }
}
