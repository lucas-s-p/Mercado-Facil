package com.ufcg.psoft.mercadofacil;

import java.lang.Class;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.context.annotation.ConfigurationClassUtils;

/**
 * Bean definitions for {@link MercadoFacilApplication}.
 */
public class MercadoFacilApplication__TestContext001_BeanDefinitions {
  /**
   * Get the bean definition for 'mercadoFacilApplication'.
   */
  public static BeanDefinition getMercadoFacilApplicationBeanDefinition() {
    Class<?> beanType = MercadoFacilApplication.class;
    RootBeanDefinition beanDefinition = new RootBeanDefinition(beanType);
    ConfigurationClassUtils.initializeConfigurationClass(MercadoFacilApplication.class);
    beanDefinition.setInstanceSupplier(MercadoFacilApplication$$SpringCGLIB$$0::new);
    return beanDefinition;
  }
}
