package inject;

@QualifierInjectTest
public class InjectTest implements MyInject
{
    @Override
    public String toString()
    {
        return ">>> InjectTest:111 <<<";
    }

    @Override
    public String generateNumber()
    {
        return "111 InjectTest generateNumber";
    }
}
