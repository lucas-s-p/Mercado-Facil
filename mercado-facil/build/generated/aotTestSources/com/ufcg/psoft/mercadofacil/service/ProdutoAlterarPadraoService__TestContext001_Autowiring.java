package com.ufcg.psoft.mercadofacil.service;

import org.springframework.beans.factory.aot.AutowiredFieldValueResolver;
import org.springframework.beans.factory.support.RegisteredBean;

/**
 * Autowiring for {@link ProdutoAlterarPadraoService}.
 */
public class ProdutoAlterarPadraoService__TestContext001_Autowiring {
  /**
   * Apply the autowiring.
   */
  public static ProdutoAlterarPadraoService apply(RegisteredBean registeredBean,
      ProdutoAlterarPadraoService instance) {
    instance.produtoRepository = AutowiredFieldValueResolver.forRequiredField("produtoRepository").resolve(registeredBean);
    return instance;
  }
}
