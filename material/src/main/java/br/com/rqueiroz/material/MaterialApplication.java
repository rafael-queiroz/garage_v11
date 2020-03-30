package br.com.rqueiroz.material;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MaterialApplication {

	public static void main(String[] args) {
		SpringApplication.run(MaterialApplication.class, args);
	}

	/*@Bean
	public PluginRegistry<LinkDiscoverer, MediaType> discoverers(
			OrderAwarePluginRegistry<LinkDiscoverer, MediaType> relProviderPluginRegistry) {
		return relProviderPluginRegistry;
	}*/
}
