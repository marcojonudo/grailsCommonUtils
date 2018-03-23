package utils.interceptors

import groovy.time.TimeCategory
import utils.Constants
import utils.messages.log.Log
import utils.messages.log.RequestLog
import utils.messages.log.ResponseLog

class LogInterceptor {

    Date refDate

    LogInterceptor() {
        matchAll()
    }

    boolean before() {
        refDate = new Date()
        RequestLog requestLog = new RequestLog(request, params)
        log.info("${new Log(step: Constants.START, message: requestLog)}")
        return true
    }

    boolean after() {
        ResponseLog responseLog = new ResponseLog(request, params, response, model)
        log.info("${new Log(step: Constants.FINISH, duration: TimeCategory.minus(new Date(), refDate), message: responseLog)}")
        return true
    }

}
