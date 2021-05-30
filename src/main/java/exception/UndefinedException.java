package exception;

public class UndefinedException extends Exception{
    @Override
    public String getMessage(){
        return "Verwendung von undefinierten Variablen nicht möglich";
    }
}
