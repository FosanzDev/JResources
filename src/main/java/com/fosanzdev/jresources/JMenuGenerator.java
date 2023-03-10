package com.fosanzdev.jresources;

/**
 * This class is used to generate a menu in the console
 * There are 4 options that can be modified: <br>
 * - init: String that will be added at the beginning of each option <br><br>
 * - autoIndex: boolean that specifies if the menu will have an autoincremental index.<br>
 *      Every '.' int the init string will be replaced by the index + '.' if this option is true.<br>
 *      IE: init = "--> . " and autoIndex = true will result in "--> 1. Option1"<br><br>
 * - footer: boolean that specifies if the menu will have a footer. The last element of the array will be the footer<br>
 *     if this option is true a line of '-' will be added before the footer.<br><br>
 * - indexFooter: boolean that specifies if the footer will have an index. If this option is true, the footer will have<br>
 *      the init string with the index 0. IE: init = "--> . " and indexFooter = true will result in "--> 0. Footer"<br><br>
 *
 * @author Esteban Sánchez (@FosanzDev)
 */
public class JMenuGenerator {

    public String init = "- ";
    public boolean autoIndex = false;
    public boolean footer = true;
    public boolean indexFooter = false;

    public String generateMenu(String title, String... args) {
        StringBuilder menu = new StringBuilder();
        int idx = 1;

        menu.append("*".repeat(title.length() + 6))
                .append("\n** ").append(title).append(" **\n")
                .append("*".repeat(title.length() + 6)).append("\n");

        if (autoIndex) {
            for (int i = 0; i < args.length - 1; i++) {
                String initMod = init.replace(".", idx + ".");
                menu.append(initMod).append(args[i]).append("\n");
                idx++;
            }
        } else {
            for (int i = 0; i < args.length - 1; i++) {
                menu.append(init).append(args[i]).append("\n");
            }
        }

        if (footer){
            if (indexFooter){
                menu.append("-".repeat(title.length() + 6)).append("\n")
                        .append(init.replace(".", "0.")).append(args[args.length - 1]);
            } else {
                menu.append("-".repeat(title.length() + 6)).append("\n")
                        .append(args[args.length - 1]);
            }
        }

        return menu.toString();
    }
}
