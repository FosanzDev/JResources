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
     * <blockquote><pre>
     * deployMenu("Example menu", "--> ", false, "Opt1", "Opt2");
     *  //******************
     *  //** Example menu **
     *  //******************
     *  // --> Opt1
     *  // --> Opt2
     *
     * deployMenu("Example menu with id", "--> . ", true, "Opt1", "Opt2", "Footer!");
     *  //**************************
     *  //** Example menu with id **
     *  //**************************
     *  // --> 1. Opt1
     *  // --> 2. Opt2
     *  //--------------------------
     *  // Footer!
     *  </pre></blockquote>
     *
     * @param title  String with the title
     * @param init   String with the starting sequence.
     * @param footer boolean specifying if the footer will be printed or not.
     *               If {@code true}, the last element of the array will be the footer.
     *               If {@code false}, the last element of the array will be the last option.
     * @param args   Receives an undefinied number of Strings or a String array ({@code String[]})
     */
    public static void deployMenu(String title, String init, boolean footer, String... args) {
        int idx = 1;
        String titleMod = "*".repeat(title.length() + 6)
                + "\n** " + title + " **\n"
                + "*".repeat(title.length() + 6);

        System.out.println(titleMod);

        if (init.contains(".")) {

            for (int i = 0; i < args.length - 1; i++) {
                String initMod = init.replace(".", idx + ".");
                System.out.println(initMod + args[i]);
                idx++;
            }
        } else {
            for (int i = 0; i < args.length - 1; i++) {
                System.out.println(init + args[i]);
            }
        }

        if (footer) {
            System.out.println("-".repeat(title.length() + 6));
            System.out.println(args[args.length - 1]);
        } else {
            System.out.println(args[args.length - 1]);
        }
    }


}
