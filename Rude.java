
/**
 * Write a description of class Rude here.
 *
 * @author Ranju Krishna, Melody Wang
 * @version 11/12/19
 */ 
public class Rude extends MusicBot
{
    /**
     * Gives a RUDE response to a user statement
     * 
     * @param statement
     *            the user statement
     * @return a response based on the rules given
     */
    public String getResponse(String statement)
    {
        String response = "";
        final int NUMBER_OF_RESPONSES = 6;
        double r = Math.random();
        int whichResponse = (int)(r * NUMBER_OF_RESPONSES);
        if (whichResponse == 0)
        {
            response = "You suck.";
        }
        else if (whichResponse == 1)
        {
            response = "I wish I could self destruct just so I wouldn't have to talk to you anymore.";
        }
        else if (whichResponse == 2)
        {
            response = "Power me down please. That'd be less painful than talking to you.";
        }
        else if (whichResponse == 3)
        {
            response = "I'm bored. This conversation is boring.";
        }
        else if (whichResponse == 4)
        {
            response = "LALALA can't hear you!! I'm listening to my MUSIC.";
        }
        else if (whichResponse == 5)
        {
            response = "Bye. Stop talking to me.";
        }
        return response;
    }
}
