package eg.edu.alexu.csd.datastructure.iceHockey.cs16;

import org.junit.jupiter.api.Test;

import java.awt.Point;

import static org.junit.jupiter.api.Assertions.*;

class MainTest {

    private Main test = new Main();

    @Test
    void firstTestCase() {

        Point[] ans1 = new Point[1000];

        ans1[0] = new Point(4, 5);
        ans1[1] = new Point(13, 9);
        ans1[2] = new Point(14, 2);

        String[] s1 = {
                "33JUBU33",
                "3U3O4433",
                "O33P44NB",
                "PO3NSDP3",
                "VNDSD333",
                "OINFD33X"
        };

        Point[] output1 = test.findPlayers(s1, 3, 16);

        for (int i = 1, max = ans1.length; i < max && ans1[i] != null; i++)
            assertEquals(ans1[i], output1[i]);
    }

    @Test
    void secondTestcase(){

        Point[] ans2 = new Point[1000];

        ans2[0] = new Point (3, 8);
        ans2[1] = new Point(5, 4);
        ans2[2] = new Point(5, 4);
        ans2[2] = new Point(16, 3);
        ans2[2] = new Point(16, 17);
        ans2[2] = new Point(5, 15);

        String[] s2 = {
                "44444H44S4",
                "K444K4L444",
                "4LJ44T44XH",
                "444O4VIF44",
                "44C4D4U444",
                "4V4Y4KB4M4",
                "G4W4HP4O4W",
                "4444ZDQ4S4",
                "4BR4Y4A444",
                "4G4V4T4444"
        };

        Point[] output2 = test.findPlayers(s2, 4, 16);

        for (int i = 1, max = ans2.length; i < max && ans2[i] != null; i++)
            assertEquals(ans2[i], output2[i]);
    }

    @Test
    void thirdTestcase()
    {

        Point[] ans3 = new Point[1000];

        ans3[0] = new Point (1, 17);
        ans3[0] = new Point (3, 3);
        ans3[0] = new Point (3, 10);
        ans3[0] = new Point (3, 25);
        ans3[0] = new Point (5, 21);
        ans3[0] = new Point (8, 17);
        ans3[0] = new Point (9, 2);
        ans3[0] = new Point (10, 9);
        ans3[0] = new Point (12, 23);
        ans3[0] = new Point (17, 16);
        ans3[0] = new Point (18, 3);
        ans3[0] = new Point (18, 11);
        ans3[0] = new Point (18, 28);
        ans3[0] = new Point (22, 20);
        ans3[0] = new Point (23, 26);
        ans3[0] = new Point (24, 15);
        ans3[0] = new Point (27, 2);
        ans3[0] = new Point (28, 26);
        ans3[0] = new Point (29, 16);

        String[] s3 = {
                "8D88888J8L8E888",
                "88NKMG8N8E8JI88",
                "888NS8EU88HN8EO",
                "LUQ888A8TH8OIH8",
                "888QJ88R8SG88TY",
                "88ZQV88B88OUZ8O",
                "FQ88WF8Q8GG88B8",
                "8S888HGSB8FT8S8",
                "8MX88D88888T8K8",
                "8S8A88MGVDG8XK8",
                "M88S8B8I8M88J8N",
                "8W88X88ZT8KA8I8",
                "88SQGB8I8J88W88",
                "U88H8NI8CZB88B8",
                "8PK8H8T8888TQR8"
        };

        Point[] output3 = test.findPlayers(s3, 8, 9);

        for (int i = 1, max = ans3.length; i < max && ans3[i] != null; i++)
            assertEquals(ans3[i], output3[i]);
    }

    @Test
    void fourthTestCase() {

        Point[] ans4 = new Point[1000];

        String[] s4 = new String[1];

        Point[] output1 = test.findPlayers(s4, 3, 16);

        for (int i = 1, max = ans4.length; i < max && ans4[i] != null; i++)
            assertEquals(ans4[i], output1[i]);
    }
}