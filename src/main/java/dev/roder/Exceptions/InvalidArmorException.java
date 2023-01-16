package dev.roder.Exceptions;

/**
 * Exception to be used for when Invalid armor is
 * attempted to be equipped
 */
public class InvalidArmorException extends Exception{
    public InvalidArmorException(String message){
        super(message);
    }
}
