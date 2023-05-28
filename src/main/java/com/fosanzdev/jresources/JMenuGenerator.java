package com.fosanzdev.jresources;

import java.util.ArrayList;
import java.util.List;

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

    private String init = "";
    private int[] sections = new int[0];
    private boolean autoIndex = false;
    private boolean footer = false;
    private ArrayList<String> options = new ArrayList<>();

    public JMenuGenerator(String init, boolean autoIndex, boolean footer) {
        this.init = init;
        this.autoIndex = autoIndex;
        this.footer = footer;
    }

    public JMenuGenerator(String init, boolean autoIndex){
        this.init = init;
        this.autoIndex = autoIndex;
    }

    public JMenuGenerator(String init){
        this.init = init;
    }

    public JMenuGenerator(boolean footer){
        this.footer = footer;
    }

    public JMenuGenerator() {
    }

    public void addOption(String option) {
        options.add(option);
    }

    public void addSection(int index){
        int[] newSections = new int[sections.length + 1];
        System.arraycopy(sections, 0, newSections, 0, sections.length);
        newSections[newSections.length - 1] = index;
        sections = newSections;
    }

    public void addOptions(String... opts) {
        for (String option : opts) {
            options.add(option);
        }
    }

    public void addOptions(List<String> options) {
        options.addAll(options);
    }

    public void addSections(int... indexes){
        int[] newSections = new int[sections.length + indexes.length];
        System.arraycopy(sections, 0, newSections, 0, sections.length);
        System.arraycopy(indexes, 0, newSections, sections.length, indexes.length);
        sections = newSections;
    }

    public void setSections(int... indexes){
        sections = indexes;
    }

    public void removeOption(int index) {
        options.remove(index);
    }

    public void removeOption(String option) {
        options.remove(option);
    }

    public void removeOptions(int... indexes) {
        for (int index : indexes) {
            options.remove(index);
        }
    }

    public void removeOptions(String... opts) {
        for (String option : opts) {
            options.remove(option);
        }
    }

    public void removeOptions(List<String> options) {
        options.removeAll(options);
    }

    public void clearOptions() {
        options.clear();
    }

    public void clearSections(){
        sections = new int[0];
    }

    public void removeSection(int index){
        int[] newSections = new int[sections.length - 1];
        int idx = 0;
        for (int section : sections) {
            if (section != index){
                newSections[idx] = section;
                idx++;
            }
        }
        sections = newSections;
    }

    public void removeSections(int... indexes){
        int[] newSections = new int[sections.length - indexes.length];
        int idx = 0;
        for (int section : sections) {
            boolean remove = false;
            for (int index : indexes) {
                if (section == index){
                    remove = true;
                }
            }
            if (!remove){
                newSections[idx] = section;
                idx++;
            }
        }
        sections = newSections;
    }

    public void setInit(String init) {
        this.init = init;
    }

    public void setAutoIndex(boolean autoIndex) {
        this.autoIndex = autoIndex;
    }

    public void setFooter(boolean footer) {
        this.footer = footer;
    }

    public String generateMenu(String title) {
        StringBuilder strMenu = new StringBuilder();
        int idx = 1;
        int sectionLength = title.length() + 6;

        strMenu.append("*".repeat(sectionLength))
                .append("\n** ").append(title).append(" **\n")
                .append("*".repeat(sectionLength)).append("\n");

        if (autoIndex) {
            for (int i=0; i<options.size() - (footer ? 1 : 0); i++){
                if (sections != null){
                    for (int section : sections) {
                        if (section == i){
                            strMenu.append("-".repeat(sectionLength)).append("\n");
                        }
                    }
                }

                String initMod = init.replace(".", idx + ".");
                strMenu.append(initMod).append(options.get(i)).append("\n");
                idx++;

                
            }
        } else {
            for (int i=0; i<options.size() - 1; i++){
                if (sections != null){
                    for (int section : sections) {
                        if (section == i){
                            strMenu.append("-".repeat(sectionLength)).append("\n");
                        }
                    }
                }


                strMenu.append(init).append(options.get(i)).append("\n");
            }
        }

        if (footer){
            if (autoIndex){
                strMenu.append("-".repeat(sectionLength)).append("\n")
                        .append(init.replace(".", "0."))
                        .append(options.get(options.size() - 1));
            } else {
                strMenu.append("-".repeat(sectionLength)).append("\n")
                        .append(init)
                        .append(options.get(options.size() - 1));
            }
        }
        
        
        // StringBuilder menu = new StringBuilder();
        // int idx = 1;

        // menu.append("*".repeat(sectionLength))
        //         .append("\n** ").append(title).append(" **\n")
        //         .append("*".repeat(sectionLength)).append("\n");

        // if (autoIndex) {
        //     for (int i = 0; i < args.length - 1; i++) {
        //         String initMod = init.replace(".", idx + ".");
        //         menu.append(initMod).append(args[i]).append("\n");
        //         idx++;
        //     }
        // } else {
        //     for (int i = 0; i < args.length - 1; i++) {
        //         menu.append(init).append(args[i]).append("\n");
        //     }
        // }

        // if (footer){
        //     if (autoIndex){
        //         menu.append("-".repeat(sectionLength)).append("\n")
        //                 .append(init.replace(".", "0.")).append(args[args.length - 1]);
        //     } else {
        //         menu.append("-".repeat(sectionLength)).append("\n")
        //                 .append(args[args.length - 1]);
        //     }
        // }

        return strMenu.toString();
    }
}
