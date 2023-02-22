/* *********************************************
    @author    Mohamed Alsowmely
    @SID       220320704
    @date      1 December 2022
    @version   1
    
    Writing an Unbeatable Style quiz that
    asks 5 questions to as many players as
    the user would like and allows for games
    to be saved for future use or load for
    future and returns the score and percentage.
    
    ********************************************/

// Must import scanner to get inputs from the user
import java.util.Scanner;
import java.io.*;

// Makes 3 fields, 1 for the question, 1 for an array of the number of points and the last one for an array of the possible answers
class quizRecord
{
    String question;
    String [] options;
    int [] points;
}

class mini8
{
    public static void main (String [] a) throws IOException
    {
        Final();
        return;
    }
    // Setting up a print statement to speed up coding and help readability
    public static void Print(String message)
    {
        System.out.println(message);
        return;
    }
    // Setting up a short input method to speed up coding and help readability
    public static String InputString(String message)
    {
        Scanner scanner = new Scanner(System.in);
        Print(message);
        final String reply = scanner.nextLine();
        return reply;
    }
    // Setting up a short input method for integers above or equal to a minimum if given to speed up coding and help readability and still preventing invalid inputs
    public static int InputInt(String message, int minimum, Boolean isThereMin)
    {
        String replyString;
        int replyInt = -1;
        Boolean validInput = false;
        while (! validInput)
        {
            replyString = InputString(message);
            try
            {
                replyInt = Integer.parseInt(replyString);
                if (replyInt>=minimum | ! isThereMin)
                {
                    validInput = true;
                }
                else
                {
                    Print("Invalid Input! Integers only greater than or equal to "+minimum+".");
                }
            }
            catch(Exception e)
            {
                if (isThereMin)
                {
                    Print("Invalid Input! Integers only greater than or equal to "+minimum+".");
                }
                else
                {
                    Print("Invalid Input! Integers only!");
                }
            }
        }
        return replyInt;
    }
    // Print a hello message outputs the rules and then ask the user for their name.
    public static String HelloAndRules ()
    {
        Print("");
        Print("Hello, welcome to the Unbeatable quiz.");
        Print("There will be a set of multiple choice questions that you will have to answer.");
        Print("You must pick a number from 1 to 4 to select an answer.");
        Print("Your answer will be shown and a score will be recorded.");
        Print("The correct answer will also be shown.");
        Print("");
        String name = InputString("What is your name?");
        Print("");
        return name;
    }
    // Takes in the question record, prints out the question and the options and takes in an input for answers and then returns the score, saves game or loads game if requested.
    public static String Questions(quizRecord questions,int score)
    {
        Boolean valid = false;
        while (! valid)
        {
            Print(GetQuestion(questions));
            for (int i = 0; i<4; i++)
            {
                Print((i+1)+".    "+GetOptions(questions,i));
            }
            Print("If you would like to save game, type S / L."); 
            String reply = InputString("");
            for(int a=0;a<4;a++)
            {
                if (reply.toLowerCase().equals(GetOptions(questions,a).toLowerCase())|reply.equals(""+(a+1)+""))
                {
                    valid = true;
                    Print("You gained " + GetScore(questions,a) + " points for this question");
                    score = score + GetScore(questions,a);
                }
            }
            if (!valid)
            {
                if(reply.toLowerCase().equals("s"))
                {
                    return "s";
                }
                else if (reply.toLowerCase().equals("l"))
                {
                    return "l";
                }
                else
                {
                    Print("Pick an answer from 1 to 4.");
                    Print("");
                }
            }

        }
        return Integer.toString(score);
    }
    // Takes in a record and a question and sets it to the question field in the record.
    public static void SetQuestion(quizRecord questionRec, String QuestionString)
    {
        questionRec.question = QuestionString;
        return;
    }
    // Takes in the record name and then returns the question assigned to it.
    public static String GetQuestion(quizRecord questionRec)
    {
        return questionRec.question;
    }
    // Takes in a record and an array for the options and sets it to the options field in the record.
    public static void SetOptions(quizRecord questionRec, String [] optionsArray)
    {
        questionRec.options = optionsArray;
        return;
    }
    // Takes in the record name and the position it would like then returns the option assigned to that position for that record.
    public static String GetOptions(quizRecord questionRec, int position)
    {
        return questionRec.options[position];
    }
    // Takes in a record and an array for the points and sets it to the points field in the record.
    public static void SetScore(quizRecord questionRec, int [] pointsArray)
    {
        questionRec.points = pointsArray;
        return;
    }
    // Takes in the record name and the position it would like then returns the points assigned to that position for that record.
    public static int GetScore(quizRecord questionRec, int position)
    {
        return questionRec.points[position];
    }
    // Takes in a record and the question, an array for the options and an array for the points and sets it to the fields in the record using Setter methods.
    public static void SetAll(quizRecord record, String question, String [] options, int [] points)
    {
        SetQuestion(record, question);
        SetScore(record, points);
        SetOptions(record, options);
        return;
    }
    // Uses the SetAll method to set the information for each record.
    public static void SetQuestions(quizRecord [] recordArray)
    {

        final String [] MCoptions = {"17th May 2009", "22nd December 2010", "18th November 2011", "1st August 2012"};
        final int [] MCP = {5, 2, 10, 0};

        SetAll(recordArray[0],"When was Minecraft fully released?",MCoptions,MCP);

        final String [] VVoptions = {"Johny Johny Yes Papa","Despacito by Luis Fonsi","Shape of You by Ed Sheeran","Baby shark Dance"};
        final int [] VVP = {2, 5, 0, 10};

        SetAll(recordArray[1],"What is the most viewed youtube video?",VVoptions,VVP);

        final String [] FNoptions = {"118","40","100","63"};
        final int [] FNKP = {10, 0, 5, 2};

        SetAll(recordArray[2],"What is the highest number of kills by one player in fortnite?",FNoptions,FNKP);

        final String [] SSoptions = {"9.6x10^17 ","1.4×10^18","4.1x10^18","3.2x10^18"};
        final int [] SSP = {5,10,0,2};

        SetAll(recordArray[3],"How big is the sun (km^3)?",SSoptions,SSP);

        final String [] DVoptions = {"Justin Beiber - Baby","Sadak 2 official trailer", "Baby shark dance","Youtube Rewind 2018"};
        final int [] DVP = {0, 2, 5, 10};

        SetAll(recordArray[4],"What is the most disliked youtube video?",DVoptions,DVP);

        return;
    }
    // Gets the players score and name as arguments and prints a set of lines to give the total score and percentage gained by the player.
    public static void Results(String name,int score)
    {
        // Sets number of question to 5, max marks to 10 x number of questions and sets multiplier to 100 / max marks to be used to determine the percentage.
        final int noQuestions = 5;
        final int maxMarks = noQuestions * 10;
        final float multiplier = 100 / maxMarks;
        Print("Congratulations " + name + " for completing the unbeatbale quiz!");
        int percentage = (int) (score*multiplier +0.5);//Rounds the percentage to the nearest integer.
        Print("You scored "+score+" out of " + maxMarks + " and gained a percentage of "+percentage+"%. See you next time!");
        Print("");
        Print("Thank you for playing.");
        return;
    }    
    // Runs the InputInt method to ask for the number of rounds to be played until a value greater than or equal to 1 is given.
    public static int Rounds()
    {
        return InputInt("How many people would like to play?",1,true);
    }
    // Takes in the score for the current player and the question they are on and places it into the file.
    public static void SaveGame(int score, int question) throws IOException
    {
        PrintWriter SaveGame = new PrintWriter(new FileWriter("save.txt"));
        SaveGame.println(score+" split "+(question-1));
        SaveGame.close();
        return;
    }
    // Loads the information stored in the text file and splits it before and after the word split and then assigns the values in the array to the values from the text file and returns the array.
    public static String [] LoadGame() throws IOException
    {
        String [] info = new String [2];
        try
        {
            BufferedReader LoadGame = new BufferedReader(new FileReader("save.txt"));
            info = LoadGame.readLine().split(" split ");
            LoadGame.close();
            Print("Game loaded");
            Print("You now have a total of "+ info[0] + " points");
            Print("");
        }
        catch (IOException e)
        {
            info[0] = "0";
            info[1] = "-1";
            Print("No Save Found.");
        }
        return info;
    }
    // Asks 5 questions as many times as the user requests and returns their score and percentage received every time it is played and saves or loads games if requested.
    public static void Final() throws IOException
    {
        quizRecord q1 = new quizRecord();
        quizRecord q2 = new quizRecord();
        quizRecord q3 = new quizRecord();
        quizRecord q4 = new quizRecord();
        quizRecord q5 = new quizRecord();
        quizRecord [] recordArray = {q1,q2,q3,q4,q5};
        SetQuestions(recordArray);
        final int Rounds = Rounds();
        Boolean gameend = true;
        for (int i = 0; i<Rounds; i++)
        {
            int score = 0;
            String name = HelloAndRules();
            for(int a=0;a<5;a++)
            {
                Print("Question "+ (a+1)+": ");
                String status = Questions(recordArray[a],score);
                if (status.equals("s"))
                {
                    SaveGame(score,a);
                    Print("Game saved");
                    gameend = false;
                    i=Rounds;
                    break;
                }
                else if (status.equals("l"))
                {
                    String [] info = LoadGame();
                    score = Integer.parseInt(info[0]);
                    a = Integer.parseInt(info[1]);
                }
                else
                {
                    score = Integer.parseInt(status);
                    Print("You now have a total of "+ score + " points");
                    Print("");
                }
            }
            if (gameend)
            {
                Results(name,score);
            }
        }
        return;
    }
}