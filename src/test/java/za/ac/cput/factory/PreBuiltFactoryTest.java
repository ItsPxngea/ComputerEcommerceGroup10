package za.ac.cput.factory;
/*
    Author: Michael Johnson
    This is the test class for Pre-Built Factory
    Date: 06 - 04 - 2022
 */
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import za.ac.cput.domain.PreBuilt;

class PreBuiltFactoryTest {

    @Test
    void createPreBuilt() {
        PreBuilt p = PreBuiltFactory.buildPreBuilt("GTX500", "Your product is good.","5 Stars","29-03-2023","Graphics Card","Gaming","Valid", 4590);
        System.out.println(p.toString());
        assertNotNull(p);
    }
    @Test
    void emptyParameters1(){
        PreBuilt p = PreBuiltFactory.buildPreBuilt("", "Your product is good.","5 Stars","29-03-2023","Graphics Card","Gaming","Valid", 4590);
        assertNull(p);
    }
    @Test
    void emptyParameters2(){
        PreBuilt p = PreBuiltFactory.buildPreBuilt("GTX500", "","5 Stars","29-03-2023","Graphics Card","Gaming","Valid", 4590);
        assertNull(p);
    }

    @Test
    void emptyParameters3(){
        PreBuilt p = PreBuiltFactory.buildPreBuilt("GTX500", "Your product is good.","","29-03-2023","Graphics Card","Gaming","Valid", 4590);
        assertNull(p);
    }

    @Test
    void emptyParameters4(){
        PreBuilt p = PreBuiltFactory.buildPreBuilt("GTX500", "Your product is good.","5 Stars","29-03-2023","","Gaming","Valid", 4590);
        assertNull(p);
    }

    @Test
    void invalidParameters(){
        PreBuilt p = PreBuiltFactory.buildPreBuilt("GTX500", "Your product is good.","5 Stars","29-03-2023","Graphics Card","Gaming","Valid", -4590);
        assertNull(p);
    }

    @Test
    void invalidParameters2(){
        PreBuilt p = PreBuiltFactory.buildPreBuilt("GTX500", "Your product is good.","5 Stars","29-02-2023","Graphics Card","Gaming","Valid", 4590);
        assertNull(p);
    }

    @Test
    void invalidParameters3(){
        PreBuilt p = PreBuiltFactory.buildPreBuilt("GTX500", "Your product is good.","5 Stars","awfawf","Graphics Card","Gaming","Valid", 4590);
        assertNull(p);
    }

    @Test
    void testEquality(){
        PreBuilt p = PreBuiltFactory.buildPreBuilt("GTX500", "Your product is good.","5 Stars","29-03-2023","Graphics Card","Gaming","Valid", 4590);

        PreBuilt p2 = PreBuiltFactory.buildPreBuilt("GTX500", "Your product is good.","5 Stars","29-03-2023","Graphics Card","Gaming","Valid", 4590);

        System.out.println(p.toString());
        System.out.println(p2.toString());
        assertNotEquals(p,p2);
    }

    @Test
    void testEquality2(){
        PreBuilt p = PreBuiltFactory.buildPreBuilt("GTX500", "Your product is good.","5 Stars","29-03-2023","Graphics Card","Gaming","Valid", 4590);

        PreBuilt p2 = p;

        System.out.println(p.toString());
        assertEquals(p,p2);

    }


}