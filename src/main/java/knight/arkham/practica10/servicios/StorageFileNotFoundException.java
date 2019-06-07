package knight.arkham.practica10.servicios;

// Esta clase es la encargada de manejar los errores de los archivos subidos en
// en el controlador, hereda de storageException
public class StorageFileNotFoundException extends StorageException {

    public StorageFileNotFoundException(String message) {
        super(message);
    }

    public StorageFileNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}
