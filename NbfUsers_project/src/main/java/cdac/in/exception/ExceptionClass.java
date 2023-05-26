package cdac.in.exception;




public class ExceptionClass
extends RuntimeException {

private String message;

public ExceptionClass() {}

public ExceptionClass(String msg)
{
    super(msg);
    this.message = msg;
}
}