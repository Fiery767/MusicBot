
/**
 * Write a description of class MusicTalk here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class MusicTalk extends MusicBot
{
    public String getResponse(String statement)
    {
        super.getResponse(statement);
        String response = "";
        if (findKeyword(statement, "listening to", 0) >= 0)
        {
            response = listeningTo(statement);
        }
        return response;
    }
    
    private String listeningTo(String statement)
    {
        //  Remove the final period, if there is one
        statement = statement.trim();
        String lastChar = statement.substring(statement
                .length() - 1);
        if (lastChar.equals("."))
        {
            statement = statement.substring(0, statement
                    .length() - 1);
        }
        int psn = findKeyword (statement, "listening to", 0);
        String restOfStatement = statement.substring(psn + 12).trim();
        final int NUMBER_OF_RESPONSES = 4;
        double r = Math.random();
        int whichResponse = (int)(r * NUMBER_OF_RESPONSES);
        String songChoice = "";
        if (whichResponse == 0)
        {
            songChoice = "How Was Your Day? by Mellow Fellow and Clairo";
        }
        else if (whichResponse == 1)
        {
            songChoice = "I Want You Back by the Jackson 5";
        }
        else if (whichResponse == 2)
        {
            songChoice = "This Love by Maroon 5";
        }
        else if (whichResponse == 3)
        {
            songChoice = "Treacherous Doctor by Wallows";
        }
        return "I'm listening to " + songChoice + "!";
    }

    
}
