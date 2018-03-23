package utils.messages.validation

class ValidationErrorMessage {

    String message
    int total
    List<ValidationError> errorList

}

class ValidationError {

    String message
    String className
    String field
    def rejectedValue

}