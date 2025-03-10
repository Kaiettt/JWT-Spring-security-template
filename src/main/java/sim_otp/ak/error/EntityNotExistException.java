package sim_otp.ak.error;

public class EntityNotExistException extends RuntimeException{
    public EntityNotExistException(String ex){
        super(ex);
    }
}
