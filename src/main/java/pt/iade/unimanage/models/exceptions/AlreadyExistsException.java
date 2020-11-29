package pt.iade.unimanage.models.exceptions;

import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(/*value = HttpStatus.ALREADY_EXISTS*/)
public class AlreadyExistsException extends RuntimeException {
    private static final long serialVersionUID = 5405519104069955535L;
 
    public AlreadyExistsException(String id, String elemType, String idName) {
        super(elemType + " with " + idName + " " + id + " already exists.");
    }
}
