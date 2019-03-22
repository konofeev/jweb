package inject;

import java.util.Random;
import java.util.logging.Logger;
import javax.inject.Inject;
import log.Loggable;

@EightDigits
public class IssnGenerator implements NumberGenerator
{
    @Inject
    private Logger logger;

    @Loggable
    @Override
    public String generateNumber()
    {
        String issn = "8-" + Math.abs(new Random().nextInt());
        logger.info("Сгенерирован ISSN: " + issn);
        return issn;
    }
}
