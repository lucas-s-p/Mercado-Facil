package com.ufcg.psoft.mercadofacil.repository;

import java.lang.Class;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.RootBeanDefinition;

/**
 * Bean definitions for {@link ProdutoVolatilStubRepository}.
 */
public class ProdutoVolatilStubRepository__TestContext001_BeanDefinitions {
  /**
   * Get the bean definition for 'produtoVolatilStubRepository'.
   */
  public static BeanDefinition getProdutoVolatilStubRepositoryBeanDefinition() {
    Class<?> beanType = ProdutoVolatilStubRepository.class;
    RootBeanDefinition beanDefinition = new RootBeanDefinition(beanType);
    beanDefinition.setInstanceSupplier(ProdutoVolatilStubRepository::new);
    return beanDefinition;
  }
}
