package com.fosanzdev.jresources;

public class JDeploy {

    /**
            * Prints a menu with personalized title, footer and initial sequence per element given.
            * <p>
     * If the initial sequence includes a {@code "."}, an autoincremental index will be added before the {@code "."}.
            * <p>
     * Footer lenght equals the title columns. If footer ==  {@code " "}, footer won't be printed.
            * <p>
     * Examples:
            *  <blockquote><pre>
     *deployMenu("Example menu", " ", "--> ", "Opt1", "Opt2");
     *  //******************
             *  //** Example menu **
             *  //******************
             *  // --> Opt1
             *  // --> Opt2
             *
             *deployMenu("Example menu with id", "Footer!", "--> . ", "Opt1", "Opt2");
     *  //**************************
             *  //** Example menu with id **
             *  //**************************
             *  // --> 1. Opt1
             *  // --> 2. Opt2
             *  //--------------------------
             *  // Footer!
             *  </pre></blockquote>
            *
            * @param title String with the title
     * @param footer String with the footer
     * @param init String with the starting sequence.
            * @param args Receives an undefinied number of Strings or a String array ({@code String[]})
            */
    public static void deployMenu(String title, String footer, String init, String... args){
        int idx = 1;
        String titleMod = new StringBuilder("*".repeat(title.length() + 6)
                + "\n** " + title + " **\n"
                + "*".repeat(title.length() + 6)).toString();

        System.out.println(titleMod);

        if (init.contains(".")){

            for (String arg : args){
                String initMod = init.replace(".", idx + ".");
                System.out.println(initMod + arg);
                idx++;
            }
        }

        else{
            for (String arg : args){
                System.out.println(init + arg);
            }
        }

        if(footer.equals(" ") || footer.equals(""));
        else{
            System.out.println("-".repeat(title.length() + 6));
            System.out.println(footer);
        }
    }


}
