package utils.builders

import org.springframework.http.HttpStatus
import utils.messages.validation.ValidationErrorMessage

abstract class StatusDecider {

    abstract HttpStatus chooseStatus(messageType = null, message)

    /**
     * Chooses validation error HTTP status
     * @param  validationErrorMessage ValidationErrorMessage
     * @return                        HttpStatus
     */
    static HttpStatus chooseValidationErrorStatus(ValidationErrorMessage validationErrorMessage) {
        /* Los errors por campos null devuelven un 400, 422 en otro caso */
        boolean unprocessable = validationErrorMessage.errorList.rejectedValue.find { it }
        HttpStatus status = unprocessable ? HttpStatus.UNPROCESSABLE_ENTITY : HttpStatus.BAD_REQUEST

        return status
    }

}
