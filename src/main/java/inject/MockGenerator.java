package inject;

import java.util.Random;
import java.util.logging.Logger;
import javax.enterprise.inject.Alternative;
import javax.inject.Inject;
import log.Loggable;

@Alternative
@ThirteenDigits
public class MockGenerator implements NumberGenerator
{
    @Inject
    private Logger logger;

    @Loggable
    public String generateNumber()
    {
        String mock = "MOCK-" + Math.abs(new Random().nextInt());
        logger.info("Сгенерирован Mock 999 : " + mock);
        return mock;
    }
}
