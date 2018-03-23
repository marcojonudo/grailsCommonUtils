package utils.messages.log

import grails.converters.JSON

class Log {

    String step
    String duration
    Object message

    @Override
    String toString() {
        return printJson()
    }

    /**
     * Prints Log object as JSON. Done in different method to avoid mocking in tests
     * @return
     */
    String printJson() {
        return "${this as JSON}"
    }

}
