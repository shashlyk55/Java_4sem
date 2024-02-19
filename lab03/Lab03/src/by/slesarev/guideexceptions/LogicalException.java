package by.slesarev.guideexceptions;

public class LogicalException extends Exception{
    private String _message;
    @Override
    public String getMessage() {
        return _message;
    }
    public LogicalException(String message){
        this._message = message;
    }
}
