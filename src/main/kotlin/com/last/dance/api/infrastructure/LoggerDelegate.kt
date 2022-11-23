package com.last.dance.api.infrastructure

import kotlin.reflect.KProperty
import org.slf4j.Logger
import org.slf4j.LoggerFactory

class LoggerDelegate {
    operator fun getValue(thisRef: Any, property: KProperty<*>): Logger {
        return LoggerFactory.getLogger(thisRef.javaClass)
    }
}
