package knight.arkham.practica10.servicios;

// clase principal para tratar los errores de manejo de archivos
public class StorageException extends RuntimeException {
    public StorageException(String message) {
        super(message);
    }

    public StorageException(String message, Throwable cause) {
        super(message, cause);
    }
}
