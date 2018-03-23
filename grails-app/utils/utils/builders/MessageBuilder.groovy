package utils.builders

import org.springframework.validation.FieldError
import utils.CommonFunctionality
import utils.Constants
import utils.Validation
import utils.messages.validation.ValidationError
import utils.messages.validation.ValidationErrorMessage

abstract class MessageBuilder {

    abstract buildMessage(messageType, message)

    /**
     * Builds validation errorList message
     * @param  errorList List of validation errorList
     * @return           ValidationErrorMessage
     */
    static ValidationErrorMessage buildValidationErrorMessage(List<FieldError> errorList) {
        ValidationErrorMessage validationErrorMessage = new ValidationErrorMessage(
                message: CommonFunctionality.getMessage(Constants.VALIDATION_ERROR),
                total: errorList.size()
        )

        validationErrorMessage.errorList = errorList.collect {
            new ValidationError(
                    message: Validation.formatValidationErrorString(it.defaultMessage, it.arguments),
                    className: it.objectName.split('\\.').last(),
                    field: it.field,
                    rejectedValue: it.rejectedValue
            )
        }

        return validationErrorMessage
    }

}
