package duartqx.com.github.payroll.preload;

import duartqx.com.github.payroll.employees.Employee;
import duartqx.com.github.payroll.employees.EmployeeRepository;
import duartqx.com.github.payroll.orders.Order;
import duartqx.com.github.payroll.orders.OrderRepository;
import duartqx.com.github.payroll.orders.OrderStatus;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class LoadDatabase {

    private static final Logger log =
            LoggerFactory.getLogger(LoadDatabase.class);

    @Bean
    CommandLineRunner initDatabase(EmployeeRepository employeeRepository, OrderRepository orderRepository) {
        return args -> {
            employeeRepository.save(new Employee("Bilbo Baggins", "burglar"));
            employeeRepository.save(new Employee("Frodo Baggins", "thief"));

            employeeRepository.findAll().forEach(
                    employee -> log.info("Preloaded " + employee)
            );

            orderRepository.save(new Order("MacBook Pro", OrderStatus.COMPLETED));
            orderRepository.save(new Order("iPhone", OrderStatus.IN_PROGRESS));

            orderRepository.findAll().forEach(
                    order -> {
                        log.info("Preloaded " + order);
                    }
            );
        };
    }
}
