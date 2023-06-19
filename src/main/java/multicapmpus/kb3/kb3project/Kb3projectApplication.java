package multicapmpus.kb3.kb3project;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import multicapmpus.kb3.kb3project.entity.Budget;
import multicapmpus.kb3.kb3project.mapper.BudgetMapper;
import multicapmpus.kb3.kb3project.service.BudgetService;

@SpringBootApplication
public class Kb3projectApplication {
	
	public static void main(String[] args) {
		ConfigurableApplicationContext context=SpringApplication.run(Kb3projectApplication.class, args);
		context.getBean(Kb3projectApplication.class).execute();
	}

	private void execute() {
	}



}