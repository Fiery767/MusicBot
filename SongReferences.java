
/**
 * Write a description of class SongReferences here.
 *
 * @author Ranju Krishna, Melody Wang
 * @version 11/12/19
 */
public class SongReferences extends MusicBot
{
    /**
    * Holds if statements for song references based on keyword detection
    * @param statement the user statement, assumed to contain partial lyrics to a song
    * @return the response, a random song reference
    */

    public String getResponse(String statement)
    {
        String response = "";
        if (findKeyword(statement, "no", 0) >= 0)
        {
            response = "♪ No, no, no, no, no, no, no \n (Oh, mamma mia, mamma mia) Mamma mia, let me go \n Beelzebub has a devil put aside for me, for me, for me!♪";
        }
        else if (findKeyword(statement, "stop", 0) >= 0)
        {
            response = "♪ Don’t stop me now! I’m having such a good time. I’m having a ball! ♪";
        }
        else if (findKeyword(statement, "weather", 0) >= 0)
        {
            response = "♪ Sun is shinin' in the sky \n There ain't a cloud in sight \n It's stopped rainin' everybody's in the play \n And don't you know It's a beautiful new day, hey hey ♪";
        }
        return response;
    }
}
