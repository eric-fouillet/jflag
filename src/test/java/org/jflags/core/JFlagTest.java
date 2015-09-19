package org.jflags.core;

import org.jflags.core.JFlag;
import org.jflags.core.JFlagException;
import org.jflags.core.JFlagParam;
import org.junit.Test;
import static org.assertj.core.api.Assertions.assertThat;  // main one
import static org.assertj.core.api.Assertions.fail; // use when making exception tests
import static org.assertj.core.api.Assertions.failBecauseExceptionWasNotThrown; // idem

/**
 * Test for org.jflags.core.JFlag
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

    @Test
    public void testStringParameterParsing() {
        JFlag flag = new JFlag();
        try
        {
            flag.stringParam( "test", null, "This is a test parameter" );
        } catch ( JFlagException e )
        {
            fail("The parameter should have been created");
        }

        String[] args = new String[] {"abc"};
        try
        {
            flag.parse( args );
        } catch(JFlagException e)
        {
            fail( "Parsing should have been ok" );
        }

        args = new String[] {"abc", "def"};
        try
        {
            flag.parse( args );
            failBecauseExceptionWasNotThrown( JFlagException.class );
        } catch(JFlagException e)
        {
        }
    }


    @Test
    public void testIntParameterParsing() {
        JFlag flag = new JFlag();
        try
        {
            flag.intParam( "test", null, "This is a test parameter" );
        } catch ( JFlagException e )
        {
            fail("The parameter should have been created");
        }

        String[] args = new String[] {"123"};
        try
        {
            flag.parse( args );
        } catch(JFlagException e)
        {
            fail( "Parsing should have been ok" );
        }

        args = new String[] {"abc"};
        try
        {
            flag.parse( args );
            fail( "Exception expected" );
        } catch(JFlagException e)
        {
        }


        args = new String[] {"12.3"};
        try
        {
            flag.parse( args );
            failBecauseExceptionWasNotThrown( JFlagException.class );
        } catch(JFlagException e)
        {
        }
    }

}
