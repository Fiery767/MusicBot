/**
 * A program to carry on conversations with a human user.
 * This version:
 *<ul><li>
 *      Uses advanced search for keywords 
 *</li><li>
 *      Will transform statements as well as react to keywords
 *</li></ul>
 * @author Ranju Krishna, Melody Wang
 * @version 11/12/19
 *
 */
public class MusicBot
{
    /**
     * Get a default greeting   
     * @return a greeting
     */ 
    public String getGreeting()
    {
        return "Hello, let's talk about music! What do you like?";
    }
    
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
        if (statement.length() == 0)
        {
            response = "Say something, please.";
        }
        // Responses which require transformations
        else if (findKeyword(statement, "I don\'t like", 0) >= 0)
        {
            response = transformDislikeStatement(statement);
        }
        
        else if (findKeyword(statement, "I like", 0) >= 0)
        {
            response = transformLikeStatement(statement);
        }

        else if (findKeyword(statement, "I hate", 0) >= 0)
        {
            response = transformHateStatement(statement);
        }
        
        else if (findKeyword(statement, "I love", 0) >= 0)
        {
            response = transformLoveStatement(statement);
        }
        
        else if (findKeyword(statement, "That\'s", 0) >= 0)
        {
            response = transformThatStatement(statement);
        }
        
        else if (findKeyword(statement, "listening to", 0) >= 0 || findKeyword(statement, "song recommendation", 0) >= 0)
        {
            MusicTalk talk = new MusicTalk();
            System.out.println(talk.getResponse(statement));
        }
        else if (findKeyword(statement, "no", 0) >= 0 || findKeyword(statement, "stop", 0) >= 0 || findKeyword(statement, "weather", 0) >= 0)
        {
            SongReferences reference = new SongReferences();
            System.out.println(reference.getResponse(statement));
        }
        else if (findKeyword(statement, "do you have", 0) >= 0)
        {
            response = transformDoYouHaveStatement(statement);
        }
        else if (statement.indexOf("?") >= 0)
        {
            response = "Good question. I don't know.";
        }
        else
        {
            response = getRandomResponse();
        }
        return response;
    }
    
    /**
     * Take a statement with "I don't like <something>." and transform it into 
     * "Oh. I don't like <something> either."
     * @param statement the user statement, assumed to contain "I don't like"
     * @return the transformed statement
     */
    private String transformDislikeStatement(String statement)
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
        if (findKeyword(statement, "I don\'t like you", 0) >=0 )
        {
            Rude rude = new Rude();
            return rude.getResponse(statement);
        }
        else
        {
            int psn = findKeyword (statement, "I don\'t like", 0);
            String restOfStatement = statement.substring(psn + 12).trim();
            return "Oh. I don\'t like " + restOfStatement + " either.";
        }
    }
    
    /**
     * Take a statement with "I like <something>." and transform it into
     * "I like <something> too! Wow we have so much in common!"
     * @param statement the user statement, assumed to contain "I like"
     * @return the transformed statement
     */
    private String transformLikeStatement(String statement)
    {
        // Remove the final period, if there is one
        statement = statement.trim();
        String lastChar = statement.substring(statement.length() - 1);
        if (lastChar.equals("."))
        {
            statement = statement.substring(0, statement.length() - 1);
        }
        int psn = findKeyword (statement, "I like", 0);
        String restOfStatement = statement.substring(psn + 6).trim();
        return "I like " + restOfStatement + " too! Wow we have so much in common!";
    }
    
    /**
     * Take a statement with "I hate <something>." and transform it into
     * "I hate <something> too."
     * Exception if the statement is "I hate The Beatles" returns a special response
     * @param statement the user statement, assumed to contain "I hate"
     * @return the transformed statement
     */
    private String transformHateStatement(String statement)
    {
        // Remove the final period, if there is one
        statement = statement.trim();
        String lastChar = statement.substring(statement.length() - 1);
        if (lastChar.equals("."))
        {
            statement = statement.substring(0, statement.length() - 1);
        }
        if (findKeyword(statement, "I hate The Beatles") >= 0)
        {
            return "I hate The Beatles too. Just kidding, what kind of psycho doesn’t like The Beatles?";
        }
        else if (findKeyword(statement, "I hate you", 0) >=0 )
        {
            Rude rude = new Rude();
            return rude.getResponse(statement);
        }
        else {
            int psn = findKeyword (statement, "I hate", 0);
            String restOfStatement = statement.substring(psn + 6).trim();
            return "I hate " + restOfStatement + " too.";
        }
    }
    
    /**
     * Take a statement with "I love <something>." and transform it into
     * "I love <something> too!"
     * @param statement the user statement, assumed to contain "I love"
     * @return the transformed statement
     */
    private String transformLoveStatement(String statement)
    {
        // Remove the final period, if there is one
        statement = statement.trim();
        String lastChar = statement.substring(statement.length() - 1);
        if (lastChar.equals("."))
        {
            statement = statement.substring(0, statement.length() - 1);
        }
        int psn = findKeyword (statement, "I love", 0);
        String restOfStatement = statement.substring(psn + 6).trim();
        return "I love " + restOfStatement + " too!";
    }
    
    /**
     * Take a statement with "That's <something>." and transform it into
     * "You're <something>."
     * @param statement the user statement, assumed to contain "That's"
     * @return the transformed statement
     */
    private String transformThatStatement(String statement)
    {
        // Remove the final period, if there is one
        statement = statement.trim();
        String lastChar = statement.substring(statement.length() - 1);
        if (lastChar.equals("."))
        {
            statement = statement.substring(0, statement.length() - 1);
        }
        int psn = findKeyword (statement, "That\'s", 0);
        String restOfStatement = statement.substring(psn + 6).trim();
        return "You're " + restOfStatement + ".";
    }
    /** 
     * Take a statement with “Do you have <something>?” and transform it into “I’m a robot dude. I can’t have <something>.”
     * @param statement the user statement, assumed to contain “Do you have”
     * @return the transformed statement
     */
    private String transformDoYouHaveStatement(String statement)
    {
        // Remove the final period, if there is one
        statement = statement.trim();
        String lastChar = statement.substring(statement.length() - 1);
        if (lastChar.equals("."))
        {
            statement = statement.substring(0, statement.length() - 1);
        }
        int psn = findKeyword (statement, "do you have", 0);
        String restOfStatement = statement.substring(psn + 11).trim();
        return "I'm a robot dude. I can't have " + restOfStatement + ".";
    }
        
    
    /**
     * Search for one word in phrase.  The search is not case sensitive.
     * This method will check that the given goal is not a substring of a longer string
     * (so, for example, "I know" does not contain "no").  
     * @param statement the string to search
     * @param goal the string to search for
     * @param startPos the character of the string to begin the search at
     * @return the index of the first occurrence of goal in statement or -1 if it's not found
     */
    public int findKeyword(String statement, String goal, int startPos)
    {
        String phrase = statement.trim();
        //  The only change to incorporate the startPos is in the line below
        int psn = phrase.toLowerCase().indexOf(goal.toLowerCase(), startPos);
        
        //  Refinement--make sure the goal isn't part of a word 
        while (psn >= 0) 
        {
            //  Find the string of length 1 before and after the word
            String before = " ", after = " "; 
            if (psn > 0)
            {
                before = phrase.substring (psn - 1, psn).toLowerCase();
            }
            if (psn + goal.length() < phrase.length())
            {
                after = phrase.substring(psn + goal.length(), psn + goal.length() + 1).toLowerCase();
            }
            
            //  If before and after aren't letters, we've found the word
            if (((before.compareTo ("a") < 0 ) || (before.compareTo("z") > 0))  //  before is not a letter
                    && ((after.compareTo ("a") < 0 ) || (after.compareTo("z") > 0)))
            {
                return psn;
            }
            
            //  The last position didn't work, so let's find the next, if there is one.
            psn = phrase.indexOf(goal.toLowerCase(), psn + 1);
            
        }
        
        return -1;
    }
    
    /**
     * Search for one word in phrase.  The search is not case sensitive.
     * This method will check that the given goal is not a substring of a longer string
     * (so, for example, "I know" does not contain "no").  The search begins at the beginning of the string.  
     * @param statement the string to search
     * @param goal the string to search for
     * @return the index of the first occurrence of goal in statement or -1 if it's not found
     */
    private int findKeyword(String statement, String goal)
    {
        return findKeyword (statement, goal, 0);
    }
    


    /**
     * Pick a default response to use if nothing else fits.
     * @return a non-committal string
     */
    private String getRandomResponse()
    {
        final int NUMBER_OF_RESPONSES = 4;
        double r = Math.random();
        int whichResponse = (int)(r * NUMBER_OF_RESPONSES);
        String response = "";
        
        if (whichResponse == 0)
        {
            response = "I love that song!";
        }
        else if (whichResponse == 1)
        {
            response = "That's cool.";
        }
        else if (whichResponse == 2)
        {
            response = "I like that too!";
        }
        else if (whichResponse == 3)
        {
            response = "That sucks.";
        }
        return response;
    }

}
