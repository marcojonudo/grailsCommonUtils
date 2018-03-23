package utils.messages.log

import grails.web.servlet.mvc.GrailsParameterMap

import javax.servlet.http.HttpServletRequest

class ControllerLog {

    String uri
    String ip
    String method
    GrailsParameterMap params

    ControllerLog(HttpServletRequest request, GrailsParameterMap params) {
        uri = request.requestURI
        ip = request.getHeader("X-Forwarded-For")
        method = request.method
        this.params = params
    }

}
