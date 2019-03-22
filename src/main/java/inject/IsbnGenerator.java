package inject;

import java.util.Random;
import java.util.logging.Logger;
import javax.inject.Inject;
import log.Loggable;

@ThirteenDigits
public class IsbnGenerator implements NumberGenerator
{
    @Inject
    private Logger logger;

    @Loggable
    @Override
    public String generateNumber()
    {
        System.out.println(">>> IsbnGenerator");
        String isbn = "13-84356-" + Math.abs(new Random().nextInt());
        logger.info("Сгенерирован ISBN: " + isbn);
        return isbn;
    }

    public IsbnGenerator()
    {
        System.out.println(">>> IsbnGenerator constructor");
    }
}
