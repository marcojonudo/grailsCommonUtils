package utils

import org.springframework.http.HttpStatus
import org.springframework.validation.FieldError
import utils.builders.MessageBuilder
import utils.builders.StatusDecider
import utils.messages.NotFound
import utils.messages.validation.ValidationErrorMessage

import javax.servlet.http.HttpServletRequest

class BaseController {

    /**
     * Builds generic response model
     * @param object Object to be returned
     * @return       Map with Model content
     */
    Map buildResponseModel(object) {
        return [responseObject: object]
    }

    /**
     * Validates if a message fields are correct and responds with validation error message if necessary
     * @param message Object or list of objects
     * @return        ValidationErrorMessage
     */
    ValidationErrorMessage validateObject(message) {
        ValidationErrorMessage validationErrorMessage = null
        List<FieldError> errors = message instanceof List ? Validation.validateMessageList(message) : Validation.validateMessage(message)
        if (errors) {
            validationErrorMessage = MessageBuilder.buildValidationErrorMessage(errors)
            response.status = StatusDecider.chooseValidationErrorStatus(validationErrorMessage).value()
            render(view: '/errors/validationErrors', model: buildResponseModel(validationErrorMessage))
        }

        return validationErrorMessage
    }

    /**
     * Returns model to render in view and sets status value
     * @param responseObject Object to be returned
     * @param status         Response HttpStatus
     * @return               Map to be returned from the controller action
     */
    def returnServiceInfo(responseObject, HttpStatus status) {
        Map model = null
        response.status = status.value()

        if (responseObject)
            model = buildResponseModel(responseObject)
        else
            render(view: '/notFound', model: buildResponseModel(new NotFound()))

        return model
    }

    /**
     * Returns a Map containing user and customerId headers
     * @param request Received request
     * @return        Map<String, String>
     */
    Map<String, String> getHeaders(HttpServletRequest request) {
        Map<String, String> headersMap = [
                user: request.getHeader(Constants.USER),
                customerId: request.getHeader(Constants.CUSTOMER_ID)
        ]

        return headersMap
    }

}
