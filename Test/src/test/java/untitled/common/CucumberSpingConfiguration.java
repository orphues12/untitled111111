package untitled.common;

import io.cucumber.spring.CucumberContextConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import untitled.TestApplication;

@CucumberContextConfiguration
@SpringBootTest(classes = { TestApplication.class })
public class CucumberSpingConfiguration {}
