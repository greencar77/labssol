package pkb.springconf.conf;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import pkb.springconf.domain.Alpha;

@Configuration
public class SecondConf extends FirstConf {
	@Bean
//	@Qualifier("ee")
	public Alpha createAlpha() {
		return new Alpha();
	}
}
