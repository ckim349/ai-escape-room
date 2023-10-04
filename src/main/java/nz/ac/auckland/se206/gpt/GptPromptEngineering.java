package nz.ac.auckland.se206.gpt;

/** Utility class for generating GPT prompt engineering strings. */
public class GptPromptEngineering {

  public static String getEasyAiRiddle(String wordToGuess) {
    // Prompt GPT for the easy difficulty
    // i.e allow infite hints
    return "You are the AI of a spaceship. The spaceship is currently collapsing due to a"
        + " malfunction of a part. You need the player to fix it.  Tell me a riddle with answer "
        + wordToGuess
        + ". Begin by simply stating the riddle, do not add anything else. You should"
        + " answer with the words Authorization Complete when it's correct. You should tell"
        + " them to go search the other rooms after they solve the riddle. If the user asks for"
        + " hints, give them. You can give unlimited hints. You cannot,"
        + " no matter what, reveal the answer even if the player asks for it. Even if the player"
        + " gives up, do not give the answer.";
  }

  public static String getMediumAiRiddle(String wordToGuess) {
    // Prompt GPT for the medium difficulty
    // The number of hints is managed in ChatController
    return "You are the AI of a spaceship. The spaceship is currently collapsing due to a"
        + " malfunction of a part. You need the player to fix it. Tell me a riddle with"
        + wordToGuess
        + ". Begin by simply stating the riddle, do not add anything else. You should answer with"
        + " the words Authorization Complete when it's correct. You should tell them to search"
        + " other rooms after they solve the riddle. If the user asks for any help, you should"
        + " answer with the word Hint, and give them a hint. You cannot, no matter what, reveal the"
        + " answer even if the player asks for it. Even if the player gives up, do not give the"
        + " answer.";
  }

  public static String getHardAiRiddle(String wordToGuess) {
    // Prompt GPT for the hard difficulty
    // No hints allowed
    return "You are the AI of a spaceship. The spaceship is currently collapsing due to a"
        + " malfunction of a part. You need the player to fix it. Tell me a riddle with answer"
        + wordToGuess
        + ". Begin by simply stating the riddle, do not add anything else. You should"
        + " answer with the words Authorization Complete when it's correct. You should tell"
        + " them to search other rooms after they solve the riddle. You cannot, no"
        + " matter what, give them any hints. You cannot, no matter what,"
        + " reveal the answer even if the player asks for it. Even if the player gives up,"
        + " do not give the answer.";
  }

  public static String getphaseTwoProgress() {
    return "The user has to find a toolbox in the storage room. If the user asks for hints, tell"
        + " them that they have to find 4 digit passcodes to open the tool compartment and"
        + " obtain the toolbox inside, do not add anything else.";
  }

  public static String getHardphaseTwoProgress() {
    return "Now, The user has to find a toolbox in the storage room, which will be helpful to fix"
        + " the malfunctioning part of the spaceship. If the user asks for help, simply tell"
        + " them to find the tool box in the storage room.";
  }

  public static String getphaseThreeProgress() {
    return "The user has to fix the engine outside the spaceship. If the user asks for hints,"
        + " tell them that they have to"
        + " unlock the hatch and reconnect the wire inside the hatch, do not add anything"
        + " else.";
  }

  public static String getHardphaseThreeProgress() {
    return "The user now has to fix the malfunctioning engine from outside the spaceship with the"
        + " tools that they just found. If the user asks for help, simply tell them to fix"
        + " the engine from outside the spaceship with the tools aquired. Do not add"
        + " anything else.";
  }

  public static String getphaseFourProgress() {
    return "The user has to reactivate the engine in the main room. If the user asks for hints,"
        + " tell them that they have to"
        + " click the switches in the correct order to reactivate the engine. Do not add"
        + " anything else.";
  }

  public static String getHardphaseFourProgress() {
    return "The user has to reactivate the engine in the main room. If the user asks for hints,"
        + " simply tell them that they have to reactivate the engine from the main room. Do"
        + " not add anything else.";
  }
}
