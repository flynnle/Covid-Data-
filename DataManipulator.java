
import java.util.ArrayList;
import java.time.LocalDate;
import java.time.Duration;
import java.time.Period;
import java.time.LocalDateTime;

/**
 * Write a description of class DataManipulator here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class DataManipulator
{
    private CovidDataLoader cdl = new CovidDataLoader();
    private ArrayList<CovidData> records = new ArrayList<>();
    private ArrayList<CovidData> data = new ArrayList<>();
    private LocalDate start;

    public DataManipulator(){
        //try{
            records = cdl.load();
            
        /*}
        catch (com.opencsv.exceptions.CsvValidationException cve){
            cve.printStackTrace();
        }*/
    }
    
    /**
     * An example of a method - replace this comment with your own
     *
     * @param  y  a sample parameter for a method
     * @return    the sum of x and y
     */
    public void filterDate(LocalDate start, LocalDate end)
    {
        System.out.println(records.get(0));    
        for (CovidData i : records){
            LocalDate date = LocalDate.parse(i.getDate());
            if (date.isAfter(start) && date.isBefore(end)){
                data.add(i);
            }
            else if (date.compareTo(start) == 0 || date.compareTo(end) == 0){
                data.add(i);
            }
        }
    }
    
    public void filterBorough(String borough){
        ArrayList<CovidData> selected = new ArrayList<>();
        for (CovidData i : records){
            String name = i.getBorough();
            
        }
    }
    
    public int validDate(LocalDate start, LocalDate end){
        if (start == null || end == null){
            return 0; //missing date
        }else if(start.compareTo(end) > 0){
            return -1;  //end before start
        }else if (start.compareTo(LocalDate.of(2020,2,0)) >= 0 && end.compareTo(LocalDate.of(2023,2,9)) <= 0){
            return 1;    //good date
        }else{
            return -2; //not in range
        }
    }
    
    public long getDateDiff(LocalDate start, LocalDate end){
        long days = 0;
        days = Duration.between(start.atStartOfDay(), end.atStartOfDay()).toDays();
        return days;
    }
    
    public int getTotalDeaths(){
        int total = 0;
        for (CovidData i : data){
            total += i.getNewDeaths();
        }
        return total;
    }
    
    public int getAvgTransitGMR(){
        int total = 0;
        int count = 0;
        for(CovidData i : data){
            total += i.getTransitGMR();
            count++;
        }
        return total/count;
    }
    
    public int getAvgParksGMR(){
        int total = 0;
        int count = 0;
        for (CovidData i : data){
            total += i.getParksGMR();
            count++;
        } 
        return total/count;
    }

    public int getAvgCases(){
        int total = 0;
        int count = 0;
        for (CovidData i : data){
            total += i.getTotalCases();
            count++;
        }
        return total/count;
    }
}