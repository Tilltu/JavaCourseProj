package pack1;


import  java.text.ParseException;
import  java.text.SimpleDateFormat;
import  java.time.LocalDate;
import  java.util.Date;

public class CountDays {
    int  year, month, day;

    public CountDays(){year = 0; month = 0; day = 0;}
    public void setDate(String input_time) throws ParseException{
        SimpleDateFormat src_format = new SimpleDateFormat("yyyy年MM月dd日");
        Date date                   = src_format.parse(input_time);
        SimpleDateFormat dis_format = new SimpleDateFormat("yyyy/MM/dd");
        String           res        = src_format.format(date);

        //System.out.println("input_time : " + input_time + "  parsed_time : " + res);
        if(!res.equals(input_time)) {
            throw new ParseException("Input Error!", 1);
        }

        String[] string_date          = dis_format.format(date).split("/");
        //System.out.println(string_date[0] + string_date[1] + string_date[2]);
        year  = Integer.valueOf(string_date[0]);
        month = Integer.valueOf(string_date[1]);
        day   = Integer.valueOf(string_date[2]);
    }

    @Override
    public String toString() {
        return (year + "-" + month + "-" + day);
    }

    public String getDays(CountDays target_date) {
        LocalDate src_date = LocalDate.of(year, month, day);
        LocalDate dis_date = LocalDate.of(target_date.year, target_date.month, target_date.day);

        return ("时间差为:" + Math.abs(dis_date.toEpochDay() - src_date.toEpochDay()) + "天");
    }

}
