class Solution {
    public double angleClock(int hour, int minutes) {
        // initial angle
        //if minute and 12 and hrs at any number

        double hour_angle=(hour%12)*30;

        // 6 degree per minute
        double minute_angle=minutes*6;

        // change in hour angle in due to change in minute hand
        // in one minute hour increase by 1/12 minute(itna aage badh jati h)

        double change=minutes*1/12.0*6 ;// number of minutes hour hand increase * angle per minute

        hour_angle+=change;

        double angle=Math.abs(minute_angle-hour_angle);

        return Math.min(angle, 360-angle);
    }
}