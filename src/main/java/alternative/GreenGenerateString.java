package alternative;

import javax.enterprise.inject.Alternative;

@Alternative
public class GreenGenerateString implements GenerateString
{
    @Override
    public String generate()
    {
        return "Generate green (alternative) string";
    } 
}
