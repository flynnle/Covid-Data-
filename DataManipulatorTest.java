import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.time.LocalDate;

/**
 * The test class DataManipulatorTest.
 *
 * @Camille Junique K23057058, Shrishaa Pathak K22051823, 
Leila Flynn K23046238, Shankhi Sinha K23038624

 */
public class DataManipulatorTest
{
    DataManipulator test;
    /**
     * Default constructor for test class DataManipulatorTest
     */
    public DataManipulatorTest()
    {
    }
    
    /**
     * Sets up the test fixture.
     *
     * Called before every test case method.
     */
    @BeforeEach
    public void setUp()
    {
         test = new DataManipulator();
    }
    
    /**
     * Tests for valid dates using the method validDate
     */
    @Test
    public void testValidDate()
    {
        assertEquals(1,test.validDate(LocalDate.of(2023,1,1), LocalDate.of(2023,1,5)));
        
        //upper bound
        assertEquals(1,test.validDate(LocalDate.of(2023,1,1), LocalDate.of(2023,2,9)));
        
        //lower bound
        assertEquals(1,test.validDate(LocalDate.of(2020,2,3), LocalDate.of(2023,1,5)));
    }
    
    /**
     * Tests for invalid dates using the method validDate
     */
    @Test
    public void testInvalidDate()
    {
        //out of range, lower bound
        assertEquals(-2,test.validDate(LocalDate.of(2020,02,02), LocalDate.of(2023,1,5)));
        
        //out of range, upper bound
        assertEquals(-2,test.validDate(LocalDate.of(2022,11,26), LocalDate.of(2023,2,10)));

        //end date is before start date
        assertEquals(-1,test.validDate(LocalDate.of(2023,1,5), LocalDate.of(2022,11,26)));
    }

    /**
     * Tests the number of days between two dates using the method getDateDiff
     */
    @Test
    public void testDateDiff(){
        assertEquals(4,test.getDateDiff(LocalDate.of(2023,1,1), LocalDate.of(2023,1,5)));        
        assertEquals(94,test.getDateDiff(LocalDate.of(2022,11,5), LocalDate.of(2023,2,7)));
    }
    
    /**
     * Tests the number of total deaths between 1/11/22 and 5/1/23
     */
    @Test
    public void testTotalDeaths(){
        test.filterDate(LocalDate.of(2022,11,1), LocalDate.of(2023,1,5));
        assertEquals(670,test.getTotalDeaths());
    }
    
    /**
     * Tests the numebr of average transit google mobility measure between 1/11/22 and 5/1/23
     */
    @Test
    public void testAvgTransitGMR(){
        test.filterDate(LocalDate.of(2022,11,1), LocalDate.of(2023,1,5));
        assertEquals(0,test.getAvgTransitGMR());
    }

    /**
     * Tests the number of average parks google mobility measure between 1/11/22 and 5/1/23
     */
    @Test
    public void testAvgParksGMR(){
        test.filterDate(LocalDate.of(2022,11,1), LocalDate.of(2023,1,5));
        assertEquals(0,test.getAvgParksGMR());
    }
    
    /**
     * Tests the number of average cases between 1/11/22 and 5/1/23
     */
    @Test
    public void testAvgCases(){
        test.filterDate(LocalDate.of(2022,11,1), LocalDate.of(2023,1,5));
        assertEquals(14,test.getAvgCases());
    }
    
    /**
     * Tears down the test fixture.
     *
     * Called after every test case method.
     */
    @AfterEach
    public void tearDown()
    {
    }
}