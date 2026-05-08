package springcontext.conf;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springcontext.domain.Alpha;

@Configuration
public class SecondConf extends FirstConf {
	@Bean
//	@Qualifier("ee")
	public Alpha createAlpha() {
		return new Alpha();
	}
}
