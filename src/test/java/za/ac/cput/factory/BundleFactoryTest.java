package za.ac.cput.factory;

import org.junit.jupiter.api.Test;
import za.ac.cput.domain.Bundle;

import static org.junit.jupiter.api.Assertions.*;

public class BundleFactoryTest {

    @Test
    void createBundle(){
        Bundle b = BundleFactory.buildBundle("Ryzen Bundle", "Gaming Pc", "Complete ryzen only pc",
                1, "2 Years", "Gaming", "Great System, Great Service", "2023-04-05","4/5",2000.00, "Ryzen Setup");
        System.out.println(b.toString());
        assertNotNull(b);
    }

    @Test
    void emptyParameters1(){
        Bundle b = BundleFactory.buildBundle("", "Gaming Pc", "Complete ryzen only pc",
                1, "2 Years", "Gaming", "Great System, Great Service", "2023-04-05","4/5",2000.00, "Ryzen Setup");
        assertNull(b);
    }

    @Test
    void emptyParameters2(){
        Bundle b = BundleFactory.buildBundle("Ryzen Bundle", "", "Complete ryzen only pc",
                1, "2 Years", "Gaming", "Great System, Great Service", "2023-04-05","4/5",2000.00, "Ryzen Setup");
        assertNull(b);
    }

    @Test
    void emptyParameters3(){
        Bundle b = BundleFactory.buildBundle("Ryzen Bundle", "Gaming Pc", "",
                1, "2 Years", "Gaming", "Great System, Great Service", "2023-04-05","4/5",2000.00, "Ryzen Setup");
        assertNull(b);
    }

    @Test
    void emptyParameters4(){
        Bundle b = BundleFactory.buildBundle("Ryzen Bundle", "Gaming Pc", "Complete ryzen only pc",1
                , "", "Gaming", "Great System, Great Service", "2023-04-05","4/5",2000.00, "Ryzen Setup");
        assertNull(b);
    }

    @Test
    void emptyParameters5(){
        Bundle b = BundleFactory.buildBundle("Ryzen Bundle", "Gaming Pc", "Complete ryzen only pc",1
                , "2 Years", "", "Great System, Great Service", "2023-04-05","4/5",2000.00, "Ryzen Setup");
        assertNull(b);
    }


    @Test
    void emptyParameters6(){
        Bundle b = BundleFactory.buildBundle("Ryzen Bundle", "Gaming Pc", "Complete ryzen only pc",1
                , "2 Years", "Gaming", "Great System, Great Service", "","4/5",2000.00, "Ryzen Setup");
        assertNull(b);
    }

    @Test
    void emptyParameters7(){
        Bundle b = BundleFactory.buildBundle("Ryzen Bundle", "Gaming Pc", "Complete ryzen only pc",1
                , "2 Years", "Gaming", "Great System, Great Service", "2023-04-05","",2000.00, "Ryzen Setup");
        assertNull(b);
    }

    @Test
    void emptyParameters8(){
    Bundle b = BundleFactory.buildBundle("Ryzen Bundle", "Gaming Pc", "Complete ryzen only pc",
            1, "2 Years", "Gaming", "Great System, Great Service", "2023-04-05","4/5",2000.00, "");
        assertNull(b);
    }

    @Test
    void invalidParameters1(){
        Bundle b = BundleFactory.buildBundle("Ryzen Bundle", "Gaming Pc", "Complete ryzen only pc",
                -1, "2 Years", "Gaming", "Great System, Great Service", "2023-04-05","4/5",2000.00, "Ryzen Setup");
        assertNull(b);
    }

    @Test
    void invalidParameters2(){
        Bundle b = BundleFactory.buildBundle("Ryzen Bundle", "Gaming Pc", "Complete ryzen only pc",
                1, "2 Years", "Gaming", "Great System, Great Service", "2023-04-05","4/5",-2000, "Ryzen Setup");
        assertNull(b);
    }

    @Test
    void testEquality(){
        Bundle b = BundleFactory.buildBundle("Ryzen Bundle", "Gaming Pc", "Complete ryzen only pc",
                1, "2 Years", "Gaming", "Great System, Great Service", "2023-04-05","4/5",2000.00, "Ryzen Setup");
        Bundle b2 = BundleFactory.buildBundle("Intel Bundle", "Desktop Pc", "Complete Intel pc",
                1, "2 Years", "Home", "Great System, Great Service", "2023-04-06","5/5",3000.00, "Intel Setup");
        System.out.println(b.toString());
        System.out.println(b2.toString());
        assertNotEquals(b, b2);
    }

    @Test
    void testEquality2(){
        Bundle b = BundleFactory.buildBundle("Ryzen Bundle", "Gaming Pc", "Complete ryzen only pc",
                1, "2 Years", "Gaming", "Great System, Great Service", "2023-04-05","4/5",2000.00, "Ryzen Setup");
        Bundle b2 = b;
        System.out.println(b.toString());
        assertEquals(b, b2);
    }

   @Test
    void testInvalidDate() {
       Bundle b = BundleFactory.buildBundle("Ryzen Bundle", "Gaming Pc", "Complete ryzen only pc",
               1, "2 Years", "Gaming", "Great System, Great Service", "dfdf", "4/5", 2000.00, "Ryzen Setup");
       assertNull(b);
   }
}
