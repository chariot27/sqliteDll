package org.ars.sqlite_dll;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(
	exclude = {
		org.springframework.boot.autoconfigure.data.jdbc.JdbcRepositoriesAutoConfiguration.class
	}
)
public class SqliteDllApplication {

	public static void main(String[] args) {
		SpringApplication.run(SqliteDllApplication.class, args);
	}

}
