package org.jflags.core;

import java.lang.reflect.Type;

/**
 * Created by 7syd on 19/09/2015.
 */
public class IntJFlag extends AbstractJFlagParam
{
    private Integer defaultValue;
    private Integer value;

    public IntJFlag() {}

    public IntJFlag(String name, Integer defaultValue, String usage) {
        super(name, usage);
        this.defaultValue = defaultValue;
    }

    /**
     * The value of the parameter
     */
    @Override
    public Integer getValue()
    {
        return value;
    }

    /**
     * The default value of the parameter
     */
    @Override
    public Integer getDefaultValue()
    {
        return defaultValue;
    }

    /**
     * The type of the parameter
     */
    @Override
    public Type getType()
    {
        return Integer.class;
    }

    @Override
    public void parse( String param ) throws JFlagException
    {
        try
        {
            value = Integer.valueOf( param );
        }
        catch ( NumberFormatException e )
        {
            throw new JFlagException( "Can not parse parameter " + param + " to integer" );
        }
    }
}
