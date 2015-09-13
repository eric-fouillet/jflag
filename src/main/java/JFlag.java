import java.util.LinkedHashMap;

/**
 * The main class for JFlag.
 * <p/>
 * JFlag allows to define and parse command line parameters.
 * <p/>
 * Multiple parameter definition styles and parameter types are
 * supported.
 */
public class JFlag
{

    private LinkedHashMap<String, JFlagParam> paramSet;

    public JFlag() {
        paramSet = new LinkedHashMap<String, JFlagParam>();
    }

    public JFlagParam getParam(String name) throws JFlagException {
        if (paramSet.containsKey( name )) {
            return paramSet.get( name );
        } else {
            throw new JFlagException( "No parameter registered with name " + name );
        }
    }

    private void addParam(JFlagParam param) throws JFlagException {
        final String name = param.getName();
        if (paramSet.containsKey( name ) ) {
            throw new JFlagException( "Parameter already exists " + name );
        }
        paramSet.put( name, param);
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

}
