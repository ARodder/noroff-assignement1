package dev.roder.Exceptions;

/**
 * Exception to be used for when Invalid weapon is
 * attempted to be equipped
 */
public class InvalidWeaponException extends Exception {
    public InvalidWeaponException(String message) {
        super(message);
    }
}
