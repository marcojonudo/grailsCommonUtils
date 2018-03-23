package utils.messages

import grails.web.databinding.DataBinder

class BasePogo implements DataBinder {

    BasePogo(Map message) {
        bindData(this, message)
    }

}
