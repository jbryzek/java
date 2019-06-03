package justyna.lab11.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NO_CONTENT,reason = "Empty result")
public class Status204 extends RuntimeException{
}
