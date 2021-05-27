import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//fat halimi - 195005
import static org.junit.jupiter.api.Assertions.*;

class SILab2Test {

    private List<Time> createList(Time... elems) {
        return new ArrayList<>(Arrays.asList(elems));
    }


    @Test
            void multipleConditionAndBranchTest() {


        Time vreme = new Time(10,10,0);// TESTING ABC-I-L-M-N
        Time vreme1 = new Time(-10,10,0);// TEST ABC-D-R
        Time vreme2 = new Time(100,10,0);//TEST ABC-D-G-H
        Time vreme3 = new Time(10,-10,0);//TEST ABC-I-J-K
        Time vreme4 = new Time(10,20,-100); //TEST ABC-I-L-O
        Time vreme5 = new Time(24,0,0);//TEST ABC-Q-R
        Time vreme6 = new Time(24,30,20);//TEST ABC-S-T

        // TESTING ABC-I-L-M-N
        List<Integer> result = new ArrayList<>();
        result.add(36600);
        assertEquals(result, SILab2.function(createList(vreme)));

        // END TEST ABC-I-L-M-N

        // TEST ABC-D-R
        RuntimeException ex ;
        ex = assertThrows(RuntimeException.class, ()->SILab2.function(createList(vreme1)));
        assertTrue(ex.getMessage().contains("The hours are smaller than the minimum"));
        // END TEST ABC-D-E

        //TEST ABC-D-G-H

        ex=assertThrows(RuntimeException.class, ()->SILab2.function(createList(vreme2)));
        assertTrue(ex.getMessage().contains("The hours are grater than the maximum"));

        //END TEST ABC-D-G-H

        //TEST ABC-I-J-K

        ex=assertThrows(RuntimeException.class, ()->SILab2.function(createList(vreme3)));
        assertTrue(ex.getMessage().contains("The minutes are not valid!"));

        // END TEST ABC-I-J-K

        //TEST ABC-I-L-O

        ex=assertThrows(RuntimeException.class, ()->SILab2.function(createList(vreme4)));
        assertTrue(ex.getMessage().contains("The seconds are not valid"));

        // END TEST ABC-I-L-O

        //TEST ABC-Q-R

        List<Integer> result1 = new ArrayList<>();
        result1.add(86400);
        assertEquals(result1, SILab2.function(createList(vreme5)));

        //END TEST ABC-Q-R

        //TEST ABC-S-T

        ex=assertThrows(RuntimeException.class, ()->SILab2.function(createList(vreme6)));
        assertTrue(ex.getMessage().contains("The time is greater than the maximum"));

        //END TEST ABC-S-T

    }




}