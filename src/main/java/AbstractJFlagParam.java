import java.lang.reflect.Type;

/**
 * Base class for all parameters implementations
 */
public abstract class AbstractJFlagParam implements JFlagParam
{
    private String name;
    private String usage;

    public AbstractJFlagParam(String name, String usage) {
        this.name = name;
        this.usage = usage;
    }

    /**
     * The name of the parameter
     */
    @Override
    public String getName()
    {
        return name;
    }

    /**
     * The help text of the parameter
     */
    @Override
    public String getUsage()
    {
        return usage;
    }

    /**
     * Return true if the default value is not null
     */
    @Override
    public boolean hasDefaultValue()
    {
        return getDefaultValue() != null;
    }
}
