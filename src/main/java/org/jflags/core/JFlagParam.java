package org.jflags.core;

import java.lang.reflect.Type;

/**
 * An interface for supported command line parameters
 */
public interface JFlagParam
{

    /**
     * The name of the parameter
     */
    String getName();

    /**
     * The value of the parameter
     */
    Object getValue();

    /**
     * The default value of the parameter
     */
    Object getDefaultValue();

    /**
     * Return true if the default value is not null
     */
    boolean hasDefaultValue();

    /**
     * The type of the parameter
     */
    Type getType();

    /**
     * The help text of the parameter
     */
    String getUsage();

    /**
     * Parse a parameter, passed as a string
     * TODO handle "-" options
     */
    void parse(String param) throws JFlagException;
}
