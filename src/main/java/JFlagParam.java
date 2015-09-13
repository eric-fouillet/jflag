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
     * The type of the parameter
     */
    Type getType();

    /**
     * The help text of the parameter
     */
    String getUsage();
}
