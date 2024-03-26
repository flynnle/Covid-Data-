import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.time.LocalDate;

/**
 * The test class DataManipulatorTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
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
    
    @Test
    public void testValidDate()
    {
        assertEquals(1,test.validDate(LocalDate.of(2023,1,1), LocalDate.of(2023,1,5)));
        
        //upper bound
        assertEquals(1,test.validDate(LocalDate.of(2023,1,1), LocalDate.of(2023,2,9)));
        
        //lower bound
        assertEquals(1,test.validDate(LocalDate.of(2022,10,25), LocalDate.of(2023,1,5)));
    }
    
    @Test
    public void testInvalidDate()
    {
        //out of range, lower bound
        assertEquals(-2,test.validDate(LocalDate.of(2022,10,14), LocalDate.of(2023,1,5)));
        
        //out of range, upper bound
        assertEquals(-2,test.validDate(LocalDate.of(2022,11,26), LocalDate.of(2023,2,10)));

        //end date is before start date
        assertEquals(-1,test.validDate(LocalDate.of(2023,1,5), LocalDate.of(2022,11,26)));
            }

    @Test
    public void testDateDiff(){
        assertEquals(4,test.getDateDiff(LocalDate.of(2023,1,1), LocalDate.of(2023,1,5)));
        
        assertEquals(94,test.getDateDiff(LocalDate.of(2022,11,5), LocalDate.of(2023,2,7)));
    }
    
    @Test
    public void testTotalDeaths(){
        assertEquals(500,test.getTotalDeaths());
    }
    
    @Test
    public void testAvgTransitGMR(){
        assertEquals(2,test.getAvgTransitGMR());
    }

    @Test
    public void testAvgParksGMR(){
        assertEquals(7,test.getAvgParksGMR());
    }
    
    @Test
    public void testAvgCases(){
        assertEquals(2,test.getAvgCases());
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