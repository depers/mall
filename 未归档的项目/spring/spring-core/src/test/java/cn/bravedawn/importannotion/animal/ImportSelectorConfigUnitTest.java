package cn.bravedawn.importannotion.animal;


import cn.bravedawn.importannotation.animal.*;
import cn.bravedawn.importannotation.method2.Horse;
import cn.bravedawn.importannotation.method2.ImportSelectorConfiguration;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = { ImportSelectorConfiguration.class })
public class ImportSelectorConfigUnitTest {

    @Autowired
    ApplicationContext context;

    @Test
    void givenImportedBeans_whenGettingEach_shallFindIt() {
        assertThatBeanExists("loin", Loin.class);
        assertThatBeanExists("bug", Bug.class);
        assertThatBeanExists("horse", Horse.class);

        assertFalse(context.containsBean("bird"));
    }

    private void assertThatBeanExists(String beanName, Class<?> beanClass) {
        assertTrue(context.containsBean(beanName));
        assertNotNull(context.getBean(beanClass));
    }
}
