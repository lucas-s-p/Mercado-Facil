package com.ufcg.psoft.mercadofacil.service;

import java.lang.Class;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.InstanceSupplier;
import org.springframework.beans.factory.support.RootBeanDefinition;

/**
 * Bean definitions for {@link ProdutoAlterarPadraoService}.
 */
public class ProdutoAlterarPadraoService__TestContext001_BeanDefinitions {
  /**
   * Get the bean definition for 'produtoAlterarPadraoService'.
   */
  public static BeanDefinition getProdutoAlterarPadraoServiceBeanDefinition() {
    Class<?> beanType = ProdutoAlterarPadraoService.class;
    RootBeanDefinition beanDefinition = new RootBeanDefinition(beanType);
    InstanceSupplier<ProdutoAlterarPadraoService> instanceSupplier = InstanceSupplier.using(ProdutoAlterarPadraoService::new);
    instanceSupplier = instanceSupplier.andThen(ProdutoAlterarPadraoService__TestContext001_Autowiring::apply);
    beanDefinition.setInstanceSupplier(instanceSupplier);
    return beanDefinition;
  }
}
