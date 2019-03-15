package io.daocloud.picture.controller;

import java.io.IOException;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.http.MediaType;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PictureController {

  @GetMapping(value = "/", produces = MediaType.IMAGE_JPEG_VALUE)
  @ResponseBody
  public byte[] picture() throws IOException {
    Resource cpr = new ClassPathResource("static/picture.jpg");
    return FileCopyUtils.copyToByteArray(cpr.getInputStream());
  }

  public String hello(){
    return "hello dcs";
  }
}


