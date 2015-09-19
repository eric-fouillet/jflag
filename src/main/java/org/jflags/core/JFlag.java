package org.jflags.core;

import java.util.LinkedHashMap;

/**
 * The main class for org.jflags.core.JFlag.
 * <p/>
 * org.jflags.core.JFlag allows to define and parse command line parameters.
 * <p/>
 * Multiple parameter definition styles and parameter types are
 * supported.
 */
public class JFlag
{

    private LinkedHashMap<String, JFlagParam> paramSet;

    private boolean usageBuilt;

    private String usageText;

    public JFlag() {
        paramSet = new LinkedHashMap<String, JFlagParam>();
        usageBuilt = false;
        usageText = null;
    }

    public JFlagParam getParam(String name) throws JFlagException {
        if (paramSet.containsKey( name )) {
            return paramSet.get( name );
        } else {
            return AbstractJFlagParam.NONE;
        }
    }

    private void addParam(JFlagParam param) throws JFlagException {
        final String name = param.getName();
        if (paramSet.containsKey( name ) ) {
            throw new JFlagException( "Parameter already exists " + name );
        }
        paramSet.put( name, param);
        buildUsage();
    }

    /**
     * Create a new string parameter
     * @param name the name of the parameter
     * @param defaultValue the default value of the parameter
     * @param usage the usage text for this parameter
     * @throws JFlagException if any issue occurs when registering the parameter
     */
    public void stringParam(String name, String defaultValue, String usage) throws JFlagException {
        addParam( new StringJFlag( name, defaultValue, usage ) );
    }

    /**
    * Create a new Integer parameter
    * @param name the name of the parameter
    * @param defaultValue the default value of the parameter
    * @param usage the usage text for this parameter
    * @throws JFlagException if any issue occurs when registering the parameter
    */
    public void intParam(String name, Integer defaultValue, String usage) throws JFlagException {
        addParam( new IntJFlag( name, defaultValue, usage ) );
    }

    /**
     * Parse the parameters according to their definition
     * @param args the arguments of the program
     */
    public void parse(String[] args) throws JFlagException
    {
        if (args == null || args.length != paramSet.size()) {
            throw new JFlagException( "Unexpected number of parameters. Usage " + getUsage() );
        }
        if (paramSet.size() > 0) {
            int i = 0;
            for ( JFlagParam param : paramSet.values() ) {
                param.parse(args[i]);
            }
        }
    }

    /**
     * Return the usage text for this command parameters
     */
    public String getUsage() {
        if (!usageBuilt) {
            usageText = buildUsage();
            usageBuilt = true;
        }
        return usageText;
    }

    private String buildUsage() {
        if ( paramSet.size() > 0 ) {
            StringBuilder sb = new StringBuilder();
            paramSet.values()
                    .stream()
                    .forEach( flag -> {
                        sb.append( flag.getName() );
                        sb.append( ": " );
                        sb.append( flag.getUsage() );
                        if ( flag.hasDefaultValue() )
                        {
                            sb.append( "(default: ");
                            sb.append( flag.getDefaultValue() );
                            sb.append( ")");
                        }
                    } );
            return sb.toString();
        } else {
            return "";
        }
    }

}
