package utils.messages.log

import grails.web.servlet.mvc.GrailsParameterMap
import groovy.transform.InheritConstructors

import javax.servlet.http.HttpServletRequest

@InheritConstructors
class RequestLog extends ControllerLog {

    Object requestJson

    RequestLog(HttpServletRequest request, GrailsParameterMap params) {
        super(request, params)
        requestJson = request.JSON ?: null
    }

}
