package springcontext.conf;

import org.springframework.context.annotation.Bean;

import springcontext.domain.Alpha;

//@Configuration
public class FirstConf {
	@Bean
	public Alpha createAlpha() {
		return new Alpha();
	}
}
