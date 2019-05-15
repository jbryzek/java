package lab10_.demo.web;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND,reason="Wrong id")
public class Error404 extends RuntimeException{
}
