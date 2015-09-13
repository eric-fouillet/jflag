import java.lang.reflect.Type;

/**
 * A string parameter
 */
public class StringJFlag extends AbstractJFlagParam
{

    private String defaultValue;
    private String value;

    public StringJFlag(String name, String defaultValue, String usage) {
        super(name, usage);
        this.defaultValue = defaultValue;
    }

    /**
     * The value of the parameter
     */
    @Override
    public Object getValue()
    {
        return value;
    }

    /**
     * The default value of the parameter
     */
    @Override
    public Object getDefaultValue()
    {
        return defaultValue;
    }

    /**
     * The type of the parameter
     */
    @Override
    public Type getType()
    {
        return String.class;
    }

}
