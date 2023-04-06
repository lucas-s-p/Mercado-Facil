package com.ufcg.psoft.mercadofacil.controller;

import java.lang.Class;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.InstanceSupplier;
import org.springframework.beans.factory.support.RootBeanDefinition;

/**
 * Bean definitions for {@link ProdutoV1Controller}.
 */
public class ProdutoV1Controller__TestContext001_BeanDefinitions {
  /**
   * Get the bean definition for 'produtoV1Controller'.
   */
  public static BeanDefinition getProdutoVControllerBeanDefinition() {
    Class<?> beanType = ProdutoV1Controller.class;
    RootBeanDefinition beanDefinition = new RootBeanDefinition(beanType);
    InstanceSupplier<ProdutoV1Controller> instanceSupplier = InstanceSupplier.using(ProdutoV1Controller::new);
    instanceSupplier = instanceSupplier.andThen(ProdutoV1Controller__TestContext001_Autowiring::apply);
    beanDefinition.setInstanceSupplier(instanceSupplier);
    return beanDefinition;
  }
}
