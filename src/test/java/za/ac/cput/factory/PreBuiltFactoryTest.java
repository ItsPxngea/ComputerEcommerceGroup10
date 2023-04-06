package za.ac.cput.factory;


import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import za.ac.cput.domain.PreBuilt;

class PreBuiltFactoryTest {

    @Test
    void createPreBuilt() {
        PreBuilt p = PreBuiltFactory.buildPreBuilt("GTX500", "Your product is good.","5 Stars","Graphics Card","Gaming","Valid", 4590);
        System.out.println(p.toString());
        assertNotNull(p);
    }
    @Test
    void emptyParameters1(){
        PreBuilt p = PreBuiltFactory.buildPreBuilt("", "Your product is good.","5 Stars","Graphics Card","Gaming","Valid", 4590);
        assertNull(p);
    }
    @Test
    void emptyParameters2(){
        PreBuilt p = PreBuiltFactory.buildPreBuilt("GTX500", "Your product is good.","5 Stars","","Gaming","Valid", 4590);
        assertNull(p);
    }

    @Test
    void emptyParameters3(){
        PreBuilt p = PreBuiltFactory.buildPreBuilt("GTX500", "Your product is good.","5 Stars","Graphics Card","","Valid", 4590);
        assertNull(p);
    }

    @Test
    void emptyParameters4(){
        PreBuilt p = PreBuiltFactory.buildPreBuilt("GTX500", "Your product is good.","5 Stars","Graphics Card","Gaming","", 4590);
        assertNull(p);
    }

    @Test
    void invalidParameters(){
        PreBuilt p = PreBuiltFactory.buildPreBuilt("GTX500", "Your product is good.","5 Stars","Graphics Card","Gaming","Valid", -4590);
        assertNull(p);
    }

    @Test
    void testEquality(){
        PreBuilt p = PreBuiltFactory.buildPreBuilt("GTX500", "Your product is good.","5 Stars","Graphics Card","Gaming","Valid", 4590);

        PreBuilt p2 = PreBuiltFactory.buildPreBuilt("GTX600", "Your product is okay.","5 Stars","Graphics Card","Gaming","Valid", 4400);

        System.out.println(p.toString());
        System.out.println(p2.toString());
        assertNotEquals(p,p2);
    }

    @Test
    void testEquality2(){
        PreBuilt p = PreBuiltFactory.buildPreBuilt("GTX500", "Your product is good.","5 Stars","Graphics Card","Gaming","Valid", 4590);

        PreBuilt p2 = p;

        System.out.println(p.toString());
        assertNotEquals(p,p2);

    }


}