package io.daocloud.picture;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

import io.daocloud.picture.controller.HelloController;
import io.daocloud.picture.controller.PictureController;
import io.daocloud.picture.controller.ServiceController;
import java.io.IOException;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PictureApplicationTests {

  @InjectMocks
  private PictureController pictureController;

  @InjectMocks
  private HelloController helloController;

  @InjectMocks
  private ServiceController serviceController;

  private MockMvc mockMvc;

  public PictureApplicationTests() {
  }

  @Before
  public void setUp() {
    MockitoAnnotations.initMocks(this);
    mockMvc = MockMvcBuilders.standaloneSetup(pictureController).build();
  }

  @Test
  public void getPicture() throws Exception {
    MvcResult result = mockMvc.perform(MockMvcRequestBuilders.get("/")).andExpect(
        MockMvcResultMatchers.status().isOk()).andDo(print()).andReturn();
  }

  @Test
  public void testHello() {
    Assert.assertEquals("hello dcs", pictureController.hello());
  }

  @Test
  public void testYahaha(){
    Assert.assertEquals("yahaha",helloController.yahaha());
  }

  @Test
  public void testAdd(){
    Assert.assertEquals("add",serviceController.add());
  }
}
