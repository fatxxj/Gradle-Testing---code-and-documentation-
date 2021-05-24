import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

//created by Jovan Davchev

class LabExampleTest {

    private List<Double> createList(Double... elems) { //deklarirame listata
        return new ArrayList<>(Arrays.asList(elems));
    }

    @Test
    void everyStatementAndBranchTest() { //so ovoj test ke testirame
        //delarirame exception
        RuntimeException ex;
        //za prviot test da pomine treba da pratime null i da vidime dali ke se frla exception
        ex = assertThrows(RuntimeException.class, () -> LabExample.sumOfPricesGreaterThan(null, 5d)); // le se frla exceptionot runitmeexeption a ke se frla koga ke se povika metodot sum of prices greater than null
        assertTrue(ex.getMessage().contains("List of prices is not ok")); // ke vraka true dokolku se frlilo exceotion vo soodvetnoto mesto

        ex = assertThrows(RuntimeException.class,
                () -> LabExample.sumOfPricesGreaterThan(createList(1d, 3d, -2d), 2d)); //pak testirame dali ke se frla exception ako se vnesuvat negativni brojki
        assertTrue(ex.getMessage().contains("Negative price is not allowed")); // ke vvrati ture ako se frla exception

        assertEquals(9d, LabExample.sumOfPricesGreaterThan(createList(1d, 4d, 5d), 2d)); //2d e value koja ja oprima funkcijata a ocelkuvaniot rezultat ni e 9d i e davan kako argument, d oznacuva double.
    }

    @Test
    void testEveryPath() { //testirame sekoja pateka
        RuntimeException ex; //definirame exception

        //1,2, 3, 12
        ex = assertThrows(RuntimeException.class, () -> LabExample.sumOfPricesGreaterThan(null, 5d)); //probuvame dali ke se frli vo soodvetnoto mesto exception ako davame null kako argument
        assertTrue(ex.getMessage().contains("List of prices is not ok")); // testot ke pomine ako ke se frli exceptionot

        //1,2, 4, 5.1, 5.2, 6, 7, 12
        ex = assertThrows(RuntimeException.class, // pak uste eden excepton probuvame
                () -> LabExample.sumOfPricesGreaterThan(createList(-3d, 5d), 2d)); // ova e exceptipon za negativven broj , 2d ni e value
        assertTrue(ex.getMessage().contains("Negative price is not allowed")); // testot ke pomine ako ke s frli exceptonn


        //1,2, 4, 5.1, 5.2, 11, 12 - can't happen


        //1,2, 4, 5.1, (5.2, 6, 8, 10, 5.3, 5.2), 11, 12
        assertEquals(0d, LabExample.sumOfPricesGreaterThan(createList(2d, 3d), 5d)); //probuvame dali vo red ke se vrsat operaciite i dali ke ni vraka 00 dokolku argument immame 2d i 5d a value ni e 5d. Treba da vraka 0 bidejki ke gi zdememe brojkite koi se pogolemi od value, odnosno po golemi od 5d a ovie se pomali i ne treba da se zemat vo predvid i zatoa vraka 0.


        //1,2, 4, 5.1, (5.2, 6, 8, 9, 10, 5.3, 5.2), 11, 12
        assertEquals(5d, LabExample.sumOfPricesGreaterThan(createList(2d, 3d), 1d)); // probuvame dali operacijaata ima rezultat 5d, 1d ke ni bide referenten broj sot kazuva site broevi pogolemi od 1d ke gi zememe vo predvid i zatoa 2d i 3d ke ni pravat 5d

        //mixed
        assertEquals(4d, LabExample.sumOfPricesGreaterThan(createList(2d, 4d), 3d)); //isto


        //1,2, 4, 5.1, (5.2, 6, 8, 10, 5.3, 5.2), 6, 7, 12
        ex = assertThrows(RuntimeException.class, //test za exceptiion
                () -> LabExample.sumOfPricesGreaterThan(createList(2d, 3d, -4d), 5d)); //treba da se frla exception za negaticen broj
        assertTrue(ex.getMessage().contains("Negative price is not allowed")); //testot pominuv ako ke se frli exceptionot


        //1,2, 4, 5.1, (5.2, 6, 8, 9, 10, 5.3, 5.2), 6, 7, 12
        ex = assertThrows(RuntimeException.class, //test za exception
                () -> LabExample.sumOfPricesGreaterThan(createList(2d, 3d, -4d), 1d));
        assertTrue(ex.getMessage().contains("Negative price is not allowed"));


        //mixed
        ex = assertThrows(RuntimeException.class, // test za excrpyion
                () -> LabExample.sumOfPricesGreaterThan(createList(2d, 4d, -4d), 2d));
        assertTrue(ex.getMessage().contains("Negative price is not allowed"));

    }

    @Test
    void multipleConditionsTest() { //testovi za multiple conditions
        //(prices==null || prices.isEmpty())
        //T || X
        //F || T
        //F || F

        RuntimeException ex; //deklarirame exception

        ex = assertThrows(RuntimeException.class, // probuvame dali ke se frla exceptionot
                () -> LabExample.sumOfPricesGreaterThan(null, 5d));
        assertTrue(ex.getMessage().contains("List of prices is not ok"));

        ex = assertThrows(RuntimeException.class,
                () -> LabExample.sumOfPricesGreaterThan(Collections.emptyList(), 5d)); // probuvame dali ke se frli exception ako listata e prazna
        assertTrue(ex.getMessage().contains("List of prices is not ok"));

        assertEquals(5d, LabExample.sumOfPricesGreaterThan(createList(2d, 3d), 1d)); //testot ke pomine samo ako ke se frla exception vo soodvetnoto mesto

    }

}
