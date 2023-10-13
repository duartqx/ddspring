package duartqx.com.github.payroll.exceptions.NotFound;

public class NotFoundException extends RuntimeException {

    public NotFoundException(Long id) {
        super("{\"error\": \"Not Found\"}");
    }
}
