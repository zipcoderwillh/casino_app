package sneetches.CasinoSpec;

import org.junit.Before;
import org.junit.Test;
import sneetches.Casino.*;
import static org.junit.Assert.*;

/**
 * Created by willhorton on 1/31/16.
 */
public class ValueSpec {

    @Test
    public void testGetRandomValue() {
        Value testValue = Value.getRandomValue();
        assertTrue(testValue instanceof Value);
    }

}
