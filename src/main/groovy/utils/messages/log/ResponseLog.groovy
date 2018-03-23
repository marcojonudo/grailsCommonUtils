package utils.messages.log

import grails.web.servlet.mvc.GrailsParameterMap
import groovy.transform.InheritConstructors

import javax.servlet.http.HttpServletRequest

@InheritConstructors
class ResponseLog extends ControllerLog {

    int status
    Object responseJson

    ResponseLog(HttpServletRequest request, GrailsParameterMap params, response, Map model) {
        super(request, params)
        status = response.status
        responseJson = model?.responseObject
    }

}