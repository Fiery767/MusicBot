
/**
 * Write a description of class MusicTalk here.
 *
 * @author Ranju Krishna, Melody Wang
 * @version 11/12/19
 */
public class MusicTalk extends MusicBot
{
    /**
     * Gives a response to a user statement
     * 
     * @param statement
     *            the user statement
     * @return a response based on the rules given
     */
    public String getResponse(String statement)
    {
        String response = "";
        if (findKeyword(statement, "listening to", 0) >= 0)
        {
            response = listeningTo(statement);
        }
        else if (findKeyword(statement, "song recommendation", 0) >= 0)
        {
            response = songRec(statement);
        }
        return response;
    }
    /**
      * Take a statement with “listening to" and returns “I’m listening to <random song>!”
      * random song comes from an array of options: The Big Time Rush Theme Song, Bohemian Rhapsody, The Sign from Pitch Perfect, or Whatcha Say by Jason Derulo
      * @param statement the user statement, assumed to contain “listening to”
      * @return the response with a random song
      */

    public String listeningTo(String statement)
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
            songChoice = "The Big Time Rush theme song";
        }
        else if (whichResponse == 1)
        {
            songChoice = "Bohemian Rhapsody";
        }
        else if (whichResponse == 2)
        {
            songChoice = "The Sign from Pitch Perfect";
        }
        else if (whichResponse == 3)
        {
            songChoice = "Whatcha Say by Jason Derulo";
        }
        return "I'm listening to " + songChoice + "!";
    }
    /**
       * Take a statement with “song recommendation” and returns a random song from a list
       * @param statement the user statement, assumed to contain “song recommendation”
       * @return the response with a random song recommendations: “How Was Your Day?” by Mellow Fellow and Clairo, “I Want You Back by the Jackson 5, “This Love” by Maroon 5, “Treacherous Doctor” by Wallows, and “Africa” by Toto
       */
    public String songRec(String statement)
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
        int psn = findKeyword (statement, "song recommendation", 0);
        String restOfStatement = statement.substring(psn + 19).trim();
        final int NUMBER_OF_RESPONSES = 5;
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
        else if (whichResponse == 4)
        {
            songChoice = "Africa by Toto";
        }
        return "I recommend " + songChoice + ". It's super good!";
    
    }
}
