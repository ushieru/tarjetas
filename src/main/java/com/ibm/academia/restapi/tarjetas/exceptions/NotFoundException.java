package com.ibm.academia.restapi.tarjetas.exceptions;

public class NotFoundException extends RuntimeException {
    public NotFoundException(String mensaje) {
        super(mensaje);
    }
}
