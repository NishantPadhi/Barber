package com.example.barber;

public class CAppointment {
    String saloonname,booking_date,scheduling_date;
    public CAppointment(String saloonname, String booking_date, String scheduling_date)
    {
        this.saloonname=saloonname;
        this.booking_date=booking_date;
        this.scheduling_date=scheduling_date;
    }

    public String getSaloonname() {
        return saloonname;
    }

    public String getBooking_date() {
        return booking_date;
    }

    public String getScheduling_date() {
        return scheduling_date;
    }
}
