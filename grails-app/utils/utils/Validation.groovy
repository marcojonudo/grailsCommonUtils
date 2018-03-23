package utils

import grails.validation.Validateable
import org.springframework.validation.FieldError

class Validation {

    /**
     * Checks message validation errors
     * @param  message Message to validate errors from
     * @return         List of FieldError
     */
    static List<FieldError> validateMessage(message) {
        /* Si el mensaje es validable y no valida, se obtienen los errores */
        List<FieldError> errorList = message instanceof Validateable && !message.validate() ? message.errors.fieldErrors : []
        /* Se obtienen aquellos objetos hijos que pueden sar validados */
        List<Object> validateableObjectList = message.properties.values().findAll { isValidateable(it) }.flatten()

        /* Si existen hijos validables, se obtienen sus errores y se añaden a 'errorList' */
        if (validateableObjectList)
            errorList += validateableObjectList.collect { validateMessage(it) }

        return errorList.flatten() as List<FieldError>
    }

    /**
     * Checks message list validation errors
     * @param  messageList List of messages to validate errors from
     * @return             List of FieldError
     */
    static List<FieldError> validateMessageList(List messageList) {
        List<FieldError> errorList = messageList.collect { validateMessage(it) }.flatten() as List<FieldError>

        return errorList
    }

    /**
     * Checks if an object validateable (Validateable object or list)
     * @param  message Message to check if validateable
     * @return         Boolean
     */
    private static boolean isValidateable(message) {
        /* Se sigue iterando si el objeto es validable o si es una lista (con posibles objetos validables) */
        return message instanceof Validateable || message instanceof List
    }

    /**
     * Replaces number elements in String with given arguments
     * Ej. La propiedad [{0}] de la clase [{1}] no puede ser nulo
     * To. La propiedad [satServiceDeviceData] de la clase [class genericservices.SatserviceEvent] no puede ser nulo
     * @param  message Message
     * @param  args    List of arguments to use in message
     * @return         Replaced message
     */
    static String formatValidationErrorString(String message, Object[] args) {
        args.eachWithIndex { arg, int index ->
            message = message.replace("{$index}", "$arg")
        }
        return message
    }

}
