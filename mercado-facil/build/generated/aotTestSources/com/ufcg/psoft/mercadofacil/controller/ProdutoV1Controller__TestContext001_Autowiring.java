package com.ufcg.psoft.mercadofacil.controller;

import org.springframework.beans.factory.aot.AutowiredFieldValueResolver;
import org.springframework.beans.factory.support.RegisteredBean;

/**
 * Autowiring for {@link ProdutoV1Controller}.
 */
public class ProdutoV1Controller__TestContext001_Autowiring {
  /**
   * Apply the autowiring.
   */
  public static ProdutoV1Controller apply(RegisteredBean registeredBean,
      ProdutoV1Controller instance) {
    instance.produtoAtualizarService = AutowiredFieldValueResolver.forRequiredField("produtoAtualizarService").resolve(registeredBean);
    return instance;
  }
}
