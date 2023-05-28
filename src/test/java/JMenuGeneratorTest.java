import org.junit.Test;
import com.fosanzdev.jresources.JMenuGenerator;
import static org.junit.Assert.*;

public class JMenuGeneratorTest {

    @Test
    public void generatorTest(){
        JMenuGenerator menu = new JMenuGenerator(". ");
        menu.setAutoIndex(true);
        menu.addOption("Option1");
        menu.addOption("Option2");
        menu.addOption("Option3");
        menu.addOption("Option4");
        menu.addOption("Option5");
        menu.addOption("Option6");
        menu.addSection(6);
        menu.addSections(16, 28);
        menu.addOptions("Option7", "Option8", "Option9", "Option10", "Option11", "Option12", "Option13", "Option14", "Option15", "Option16", "Option17", "Option18", "Option19", "Option20", "Option21", "Option22", "Option23", "Option24", "Option25", "Option26", "Option27", "Option28", "Option29", "Option30", "Option31", "Option32", "Option33", "Option34", "Option35", "Option36");
        String expectedString = """
                ***************
                ** Test Menu **
                ***************
                1. Option1
                2. Option2
                3. Option3
                4. Option4
                5. Option5
                6. Option6
                ---------------
                7. Option7
                8. Option8
                9. Option9
                10. Option10
                11. Option11
                12. Option12
                13. Option13
                14. Option14
                15. Option15
                16. Option16
                ---------------
                17. Option17
                18. Option18
                19. Option19
                20. Option20
                21. Option21
                22. Option22
                23. Option23
                24. Option24
                25. Option25
                26. Option26
                27. Option27
                28. Option28
                ---------------
                29. Option29
                30. Option30
                31. Option31
                32. Option32
                33. Option33
                34. Option34
                35. Option35
                36. Option36
                """;

        assertEquals(expectedString, menu.generateMenu("Test Menu"));
    }
}