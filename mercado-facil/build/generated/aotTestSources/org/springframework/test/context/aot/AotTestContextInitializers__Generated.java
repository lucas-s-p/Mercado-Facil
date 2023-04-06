package org.springframework.test.context.aot;

import com.ufcg.psoft.mercadofacil.MercadoFacilApplicationTests__TestContext001_ApplicationContextInitializer;
import com.ufcg.psoft.mercadofacil.controller.ProdutoV1ControllerTests__TestContext002_ApplicationContextInitializer;
import java.lang.Class;
import java.lang.String;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;
import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * Generated mappings for {@link AotTestContextInitializers}.
 */
public class AotTestContextInitializers__Generated {
  public static Map<String, Supplier<ApplicationContextInitializer<? extends ConfigurableApplicationContext>>> getContextInitializers(
      ) {
    Map<String, Supplier<ApplicationContextInitializer<? extends ConfigurableApplicationContext>>> map = new HashMap<>();
    map.put("com.ufcg.psoft.mercadofacil.MercadoFacilApplicationTests", () -> new MercadoFacilApplicationTests__TestContext001_ApplicationContextInitializer());
    map.put("com.ufcg.psoft.mercadofacil.repository.LoteRepositoryTests", () -> new MercadoFacilApplicationTests__TestContext001_ApplicationContextInitializer());
    map.put("com.ufcg.psoft.mercadofacil.controller.ProdutoV1ControllerTests", () -> new ProdutoV1ControllerTests__TestContext002_ApplicationContextInitializer());
    map.put("com.ufcg.psoft.mercadofacil.controller.ProdutoV1ControllerTests$ProdutoValidacaoCamposObrigatorios", () -> new ProdutoV1ControllerTests__TestContext002_ApplicationContextInitializer());
    map.put("com.ufcg.psoft.mercadofacil.controller.ProdutoV1ControllerTests$ProdutoValidacaoCodigoDeBarras", () -> new ProdutoV1ControllerTests__TestContext002_ApplicationContextInitializer());
    map.put("com.ufcg.psoft.mercadofacil.controller.ProdutoV1ControllerTests$ProdutoValidacaoRegrasDoPreco", () -> new ProdutoV1ControllerTests__TestContext002_ApplicationContextInitializer());
    return map;
  }

  public static Map<String, Class<? extends ApplicationContextInitializer<?>>> getContextInitializerClasses(
      ) {
    Map<String, Class<? extends ApplicationContextInitializer<?>>> map = new HashMap<>();
    map.put("com.ufcg.psoft.mercadofacil.MercadoFacilApplicationTests", MercadoFacilApplicationTests__TestContext001_ApplicationContextInitializer.class);
    map.put("com.ufcg.psoft.mercadofacil.repository.LoteRepositoryTests", MercadoFacilApplicationTests__TestContext001_ApplicationContextInitializer.class);
    map.put("com.ufcg.psoft.mercadofacil.controller.ProdutoV1ControllerTests", ProdutoV1ControllerTests__TestContext002_ApplicationContextInitializer.class);
    map.put("com.ufcg.psoft.mercadofacil.controller.ProdutoV1ControllerTests$ProdutoValidacaoCamposObrigatorios", ProdutoV1ControllerTests__TestContext002_ApplicationContextInitializer.class);
    map.put("com.ufcg.psoft.mercadofacil.controller.ProdutoV1ControllerTests$ProdutoValidacaoCodigoDeBarras", ProdutoV1ControllerTests__TestContext002_ApplicationContextInitializer.class);
    map.put("com.ufcg.psoft.mercadofacil.controller.ProdutoV1ControllerTests$ProdutoValidacaoRegrasDoPreco", ProdutoV1ControllerTests__TestContext002_ApplicationContextInitializer.class);
    return map;
  }
}
