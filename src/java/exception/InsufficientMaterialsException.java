/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package exception;

/**
 *
 * @author Irina
 */
public class InsufficientMaterialsException extends RuntimeException {
    public InsufficientMaterialsException(String message) {
        super(message);
    }
}