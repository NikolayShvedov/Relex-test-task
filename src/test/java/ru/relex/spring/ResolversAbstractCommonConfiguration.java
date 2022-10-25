package ru.relex.spring;

import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = RelexTestTaskJavaApplication.class)
@AutoConfigureMockMvc
public abstract class ResolversAbstractCommonConfiguration {

}
