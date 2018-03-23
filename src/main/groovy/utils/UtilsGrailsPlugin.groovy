package utils

import grails.plugins.*

class UtilsGrailsPlugin extends Plugin {

    // the version or versions of Grails the plugin is designed for
    def grailsVersion = "3.3.2 > *"
    // resources that are excluded from plugin packaging
    def pluginExcludes = [
            "grails-app/views/error.gsp"
    ]

    def title = "Commonresources" // Headline display name of the plugin
    def author = "Marco Martínez Ávila"
    def authorEmail = "marco.martinez@bq.com"
    def description = '''\
This plugin groups the main functionality used in controllers, including data binding, validation and data response
'''

    // URL to the plugin's documentation
    def documentation = "http://grails.org/plugin/commonresources"

    // Extra (optional) plugin metadata

    // License: one of 'APACHE', 'GPL2', 'GPL3'
//    def license = "APACHE"

    // Details of company behind the plugin (if there is one)
//    def organization = [ name: "My Company", url: "http://www.my-company.com/" ]

    // Any additional developers beyond the author specified above.
//    def developers = [ [ name: "Joe Bloggs", email: "joe@bloggs.net" ]]

    // Location of the plugin's issue tracker.
//    def issueManagement = [ system: "JIRA", url: "http://jira.grails.org/browse/GPMYPLUGIN" ]

    // Online location of the plugin's browseable source code.
//    def scm = [ url: "http://svn.codehaus.org/grails-plugins/" ]

//    Closure doWithSpring() { {->
//        }
//    }
//
//    void doWithDynamicMethods() {
//    }
//
//    void doWithApplicationContext() {
//    }
//
//    void onChange(Map<String, Object> event) {
//        // watching is modified and reloaded. The event contains: event.source,
//        // event.application, event.manager, event.ctx, and event.plugin.
//    }
//
//    void onConfigChange(Map<String, Object> event) {
//        // The event is the same as for 'onChange'.
//    }
//
//    void onShutdown(Map<String, Object> event) {
//    }

}
