package inject;

@QualifierInjectTest2
public class InjectTest2 implements MyInject
{
    @Override 
    public String toString()
    {
        return ">>> InjectTest:222 <<<";
    }

    @Override
    public String generateNumber()
    {
        return "222 InjectTest generateNumber";
    }
}
