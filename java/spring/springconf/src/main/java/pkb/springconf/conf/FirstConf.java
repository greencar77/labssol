package pkb.springconf.conf;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import pkb.springconf.domain.Alpha;

//@Configuration
public class FirstConf {
	@Bean
	public Alpha createAlpha() {
		return new Alpha();
	}
}
