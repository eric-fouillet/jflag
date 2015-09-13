import org.junit.Test;
import static org.assertj.core.api.Assertions.assertThat;  // main one
import static org.assertj.core.api.Assertions.atIndex; // for List assertions
import static org.assertj.core.api.Assertions.entry;  // for Map assertions
import static org.assertj.core.api.Assertions.tuple; // when extracting several properties at once
import static org.assertj.core.api.Assertions.fail; // use when making exception tests
import static org.assertj.core.api.Assertions.failBecauseExceptionWasNotThrown; // idem
import static org.assertj.core.api.Assertions.filter; // for Iterable/Array assertions
import static org.assertj.core.api.Assertions.offset; // for floating number assertions
import static org.assertj.core.api.Assertions.anyOf; // use with Condition
import static org.assertj.core.api.Assertions.contentOf; // use with File assertions

/**
 * Test for JFlag
 */
public class JFlagTest
{
    @Test
    public void testParameterDefinition() {
        JFlag flag = new JFlag();
        try
        {
            flag.stringParam( "test", null, "This is a test parameter" );
        } catch ( JFlagException e )
        {
            fail("The parameter should have been created");
        }

        try
        {
            flag.stringParam( "test", null, "This is a test parameter" );
            failBecauseExceptionWasNotThrown( JFlagException.class );
        } catch ( JFlagException e )
        {
        }

        try
        {
            JFlagParam flagParam = flag.getParam( "test" );
            assertThat( flagParam ).isNotNull();
            assertThat( flagParam.getName() ).isEqualTo( "test" );
        } catch ( JFlagException e )
        {
            fail("Parameter should have been found");
        }
    }

}
