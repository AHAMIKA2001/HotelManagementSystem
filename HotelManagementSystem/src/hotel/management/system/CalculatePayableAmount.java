package hotel.management.system;

import java.sql.ResultSet;
import java.util.Date;

public class CalculatePayableAmount {
	
	String roomNo,checkInTime;
	static int pay=0;
	
	public CalculatePayableAmount(String room_no,String checkinTime)
	{
		roomNo=room_no;
		checkInTime=checkinTime;
		
		String mon=checkInTime.substring(4,7);
		int date=Integer.parseInt(checkInTime.substring(8,10));
		Date dte=new Date();
		String currdate=""+dte;
		String currmon=currdate.substring(4,7);
		int d=Integer.parseInt(currdate.substring(8,10));
		int cost=1;
		try {
			Conn c=new Conn();
			String q="select price from roomdetails where room_no='"+roomNo+"'";
			ResultSet rs=c.s.executeQuery(q);
			while(rs.next())
				cost=rs.getInt("price");
			
		}catch(Exception ae) {
			ae.printStackTrace();
		}
		if(mon.equals(currmon))
		{
			pay=((d-date)+1)*cost;
		}
		else
		{
			int lastdate=noOfDays(mon);
			pay=((lastdate-date)+(d-1)+1)*cost;
		}
	}
	
public int noOfDays(String mon)
{
	switch(mon) {
	case "Jan":
	case "Mar":
	case "May":
	case "Jul":
	case "Aug":
	case "Oct":
	case "Dec":
		return 31;
	case "Feb":
		return 28;
	case "Apr":
	case "Jun":
	case "Sep":
	case "Nov":
		return 30;
	}
	return 0;
}

public static int payableAmt()
{
	return pay;
}
}