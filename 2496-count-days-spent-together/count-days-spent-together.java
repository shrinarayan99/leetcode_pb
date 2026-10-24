
class Solution {
    public int countDaysTogether(String arriveAlice, String leaveAlice,
                                 String arriveBob, String leaveBob) {

        // Alice
        int alice_A_M = Integer.parseInt(arriveAlice.substring(0, 2));
        int alice_L_M = Integer.parseInt(leaveAlice.substring(0, 2));
        int alice_A_D = Integer.parseInt(arriveAlice.substring(3, 5));
        int alice_L_D = Integer.parseInt(leaveAlice.substring(3, 5));

        // Bob
        int bob_A_M = Integer.parseInt(arriveBob.substring(0, 2));
        int bob_L_M = Integer.parseInt(leaveBob.substring(0, 2));
        int bob_A_D = Integer.parseInt(arriveBob.substring(3, 5));
        int bob_L_D = Integer.parseInt(leaveBob.substring(3, 5));

        // No overlap
        if (alice_A_M > bob_L_M || bob_A_M > alice_L_M) {
            return 0;
        }

        int start_month, start_date;
        int end_month, end_date;

        // Find the later arrival
        if (alice_A_M > bob_A_M) {
            start_date = alice_A_D;
            start_month = alice_A_M;
        } else if (bob_A_M > alice_A_M) {
            start_date = bob_A_D;
            start_month = bob_A_M;
        } else {
            start_date = Math.max(alice_A_D, bob_A_D);
            start_month = alice_A_M;
        }

        // Find the earlier departure
        if (alice_L_M < bob_L_M) {
            end_month = alice_L_M;
            end_date = alice_L_D;
        } else if (bob_L_M < alice_L_M) {
            end_month = bob_L_M;
            end_date = bob_L_D;
        } else {
            end_date = Math.min(alice_L_D, bob_L_D);
            end_month = alice_L_M;
        }

        // Check for no overlap
        if (start_month > end_month ||
            (start_month == end_month && start_date > end_date)) {
            return 0;
        }

        int total_days = 0;

        while (start_month < end_month) {
            total_days += days(start_month) - start_date + 1;
            start_month++;
            start_date = 1;
        }

        // Count the final month
        total_days += end_date - start_date + 1;

        return total_days;
    }

    public int days(int month) {
        switch (month) {
            case 1, 3, 5, 7, 8, 10, 12:
                return 31;
            case 4, 6, 9, 11:
                return 30;
            default:
                return 28;
        }
    }
}
