package utils

import grails.util.Holders

class CommonFunctionality {

    /**
     * Method to simulate a list of if-elseif in a smart way
     * @param conditionList List with closures where the conditions are defined
     *
     * if (n == 1) return x
     * else if (n == 2) return y
     * else return z
     *
     * List<Closure> conditionList = [
     *     { n == 1 ? additionalInfo.x : null },
     *     { n == 2 ? additionalInfo.y : null },
     *     { additionalInfo.z }
     * ]
     *
     * @param  argument       Evaluated argument (n in the previous example)
     * @param  additionalInfo Additional info to build returned message (optional)
     * @param  index          Default 0, not needed
     * @return                Returned object depending on the conditions
     */
    static recursiveIf(List<Closure> conditionList, int index = 0) {
        def returnObject = conditionList.get(index++)()
        if (!returnObject && index < conditionList.size())
            returnObject = recursiveIf(conditionList, index)

        return returnObject
    }

    /**
     * Gets a message using messageSource
     * @param code         Message code
     * @param argumentList List of arguments to fill the message
     * @return             String containing the message
     */
    static String getMessage(String code, Object[] argumentList) {
        argumentList = argumentList.collect { it ?: '' }
        String message = Holders.grailsApplication.mainContext.getBean('messageSource').getMessage(code, argumentList, Locale.default)
        return message
    }

}